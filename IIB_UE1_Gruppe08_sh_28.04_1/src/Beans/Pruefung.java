package Beans;

import java.io.OptionalDataException;
import java.sql.Date;
import java.time.LocalDate;

public class Pruefung {
  private int pruefung_id;
  private String pruefung_ergebnis;
  private LocalDate pruefung_datum;
  private String pruefung_beschreibung;
  
  private int pruefung_nachtrag_id;
  private int pruefung_flag;
  
public int getPruefung_nachtrag_id() {
	return pruefung_nachtrag_id;
}
public void setPruefung_nachtrag_id(int pruefung_nachtrag_id) {
	this.pruefung_nachtrag_id = pruefung_nachtrag_id;
}

	public Pruefung() {
		// TODO Auto-generated constructor stub
	}
	public int getPruefung_id() {
		return pruefung_id;
	}
	public void setPruefung_id(int pruefung_id) {
		this.pruefung_id = pruefung_id;
	}
	public String getPruefung_ergebnis() {
		return pruefung_ergebnis;
	}
	public void setPruefung_ergebnis(String pruefung_ergebnis) {
		this.pruefung_ergebnis = pruefung_ergebnis;
	}
	public String getPruefung_beschreibung() {
		return pruefung_beschreibung;
	}
	public void setPruefung_beschreibung(String pruefung_beschreibung) {
		this.pruefung_beschreibung = pruefung_beschreibung;
	}
	public LocalDate getPruefung_datum() {
		return pruefung_datum;
	}
	public void setPruefung_datum(LocalDate pruefung_datum) {
		this.pruefung_datum = pruefung_datum;
	}
	public int getPruefung_flag() {
		return pruefung_flag;
	}
	public void setPruefung_flag(int pruefung_flag) {
		this.pruefung_flag = pruefung_flag;
	}

}
