package DB_manager;

import java.time.LocalDate;

public class NachtragProjectTabele {
	private int nachtrag_id;
	private String project_name;
	private String bauteil_name;
	private LocalDate nachtrag_datum;
	private LocalDate nachtrag_frist;
	private double kalkulation_menge;
	private String kalkulation_einheit;
	private double kalkulation_preis_gesamt;
	private String nachtrag_beschreibung;
	private String nachtrag_verursacher;
	private String nachtrag_vob;
	private String pruefung_ergebnis;
	private LocalDate pruefung_datum;
	
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getBauteil_name() {
		return bauteil_name;
	}
	public void setBauteil_name(String bauteil_name) {
		this.bauteil_name = bauteil_name;
	}
	public LocalDate getNachtrag_datum() {
		return nachtrag_datum;
	}
	public void setNachtrag_datum(LocalDate nachtrag_datum) {
		this.nachtrag_datum = nachtrag_datum;
	}
	public LocalDate getNachtrag_frist() {
		return nachtrag_frist;
	}
	public void setNachtrag_frist(LocalDate nachtrag_frist) {
		this.nachtrag_frist = nachtrag_frist;
	}
	public double getKalkulation_menge() {
		return kalkulation_menge;
	}
	public void setKalkulation_menge(double kalkulation_menge) {
		this.kalkulation_menge = kalkulation_menge;
	}
	public String getKalkulation_einheit() {
		return kalkulation_einheit;
	}
	public void setKalkulation_einheit(String kalkulation_einheit) {
		this.kalkulation_einheit = kalkulation_einheit;
	}
	public double getKalkulation_preis_gesamt() {
		return kalkulation_preis_gesamt;
	}
	public void setKalkulation_preis_gesamt(double kalkulation_preis_gesamt) {
		this.kalkulation_preis_gesamt = kalkulation_preis_gesamt;
	}
	public String getNachtrag_beschreibung() {
		return nachtrag_beschreibung;
	}
	public void setNachtrag_beschreibung(String nachtrag_beschreibung) {
		this.nachtrag_beschreibung = nachtrag_beschreibung;
	}
	public String getNachtrag_verursacher() {
		return nachtrag_verursacher;
	}
	public void setNachtrag_verursacher(String nachtrag_verursacher) {
		this.nachtrag_verursacher = nachtrag_verursacher;
	}
	public String getNachtrag_vob() {
		return nachtrag_vob;
	}
	public void setNachtrag_vob(String nachtrag_vob) {
		this.nachtrag_vob = nachtrag_vob;
	}
	public String getPruefung_ergebnis() {
		return pruefung_ergebnis;
	}
	public void setPruefung_ergebnis(String pruefung_ergebnis) {
		this.pruefung_ergebnis = pruefung_ergebnis;
	}
	public LocalDate getPruefung_datum() {
		return pruefung_datum;
	}
	public void setPruefung_datum(LocalDate pruefung_datum) {
		this.pruefung_datum = pruefung_datum;
	}
	public int getNachtrag_id() {
		return nachtrag_id;
	}
	public void setNachtrag_id(int nachtrag_id) {
		this.nachtrag_id = nachtrag_id;
	}

}