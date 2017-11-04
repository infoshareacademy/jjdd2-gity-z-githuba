<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Upload File Response</title>
</head>
<body>
<jsp:include page="../shared/menu.jsp"/>
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>

<div id="main">
    <h1>${requestScope.message}</h1>
    <h5>${requestScope.message2}</h5>
    <br><br>
    <h2>Please, go to <a href="${pageContext.request.contextPath}/jsp/choice.jsp">NEXT STEP</a>. We are done here...
    </h2>
    <h2>Or you can check uploaded files <a href="list">HERE</a></h2>
</div>
</body>
</html>