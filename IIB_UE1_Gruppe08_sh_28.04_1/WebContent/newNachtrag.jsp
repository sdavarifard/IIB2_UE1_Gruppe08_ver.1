<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ page import="Beans.*"  %>
            <%@ page import="DB_connect.*"  %>
            <%@ page import="java.sql.*"  %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>New Nachtrag</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<script>
		var projectid = 0;
				function getComboProject() {
		    		var projectid =  selectObject.value;
		    		projectid =  document.getElementById("project").value;
		    		console.log(projectid);
		    		//document.getElementById("input").value = projectid;
				}
		</script>
</head>
<body>
		
		<div id="page-wrapper">

			<!-- Header -->
				<header id="header">
					
					<nav id="nav">
						<ul>
							<li><a href="home.jsp">Home</a></li>
							<li>
								<a href="#" class="icon fa-angle-down">Leisung</a>
								<ul>
									<li><a href="project.jsp">Projekts</a></li>
									<li><a href="nachtrags.jsp">Nachtrags</a></li>
									<li><a href="elements.html">Elements</a></li>
									<li>
										<a href="#">About Programm</a>
										<ul>
											<li><a href="#">Datenbank</a></li>
											<li><a href="#">ERM</a></li>
											<li><a href="#">JSP</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li><a href="index.jsp" class="button">Logout</a></li>
						</ul>
					</nav>
				</header>

			<!-- Main -->
				<section id="main" class="container">
					<header>
						<h2>Elements</h2>
						<p>Just an assorted selection of elements.</p>
					</header>
					<div class="row">
						<div class="12u">


							<!-- Buttons -->
						</div>
					</div>
					<div class="row">
						<div class="12u">

							<!-- Form -->
								<section class="box">
									<h3>Nachtrag</h3>
                                    
									<form method="post" action="./Servlet_Nachtrag">
										<div class="row uniform 50%">
                                        <table >
                                        <tr>
                                            <td colspan="2">
                                            <div><input type="text" name="title" id="title" value="" placeholder="Title"/>
											</div>
                                            </td>
                                            
                                            <td>
                                            <div>
												Datum: <input type="date" name="datum" id="datum" value="" placeholder="Datum" />
											</div>
                                            </td>
                                          </tr>
                                          
                                          		 
                                           <tr>
                                            <td><div ><input type="text" name="becshreibung" value="" placeholder="Beschreibung"/></td>
                                            <td><div ><input type="text" name="VOB" value="" placeholder="VOB"/></td>
                                            <td><div ><input type="text" name="verursacher" value="" placeholder="Verursacher"/></td>
                                          </tr>
                                                                                     <tr>
                                            <td><div >Frist: <input type="date" name="frist_datum" id="frist_datum" value="" placeholder="Frist" /></td>
                                            <td colspan="2"><div >
                                            
											<div>
												<div class="select-wrapper">
													<select name="category" id="category">
														<c:forEach items="${myPosition}" var="p">
														    <c:forEach items="${myBauteil}" var="b">
														       <option value="${b.getBauteil_id()}">Bauteil: ${b.getBauteil_name()} Position:${p.getPosition_name()}</option>
														     </c:forEach>
													     </c:forEach>
													</select>
												</div>
											</div>
										</div>
										
                                            </td>
                                            
                                           <tr>
                                            <td>
                                            	<select name="project" id="project" onchange="getComboProject()">
                                            	<c:forEach items="${myProject}" var="p">
                                            		<option value="${p.getProject_id()}">Selected Project: ${p.getProject_name()} </option>
												</c:forEach>
                                            	</select>	
                                            </td>
                                            <td>
                                                <select>
                                            		<option value="0">Select Position</option>
                                            		                                            		<%
                                            			try{
                                            				Connection  con= databank.getInstance();
                                            				Statement st = con.createStatement();
                                            				String SQL= " select position_id, position_name, position_beschreibung from position,bauteil, project where position_id=bauteil_position_id and bauteil_project_id =;";                 
                                            				PreparedStatement psm = con.prepareStatement(SQL);
                                            				ResultSet rs = st.executeQuery(SQL);
                                            				while(rs.next()) {
                                            					%>
                                            					<option value="<%=rs.getInt("position_id")%>"><%=rs.getString("position_name")%> , <%=rs.getString("position_beschreibung")%></option>
                                            					<%
                                            				}
                                            				con.close();

                                            				
                                            			}catch(Exception e){
                                            				e.printStackTrace();
                                            			}
                                            		
                                            		
                                            		%>
                                            	</select>
                                            </td>
                                            <td>
                                            	<select>
                                            		<option value="0">Select Bauteil</option>
                                            	</select>
                                            </td>
                                          </tr>
											
                                        
                                        </table>
                                        
										</div>
										<div class="row uniform">
											<div class="12u">
												<ul class="actions">
												<input type="hidden" name="userId" value="${user.getUser_id()}">
												<input type="hidden" name="myBauteil" value="${bauteil.getBauteil_id()}">
												<input type="hidden" name="myPosition" value="${position.getPosition_id()}"> 
													<li><input type="submit" value="Send Message" /></li>
													<li><input type="reset" value="Reset" class="alt" /></li>
												</ul>
											</div>
										</div>
									</form>
                                    					
					
				</section>

			<!-- Footer -->
				<footer id="footer">
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
						<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
						<li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
					</ul>
					<ul class="copyright">
						<li>&copy; Shervin & Polycarpe. All rights reserved.</li>
					</ul>
				</footer>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrollgress.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	
</body>
</html>