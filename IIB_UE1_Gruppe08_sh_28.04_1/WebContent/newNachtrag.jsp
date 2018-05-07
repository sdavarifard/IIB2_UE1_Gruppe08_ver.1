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
                                            <td><input type="text" name="becshreibung" value="" placeholder="Beschreibung"/></td>
                                            <td><input type="text" name="VOB" value="" placeholder="VOB"/></td>
                                            <td><input type="text" name="verursacher" value="" placeholder="Verursacher"/></td>
                                          </tr>
                                          <tr>
                                            <td>Frist: <input type="date" name="frist_datum" id="frist_datum" value="" placeholder="Frist" /></td>
                                            <td colspan="2">
										
                                            </td>
                                            
                                           </tr>
                                           <tr>
                                           
                                           <td><select name="selecetProject" id="ddl1" onchange="configureDDL2(this, document.getElementById('ddl2'), document.getElementById('ddl3'))">
											    <option value="">Project</option>
											    <option value="100B Hochhaus">100B Hochhaus </option>
											    <option value="Darmstadt Brückenbau">Darmstadt Brückenbau</option>
											    <option value="Schlosspark Ensemble">Schlosspark Ensemble</option>
												<option value="FIFTYSEVEN">FIFTYSEVEN</option>
											</select>
                                           </td>
                                           
                                           
                                           <td>
                                           <select name="selecetPosition" id="ddl2" onchange="configureDDL3(document.getElementById('ddl1'), this, document.getElementById('ddl3'))">
 												 </select>
											 </td>
                                           <td> <select name="selecetBauteil" id="ddl3">
 													 </select>
                                           </td>
                    
                                           </tr>
											
                                        
                                        </table>
                                        
										</div>
										<div class="row uniform">
											<div class="12u">
												<ul class="actions">
													<li><input type="submit" value="next" /></li>
													<li><input type="reset" value="Reset" class="alt" /></li>
												</ul>
											</div>
										</div>
									</form>
                                <script>
									var myNestedVals = {
											'100B Hochhaus': {
												'Erd Geschoss': ['Wand', 'Fenster', 'Dach', 'Stuetz'],
												'1 Geschoss': ['Wand', 'Fenster', 'Dach', 'Stuetz']
												
											},
											'Darmstadt Brückenbau': {
												'Überbau': ['Stahl','Beton'],
												'Träger': ['Schalung']
											},
											'Schlosspark Ensemble': {
												'Erd Geschoss': ['Wand', 'Fenster'],
												'1 Geschoss': ['Wand', 'Fenster'],
												'2 Geschoss': ['Wand', 'Fenster']
											},
											'FIFTYSEVEN': {
												'4 Geschoss': ['Dach']
											}
										}
							
										function createOption(ddl, text, value) {
											var opt = document.createElement('option');
											opt.value = value;
											opt.text = text;
											ddl.options.add(opt);
										}
							
										function createOptions(optionsArray, ddl) {
											for (i = 0; i < optionsArray.length; i++) {
												createOption(ddl, optionsArray[i], optionsArray[i]);
											}
										}
							
										function configureDDL2(ddl1, ddl2, ddl3) {
											ddl2.options.length = 0;
											ddl3.options.length = 0;
											createOption(ddl2, "Position", "");
											var ddl2keys = Object.keys(myNestedVals[ddl1.value]);
											createOptions(ddl2keys, ddl2)
										}
							
										function configureDDL3(ddl1, ddl2, ddl3) {
											ddl3.options.length = 0;
											createOption(ddl3, "Bauteil", "");
											var ddl3keys = myNestedVals[ddl1.value][ddl2.value];
											createOptions(ddl3keys, ddl3);
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