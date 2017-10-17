<%--
  Created by IntelliJ IDEA.
  User: sowatheking
  Date: 17.10.17
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../js/menu.js"></script>
    <link href="../css/display.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Upload some files...</title>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading"><strong>Upload Files</strong> <small>Bootstrap files upload</small></div>
        <div class="panel-body">

            <!-- Standar Form -->
            <h4>Select files from your computer</h4>
            <form action="../FileUploadServlet" method="post" enctype="multipart/form-data" id="js-upload-form">
                <div class="form-inline">
                    <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="file" name="files[]" id="js-upload-files" multiple>
                        </div>
                        <button type="submit" class="btn btn-sm btn-primary" id="js-upload-submit">Upload files</button>
                    </form>

                </div>
            </form>

            <!-- Drop Zone -->
            <h4>Or drag and drop files below</h4>
            <div class="upload-drop-zone" id="drop-zone">
                Just drag and drop files here
            </div>
        </div>
    </div>
</div> <!-- /container -->
</body>
</html>