<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title></title>
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
						<h2>neues Projekt</h2>
						<p>Just an assorted selection of elements.</p>
					</header>
					<div class="row">
						<div class="12u">

							<!-- Form -->
								<section class="box">
									<h3>Projekt Information</h3>
									<form method="post" action="./Servlet_Project">
										<div class="row uniform 50%">
                                        <table >
                                        <tr>
                                            <td colspan="3">
                                            <div class="6u 12u(mobilep)"><input type="text" name="name" id="name" value="" placeholder="Name"/>
											</div>
                                            </td>
                                          </tr>  
                                          
                                          
                                          <tr>
                                            <td><div class="6u 12u(mobilep)">
                                            Anfang Datum
												<input type="date" name="anfang_datum" id="adate" value="" placeholder="Anfang Datum" />
											</div></td>
                                            <td><div class="6u 12u(mobilep)">
                                            End Datum
												<input type="date" name="end_datum" id="edate" value="" placeholder="End Datum" />
											</div></td>
                                            <td></td>
                                          </tr>
                                          
                                          		 
                                           <tr>
                                            <td><div class="6u 12u(mobilep)"><input type="text" name="land" value="" placeholder="Land"/></td>
                                            <td><div class="6u 12u(mobilep)"><input type="text" name="stadt" value="" placeholder="Stadt"/></td>
                                            <td><div class="6u 12u(mobilep)"><input type="text" name="plz" value="" placeholder="PLZ"/></td>
                                          </tr>
                                          
                                          
                                           <tr>
                                            <td colspan="2"><div class="6u 12u(mobilep)">
                                            <input type="text" name="adresse" value="" placeholder="Adresse"/></td>
                                            <td><div class="6u 12u(mobilep)"><input type="text" name="Auftragnehmer" value="" placeholder="Auftragnehmer"/></td>
                                          </tr>
                                        
                                        </table>
                                        <%
                                        
                                        
                                        %>
										</div>
										<div class="row uniform">
											<div class="12u">
												<ul class="actions">
													<input type="hidden" name="userId" value="${user.getUser_id()}"> 
													<li><input type="submit" value="Send Message" /></li>
													<li><input type="reset" value="Reset" class="alt" /></li>
												</ul>
											</div>
										</div>
									</form>

									<hr />
								</section>

						</div>
					</div>
				</section>
				<script type="text/javascript">
				function dateControll(){
					var StartDate= document.getElementById('adate').value;
					  var EndDate= document.getElementById('edate').value;
					  var eDate = new Date(EndDate);
					  var sDate = new Date(StartDate);
					  if(StartDate!= '' && StartDate!= '' && sDate> eDate)
						{
						alert("Bitte Controllieren Sie! End Datum muss nach Anfagsdatum sein..");
						return false;
						}
				}
				</script>

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