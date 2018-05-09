package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Nachtrag;
import Beans.Nachtragskalkulation;
import Beans.*;
import DB_manager.Project_Manager;

/**
 * Servlet implementation class nachtragSelection
 */
@WebServlet("/nachtragSelection")
public class nachtragSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int selectedNachtragID = Integer.parseInt(request.getParameter("selectedNachtrag"));
		HttpSession session = request.getSession(true);
		Nachtragskalkulation nk = new  Nachtragskalkulation();
		try {
			if(selectedNachtragID !=0) {
				session.setAttribute("selectedNachtrag", Project_Manager.getNachtragfromNachtragID(selectedNachtragID));
				session.setAttribute("selectedKalkulation", Project_Manager.getNachtragskalkulationfromNachtragID(selectedNachtragID));
				session.setAttribute("selectedProjectforEditNachtrag", Project_Manager.getProjectfromNachtragID(selectedNachtragID));
				session.setAttribute("selectedPositionforEditNachtrag", Project_Manager.getPositionfromNachtragID(selectedNachtragID));
				session.setAttribute("selectedBauteilforEditNachtrag", Project_Manager.getBauteilfromNachtragID(selectedNachtragID));
				session.setAttribute("selectedPruefung", Project_Manager.getPruefungfromNachtragID(selectedNachtragID));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("selectedNachragID", selectedNachtragID);
		response.sendRedirect("closeOnLoad.jsp");

	}

}
