package Beans;

import java.time.LocalDate;

public class Project {

	 private int project_id;
	 private String project_name;
	 private LocalDate project_anfang;
	 private LocalDate project_end;
	 private String project_land;
	 private String project_Stadt;
	 private int project_plz;
	 private String project_adresse;
	 
 
	 
	 
	 
	 
	 public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public LocalDate getProject_anfang() {
		return project_anfang;
	}
	public void setProject_anfang(LocalDate project_anfang) {
		this.project_anfang = project_anfang;
	}
	public LocalDate getProject_end() {
		return project_end;
	}
	public void setProject_end(LocalDate project_end) {
		this.project_end = project_end;
	}

	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(int project_id, String project_name, LocalDate project_anfang, LocalDate project_end) {
		super();
		this.project_id = project_id;
		this.project_name = project_name;
		this.project_anfang = project_anfang;
		this.project_end = project_end;
	}
	public String getProject_land() {
		return project_land;
	}
	public void setProject_land(String project_land) {
		this.project_land = project_land;
	}
	public String getProject_Stadt() {
		return project_Stadt;
	}
	public void setProject_Stadt(String project_Stadt) {
		this.project_Stadt = project_Stadt;
	}
	public int getProject_plz() {
		return project_plz;
	}
	public void setProject_plz(int project_plz) {
		this.project_plz = project_plz;
	}
	public String getProject_adresse() {
		return project_adresse;
	}
	public void setProject_adresse(String project_adresse) {
		this.project_adresse = project_adresse;
	}

}
