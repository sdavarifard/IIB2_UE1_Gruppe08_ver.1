<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ page import="Beans.*"  %>
            <%@ page import="DB_connect.*"  %>
            <%@ page import="java.sql.*"  %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Prüfen</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->

</head>
<body onload="defaultValue()">
		
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
						<h2>Nachtrag Prüfen</h2>
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
                                    <ul class="actions fit">
										<li>Select Nachtrag:</li>
										<li><a onclick="btnSelectNachtrag()" class="button fit">Select Nachtrag</a></li>
										
										
									</ul>
									
									<form method="post" action="./Servlet_Pruefung">
									
                                        <table >
                                        <h1>Nachtrag Information</h1>
                                        <tr>
                                            <td colspan="3">
                                            <input type="text" name="title" id="title" value="" placeholder="Title" readonly="readonly"/>
                                            </td>
                                            
                                            <td> <input type="text" name="datum" id="datum" value="" placeholder="Datum" readonly="readonly" />
                                     		</td>
                                          </tr>
                                          
                                          		 
                                           <tr>
                                            <td><input type="text" id="becshreibung" name="becshreibung" value="" placeholder="Beschreibung" readonly="readonly"/></td>
                                            <td><input type="text" id="VOB" name="VOB" value="" placeholder="VOB" readonly="readonly"/></td>
                                            <td><input type="text" id="verursacher" name="verursacher" value="" placeholder="Verursacher" readonly="readonly"/></td>
                                            <td>
                                            <input type="text" id="frist_datum" name="frist_datum" id="frist_datum" value="" placeholder="Frist" readonly="readonly"/></td>
                                          
                                           <tr>
                                           
                                           <tr>
                                           <td colspan="2"><input type="text" id="selectedProject" name="selectedProject" readonly="readonly">
                                           </td>
                                           
                                           
                                           <td><input type="text" id="selectedPosition" name="selectedPosition" readonly="readonly"></td>
                                           <td><input type="text" id="selectedBauteil" name="selectedBauteil" readonly="readonly"></td>
                                           </tr>
                                          
                                          <tr>
                                            <td><input type="text" id="Menge" name="Menge" value="" placeholder="Menge" readonly="readonly"/></td>
                                            <td><input type="text" id="Einheit" name="Einheit" value="" placeholder="Einheit" readonly="readonly"/></td>
                                            <td><input type="text" id="Preis_Einheit" name="Preis_Einheit" value="" placeholder="Preis Einheit" readonly="readonly"/></td>
                                            <td><input type="text" id="Preis_Gesamt" name="Preis_Gesamt" value="" placeholder="Preis Gesamt" readonly="readonly"/></td>
                                          </tr>
                                          
                                          
											
                                        
                                        </table>
                                        
                                        <p></p>
                                        <h1>Prüfung Formular</h1>
                                        <table>
                                        <tr>
                                            <td><input type="text" id="pruefungDatum" name="pruefungDatum" value="" placeholder="Datum" onFocus="this.type='date'"/></td>
                                            
                                             <td><input type="text" id="pruefungErgebnis" name="pruefungErgebnis" value="" placeholder="Ergebnis"/></td>
                                           
                                            <td><input type="text" id="pruefungBeschreibung" name="pruefungBeschreibung" value="" placeholder="Beschreibung"/></td>
                                          </tr>
                                        
                                        </table>
										<div class="row uniform">
											<div class="12u">
												<ul class="actions">
													<li><input type="submit" value="submit" /></li>
												</ul>
											</div>
										</div>
									</form>
									<input type="hidden" id="getNachtrag_titel" value="${selectedNachtrag.getNachtrag_titel()}">
									<input type="hidden" id="getNachtrag_datum" value="${selectedNachtrag.getNachtrag_datum()}">
									<input type="hidden" id="getNachtrag_beschreibung" value="${selectedNachtrag.getNachtrag_beschreibung()}">
									<input type="hidden" id="getNachtrag_vob" value="${selectedNachtrag.getNachtrag_vob()}">
									<input type="hidden" id="getNachtrag_verursacher" value="${selectedNachtrag.getNachtrag_verursacher()}">
									<input type="hidden" id="getNachtrag_frist" value="${selectedNachtrag.getNachtrag_frist()}">
									<input type="hidden" id="getKalkulation_menge" value="${selectedKalkulation.getKalkulation_menge()}">
									<input type="hidden" id="getKalkulation_einheit" value="${selectedKalkulation.getKalkulation_einheit()}">
									<input type="hidden" id="getKalkulation_preise_einheit" value="${selectedKalkulation.getKalkulation_preise_einheit()}">
									<input type="hidden" id="getKalkulation_preise_gesamt" value="${selectedKalkulation.getKalkulation_preise_gesamt()}">
									<input type="hidden" id="getProject_name" value="${selectedProjectforEditNachtrag.getProject_name()}">
									<input type="hidden" id="getPosition_name" value="${selectedPositionforEditNachtrag.getPosition_name()}">
									<input type="hidden" id="getBauteil_name" value="${selectedBauteilforEditNachtrag.getBauteil_name()}">
									<input type="hidden" id="getPruefung_datum" value="${selectedPruefung.getPruefung_datum()}">
									<input type="hidden" id="getPruefung_ergebnis" value="${selectedPruefung.getPruefung_ergebnis()}">
									<input type="hidden" id="getPruefung_beschreibung" value="${selectedPruefung.getPruefung_beschreibung()}">
                                <script>
                                	
                                		function defaultValue() {
                                			document.getElementById("title").defaultValue =document.getElementById("getNachtrag_titel").value;
                                			document.getElementById("datum").defaultValue =document.getElementById("getNachtrag_datum").value;
                                			document.getElementById("becshreibung").defaultValue =document.getElementById("getNachtrag_beschreibung").value;
                                			document.getElementById("VOB").defaultValue =document.getElementById("getNachtrag_vob").value;
                                			document.getElementById("verursacher").defaultValue =document.getElementById("getNachtrag_verursacher").value;
                                			document.getElementById("frist_datum").defaultValue =document.getElementById("getNachtrag_frist").value;
                                			document.getElementById("selectedProject").defaultValue =document.getElementById("getProject_name").value;
                                			document.getElementById("selectedPosition").defaultValue =document.getElementById("getPosition_name").value;
                                			document.getElementById("selectedBauteil").defaultValue =document.getElementById("getBauteil_name").value;
                                			document.getElementById("Menge").defaultValue =document.getElementById("getKalkulation_menge").value;
                                			document.getElementById("Einheit").defaultValue =document.getElementById("getKalkulation_einheit").value;
                                			document.getElementById("Preis_Einheit").defaultValue =document.getElementById("getKalkulation_preise_einheit").value;
                                			document.getElementById("Preis_Gesamt").defaultValue =document.getElementById("getKalkulation_preise_gesamt").value;
                                			document.getElementById("pruefungDatum").defaultValue =document.getElementById("getPruefung_datum").value;
                                			document.getElementById("pruefungErgebnis").defaultValue =document.getElementById("getPruefung_ergebnis").value;
                                			document.getElementById("pruefungBeschreibung").defaultValue =document.getElementById("getPruefung_beschreibung").value;
                                			
                                			var d = new Date();
                                			//document.getElementById('pruefungDatum').value= Date();
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
										//Nachtrag Slection Pop_UP
										var popupNachtrag;
										function btnSelectNachtrag() {
											popupNachtrag = window.open("nachtrag_select.jsp", "Popup", "width=700,height=400");
											popupNachtrag.focus();
											location.reload();
									        return false
									    }
										
										//Page Refresh
										window.setInterval(function(){
										    if(localStorage["update"] == "1"){
										        localStorage["update"] = "0";
										        alert("Default Datei wurden eingesetzt!");
										        location.reload();
										    }
										}, 50);
										
										//Default Value
										
				
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