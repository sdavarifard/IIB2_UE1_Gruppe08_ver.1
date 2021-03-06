package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB_manager.Project_Manager;

/**
 * Servlet implementation class positionSelection
 */
@WebServlet("/positionSelection")
public class positionSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		int selectedPosition = Integer.parseInt(request.getParameter("selectedPositionPopUp"));
		int selectedProject = (int) session.getAttribute("selectedProjectID");
		try {
			session.setAttribute("bauteilList", Project_Manager.getBauteilfromProjectandPosition(selectedProject, selectedPosition));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("selectedPositionID", selectedPosition);
		response.sendRedirect("closeOnLoad.jsp");
	}

}
