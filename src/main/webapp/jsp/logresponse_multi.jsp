<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Log Display</title>
</head>
<body>
<h1>${requestScope.header}</h1><br><br>
<table>
    <c:forEach items="${requestScope.body}" var="Log" >
        <tr>
            <th>${Log.id}</th>
            <th>${Log.time}</th>
            <th>${Log.level}</th>
            <th>${Log.message}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
