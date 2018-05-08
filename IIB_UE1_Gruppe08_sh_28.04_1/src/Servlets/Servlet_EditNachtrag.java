package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Bauteil;
import Beans.Nachtrag;
import DB_manager.Project_Manager;

/**
 * Servlet implementation class Servlet_EditNachtrag
 */
@WebServlet("/Servlet_EditNachtrag")
public class Servlet_EditNachtrag extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("username");
		String title= req.getParameter("title");
		DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate Datum = LocalDate.parse(req.getParameter("datum"), DATEFORMATTER);
		String becshreibung= req.getParameter("becshreibung");
		String VOB= req.getParameter("VOB");
		String verursacher= req.getParameter("verursacher");
		LocalDate frist = LocalDate.parse(req.getParameter("frist_datum"), DATEFORMATTER);
		String einheit = req.getParameter("Einheit");
		double menge=Double.parseDouble(req.getParameter("Menge"));
		double preis_einheit=Double.parseDouble(req.getParameter("Preis_Einheit"));
		double preisgesamt=Double.parseDouble(req.getParameter("Preis_Gesamt"));
		int selectedNachtragID = (int) session.getAttribute("selectedNachragID");
		
		try {
			
			Project_Manager.editNachtragSQLTabele(selectedNachtragID, title, Datum, becshreibung, VOB, verursacher, frist);
			Project_Manager.editNachtragKalkulationSQLTabele(menge, einheit, preis_einheit, preisgesamt, selectedNachtragID);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.removeAttribute("myNachtragTabele");
		try {
			session.setAttribute("myNachtragTabele", Project_Manager.getNachtragTabele(username));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.sendRedirect("nachtrag.jsp");
	}

}
