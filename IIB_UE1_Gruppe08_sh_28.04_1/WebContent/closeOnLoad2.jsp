<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<script type="text/javascript">
localStorage.setItem("update", "0");

$('body').on('click', '#clickforrefresh', function(){
    localStorage.setItem("update", "1");
});

</script>

</head>
<body onLoad="window.close()">

</body>
</html>