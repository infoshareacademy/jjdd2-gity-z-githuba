<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/display.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/LogServlet">
        <button class="btn btn-sm btn-default block" type="submit"><i class="glyphicon glyphicon-floppy-save"></i>Update (Only if auto not working)</button>
    <input type="hidden" class="block" name="action" value="getall">
</form>

<form action="${pageContext.request.contextPath}/LogServlet">
    <button class="btn btn-sm btn-default block" type="submit"><i class="glyphicon glyphicon-floppy-remove">Get All Logs</i></button>
    <input type="hidden" class="block" name="action" value="getall">
</form>



<form action="${pageContext.request.contextPath}/LogServlet">
        <button class="btn btn-sm btn-default block" type="submit"><i class="glyphicon glyphicon-floppy-remove">Delete
            All
            Logs</i></button>
    <input type="hidden" class="block" name="action" value="deleteall">
</form>

</body>
</html>