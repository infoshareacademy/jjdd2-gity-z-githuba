<%--
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
            <h4>Or drag and drop files below</h4>
            <div class="upload-drop-zone" id="drop-zone">
                Just drag and drop files here
            </div>
        </div>
    </div>
</div>
</body>
</html>--%>

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
<p>Upload your files mine little fellow hobbit</p>
<div class="container">
    <div class="row"></div>
    <div class="row">
        <div class="col-md-9"></div>
        <jsp:include page="../shared/file_up.jsp"/>
        <div class="col-md-3"></div>
        Some error messages need to be redirected here
    </div>
</div>

<jsp:include page="../shared/footer.jsp" />
</body>
</html>