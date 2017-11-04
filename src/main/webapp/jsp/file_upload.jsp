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
<body onload="openNav()">
<jsp:include page="../shared/menu.jsp"/>
<div id="main">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>
    <div class="container">
        <%--<div class="row"><jsp:include page="../shared/menu.jsp"/></div>--%>
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
                <%--Some error messages need to be redirected here--%>
            </div>
            <div class="col-md-3"></div>
        </div>
        <%--<div class="row"><jsp:include page="../shared/footer.jsp"/></div>--%>
    </div>
</div>
</body>
</html>