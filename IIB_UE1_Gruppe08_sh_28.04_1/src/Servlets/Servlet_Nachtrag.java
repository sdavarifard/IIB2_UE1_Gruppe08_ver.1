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

import Beans.Nachtrag;
import DB_manager.Project_Manager;

/**
 * Servlet implementation class Servlet_Nachtrag
 */
@WebServlet("/Servlet_Nachtrag")
public class Servlet_Nachtrag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Nachtrag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doPost(req, res);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Nachtrag n = new Nachtrag();
		HttpSession session = req.getSession(true);
		String title= req.getParameter("title");
		DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate Datum = LocalDate.parse(req.getParameter("datum"), DATEFORMATTER);
		String becshreibung= req.getParameter("becshreibung");
		String VOB= req.getParameter("VOB");
		String verursacher= req.getParameter("verursacher");
		LocalDate frist = LocalDate.parse(req.getParameter("frist_datum"), DATEFORMATTER);
		String project_name = req.getParameter("selecetProject");
		String position_name = req.getParameter("selecetPosition");
		String bauteil_name = req.getParameter("selecetBauteil");
		int bauteilID=0;
		try {
			bauteilID = Project_Manager.getBauteilIDfromProjectandPosition(project_name, position_name, bauteil_name);
			n=Project_Manager.insertNewNachtrag(title, Datum, becshreibung, VOB, verursacher, frist, bauteilID);
			Project_Manager.insertNewNachtragSQLTabele(n);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.removeAttribute("myNachtrag");
		session.removeAttribute("myNachtragTabele");
		try {
			session.setAttribute("myNachtrag", Project_Manager.getNachtrag(session.getAttribute("user").toString()));
			session.setAttribute("myNachtragTabele", Project_Manager.getNachtragTabele(session.getAttribute("user").toString()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		res.sendRedirect("nachtrag.jsp");
	}

}
