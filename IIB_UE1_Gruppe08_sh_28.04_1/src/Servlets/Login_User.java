package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB_manager.Project_Manager;
import DB_manager.User_Manager;

/**
 * Servlet implementation class Passwort_Pruef
 */
@WebServlet("/Login_User")
public class Login_User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String username = request.getParameter("login");
		String password = request.getParameter("password");
		String fachrolle = request.getParameter("taetigkeit");
		String err = "";
		if(username.equals("") || password.equals("")) {
			err += "Bitte geben Username und Password";
		}else {
		
			try {
				String url = "index.html";
				boolean status = User_Manager.loginVerify(username, password,fachrolle);
				if(status=false)err+="username oder passqord ist Falsch";
					if(err.length()==0) {
						
						session.setAttribute("login", "true");
						session.setAttribute("user", User_Manager.getUser(username));
						session.setAttribute("myProject", Project_Manager.getProject(username));
						session.setAttribute("myBauteil", Project_Manager.getBauteil(username));
						session.setAttribute("myPosition", Project_Manager.getPosition(username));
						session.setAttribute("myNachtrag", Project_Manager.getNachtrag(username));
						session.setAttribute("myPruefung", Project_Manager.getPruefung(username));
						session.setAttribute("myKalkulation", Project_Manager.getNachtragskalkulation(username));
						
						session.setAttribute("myNachtragTabele", Project_Manager.getNachtragTabele(username));
						response.sendRedirect("home.jsp");
						
						url = "test.jsp";
					}else {
						url = "index.html";
						RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
						rd.forward(request, response);
					}
				} 
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
			
			}
		
		}
}


