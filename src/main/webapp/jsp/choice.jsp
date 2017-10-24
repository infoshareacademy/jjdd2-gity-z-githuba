<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        .navbar-brand {
            position: absolute;
            width: 100%;
            left: 0;
            top: 0;
            text-align: center;
            margin: auto;
        }
        .navbar-toggle {
            z-index:3;
        }
        .color-green{
            color: lawngreen;
        }
        .color-red {
            color: red;
        }
        p {
            padding-top: 70px;
            color: #d7ceb2;
            text-shadow: 3px 3px 0px #2c2e38, 5px 5px 0px #5c5f72;
            font: 80px 'BazarMedium';
            letter-spacing: 10px;
        }
    </style>
    <link href="../css/menu_css.css" rel="stylesheet" type="text/css">
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
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <c:forTokens items="${requestScope.message}"
                             delims="," var="fileStatus">
                    <div class="color-green"><c:out value = "${fileStatus}"/></div>
                </c:forTokens>
                <h6>${fileStatus}</h6>
                <h6>${requestScope.message}</h6>
                <div class="btn-group-vertical">
                    <a href="${pageContext.request.contextPath}/jsp/SearchingBySenderWords.jsp" class="btn btn-primary" type="button">Show me messages with certain word</a>
                    <a href="${pageContext.request.contextPath}/jsp/keywords.jsp"class="btn btn-primary" type="button">What keywords should I use to find my email?</a>
                    <a href="${pageContext.request.contextPath}/jsp/file_upload.jsp"class="btn btn-primary" type="button">Let me upload another file</a><br><br>
                    <a href="${pageContext.request.contextPath}/stats" class="btn btn-primary" type="button">Show me statistics</a>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>
        <%--<div class="row"><jsp:include page="../shared/footer.jsp"/></div>--%>
    </div>
</body>
</html>
