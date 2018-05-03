package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Servlet_User
 */
@WebServlet("/Servlets_User")
public class Servlet_User extends HttpServlet {
		private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


		
	}
	
	/*
	@SuppressWarnings("null")
	public void Projekt_Anzeige(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession mysession=request.getSession();
		Login user=(Login) mysession.getAttribute("utilisateur");	
		//MySQL Connection
		ResultSet rs;
		Connection  con;
		Statement st;
		con= databank.getInstance();
		st = con.createStatement();
		String SQL_Projekt="";
	     rs = st.executeQuery(SQL_Projekt);
	     rs = st.executeQuery(SQL_Call_User_Projekt+user.getLogin()+"';");
		Project project=new Project();
		ArrayList<Project> maListe = null;
		while(rs.next()) {	
			project.setProject_anfang(rs.getString("project_anfang"));
			project.setProject_end(rs.getString("project_end"));
			project.setProject_name(rs.getString("project_name"));
			project.setProject_id(rs.getInt("project_id"));
			maListe.add(project);
			
		}
		  
		if(maListe.isEmpty()) {
			int message = 1;
			request.setAttribute( "message", message );
			this.getServletContext().getRequestDispatcher( "./Vue_Backend/Error.jsp" ).forward( request, response );
			
		}else {
			for(Project mproject : maListe){
				System.out.println(mproject.getProject_id());
				System.out.println(mproject.getProject_name());
			}
			mysession.setAttribute("myListe",maListe); //mit diese liste hast du alle projet in user_Fronkend.jsp
			this.getServletContext().getRequestDispatcher("./Vue_Backend/project.jsp").forward(request, response);
			
		}
			
			
			
			Connection_and_ResultSet_close.silentClosing(rs, st, con);
	}


	*/
	

}
