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
                                        <table >
                                        <tr>
                                            <td colspan="3">
                                            <input type="text" name="title" id="title" value="" placeholder="Title"/>
                                            </td>
                                            
                                            <td> <input type="text" name="datum" id="datum" value="" placeholder="Datum" onchange="dateControll();" onFocus="this.type='date'" />
                                     
											
                                            </td>
                                          </tr>
                                          
                                          		 
                                           <tr>
                                            <td><input type="text" name="becshreibung" value="" placeholder="Beschreibung"/></td>
                                            <td><input type="text" name="VOB" value="" placeholder="VOB"/></td>
                                            <td><input type="text" name="verursacher" value="" placeholder="Verursacher"/></td>
                                            <td>
                                            <input type="text" name="frist_datum" id="frist_datum" value="" placeholder="Frist" onchange="dateControll();"  onFocus="this.type='date'"/></td>
                                          </tr>
                                           <tr>
                                           
                                           <td colspan="2"><a class="button special" onclick="btnSelectProject()">Select Project</a>
                                           </td>
                                           
                                           
                                           <td><a class="button" onclick="btnSelectPosition()">Select Position</a></td>
                                           <td><a class="button alt" onclick="btnSelectBauteil()">Select Bauteil</a> </td>
                    
                                           </tr>
                                           
                                           
                                           <tr>
                                           
                                           <tr>
                                           <td colspan="2"><input type="text" id="selectedProject" name="selectedProject" readonly="readonly">
                                           </td>
                                           
                                           
                                           <td><input type="text" id="selectedPosition" name="selectedPosition" readonly="readonly"></td>
                                           <td><input type="text" id="selectedBauteil" name="selectedBauteil" readonly="readonly"></td>
                                           </tr>
                                          
                                          <tr>
                                            <td><input type="text" name="Menge" value="" placeholder="Menge"/></td>
                                            <td><input type="text" name="Einheit" value="" placeholder="Einheit"/></td>
                                            <td><input type="text" name="Preis_Einheit" value="" placeholder="Preis Einheit"/></td>
                                            <td><input type="text" name="Preis_Gesamt" value="" placeholder="Preis Gesamt"/></td>
                                          </tr>
                                          
                                          
											
                                        
                                        </table>
										<div class="row uniform">
											<div class="12u">
												<ul class="actions">
													<li><input type="submit" value="submit" /></li>
													<li><input type="reset" value="Reset" class="alt" /></li>
												</ul>
											</div>
										</div>
									</form>
                                <script>
										var popupProject;
										function btnSelectProject() {
									    	popupProject = window.open("project_select.jsp", "Popup", "width=700,height=400");
									    	popupProject.focus();
									        return false
									    }
										var popupPosition;
										function btnSelectPosition() {
											popupPosition = window.open("position_select.jsp", "Popup", "width=700,height=400");
											popupPosition.focus();
									        return false
									    }
										var popupBauteil;
										function btnSelectBauteil() {
											popupPosition = window.open("bauteil_select.jsp", "Popup", "width=700,height=400");
											popupPosition.focus();
									        return false
									    }
										
										function dateControll(){
											var StartDate= document.getElementById('datum').value;
											  var EndDate= document.getElementById('frist_datum').value;
											  var eDate = new Date(EndDate);
											  var sDate = new Date(StartDate);
											  if(StartDate!= '' && StartDate!= '' && sDate> eDate)
												{
												alert("Bitte Controllieren Sie! Frist Datum muss nach Nachtragdatum sein..");
												return false;
												}
										}
							</script>
                                    					
					
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