package Beans;

public class Nachtragskalkulation {
  private int kalkulation_id;
  private double kalkulation_menge;
  private String kalkulation_einheit;
  private double kalkulation_preise_einheit;
  private double kalkulation_prise_gesamt;
  private int kalkulation_nachtrag_id;
	public Nachtragskalkulation() {
		// TODO Auto-generated constructor stub
	}
	public Nachtragskalkulation(int kalkulation_id, int kalkulation_menge, String kalkulation_einheit,
			double kalkulation_preise_einheit, double kalkulation_prise_gesant) {
		super();
		this.kalkulation_id = kalkulation_id;
		this.kalkulation_menge = kalkulation_menge;
		this.kalkulation_einheit = kalkulation_einheit;
		this.kalkulation_preise_einheit = kalkulation_preise_einheit;
		this.kalkulation_prise_gesamt = kalkulation_prise_gesant;
	}
	public int getKalkulation_id() {
		return kalkulation_id;
	}
	public void setKalkulation_id(int kalkulation_id) {
		this.kalkulation_id = kalkulation_id;
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
	public double getKalkulation_preise_einheit() {
		return kalkulation_preise_einheit;
	}
	public void setKalkulation_preise_einheit(double preis_Einheit) {
		this.kalkulation_preise_einheit = preis_Einheit;
	}
	public double getKalkulation_preise_gesamt() {
		return kalkulation_prise_gesamt;
	}
	public void setKalkulation_preise_gesamt(double kalkulation_prise_gesant) {
		this.kalkulation_prise_gesamt = kalkulation_prise_gesant;
	}
	public int getKalkulation_nachtrag_id() {
		return kalkulation_nachtrag_id;
	}
	public void setKalkulation_nachtrag_id(int kalkulation_nachtrag_id) {
		this.kalkulation_nachtrag_id = kalkulation_nachtrag_id;
	}

}
