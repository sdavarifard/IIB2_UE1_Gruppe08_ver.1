<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="Beans.*"  %>
    <%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Nachtrag</title>

		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<input type="hidden" id="userTaetigkeit" name="userTaetigkeit" value="${user.getUser_taetigkeit()}">

</head>
<body onload="btnHide()">

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
									<li><a href="nachtrag.jsp">Nachtrags</a></li>
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
						<h2>Nachtrag</h2>
						<p>Hier finsen Sie Ihre actuelle Nachtrags</p>
					</header>

							<!-- Table -->
								<section class="box">
									<h3>Nachtrag</h3>

									<div class="table-wrapper"  >
										<table>
											<thead >
												<tr>
													<th>Project Name</th>
													<th>Bauteil</th>
													<th>Nachtrag Datum</th>
													<th>Frist</th>
                                                    <th>Menge</th>
                                                    <th>Preis($)</th>
                                                    <th>VOB Kl.</th>
                                                    <th>Beschreibung</th>
                                                    <th>Verursacher</th>
                                                    <th>Prüfung Ergebnis</th>
                                                    <th>Prüfung Datum</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${myNachtragTabele}" var="mn">
												<tr>
													<td>${mn.getProject_name()}</td>
													<td>${mn.getBauteil_name()}</td>
													<td>${mn.getNachtrag_datum()}</td>
													<td>${mn.getNachtrag_frist()}</td>
													<td>${mn.getKalkulation_menge()}${mn.getKalkulation_einheit()}</td>
													<td>${mn.getKalkulation_preis_gesamt()}</td>
													<td>${mn.getNachtrag_vob()}</td>
													<td>${mn.getNachtrag_beschreibung()}</td>
													<td>${mn.getNachtrag_verursacher()}</td>
													<td>${mn.getPruefung_ergebnis()}</td>
													<td>${mn.getPruefung_datum()}</td>
													
												</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<ul class="actions">
									
									<li><a href="newNachtrag.jsp" id="btnNewNachtrag" class="button special">neuer Nachtrag</a></li>
									<li><a href="#" id="btnEditNachtrag" class="button">Nachtrag bearbeiten</a></li>
									
										<li><a href="#" class="button alt">Zuruck</a></li>
									</ul>
								</section> 
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
			
			
		<script type="text/javascript">
		 function btnHide(){
				var elt = document.getElementById("userTaetigkeit").value;
				
				var hlink1 = document.getElementById("btnNewNachtrag");
				var hlink2 = document.getElementById("btnEditNachtrag");
				if(elt!="Bauleiter"){
					hlink1.href = "#";
					hlink1.className = "button special disabled";

					hlink2.href = "#";
					hlink2.className = "button special disabled"; 
				}
				
			}
		</script>
	

</body>
</html>