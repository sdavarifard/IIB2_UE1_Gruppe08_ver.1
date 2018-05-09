<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<title>Select Nachtrag zu entfernen</title>


</head>
<body>
<section id="main" class="container">
<section class="box">
<h3>Select Nachtrag</h3>
<form name="selectForm" method="post" action="./Servlet_DeleteNachtrag">
<div class="row uniform 50%">
<div class="12u">
<div class="select-wrapper">
<select id="selectedNachtrag" name="selectedNachtragD" onchange="">
    <c:forEach items="${myNachtragTabele}" var="m">
        <c:if test="${m != selected}">
            <option value="${m.getNachtrag_id()}">Project: ${m.getProject_name()}, Bauteil: ${m.getBauteil_name()}, Datum: ${m.getNachtrag_datum()}, Preis: ${m.getKalkulation_preis_gesamt()} &euro;</option>
        </c:if>
    </c:forEach>
</select>
</div>
</div>
</div>
<div class="row uniform">
<div class="12u">
<ul class="actions">
<input type="submit" value="Submit"/></div>

</ul>
</div>
</div>
</form>
</section>
</section>
</body>
</html>