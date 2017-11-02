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
    <div class="row"><jsp:include page="../shared/menu.jsp"/></div>
    <div class="container main-container">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <jsp:include page="../shared/file_up.jsp"/>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <%--${requestScope.message}--%>
            </div>
            <div class="col-md-3"></div>
        </div>
    </div>
</body>
</html>
