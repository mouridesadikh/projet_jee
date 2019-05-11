/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Cheikh_Mouride
 */
public class Ticket {
    private int id ;
    private String code;
    private String datePrise;
    private Specialite specialite;
    private Patient patient;
    private Caissier caissier;
  
    
  
    public Ticket() {
		super();
	}


	public Ticket(int id,String code,String datePrise, Specialite  specialite, Patient patient, Caissier caissier) {
        this.id = id;
        this.code = code;
        this.datePrise = datePrise;
        this.specialite = specialite;
        this.patient = patient;
        this.caissier =caissier;
        
    }
 
    
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatePrise() {
		return datePrise;
	}

	public void setDatePrise(String string) {
		this.datePrise = string;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Caissier getCaissier() {
		return caissier;
	}

	public void setCaissier(Caissier caissier) {
		this.caissier = caissier;
	}
    
            
    
}
