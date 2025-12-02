/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connexion.Connexion;
import entities.Patient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class PatientDao implements IDao<Patient> {

    @Override
    public boolean create(Patient p) {
        try {
            String req = "INSERT INTO Patient(nom, age, ville) VALUES (?, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getVille());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Patient p) {
        try {
            String req = "UPDATE Patient SET nom = ?, age = ?, ville = ? WHERE idPt = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getVille());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Patient p) {
        try {
            String req = "DELETE FROM Patient where idPt = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Patient findById(int id) {
        try {
            String req = "select * from Patient where idPt = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Patient(rs.getInt("idPt"), rs.getString("nom"), rs.getInt("age"), rs.getString("ville"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        try {
            String req = "select * from Patient";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patients.add(new Patient(rs.getInt("idPt"), rs.getString("nom"), rs.getInt("age"), rs.getString("ville")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patients;
    }
}
