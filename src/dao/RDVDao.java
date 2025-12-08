package dao;

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
            String req = "INSERT INTO RDV(dateRDV, acte, tarif, idPt, idMd) VALUES (?, ?, ?, ?, ?)";
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
            String req = "UPDATE RDV SET acte = ?, tarif = ? WHERE idPt = ? AND idMd = ? AND dateRDV = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, r.getActe());
            ps.setDouble(2, r.getTarif());
            ps.setInt(3, r.getPatient().getId());
            ps.setInt(4, r.getMedcin().getId());
            ps.setDate(5, new Date(r.getDateRDV().getTime()));
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
            String req = "DELETE FROM RDV WHERE idPt = ? AND idMd = ? AND dateRDV = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, r.getPatient().getId());
            ps.setInt(2, r.getMedcin().getId());
            ps.setDate(3, new Date(r.getDateRDV().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RDVDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     @Override
    public RDV findById(int id) {
        return null;
    }
    
    public RDV findByKey(int idPt, int idMd, java.util.Date dateRDV) {
        try {
            String req = "SELECT r.*, p.nom AS patientNom, m.nom AS medcinNom, m.specialite " +
                         "FROM RDV r " +
                         "JOIN Patient p ON r.idPt = p.idPt " +
                         "JOIN Medcin m ON r.idMd = m.idMd " +
                         "WHERE r.idPt = ? AND r.idMd = ? AND r.dateRDV = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, idPt);
            ps.setInt(2, idMd);
            ps.setDate(3, new Date(dateRDV.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Patient p = new Patient(rs.getInt("idPt"), rs.getString("patientNom"), 0, "");
                Medcin m = new Medcin(rs.getInt("idMd"), rs.getString("medcinNom"), "", rs.getString("specialite"));
                return new RDV(rs.getDate("dateRDV"), rs.getString("acte"), rs.getDouble("tarif"), p, m);
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
                "SELECT r.*, p.nom AS patientNom, m.nom AS medcinNom, m.specialite " +
                "FROM RDV r " +
                "JOIN Patient p ON r.idPt = p.idPt " +
                "JOIN Medcin m ON r.idMd = m.idMd";

            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patient p = new Patient(rs.getInt("idPt"), rs.getString("patientNom"), 0, "");
                Medcin m = new Medcin(rs.getInt("idMd"), rs.getString("medcinNom"), "", rs.getString("specialite"));
                rdvs.add(new RDV(rs.getDate("dateRDV"), rs.getString("acte"), rs.getDouble("tarif"), p, m));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RDVDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rdvs;
    }

    public List<RDV> search(java.util.Date from, java.util.Date to, String specialite) {
        List<RDV> rdvs = new ArrayList<>();
        String sql =
            "SELECT r.*, p.nom AS patientNom, m.nom AS medcinNom, m.specialite " +
            "FROM RDV r " +
            "JOIN Patient p ON r.idPt = p.idPt " +
            "JOIN Medcin m ON r.idMd = m.idMd " +
            "WHERE ( ? IS NULL OR r.dateRDV >= ? ) " +
            "AND   ( ? IS NULL OR r.dateRDV <= ? ) " +
            "AND   ( ? IS NULL OR m.specialite = ? )";
        try (PreparedStatement ps = Connexion.getConnection().prepareStatement(sql)) {
            ps.setDate(1, from == null ? null : new java.sql.Date(from.getTime()));
            ps.setDate(2, from == null ? null : new java.sql.Date(from.getTime()));
            ps.setDate(3, to == null ? null : new java.sql.Date(to.getTime()));
            ps.setDate(4, to == null ? null : new java.sql.Date(to.getTime()));
            ps.setString(5, specialite);
            ps.setString(6, specialite);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient p = new Patient(rs.getInt("idPt"), rs.getString("patientNom"), 0, "");
                Medcin m = new Medcin(rs.getInt("idMd"), rs.getString("medcinNom"), "", rs.getString("specialite"));
                rdvs.add(new RDV(rs.getDate("dateRDV"), rs.getString("acte"), rs.getDouble("tarif"), p, m));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rdvs;
    }

    public Map<Integer, Integer> countRdvsByMonth(int year) {
        Map<Integer, Integer> data = new HashMap<>();
        String sql = "SELECT MONTH(dateRDV) m, COUNT(*) c FROM RDV WHERE YEAR(dateRDV)=? GROUP BY MONTH(dateRDV)";
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
