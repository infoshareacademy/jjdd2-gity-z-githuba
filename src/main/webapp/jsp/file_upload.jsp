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
<jsp:include page="../shared/menu.jsp" />
<p>Upload your files</p>
<div class="container">
    <div class="row"></div>
    <div class="row">
        <div class="col-md-9"></div>
        <jsp:include page="../shared/file_up.jsp"/>
        <div class="col-md-3"></div>
        ${requestScope.message}
    </div>
</div>
<jsp:include page="../shared/footer.jsp" />
</body>
</html>