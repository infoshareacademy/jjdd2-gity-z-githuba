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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <br>
    <br>
    <div class="container-fluid bg-1 text-center">
        <img src="${pageContext.request.contextPath}/shared/welcome.jpg" alt="Welcome" width="50%" height="50%">
        <br>
        <br>
        <a href="${pageContext.request.contextPath}/jsp/file_upload.jsp" class="btn btn-primary btn-md" type="button">START</a>
    </div>
</body>
</html>
