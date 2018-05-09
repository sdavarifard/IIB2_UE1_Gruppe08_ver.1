package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Nachtragskalkulation;
import DB_manager.Project_Manager;

/**
 * Servlet implementation class Servlet_Nchtragskalkulation
 */
@WebServlet("/Servlet_Nchtragskalkulation")
public class Servlet_Nchtragskalkulation extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Nachtragskalkulation nk = new Nachtragskalkulation();
		HttpSession session = req.getSession(true);
		int nachtragID = (int) session.getAttribute("nachtragID");
		String einheit =(String) session.getAttribute("Kal_Einheit_EditNachtrag") ;
		double menge = (double) session.getAttribute("Kal_Menge_EditNachtrag");
		double preisEin=(double) session.getAttribute("Kal_Preis_Einheit_EditNachtrag");
		double preisGes= (double) session.getAttribute("Kal_Preis_Gesamt_EditNachtrag");
		LocalDate datum = (LocalDate) session.getAttribute("datum_editNachtrag");
		try {
			Project_Manager.setDefaultPruefung(datum, nachtragID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nk = Project_Manager.insertNewNachtragskalkulation(menge, einheit, preisEin, preisGes, nachtragID);
		try {
			Project_Manager.insertNewNachtragKalkulationSQLTabele(nk);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.sendRedirect("Servlet_NachtragTabele");
				
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
