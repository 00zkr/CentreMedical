/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author User
 */
public class Medcin {
    private int id;
    private String nom;
    private String specialite;
    private String telephone;
    
    public Medcin(int id, String nom, String specialite, String telephone){
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
        this.telephone = telephone;
    }
    
    public Medcin(String nom, String specialite, String telephone){
        this.nom = nom;
        this.specialite = specialite;
        this.telephone = telephone;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getSpecialite(){
        return specialite;
    }
    
    public void setSpecialite(String specialite){
        this.specialite = specialite;
    }
    
    public String getTelephone(){
        return telephone;
    }
    
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
}
