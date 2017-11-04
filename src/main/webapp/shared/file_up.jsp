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
<div class="panel panel-default">
    <div class="panel-heading"><strong>Upload Files</strong></div>
    <div class="panel-body">
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
        <%--<h4>Or drag and drop files below</h4>--%>
        <%--<div class="upload-drop-zone" id="drop-zone">--%>
        <%--Just drag and drop files here--%>
    </div>
</div>
</div>
</body>
</html>