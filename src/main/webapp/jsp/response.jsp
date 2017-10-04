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
<h2>${requestScope.message}</h2>
<h2>${requestScope.message2}</h2>
<br><br>
<h1>Please, go back to <a href = "/EMailApp/choice">HOME</a> page. We are done here...</h1>
</body>
</html>