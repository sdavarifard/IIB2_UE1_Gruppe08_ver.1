package Beans;

import java.time.LocalDate;

public class Nachtrag {
  private int nachtrag_id;
  private String  nachtrag_titel;
  private LocalDate nachtrag_datum;
  private String nachtrag_beschreibung;
  private String nachtrag_vob;
  private String nachtrag_verursacher;
  private LocalDate nachtrag_frist;
  private int nachtrag_bauteil_id;
  
  
	public Nachtrag(int nachtrag_id, String nachtrag_titel, LocalDate nachtrag_datum, String nachtrag_beschreibung,
		String nachtrag_vob, String nachtrag_verursacher, LocalDate nachtrag_frist) {
	super();
	this.nachtrag_id = nachtrag_id;
	this.nachtrag_titel = nachtrag_titel;
	this.nachtrag_datum = nachtrag_datum;
	this.nachtrag_beschreibung = nachtrag_beschreibung;
	this.nachtrag_vob = nachtrag_vob;
	this.nachtrag_verursacher = nachtrag_verursacher;
	this.nachtrag_frist = nachtrag_frist;
}


	public Nachtrag() {
		// TODO Auto-generated constructor stub
	}


	public int getNachtrag_id() {
		return nachtrag_id;
	}


	public void setNachtrag_id(int nachtrag_id) {
		this.nachtrag_id = nachtrag_id;
	}


	public String getNachtrag_titel() {
		return nachtrag_titel;
	}


	public void setNachtrag_titel(String nachtrag_titel) {
		this.nachtrag_titel = nachtrag_titel;
	}


	public LocalDate getNachtrag_datum() {
		return nachtrag_datum;
	}


	public void setNachtrag_datum(LocalDate nachtrag_datum) {
		this.nachtrag_datum = nachtrag_datum;
	}


	public String getNachtrag_beschreibung() {
		return nachtrag_beschreibung;
	}


	public void setNachtrag_beschreibung(String nachtrag_beschreibung) {
		this.nachtrag_beschreibung = nachtrag_beschreibung;
	}


	public String getNachtrag_vob() {
		return nachtrag_vob;
	}


	public void setNachtrag_vob(String nachtrag_vob) {
		this.nachtrag_vob = nachtrag_vob;
	}


	public String getNachtrag_verursacher() {
		return nachtrag_verursacher;
	}


	public void setNachtrag_verursacher(String nachtrag_verursacher) {
		this.nachtrag_verursacher = nachtrag_verursacher;
	}


	public LocalDate getNachtrag_frist() {
		return nachtrag_frist;
	}


	public void setNachtrag_frist(LocalDate nachtrag_frist) {
		this.nachtrag_frist = nachtrag_frist;
	}


	public int getNachtrag_bauteil_id() {
		return nachtrag_bauteil_id;
	}


	public void setNachtrag_bauteil_id(int nachtrag_bauteil_id) {
		this.nachtrag_bauteil_id = nachtrag_bauteil_id;
	}

}
