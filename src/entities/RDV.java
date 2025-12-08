package entities;

import java.util.Date;

public class RDV {
    private Date dateRDV;
    private String acte;
    private double tarif;
    private Patient patient;
    private Medcin medcin;

    public RDV(Date dateRDV, String acte, double tarif, Patient patient, Medcin medcin) {
        this.dateRDV = dateRDV;
        this.acte = acte;
        this.tarif = tarif;
        this.patient = patient;
        this.medcin = medcin;
    }

    // Optional constructor with id (can be ignored if using composite key)
    private int id; // keep it only if needed for legacy code

    public RDV(int id, Date dateRDV, String acte, double tarif, Patient patient, Medcin medcin) {
        this.id = id;
        this.dateRDV = dateRDV;
        this.acte = acte;
        this.tarif = tarif;
        this.patient = patient;
        this.medcin = medcin;
    }

    // Getters and setters
    public Date getDateRDV() { return dateRDV; }
    public void setDateRDV(Date dateRDV) { this.dateRDV = dateRDV; }

    public String getActe() { return acte; }
    public void setActe(String acte) { this.acte = acte; }

    public double getTarif() { return tarif; }
    public void setTarif(double tarif) { this.tarif = tarif; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Medcin getMedcin() { return medcin; }
    public void setMedcin(Medcin medcin) { this.medcin = medcin; }

    public int getId() { return id; } // optional
    public void setId(int id) { this.id = id; } // optional
}
