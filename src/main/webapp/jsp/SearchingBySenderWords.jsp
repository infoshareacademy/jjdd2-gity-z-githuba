<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <title>Upload File Response</title>
    <script language="JavaScript">

        $(document).ready(function () {
            openNav();
            var sentences = $('#sentences');
            var normal = $('#sentences');
            var keywords = $('#keywords');

            keywords.click(function () {

                var text = sentences.html();
                var selection = window.getSelection() || document.getSelection() || document.selection.createRange();
                var selObj = document.getSelection();
                var word = $.trim(selection.toString());
                console.log(word);

                var regex = new RegExp('(' + word + ')', 'ig');
                text = text.replace(regex, '<span style="background-color: yellow">$1</span>');
                sentences.html(text);
            });

            if (word === '') {
                word = event.target.innerText;
            }
            $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
                $("#success-alert").slideUp(500);
            });

            $(document).on('click', '.panel-heading span.clickable', function (e) {
                var $this = $(this);
                if (!$this.hasClass('panel-collapsed')) {
                    $this.parents('.panel').find('.panel-body').slideUp();
                    $this.addClass('panel-collapsed');
                    $this.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
                } else {
                    $this.parents('.panel').find('.panel-body').slideDown();
                    $this.removeClass('panel-collapsed');
                    $this.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
                }
            });


        );

    </script>
</head>
<body onload="openNav()">
<jsp:include page="../shared/menu.jsp"/>
<div id="main">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>


    <div class="container">
        <%--<div class="row"><jsp:include page="../shared/menu.jsp"/></div>--%>
        <div class="row">
            <form method="post" action="../sender" class="form-horizontal">
                <fieldset>

                    <!-- Form Name -->
                    <legend></legend>

                    <!-- Prepended checkbox -->
                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading"><h3 class="panel-title">Website</h3>
                                <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
                            </div>
                            <div class="panel-body">

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="prependedcheckbox">Enter searching
                                        words</label>
                                    <div class="col-md-4">
                                        <div class="input-group">
              <span class="input-group-addon">
                  <input type="checkbox" name="searchword" value="searchword">
              </span>
                                            <input id="prependedcheckbox" name="sender" class="form-control"
                                                   placeholder="Your word here" type="text">
                                        </div>
                                    </div>
                                </div>
                                <!-- Select Basic -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="selectbasic">To language</label>
                                    <div class="col-md-4">
                                        <select id="selectbasic" name="tolanguage" class="form-control">
                                            <option value="no">Do not translate</option>
                                            <option value="pl">Option two</option>
                                        </select>
                                    </div>
                                </div>

                                <%--<!-- Multiple Checkboxes (inline) -->--%>
                                <%--<div class="form-group">--%>
                                <%--<label class="col-md-4 control-label" for="checkboxes">Search also</label>--%>
                                <%--<div class="col-md-4">--%>
                                <%--<label class="checkbox-inline" for="checkboxes-0">--%>
                                <%--<input name="Websites" id="checkboxes-0" value="1" type="checkbox">--%>
                                <%--Websites--%>
                                <%--</label>--%>
                                <%--<label class="checkbox-inline" for="checkboxes-1">--%>
                                <%--<input name="Phonenumbers" id="checkboxes-1" value="2" type="checkbox">--%>
                                <%--Phone numbers--%>
                                <%--</label>--%>
                                <%--<label class="checkbox-inline" for="checkboxes-2">--%>
                                <%--<input name="Emails" id="checkboxes-2" value="3" type="checkbox">--%>
                                <%--Emails--%>
                                <%--</label>--%>
                                <%--</div>--%>
                                <%--</div>--%>

                                <!-- Button -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="singlebutton"></label>
                                    <div class="col-md-4">
                                        <button id="singlebutton" name="singlebutton" class="btn btn-default">Send
                                        </button>
                                    </div>
                                </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</div>


<form method="get" action="../oauth" class="form-horizontal">
    <div class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading"><h3 class="panel-title">Website</h3>
                <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
            </div>
            <div class="panel-body">
                <%--<div class="row">--%>
                <%--<form class="form-horizontal">--%>
                <fieldset>

                    <!-- Search input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="searchinput">Search in Gmail</label>
                        <div class="col-md-4">
                            <input id="searchinput" name="srch" placeholder="keyword" class="form-control input-md"
                                   type="search">

                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="singlebutton"></label>
                        <div class="col-md-4">
                            <button id="singlebutton" name="singlebutton" class="btn btn-default">Send</button>
                        </div>
                    </div>
                </fieldset>
</form>
<%--<div class="row"><jsp:include page="../shared/footer.jsp"/></div>--%>
</div>

</form>
</div>
</body>
</html>
