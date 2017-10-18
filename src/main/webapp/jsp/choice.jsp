<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
</head>
<body>
<h1>What do you want to do?</h1>
<a href="${pageContext.request.contextPath}/jsp/SearchingBySenderWords.jsp">1.Show me messages with certain word.</a><br>
<a href="${pageContext.request.contextPath}/jsp/keywords.jsp">2.What keywords should I use to find my email?</a><br>
<a href="${pageContext.request.contextPath}/jsp/file_upload.jsp">3. Let me upload another file</a>
</body>
</html>
