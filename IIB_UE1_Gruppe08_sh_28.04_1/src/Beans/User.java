package Beans;

public class User {
   int user_id;
   private String user_vorname;
   private String user_Nachname;
   private String user_tel;
   private String user_email;
   private String user_land;
   private String user_stadt;
   private int user_plz;
   private String user_adresse;
   private String user_username;
   private String user_password;
   private String user_taetigkeit;
   
   public String getUser_land() {
	return user_land;
}

public void setUser_land(String user_land) {
	this.user_land = user_land;
}

public String getUser_stadt() {
	return user_stadt;
}

public void setUser_stadt(String user_stadt) {
	this.user_stadt = user_stadt;
}

public int getUser_plz() {
	return user_plz;
}

public void setUser_plz(int user_plz) {
	this.user_plz = user_plz;
}

public String getUser_adresse() {
	return user_adresse;
}

public void setUser_adresse(String user_adresse) {
	this.user_adresse = user_adresse;
}


   
	public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public String getUser_vorname() {
	return user_vorname;
}

public void setUser_vorname(String user_vorname) {
	this.user_vorname = user_vorname;
}

public String getUser_Nachname() {
	return user_Nachname;
}

public void setUser_Nachname(String user_Nachname) {
	this.user_Nachname = user_Nachname;
}

public String getUser_tel() {
	return user_tel;
}

public void setUser_tel(String user_tel) {
	this.user_tel = user_tel;
}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}


	public String getUser_taetigkeit() {
		return user_taetigkeit;
	}

	public void setUser_taetigkeit(String user_taetigkeit) {
		this.user_taetigkeit = user_taetigkeit;
	}

}
