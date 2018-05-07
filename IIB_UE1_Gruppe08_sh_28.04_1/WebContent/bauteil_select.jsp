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
<title>Select Bauteil</title>
<script type="text/javascript">

function SetName() {
    if (window.opener != null && !window.opener.closed) {
        var txtName = window.opener.document.getElementById("selectedBauteil");
        var elt = document.getElementById("selectedBauteilPopUp");
		if (elt.selectedIndex == -1)
    	return null;
        txtName.value = elt.options[elt.selectedIndex].text;
    }
}
</script>
</head>
<body>
<section id="main" class="container">
<section class="box">
<h3>Select Project</h3>
<form name="selectBForm" method="post" action="./bauteilSelection">
<div class="row uniform 50%">
<div class="12u">
<div class="select-wrapper">
<select id="selectedBauteilPopUp" name="selectedBauteilPopUp">
    <c:forEach items="${bauteilList}" var="ml">
        <c:if test="${ml != selected}">
            <option value="${ml.getBauteil_id()}">${ml.getBauteil_name()}</option>
        </c:if>
    </c:forEach>
</select>
</div>
</div>
</div>
<div class="row uniform">
<div class="12u">
<ul class="actions">
<input type="submit" value="Upload"  onclick="SetName();"/></div>
</ul>
</div>
</div>
</form>
</section>
</section>
</body>
</html>