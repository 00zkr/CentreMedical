/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author User
 */
import dao.RDVDao;
import dao.PatientDao;
import dao.MedcinDao;
import entities.RDV;
import entities.Patient;
import entities.Medcin;
import java.util.Date;

public class TestRDVDao {
    public static void main(String[] args) {

        RDVDao rdvDao = new RDVDao();
        PatientDao patientDao = new PatientDao();
        MedcinDao medcinDao = new MedcinDao();

        Patient p = patientDao.findById(1);
        Medcin m = medcinDao.findById(1);

        if (p == null || m == null) {
            System.out.println("Add at least 1 patient and 1 medcin before testing RDV.");
            return;
        }

        RDV r = new RDV(new Date(), "Consultation", 200.0, p, m);
        boolean created = rdvDao.create(r);
        System.out.println("Create RDV: " + created);

        System.out.println("\nAll RDVs:");
        for (RDV rdv : rdvDao.findAll()) {
            System.out.println(
                rdv.getId() + " - " +
                rdv.getDateRDV() + " - " +
                rdv.getActe() + " - " +
                rdv.getTarif()
            );
        }

        RDV last = rdvDao.findAll().get(rdvDao.findAll().size() - 1);
        last.setActe("Updated test");
        boolean updated = rdvDao.update(last);
        System.out.println("\nUpdate RDV: " + updated);

        boolean deleted = rdvDao.delete(last);
        System.out.println("Delete RDV: " + deleted);
    }
}

