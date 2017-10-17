<<<<<<< HEAD

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>

    <!-- Ignite UI Required Combined CSS Files -->
    <link href="http://cdn-na.infragistics.com/igniteui/2017.1/latest/css/themes/infragistics/infragistics.theme.css" rel="stylesheet" />
    <link href="http://cdn-na.infragistics.com/igniteui/2017.1/latest/css/structure/infragistics.css" rel="stylesheet" />
    <link href="../css/display.css" rel="stylesheet" />


    <script src="http://ajax.aspnetcdn.com/ajax/modernizr/modernizr-2.8.3.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="http://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
    <script src="../js/menu.js"></script>

    <!-- Ignite UI Required Combined JavaScript Files -->
    <script src="http://cdn-na.infragistics.com/igniteui/2017.1/latest/js/infragistics.core.js"></script>
    <script src="http://cdn-na.infragistics.com/igniteui/2017.1/latest/js/infragistics.lob.js"></script>

</head>
<body>
<jsp:include page="../shared/header.jsp"/>
<jsp:include page="../jsp/menu.jsp"/>
<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
    <div id="igUpload1"></div>
</form>for
<div id="error-message" style="color: #FF0000; font-weight: bold;"></div>

<script>
    $(function () {
        var buttonLabel = $.ig.Upload.locale.labelUploadButton;
        if (Modernizr.input.multiple) {
            buttonLabel = "Drag and Drop Files Here <br/> or Click to Select From a Dialog";
        }
        $("#igUpload1").igUpload({
            mode: 'multiple',
            multipleFiles: true,
            maxUploadedFiles: 5,
            maxSimultaneousFilesUploads: 2,
            progressUrl: "https://www.igniteui.com/IGUploadStatusHandler.ashx",
            controlId: "serverID1",
            labelUploadButton: buttonLabel,
            onError: function (e, args) {
                showAlert(args);
            }
        });
        if (Modernizr.input.multiple) {
            $(".ui-igstartupbrowsebutton").attr("style", "width: 320px; height: 80px;");
        }
    });

    function showAlert(args) {
        $("#error-message").html(args.errorMessage).stop(true, true).fadeIn(500).delay(3000).fadeOut(500);
    }
</script>

<jsp:include page="../shared/footer.jsp"/>

=======
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1>Hello, world!</h1>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<div class="row">
    <div class="col-xs-12 col-sm-6 col-md-8"><h5>@ANALyzer</h5></div>
    <div class="col-xs-6 col-md-4">Tutaj wjebac logo</div>
</div>
<div class="row">
    <div class="col-xs-6 col-sm-4">Upload Pliku</div>
    <div class="col-xs-6 col-sm-4">Lista plików</div>
    <!-- Optional: clear the XS cols if their content doesn't match in height -->
    <div class="clearfix visible-xs-block"></div>
    <div class="col-xs-6 col-sm-4">Lista wykrytych błędów</div>
</div>
>>>>>>> e61dbbae79ead5a8c5c567331c7c8e565c84ff02
</body>
</html>