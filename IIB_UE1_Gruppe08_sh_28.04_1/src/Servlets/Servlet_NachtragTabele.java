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
 * Servlet implementation class Servlet_NachtragTabele
 */
@WebServlet("/Servlet_NachtragTabele")
public class Servlet_NachtragTabele extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
			
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);

		session.removeAttribute("myNachtragTabele");
		try {
			session.setAttribute("myNachtragTabele", Project_Manager.getNachtragTabele((String) session.getAttribute("username")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.sendRedirect("nachtrag.jsp");
	}

}
