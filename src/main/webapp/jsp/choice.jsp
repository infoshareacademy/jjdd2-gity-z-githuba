<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Upload File Response</title>
</head>
<body>
    <div class="container">
        <%--<div class="row"><jsp:include page="../shared/menu.jsp"/></div>--%>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <h4>Great! What do you want next?</h4>
                <div class="btn-group-vertical">
                    <a href="${pageContext.request.contextPath}/jsp/SearchingBySenderWords.jsp" class="btn btn-primary" type="button">Show me messages with certain word.</a>
                    <a href="${pageContext.request.contextPath}/jsp/keywords.jsp"class="btn btn-primary" type="button">What keywords should I use to find my email?</a>
                    <a href="${pageContext.request.contextPath}/jsp/file_upload.jsp"class="btn btn-primary" type="button">Let me upload another file</a>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>
        <%--<div class="row"><jsp:include page="../shared/footer.jsp"/></div>--%>
    </div>
</body>
</html>
