<!DOCTYPE HTML>
<html>
	<head>
		<title>Login</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body onload="hide()">
		<div id="page-wrapper">

			<!-- Header -->
				<header id="header">
					
					<nav id="nav">
						<ul>							
							<li><a href="index.jsp" class="button">Admin</a></li>
						</ul>
					</nav>
				</header>

			<!-- Main -->
				<section id="main" class="container">
					<header>
						<h2>Login Form</h2>
					</header>
					<div class="row">
						<div class="12u">

							<!-- Form -->
								<section class="box">
									
									<form method="post" action="Login_User">
										<div class="row uniform 50%">
											<div class="6u 12u(mobilep)">
												<input type="text" name="login" value="" placeholder="Username" />
											</div>
											<div class="6u 12u(mobilep)">
												<input type="password" name="password" value="" placeholder="Password" />
											</div>
                                            </div>
                                            <p id="Fehler" name="Fehler" style="color: red;"></p>
										<div class="row uniform">
											<div class="12u">
												<ul class="actions">
													<li><input type="submit" value="Login" /></li>
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
<input type="hidden" id="get_Fehler" name="get_Fehler" value="${FehlerLogin}">
		<!-- Scripts -->
		<script type="text/javascript">
		function hide(){
			//var elt = document.getElementById("Fehler").value;
			//var elt2 = document.getElementById("divFehler");
			//elt = document.getElementById("get_Fehler").value;
			//if(elt=="") elt2.style.display = "none";
			document.getElementById("Fehler").innerHTML = document.getElementById("get_Fehler").value;
		}
		
		setTimeout(function(){
			document.getElementById("get_Fehler").value="";
			}, 3000);
		
		</script>
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrollgress.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>