<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">@Mail Analyzer</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/file_upload.jsp">Upload Files</a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/check_files.jsp">Check files</a></li>
            <li><a href="${pageContext.request.contextPath}/sender">Keywords</a></li>
            <li><a href="${pageContext.request.contextPath}/keywords">Helper</a></li>
        </ul>
    </div>
</nav>
</body>
</html>