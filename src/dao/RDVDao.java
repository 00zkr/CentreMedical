/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author User
 */
import connexion.Connexion;
import entities.RDV;
import entities.Patient;
import entities.Medcin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RDVDao implements IDao<RDV> {

    @Override
    public boolean create(RDV r) {
        try {
            String req = "INSERT INTO RDV(idRDV, dateRDV, acte, tarif, idPt, idMd) VALUES (NULL, ?, ?, ?, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setDate(1, new Date(r.getDateRDV().getTime()));
            ps.setString(2, r.getActe());
            ps.setDouble(3, r.getTarif());
            ps.setInt(4, r.getPatient().getId());
            ps.setInt(5, r.getMedcin().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RDVDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(RDV r) {
        try {
            String req = "UPDATE RDV SET dateRDV = ?, acte = ?, tarif = ?, idPt = ?, idMd = ? WHERE idRDV = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setDate(1, new Date(r.getDateRDV().getTime()));
            ps.setString(2, r.getActe());
            ps.setDouble(3, r.getTarif());
            ps.setInt(4, r.getPatient().getId());
            ps.setInt(5, r.getMedcin().getId());
            ps.setInt(6, r.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RDVDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(RDV r) {
        try {
            String req = "DELETE FROM RDV WHERE idRDV = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, r.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RDVDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public RDV findById(int id) {
        try {
            String req = "SELECT * FROM RDV WHERE idRDV = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                // Load linked Patient
                Patient p = new Patient(
                    rs.getInt("idPt"), "", 0, ""
                );

                // Load linked Medcin
                Medcin m = new Medcin(
                    rs.getInt("idMd"), "", "", ""
                );

                return new RDV(
                        rs.getInt("idRDV"),
                        rs.getDate("dateRDV"),
                        rs.getString("acte"),
                        rs.getDouble("tarif"),
                        p,
                        m
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(RDVDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<RDV> findAll() {
        List<RDV> rdvs = new ArrayList<>();
        try {
            String req =
                "SELECT r.idRDV, r.dateRDV, r.acte, r.tarif, " +
                "p.idPt, p.nom AS patient_nom, " +
                "m.idMd, m.nom AS medcin_nom " +
                "FROM RDV r " +
                "JOIN Patient p ON r.idPt = p.idPt " +
                "JOIN Medcin m ON r.idMd = m.idMd";

            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Patient p = new Patient(
                    rs.getInt("idPt"),
                    rs.getString("patient_nom"),
                    0,
                    null
                );

                Medcin m = new Medcin(
                    rs.getInt("idMd"),
                    rs.getString("medcin_nom"),
                    null,
                    null
                );

                rdvs.add(new RDV(
                    rs.getInt("idRDV"),
                    rs.getDate("dateRDV"),
                    rs.getString("acte"),
                    rs.getDouble("tarif"),
                    p,
                    m
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RDVDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rdvs;
    }
    
    
    public List<RDV> search(java.util.Date from, java.util.Date to, String specialite) {
        List<RDV> rdvs = new ArrayList<>();

        String sql =
            "SELECT r.*, p.nom AS patientNom, m.nom AS medcinNom " +
            "FROM RDV r " +
            "JOIN Patient p ON r.idPt = p.idPt " +
            "JOIN Medcin m ON r.idMd = m.idMd " +
            "WHERE ( ? IS NULL OR r.dateRDV >= ? ) " +
            "AND   ( ? IS NULL OR r.dateRDV <= ? ) " +
            "AND   ( ? IS NULL OR m.specialite = ? )";

        try (PreparedStatement ps = Connexion.getConnection().prepareStatement(sql)) {
            ps.setDate(1, from == null ? null : new java.sql.Date(from.getTime()));
            ps.setDate(2, from == null ? null : new java.sql.Date(from.getTime()));
            ps.setDate(3, to == null   ? null : new java.sql.Date(to.getTime()));
            ps.setDate(4, to == null   ? null : new java.sql.Date(to.getTime()));
            ps.setString(5, specialite);
            ps.setString(6, specialite);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rdvs.add(new RDV(
                    rs.getInt("idRDV"),
                    rs.getDate("dateRDV"),
                    rs.getString("acte"),
                    rs.getDouble("tarif"),
                    new Patient(rs.getInt("idPt"), rs.getString("patientNom"), 0, ""),
                    new Medcin(rs.getInt("idMd"), rs.getString("medcinNom"), "", specialite)
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rdvs;
    }
    
    
    public Map<Integer, Integer> countRdvsByMonth(int year) {
        Map<Integer, Integer> data = new HashMap<>();
        String sql =
            "SELECT MONTH(dateRDV) m, COUNT(*) c " +
            "FROM RDV WHERE YEAR(dateRDV)=? GROUP BY MONTH(dateRDV)";

        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.put(rs.getInt("m"), rs.getInt("c"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}

