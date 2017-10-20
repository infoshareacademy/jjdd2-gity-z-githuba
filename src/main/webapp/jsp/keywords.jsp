<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <script src="../js/menu.js"></script>
    <link href="../css/display.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
Is this an urgent message?
<br>

<form method="post" action="../words">
    <select name="question1">
        <option value="Yes">Yes</option>
        <option value="No">No</option>
    </select>
    <br>
    Is this a formal message?
    <br>

    <select name="question2">");
        <option value="Yes">Yes</option>
        <option value="No">No</option>
    </select>
    <br>
    Is this an important message
    <br>

    <select name="question3">
        <option value="Yes">Yes</option>
        <option value="No">No</option>
    </select>
    <br><br>

    <button type="submit">Give me the list of keywords!</button>
</form>

</body>
</html>