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

import dao.MedcinDao;
import entities.Medcin;

public class TestMedcinDao {
    public static void main(String[] args) {

        MedcinDao mdao = new MedcinDao();

        Medcin m = new Medcin("Dr Test", "Cardiology", "123456789");
        boolean created = mdao.create(m);
        System.out.println("Create: " + created);

        System.out.println("\nList of medcins:");
        for (Medcin med : mdao.findAll()) {
            System.out.println(med.getId() + " - " + med.getNom() + " - " + med.getSpecialite());
        }

        if (mdao.findAll().isEmpty()) {
            System.out.println("No medcins found.");
            return;
        }

        int lastId = mdao.findAll().get(mdao.findAll().size() - 1).getId();
        Medcin last = mdao.findById(lastId);
        System.out.println("\nFindById (" + lastId + "): " + last.getNom());

        last.setNom("Dr Updated");
        last.setTelephone("987654321");
        boolean updated = mdao.update(last);
        System.out.println("Update: " + updated);

        boolean deleted = mdao.delete(last);
        System.out.println("Delete: " + deleted);
    }
}
