package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import Beans.Project;
import DB_manager.Project_Manager;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 * Servlet implementation class Servlet_Project
 */
@WebServlet("/Servlet_Project")
public class Servlet_Project extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		Project p = new Project();
		String AN="";
		String userID="";
		String name="";
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session = req.getSession(true);
		if(req.getParameter("name").equals("")) { //|| req.getParameter("anfang_datum").equals(null) || req.getParameter("end_datum").equals(null)||req.getParameter("land").equals("") || req.getParameter("stadt").equals("")) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Accountant Panel</title>");
			out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
			out.println("<link rel='stylesheet' href='style.css'/>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Fill ALLE</h1>");
			out.println("</body>");
			out.println("</html>");
		}else {
			DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate anfang = LocalDate.parse(req.getParameter("anfang_datum"), DATEFORMATTER);
			LocalDate end = LocalDate.parse(req.getParameter("end_datum"), DATEFORMATTER);
			name = req.getParameter("name");
			String land= req.getParameter("land");
			String stadt= req.getParameter("stadt");
			int plz = Integer.parseInt(req.getParameter("plz"));
			String adresse= req.getParameter("adresse");
			AN = req.getParameter("Auftragnehmer");
			userID = req.getParameter("userId");
			//int userID = (int) req.getSession(false).getAttribute("userID");
			try {
				p = Project_Manager.insertNewProject(name, anfang, end, land, stadt, plz, adresse);
				Project_Manager.insertProjectSQLTabele(p);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//	out.println("<h1 style='color:red;'>neues Projekt Erfolgreich hinzugefugt!</h1>");
		//	out.println("<meta http-equiv='refresh' content='2;URL=newProject.jsp'>");

			}
		//session.setAttribute("newProjectID", p.getProject_id());
		session.setAttribute("AN", AN);
		session.setAttribute("projectName", name);
		session.setAttribute("userID", userID);
		res.sendRedirect("Servlet_UHP");
		}
	}

