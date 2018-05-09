package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
		String err = "";
		HttpSession session = request.getSession(true);
		
		String username = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(username.equals("") || password.equals("")) {
			//out.println("<meta http-equiv='refresh' content='3;URL=index.html'>");//redirects after 3 seconds
			   //out.println("<p style='color:red;'>Bitte Füllen Username und Password!!</p>");
			err = "Bitte Füllen Username und Password!!";
			session.setAttribute("FehlerLogin", err);
			response.sendRedirect("index.jsp");
		}else {
		
			try {
				boolean status = User_Manager.loginVerify(username, password);
				if(status==false) {
					err = "User oder Password FALSCH!!";
					session.setAttribute("FehlerLogin", err);
					response.sendRedirect("index.jsp");
				}if(err.length()==0) {
						
						session.setAttribute("login", "true");
						session.setAttribute("user", User_Manager.getUser(username));
						session.setAttribute("myProject", Project_Manager.getProject(username));
						session.setAttribute("username", username);
						
						session.setAttribute("myNachtragTabele", Project_Manager.getNachtragTabele(username));
						session.setAttribute("mynachtrag",Project_Manager.NachtragFrist( Project_Manager.getNachtrag(username)));
						response.sendRedirect("home.jsp");
						
					}
				} 
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
			
			}
		}
}


