<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu_css.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Upload File Response</title>
</head>
<body>
<div class="container">
    <p></p>
    <div class="row"><jsp:include page="../shared/menu.jsp"/></div>
    <div class="row">
        <form method="post" action="../sender" class="form-horizontal">
            <fieldset>

                <!-- Prepended checkbox -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="prependedcheckbox">Enter searching words</label>
                    <div class="col-md-4">
                        <div class="input-group">
              <span class="input-group-addon">
                  <input type="checkbox" name="searchword" value="searchword">
              </span>
                            <input id="prependedcheckbox" name="sender" class="form-control" placeholder="Your word here" type="text">
                        </div>
                    </div>
                </div>

                <!-- Multiple Checkboxes (inline) -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="checkboxes">Search also</label>
                    <div class="col-md-4">
                        <label class="checkbox-inline" for="checkboxes-0">
                            <input name="Websites" id="checkboxes-0" value="1" type="checkbox">
                            Websites
                        </label>
                        <label class="checkbox-inline" for="checkboxes-1">
                            <input name="Phonenumbers" id="checkboxes-1" value="2" type="checkbox">
                            Phone numbers
                        </label>
                        <label class="checkbox-inline" for="checkboxes-2">
                            <input name="Emails" id="checkboxes-2" value="3" type="checkbox">
                            Emails
                        </label>
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton"></label>
                    <div class="col-md-4">
                        <button id="singlebutton" name="singlebutton" class="btn btn-primary">Send</button>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
    <%--<div class="row"><jsp:include page="../shared/footer.jsp"/></div>--%>
</div>
</body>
</html>
