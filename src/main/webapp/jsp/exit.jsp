<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <script src="../js/menu.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/menu_css.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container main-container">
        <div class="container-fluid bg-1 text-center">
            <div class="jumbotron">
                <h3>Thank you for your time!</h3>
            </div>
            <img src="${pageContext.request.contextPath}/shared/good-bye.jpeg" alt="Bye" width="20%" height="20%">
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/portal/index" class="btn btn-primary btn-md" type="button">Login again</a>
        </div>
    </div>
</body>
</html>
