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
import entities.Medcin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedcinDao implements IDao<Medcin> {

    @Override
    public boolean create(Medcin m) {
        try {
            String req = "INSERT INTO Medcin(idMd, nom, specialite, telephone) VALUES (NULL, ?, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, m.getNom());
            ps.setString(2, m.getSpecialite());
            ps.setString(3, m.getTelephone());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MedcinDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Medcin m) {
        try {
            String req = "UPDATE Medcin SET nom = ?, specialite = ?, telephone = ? WHERE idMd = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, m.getNom());
            ps.setString(2, m.getSpecialite());
            ps.setString(3, m.getTelephone());
            ps.setInt(4, m.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MedcinDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Medcin m) {
        try {
            String req = "DELETE FROM Medcin WHERE idMd = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, m.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MedcinDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Medcin findById(int id) {
        try {
            String req = "SELECT * FROM Medcin WHERE idMd = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Medcin(
                        rs.getInt("idMd"),
                        rs.getString("nom"),
                        rs.getString("specialite"),
                        rs.getString("telephone")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedcinDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Medcin> findAll() {
        List<Medcin> medcins = new ArrayList<>();
        try {
            String req = "SELECT * FROM Medcin";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                medcins.add(new Medcin(
                        rs.getInt("idMd"),
                        rs.getString("nom"),
                        rs.getString("specialite"),
                        rs.getString("telephone")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedcinDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medcins;
    }
    
    public List<String> findAllSpecialties() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT DISTINCT specialite FROM Medcin WHERE specialite IS NOT NULL";

        try (PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(rs.getString("specialite"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MedcinDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
