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
import dao.PatientDao;
import entities.Patient;

public class TestPatientDao {
    public static void main(String[] args) {

        PatientDao pdao = new PatientDao();

        Patient p = new Patient("TestName", 22, "TestVille");
        boolean created = pdao.create(p);
        System.out.println("Create: " + created);

        System.out.println("\nList of patients:");
        for (Patient pat : pdao.findAll()) {
            System.out.println(pat.getId() + " - " + pat.getNom() + " - " + pat.getVille());
        }

        if (pdao.findAll().isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        int lastId = pdao.findAll().get(pdao.findAll().size() - 1).getId();
        Patient last = pdao.findById(lastId);
        System.out.println("\nFindById (" + lastId + "): " + last.getNom());

        last.setNom("zero");
        boolean updated = pdao.update(last);
        System.out.println("Update: " + updated);

        boolean deleted = pdao.delete(last);
        System.out.println("Delete: " + deleted);
    }
}

