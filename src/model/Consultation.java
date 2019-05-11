package model;

public class Consultation {
private int id;
private String date;
private String therapie;
private String ordonnance;
private Ticket ticket;
private Medecin medecin;
public Consultation() {
	super();
}
public Consultation(int id, String date, String therapie, String ordonnance, Ticket ticket, Medecin medecin) {
	super();
	this.id = id;
	this.date = date;
	this.therapie = therapie;
	this.ordonnance = ordonnance;
	this.ticket = ticket;
	this.medecin = medecin;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getTherapie() {
	return therapie;
}
public void setTherapie(String therapie) {
	this.therapie = therapie;
}
public String getOrdonnance() {
	return ordonnance;
}
public void setOrdonnance(String ordonnance) {
	this.ordonnance = ordonnance;
}
public Ticket getTicket() {
	return ticket;
}
public void setTicket(Ticket ticket) {
	this.ticket = ticket;
}
public Medecin getMedecin() {
	return medecin;
}
public void setMedecin(Medecin medecin) {
	this.medecin = medecin;
}


}
