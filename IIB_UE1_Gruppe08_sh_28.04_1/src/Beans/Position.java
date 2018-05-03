package Beans;

public class Position {
private int position_id;
private String position_name;
private String position_beschreibung;

	public Position(int position_id, String position_name, String position_beschreibung) {
	super();
	this.position_id = position_id;
	this.position_name = position_name;
	this.position_beschreibung = position_beschreibung;
}

	public Position() {
		// TODO Auto-generated constructor stub
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getPosition_beschreibung() {
		return position_beschreibung;
	}

	public void setPosition_beschreibung(String position_beschreibung) {
		this.position_beschreibung = position_beschreibung;
	}

}
