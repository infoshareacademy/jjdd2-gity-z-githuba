<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Custom CSS section -->
        <link rel="stylesheet" href="../css/menu_css.css">
    </head>
<body>
<jsp:include page="menu.jsp"/>
<p>Files uploaded: </p>
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <b>${requestScope.positiveFiles}</b>
        </div>
        <div class="col-md-4">
            <b>${requestScope.negativeFiles}</b></div>
        <div class="col-md-3">
            <b>${requestScope.Error}</b>
        </div>
    </div>
    <div class="row"></div>
    <div class="row"></div>
</div>
</body>
</html>