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

import Beans.Pruefung;
import DB_manager.Project_Manager;

/**
 * Servlet implementation class Servlet_Pruefung
 */
@WebServlet("/Servlet_Pruefung")
public class Servlet_Pruefung extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession(true);
		Pruefung p = (Pruefung) session.getAttribute("selectedPruefung");
		String pruefungErgebnis = req.getParameter("pruefungErgebnis");
		DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate Datum = LocalDate.parse(req.getParameter("pruefungDatum"), DATEFORMATTER);
		String pruefungBeschreibung= req.getParameter("pruefungBeschreibung");
		int nachtragID = (int) session.getAttribute("selectedNachragID");
		
		try {
			Project_Manager.insertPruefung(p.getPruefung_id(),pruefungErgebnis, Datum, nachtragID, pruefungBeschreibung);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		res.sendRedirect("Servlet_NachtragTabele");
	}

}
