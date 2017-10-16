
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
<jsp:include page="../shared/menu.jsp"/>
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

</body>
</html>