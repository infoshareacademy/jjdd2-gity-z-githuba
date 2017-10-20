<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<jsp:include page="../shared/header.jsp" />--%>
    <title>Start page</title>
    <script src="../js/menu.js"></script>
    <link href="../css/display.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <h3>What do you want to do?</h3>
    </div>
    <div class="btn-group-vertical">
        <a href="${pageContext.request.contextPath}/jsp/SearchingBySenderWords.jsp" class="btn btn-primary" type="button">Show me messages with certain word.</a>
        <a href="${pageContext.request.contextPath}/jsp/keywords.jsp"class="btn btn-primary" type="button">What keywords should I use to find my email?</a>
        <a href="${pageContext.request.contextPath}/jsp/file_upload.jsp"class="btn btn-primary" type="button">Let me upload another file</a>
</div>
<jsp:include page="../shared/footer.jsp" />
</body>
</html>
