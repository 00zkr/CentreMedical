/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author User
 */

public class RDV {
    private int id;
    private Date dateRDV;
    private String acte;
    private double tarif;
    private Patient patient;
    private Medcin medcin;

    public RDV(int id, Date dateRDV, String acte, double tarif, Patient patient, Medcin medcin) {
        this.id = id;
        this.dateRDV = dateRDV;
        this.acte = acte;
        this.tarif = tarif;
        this.patient = patient;
        this.medcin = medcin;
    }
    
    public RDV(Date dateRDV, String acte, double tarif, Patient patient, Medcin medcin) {
        this.dateRDV = dateRDV;
        this.acte = acte;
        this.tarif = tarif;
        this.patient = patient;
        this.medcin = medcin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(Date dateRDV) {
        this.dateRDV = dateRDV;
    }

    public String getActe() {
        return acte;
    }

    public void setActe(String acte) {
        this.acte = acte;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medcin getMedcin() {
        return medcin;
    }

    public void setMedcin(Medcin medcin) {
        this.medcin = medcin;
    }
}
