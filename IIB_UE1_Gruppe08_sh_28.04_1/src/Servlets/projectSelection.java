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

import DB_manager.Project_Manager;

/**
 * Servlet implementation class projectSelection
 */
@WebServlet("/projectSelection")
public class projectSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int selectedProject = Integer.parseInt(request.getParameter("selectedProject"));
		HttpSession session = request.getSession(true);
		try {
			session.setAttribute("positionList", Project_Manager.getPositionfromProject(selectedProject));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("selectedProjectID",selectedProject);
		response.sendRedirect("closeOnLoad.jsp");
		
				
	}

}
