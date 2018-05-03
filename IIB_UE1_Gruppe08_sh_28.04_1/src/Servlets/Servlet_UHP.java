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
 * Servlet implementation class Servlet_UHP
 */
@WebServlet("/Servlet_UHP")
public class Servlet_UHP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		int userID = Integer.parseInt(session.getAttribute("userID").toString());
		String AN = session.getAttribute("AN").toString();
		String name = session.getAttribute("projectName").toString();
		if (!name.isEmpty()) {
				try {
					int ProjectID = Project_Manager.getProjectIdfromName(name);
					Project_Manager.insertUserHatProject(userID,ProjectID,AN);
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}

		session.removeAttribute("myProject");
		try {
			session.setAttribute("myProject", Project_Manager.getProjectfromUserID(userID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("project.jsp");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
