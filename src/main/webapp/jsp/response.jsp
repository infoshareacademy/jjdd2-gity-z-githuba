<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Upload File Response</title>
</head>
<body>
<%-- Using JSP EL to get message attribute value from request scope --%>
<h2><b>${requestScope.message}</b></h2>
<h5>${requestScope.message2}</h5>
<br>
<h2>Please, go to <a href = "choice">NEXT STEP</a>. We are done here...</h2>
<h2>Or you can check uploaded files <a href="list">HERE</a> </h2>
</body>
</html>