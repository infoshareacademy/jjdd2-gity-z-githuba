<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form action=${pageContext.request.contextPath}/LogServlet>
    <button class="btn btn-xs btn-success block" type="submit"><i class="glyphicon glyphicon-floppy-save">Get By ID</i> </button>
    <input type="number" min="0" max="999"  class="block" id="getbyid_ID" name="getbyid_ID" placeholder="ID" size="5" maxlength="5">
    <input type="hidden" class="block" name="action" value="getbyid">
</form>

<form action="${pageContext.request.contextPath}/LogServlet">
    <button class="btn btn-xs btn-success block" type="submit"><i class="glyphicon glyphicon-floppy-save">Get By Range</i> </button>
    <input type="number" min="0" max="999" class="block" name="getbyrangemin" placeholder="Start" size="5" maxlength="5">
    <input type="number" min="0" max="999" class="block" name="getbyrangemax" placeholder="Stop" size="5" maxlength="5">
    <input type="hidden" class="block" name="action" value="getbyrange">
</form>

<form action="${pageContext.request.contextPath}/LogServlet">
    <button class="btn btn-xs btn-success block" type="submit"><i class="glyphicon glyphicon-floppy-save">Get All Logs</i> </button>
    <input type="hidden" class="block" name="action" value="getall">
</form>

<form action="${pageContext.request.contextPath}/LogServlet">
    <button class="btn btn-xs btn-danger block" type="submit"><i class="glyphicon glyphicon-floppy-remove">Delete By Id</i> </button>
    <input type="number" min="0" max="999" class="block" name="id" placeholder="ID" size="5" maxlength="5">
    <input type="hidden" class="block" name="action" value="deletebyid">
</form>

<form action="${pageContext.request.contextPath}/LogServlet">
    <button class="btn btn-xs btn-danger block" type="submit"><i class="glyphicon glyphicon-floppy-remove">Delete All Logs</i> </button>
    <input type="hidden" class="block" name="action" value="deleteall">
</form>

</body>
</html>