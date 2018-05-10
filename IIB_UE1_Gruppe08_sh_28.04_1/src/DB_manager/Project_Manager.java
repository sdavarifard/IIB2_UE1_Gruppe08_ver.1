package DB_manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.joda.time.Days;

import Beans.*;
import DB_connect.databank;

public class Project_Manager {

	public static void execute(String sql) throws ClassNotFoundException, SQLException {

		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		st.execute(sql);
		con.close();

	}
	
	public static List<Project> getProject(String loginUsername) throws SQLException{
		List<Project> lProject = new ArrayList<Project>();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select project_id,project_name,project_anfang,project_end,project_land,project_stadt,project_plz,project_adresse from project as p,"
				+ " user as u, user_hat_project as uhp where p.project_id=uhp.user_hat_project_project_id and "
				+ "uhp.user_hat_project_user_id = u.user_id and u.user_username= '"+loginUsername+"';";
		ResultSet rs = st.executeQuery(SQL);
		while(rs.next()) {
			Project myProject = new Project();
			myProject.setProject_id(rs.getInt(1));
			myProject.setProject_name(rs.getString(2));
			myProject.setProject_anfang(rs.getDate(3).toLocalDate());
			myProject.setProject_end(rs.getDate(4).toLocalDate());
			myProject.setProject_land(rs.getString(5));
			myProject.setProject_Stadt(rs.getString(6));
			myProject.setProject_plz(rs.getInt(7));
			myProject.setProject_adresse(rs.getString(8));
			lProject.add(myProject);
		}
		con.close();
		
		return lProject;
	}
	
	public static List<Project> getProjectfromUserID(int userID) throws SQLException{
		List<Project> lProject = new ArrayList<Project>();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select project_id,project_name,project_anfang,project_end,project_land,project_stadt,project_plz,project_adresse from project as p,"
				+ " user as u, user_hat_project as uhp where p.project_id=uhp.user_hat_project_project_id and "
				+ "uhp.user_hat_project_user_id = u.user_id and u.user_id= "+userID+";";
		ResultSet rs = st.executeQuery(SQL);
		while(rs.next()) {
			Project myProject = new Project();
			myProject.setProject_id(rs.getInt(1));
			myProject.setProject_name(rs.getString(2));
			myProject.setProject_anfang(rs.getDate(3).toLocalDate());
			myProject.setProject_end(rs.getDate(4).toLocalDate());
			myProject.setProject_land(rs.getString(5));
			myProject.setProject_Stadt(rs.getString(6));
			myProject.setProject_plz(rs.getInt(7));
			myProject.setProject_adresse(rs.getString(8));
			lProject.add(myProject);
		}
		con.close();
		
		return lProject;
	}
	
	public static Project getProjectfromProjectID(int projectID) throws SQLException{
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select project_id,project_name,project_anfang,project_end,project_land,project_stadt,project_plz,project_adresse"
				+ " from project where project_id= "+projectID+";";
		ResultSet rs = st.executeQuery(SQL);
		Project myProject = new Project();
		if(rs.next()) {
			
			myProject.setProject_id(rs.getInt(1));
			myProject.setProject_name(rs.getString(2));
			myProject.setProject_anfang(rs.getDate(3).toLocalDate());
			myProject.setProject_end(rs.getDate(4).toLocalDate());
			myProject.setProject_land(rs.getString(5));
			myProject.setProject_Stadt(rs.getString(6));
			myProject.setProject_plz(rs.getInt(7));
			myProject.setProject_adresse(rs.getString(8));
		}
		con.close();
		
		return myProject;
	}
	
	public static Project getProjectfromNachtragID(int nachtragID) throws SQLException{
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select project_id,project_name,project_anfang,project_end,project_land,project_stadt,project_plz,project_adresse"
				+ " from project, nachtrag, bauteil where nachtrag_bauteil_id=bauteil_id and bauteil_project_id = project_id and nachtrag_id= "+nachtragID+";";
		ResultSet rs = st.executeQuery(SQL);
		Project myProject = new Project();
		if(rs.next()) {
			myProject.setProject_id(rs.getInt(1));
			myProject.setProject_name(rs.getString(2));
			myProject.setProject_anfang(rs.getDate(3).toLocalDate());
			myProject.setProject_end(rs.getDate(4).toLocalDate());
			myProject.setProject_land(rs.getString(5));
			myProject.setProject_Stadt(rs.getString(6));
			myProject.setProject_plz(rs.getInt(7));
			myProject.setProject_adresse(rs.getString(8));
		}
		con.close();
		
		return myProject;
	}
	
	public static void insertProjectSQLTabele(Project p) throws SQLException, ClassNotFoundException {

		String SQLInsertInto="";
		SQLInsertInto="Insert into project (project_name, project_anfang, project_end, project_land, project_stadt, project_plz, project_adresse) "
				+ "values ('"+p.getProject_name() +"','"+p.getProject_anfang()+"', '"+p.getProject_end()+
				"', '"+p.getProject_land() +"','"+p.getProject_Stadt()+"',"+p.getProject_plz()+
				", '"+p.getProject_adresse()+"');";
		execute(SQLInsertInto);

	}
	public static Project insertNewProject(String name, LocalDate anfang, LocalDate end,String land
			, String stadt, int plz, String adresse) 
			throws SQLException, ClassNotFoundException, ServletException, IOException {
		Project p = new Project();
		p.setProject_name(name);
		p.setProject_anfang(anfang);
		p.setProject_end(end);
		p.setProject_land(land);
		p.setProject_Stadt(stadt);
		p.setProject_plz(plz);
		p.setProject_adresse(adresse);
		return p;

	}
	
	
	public static List<Bauteil> getBauteilfromProjectandPosition(int Project_id, int Position_id) throws SQLException {
		List<Bauteil> l = new ArrayList<Bauteil>();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL= "select bauteil_id, bauteil_name from bauteil, project, position where "
				+ "bauteil_project_id= project_id and bauteil_position_id= position_id and "
				+ "project_id="+Project_id+" and position_id="+ Position_id+" ;";
		ResultSet rs = st.executeQuery(SQL);
		while(rs.next()) {
			Bauteil m = new Bauteil();
			m.setBauteil_id(rs.getInt(1));
			m.setBauteil_name(rs.getString(2));
			m.setBauteil_position_id(Position_id);
			m.setBauteil_project_id(Project_id);
			l.add(m);
		}
		con.close();
		
		return l;
	}

	public static void insertUserHatProject(int userID, int projectid, String Auftragnehmer) 
			throws ClassNotFoundException, SQLException {
		String SQL3="";
		SQL3="insert into user_hat_project (user_hat_project_user_id,user_hat_project_project_id,"
				+ "user_hat_project_auftragnehmer_name) values ("+userID +","+projectid+
				",'"+Auftragnehmer+"');";
		execute(SQL3);
	}
	
	public static int getProjectId(Project p) throws SQLException {
		String SQLGetProjectId="";
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		SQLGetProjectId = " select project_id from project where project_name='"+p.getProject_name() +
				"' and project_plz="+p.getProject_plz()+";";
		ResultSet rs = st.executeQuery(SQLGetProjectId);
		return rs.getInt(1);
	}
	
	
	public static int getProjectIdfromName(String name) throws SQLException {
		String SQLGetProjectId="";
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		SQLGetProjectId = " select project_id from project where project_name='"+name +"';";
		ResultSet rs = st.executeQuery(SQLGetProjectId);
		int id = 0;
		if(rs.next()) 	id= rs.getInt("project_id");

		con.close();
		return id;
	}

	
	public static List<Bauteil> getBauteil(String loginUsername) throws SQLException{
		List<Bauteil> lBauteil = new ArrayList<Bauteil>();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL= "select bauteil_id, bauteil_name, bauteil_project_id,bauteil_position_id  from project as p,"
				+ " user as u, user_hat_project as uhp , bauteil as b where b.bauteil_project_id = "
				+ "p.project_id and p.project_id=uhp.user_hat_project_project_id and"
				+ " uhp.user_hat_project_user_id = u.user_id and u.user_username= '"+loginUsername+"' group by bauteil_id;";
		ResultSet rs = st.executeQuery(SQL);
		while(rs.next()) {
			Bauteil myBauteil = new Bauteil();
			myBauteil.setBauteil_id(rs.getInt(1));
			myBauteil.setBauteil_name(rs.getString(2));
			myBauteil.setBauteil_project_id(rs.getInt(3));
			myBauteil.setBauteil_position_id(rs.getInt(4));
			lBauteil.add(myBauteil);
		}
		con.close();
		
		return lBauteil;
	}

	public static Bauteil getBauteilfromNachtragID (int nachtragID) throws SQLException {
		Bauteil b = new Bauteil();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select  bauteil_id, bauteil_name, bauteil_project_id,bauteil_position_id from bauteil,"
				+ " nachtrag where nachtrag_bauteil_id = bauteil_id and nachtrag_id="+nachtragID+";";
		ResultSet rs = st.executeQuery(SQL);
		if(rs.next()) {
			b.setBauteil_id(rs.getInt(1));
			b.setBauteil_name(rs.getString(2));
			b.setBauteil_project_id(rs.getInt(3));
			b.setBauteil_position_id(rs.getInt(4));
		}
		con.close();
		return b;
	}

	public static Nachtrag getNachtragfromNachtragID (int nachtragID) throws SQLException {
		Nachtrag n = new Nachtrag();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select * from nachtrag where nachtrag_id="+nachtragID+";";
		ResultSet rs = st.executeQuery(SQL);
		if(rs.next()) {
			n.setNachtrag_id(nachtragID);
			n.setNachtrag_titel(rs.getString(2));
			n.setNachtrag_datum(rs.getDate(3).toLocalDate());
			n.setNachtrag_beschreibung(rs.getString(4));
			n.setNachtrag_vob(rs.getString(5));
			n.setNachtrag_verursacher(rs.getString(6));
			n.setNachtrag_frist(rs.getDate(7).toLocalDate());
			n.setNachtrag_bauteil_id(rs.getInt(8));
		}
		con.close();
		return n;
	}
	
	public static Nachtrag insertNewNachtrag(String title, LocalDate datum,String beschreibung,String VOB, String verursacher,
			LocalDate frist, int bauteilID) {
		Nachtrag n = new Nachtrag();
		n.setNachtrag_titel(title);
		n.setNachtrag_datum(datum);
		n.setNachtrag_beschreibung(beschreibung);
		n.setNachtrag_vob(VOB);
		n.setNachtrag_verursacher(verursacher);
		n.setNachtrag_frist(frist);
		n.setNachtrag_bauteil_id(bauteilID);
		return n;
	}
	
	
	public static void insertNewNachtragSQLTabele(Nachtrag n) throws ClassNotFoundException, SQLException {
		String SQLInsertInto="";
		SQLInsertInto=" insert into nachtrag (nachtrag_titel, nachtrag_datum, nachtrag_beschreibung, "
				+ "nachtrag_vob, nachtrag_verursacher, nachtrag_frist, nachtrag_bauteil_id) values"
				+ " ('"+ n.getNachtrag_titel()+"','"+ n.getNachtrag_datum()+"','"+n.getNachtrag_beschreibung()+"',"
				+ "'"+n.getNachtrag_vob()+"','"+n.getNachtrag_verursacher()+"','"+n.getNachtrag_frist()+"',"+n.getNachtrag_bauteil_id()+");";
		execute(SQLInsertInto);
	}
	
	
	public static void editNachtragSQLTabele(int nachtragID, String title, LocalDate datum,String beschreibung,String VOB, String verursacher,
			LocalDate frist) throws ClassNotFoundException, SQLException {
		String SQLInsertInto="";
		SQLInsertInto="update nachtrag set nachtrag_titel='"+title+"', nachtrag_datum='"+datum+"', nachtrag_beschreibung='"+beschreibung+"',"
				+ " nachtrag_vob='"+VOB+"',nachtrag_verursacher='"+verursacher+"',nachtrag_frist='"+frist+"' where nachtrag_id="+nachtragID+";";
		execute(SQLInsertInto);
	}
	
	public static Nachtragskalkulation insertNewNachtragskalkulation(double Menge, String Einheit, double Preis_Einheit, 
			double Preis_Gesamt, int Nachtrag_id) {
		Nachtragskalkulation n = new Nachtragskalkulation();
		n.setKalkulation_menge(Menge);
		n.setKalkulation_einheit(Einheit);
		n.setKalkulation_preise_einheit(Preis_Einheit);
		n.setKalkulation_preise_gesamt(Preis_Gesamt);
		n.setKalkulation_nachtrag_id(Nachtrag_id);		
		return n;
	}

	public static void insertNewNachtragKalkulationSQLTabele(Nachtragskalkulation n) throws ClassNotFoundException, SQLException {
		String SQLInsertInto="";
		SQLInsertInto="   insert into kalkulation (kalkulation_menge, kalkulation_einheit,kalkulation_preis_einheit,kalkulation_preis_gesamt,kalkulation_nachtrag_id)"
				+ " values ("+n.getKalkulation_menge()+", '"+n.getKalkulation_einheit()+"',"+n.getKalkulation_preise_einheit()+","+n.getKalkulation_preise_gesamt()+","+n.getKalkulation_nachtrag_id()+");";
		execute(SQLInsertInto);
	}
	
	public static void editNachtragKalkulationSQLTabele(double Menge, String Einheit, double Preis_Einheit, 
			double Preis_Gesamt, int Nachtrag_id) throws ClassNotFoundException, SQLException {
		String SQLInsertInto="";
		SQLInsertInto="update kalkulation set kalkulation_menge="+Menge+", kalkulation_einheit='"+Einheit+"', kalkulation_preis_einheit="+Preis_Einheit+","
				+ " kalkulation_preis_gesamt="+Preis_Gesamt+" where kalkulation_nachtrag_id="+Nachtrag_id+"; ";
		execute(SQLInsertInto);
	}
	
	public static List<Nachtrag> getNachtrag(String loginUsername) throws SQLException{
		List<Nachtrag> lNachtrag = new ArrayList<Nachtrag>();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL= " select nachtrag_id,nachtrag_titel,nachtrag_datum,nachtrag_beschreibung,"
				+ "nachtrag_vob,nachtrag_verursacher,nachtrag_frist,nachtrag_bauteil_id from "
				+ "project as p, user as u, user_hat_project as uhp , bauteil as b, position, "
				+ "nachtrag where nachtrag_bauteil_id=b.bauteil_id and position_id = b.bauteil_position_id "
				+ "and b.bauteil_project_id = p.project_id and p.project_id=uhp.user_hat_project_project_id"
				+ " and uhp.user_hat_project_user_id = u.user_id and u.user_username= '"+loginUsername+"' group by nachtrag_id;";
		ResultSet rs = st.executeQuery(SQL);
		while(rs.next()) {
			Nachtrag myNachtrag = new Nachtrag();
			myNachtrag.setNachtrag_id(rs.getInt(1));
			myNachtrag.setNachtrag_titel(rs.getString(2));
			myNachtrag.setNachtrag_datum(rs.getDate(3).toLocalDate());
			myNachtrag.setNachtrag_beschreibung(rs.getString(4));
			myNachtrag.setNachtrag_vob(rs.getString(5));
			myNachtrag.setNachtrag_verursacher(rs.getString(6));
			myNachtrag.setNachtrag_frist(rs.getDate(7).toLocalDate());
			myNachtrag.setNachtrag_bauteil_id(rs.getInt(8));
			lNachtrag.add(myNachtrag);
		}
		con.close();
		
		return lNachtrag;
	}
	
	public static int getNachtragIdfromName(String name) throws SQLException {
		String SQLGetId="";
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		SQLGetId = " select nachtrag_id from nachtrag where nachtrag_titel='"+name +"';";
		ResultSet rs = st.executeQuery(SQLGetId);
		int id = 0;
		if(rs.next()) 	id= rs.getInt(1);

		con.close();
		return id;
	}
	
	public static void deleteNachtragbyNachtagID(int Nachtrag_id) throws ClassNotFoundException, SQLException {
		String SQL="";
		SQL="delete from nachtrag where nachtrag_id="+Nachtrag_id+"; ";
		execute(SQL);
	}
	
	
	public static List<Position> getPositionfromProject(int projectID) throws SQLException{
		List<Position> lPosition = new ArrayList<Position>();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL= "select position_id, position_name, position_beschreibung from position,bauteil,"
				+ " project where position_id=bauteil_position_id and bauteil_project_id=project_id and project_id = "+projectID+" group by position_id ;";
		ResultSet rs = st.executeQuery(SQL);
		while(rs.next()) {
			Position myPosition = new Position();
			myPosition.setPosition_id(rs.getInt(1));
			myPosition.setPosition_name(rs.getString(2));
			myPosition.setPosition_beschreibung(rs.getString(3));
			lPosition.add(myPosition);
		}
		con.close();
		
		return lPosition;
	}
	
	public static Position getPositionfromNachtragID (int nachtragID) throws SQLException {
		Position myPosition = new Position();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select  position_id, position_name, position_beschreibung from position, bauteil, nachtrag where"
				+ " position_id = bauteil_position_id and nachtrag_bauteil_id = bauteil_id and nachtrag_id="+nachtragID+";";
		ResultSet rs = st.executeQuery(SQL);
		if(rs.next()) {
			
			myPosition.setPosition_id(rs.getInt(1));
			myPosition.setPosition_name(rs.getString(2));
			myPosition.setPosition_beschreibung(rs.getString(3));
		}
		con.close();
		return myPosition;
	}
	
	public static List<Pruefung> getPruefung(String loginUsername) throws SQLException{
		List<Pruefung> lp = new ArrayList<Pruefung>();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL= "  select pruefung_id,pruefung_ergebnis,pruefung_datum,pruefung_nachtrag_id, pruefung_beschreibung, pruefung_flag from project "
				+ "as p, user as u, user_hat_project as uhp , bauteil as b, position, nachtrag, pruefung where "
				+ "pruefung_nachtrag_id = nachtrag_id and nachtrag_bauteil_id=b.bauteil_id and position_id ="
				+ " b.bauteil_position_id and b.bauteil_project_id = p.project_id and "
				+ "p.project_id=uhp.user_hat_project_project_id "
				+ "and uhp.user_hat_project_user_id = u.user_id and u.user_username= '"+loginUsername+"';";
		ResultSet rs = st.executeQuery(SQL);
		while(rs.next()) {
			Pruefung p = new Pruefung();
			p.setPruefung_id(rs.getInt(1));
			p.setPruefung_ergebnis(rs.getString(2));
			p.setPruefung_datum(rs.getDate(3).toLocalDate());
			p.setPruefung_nachtrag_id(rs.getInt(4));
			p.setPruefung_beschreibung(rs.getString(5));
			p.setPruefung_flag(rs.getInt(6));
			lp.add(p);
		}
		con.close();
		
		return lp;
	}
	
	public static Pruefung getPruefungfromNachtragID (int nachtragID) throws SQLException {
		Pruefung n = new Pruefung();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select * from pruefung where pruefung_nachtrag_id="+nachtragID+";";
		ResultSet rs = st.executeQuery(SQL);
		if(rs.next()) {
			n.setPruefung_id(rs.getInt(1));
			n.setPruefung_ergebnis(rs.getString(2));
			n.setPruefung_datum(rs.getDate(3).toLocalDate());
			n.setPruefung_nachtrag_id(rs.getInt(4));
			n.setPruefung_beschreibung(rs.getString(5));
			n.setPruefung_flag(rs.getInt(6));
		}
		con.close();
		return n;
	}
	
	public static void insertPruefung(int pruefungID, String ergebnis, LocalDate datum, int nachtragID, String beschreibung) throws SQLException, ClassNotFoundException{
		String SQL="";
		SQL="INSERT INTO pruefung (pruefung_id, pruefung_ergebnis, pruefung_datum, pruefung_nachtrag_id, pruefung_beschreibung, pruefung_flag)"
				+ " VALUES("+pruefungID+", '"+ergebnis+"', '"+datum+"', "+nachtragID+", '"+beschreibung+"',0) ON DUPLICATE KEY UPDATE"
						+ " pruefung_ergebnis = VALUES(pruefung_ergebnis), pruefung_datum = VALUES(pruefung_datum),"
				+ " pruefung_nachtrag_id = VALUES(pruefung_nachtrag_id), pruefung_beschreibung = VALUES(pruefung_beschreibung),pruefung_flag= VALUES(pruefung_flag) ;";
		execute(SQL);
	}
	
	public static void setDefaultPruefung(LocalDate datum, int nachtragID) throws SQLException, ClassNotFoundException{
		String SQLInsertInto="";
		SQLInsertInto="insert into pruefung (pruefung_ergebnis,pruefung_datum,pruefung_nachtrag_id,pruefung_beschreibung, pruefung_flag)"
				+ " values ('NichtBewertet','"+datum+"',"+nachtragID+",'---',0);";
		execute(SQLInsertInto);
	}
	 
	public static Nachtragskalkulation getNachtragskalkulationfromNachtragID (int nachtragID) throws SQLException {
		Nachtragskalkulation n = new Nachtragskalkulation();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL="select * from kalkulation where kalkulation_nachtrag_id="+nachtragID+";";
		ResultSet rs = st.executeQuery(SQL);
		if(rs.next()) {
			n.setKalkulation_id(rs.getInt(1));
			n.setKalkulation_menge(rs.getDouble(2));
			n.setKalkulation_einheit(rs.getString(3));
			n.setKalkulation_preise_einheit(rs.getDouble(4));
			n.setKalkulation_preise_gesamt(rs.getDouble(5));
			n.setKalkulation_nachtrag_id(rs.getInt(6));
		}
		con.close();
		return n;
	}
	
	
	public static List<Nachtragskalkulation> getNachtragskalkulation(String loginUsername) throws SQLException{
		List<Nachtragskalkulation> ln = new ArrayList<Nachtragskalkulation>();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL= " select kalkulation_id, kalkulation_menge,kalkulation_einheit,kalkulation_preis_einheit,"
				+ "kalkulation_preis_gesamt,kalkulation_nachtrag_id from project as p, user as u, user_hat_project as uhp"
				+ " , bauteil as b, position, nachtrag, kalkulation where kalkulation_nachtrag_id = nachtrag_id and"
				+ " nachtrag_bauteil_id=b.bauteil_id and position_id = b.bauteil_position_id and b.bauteil_project_id"
				+ " = p.project_id and p.project_id=uhp.user_hat_project_project_id "
				+ "and uhp.user_hat_project_user_id = u.user_id and u.user_username= '"+loginUsername+"';";
		ResultSet rs = st.executeQuery(SQL);
		while(rs.next()) {
			Nachtragskalkulation n = new Nachtragskalkulation();
			n.setKalkulation_id(rs.getInt(1));
			n.setKalkulation_menge(rs.getDouble(2));
			n.setKalkulation_einheit(rs.getString(3));
			n.setKalkulation_preise_einheit(rs.getDouble(4));
			n.setKalkulation_preise_gesamt(rs.getDouble(5));
			n.setKalkulation_nachtrag_id(rs.getInt(6));
			ln.add(n);
		}
		con.close();
		
		return ln;
	}
	
	
	
	public static List<NachtragProjectTabele> getNachtragTabele(String loginUsername) throws SQLException{
		List<NachtragProjectTabele> l = new ArrayList<NachtragProjectTabele>();
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL= "Select project_name, bauteil_name, nachtrag_datum, nachtrag_frist, kalkulation_menge, kalkulation_einheit,"
				+ " kalkulation_preis_gesamt, nachtrag_vob,nachtrag_beschreibung, nachtrag_verursacher, pruefung_ergebnis, "
				+ "pruefung_datum, nachtrag_id, pruefung_beschreibung, pruefung_flag from project as p,nachtrag as n, bauteil as b," + 
				" position as po, user as u, user_hat_project as uhp, pruefung as pr, kalkulation as k where"
				+ " k.kalkulation_nachtrag_id=n.nachtrag_id and pr.pruefung_nachtrag_id=n.nachtrag_id  "
				+ "and n.nachtrag_bauteil_id=b.bauteil_id and b.bauteil_position_id = po.position_id and "
				+ " b.bauteil_project_id = p.project_id and uhp.user_hat_project_project_id = "
				+ "p.project_id and uhp.user_hat_project_user_id=u.user_id and u.user_username='"+loginUsername+"' group by nachtrag_id;";
		ResultSet rs = st.executeQuery(SQL);
		while(rs.next()) {
			NachtragProjectTabele n = new NachtragProjectTabele();
			n.setProject_name(rs.getString(1));
			n.setBauteil_name(rs.getString(2));
			n.setNachtrag_datum(rs.getDate(3).toLocalDate());
			n.setNachtrag_frist(rs.getDate(4).toLocalDate());
			n.setKalkulation_menge(rs.getDouble(5));
			n.setKalkulation_einheit(rs.getString(6));
			n.setKalkulation_preis_gesamt(rs.getDouble(7));
			n.setNachtrag_vob(rs.getString(8));
			n.setNachtrag_beschreibung(rs.getString(9));
			n.setNachtrag_verursacher(rs.getString(10));
			n.setPruefung_ergebnis(rs.getString(11));
			if(rs.wasNull()) n.setPruefung_datum(null);
			else{n.setPruefung_datum(rs.getDate(12).toLocalDate());}
			n.setNachtrag_id(rs.getInt(13));
			n.setPruefung_beschreibung(rs.getString(14));
			n.setPruefung_flag(rs.getInt(15));
			l.add(n);
		}
		con.close();
		
		return l;
	}
	
	public static ArrayList<NachtragProjectTabele> NachtragFrist(List<NachtragProjectTabele> list) {
		ArrayList <NachtragProjectTabele> mynachtrag=new ArrayList<NachtragProjectTabele>();
		for(NachtragProjectTabele nachtrag:list) {
			int date=nachtrag.getNachtrag_frist().getDayOfYear()-LocalDate.now().getDayOfYear();
			if(date<30)
				mynachtrag.add(nachtrag);
		}
		
		return mynachtrag;
	}
	
	public static ArrayList<NachtragProjectTabele> PruefungErgebnissNEW(List<NachtragProjectTabele> list) {
		ArrayList <NachtragProjectTabele> m=new ArrayList<NachtragProjectTabele>();
		for(NachtragProjectTabele p:list) {
			long daysBetween = daysToNow(p.getPruefung_datum());

			if(daysBetween<30 && daysBetween>0)
			{
				if(!(p.getPruefung_ergebnis().contentEquals("NichtBewertet"))) m.add(p);
			}
				
		}
		
		return m;
	}
	
	public static long daysToNow(LocalDate fromDate) {
		  return ChronoUnit.DAYS.between(fromDate, LocalDate.now());
		}
}
