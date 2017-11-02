<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <script src="../js/menu.js"></script>
    <link href="../css/display.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu_css.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <p></p>
        <div class="row"><jsp:include page="../shared/menu.jsp"/></div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form method="post" action="../words">
                    <div class="form-group">
                        <label for="question1">Is this an urgent message?</label>
                        <select class="form-control" id="question1" name="question1">
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                        </select>
                        <br>
                        <label for="question2">Is this a formal message?</label>
                        <select class="form-control" id="question2" name="question2">
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                        </select>
                        <br>
                        <label for="question3">Is this an important message?</label>
                        <select class="form-control" id="question3" name="question3">
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                        </select>
                        <br>
                    </div>
                    <button class="btn btn-primary" type="submit">Give me the list of keywords!</button>
                </form>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
</body>
</html>