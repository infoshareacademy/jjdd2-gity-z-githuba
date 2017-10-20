<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Custom CSS section -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu_css.css">
    </head>
<body>
<jsp:include page="menu.jsp"/>
<p>Files uploaded: </p>
<div class="container">
    <div class="row">
        <div class="col-md-5">

            <b>Good files:</b>
            <c:choose>
                <c:when test="${empty requestScope.positiveFiles}">
                    <b class="color-red">There is no proper files :(</b>
                </c:when>
                <c:otherwise>
                    <c:forTokens items="${requestScope.positiveFiles}"
                                 delims="," var="filename">
            <div class="color-green"><c:out value = "${filename}"/></div>
                    </c:forTokens>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-md-4">
            <b>Bad Files:</b>
            <c:choose>
            <c:when test="${empty requestScope.negativeFiles}">
                <b >There is no negative files ^_^</b>
            </c:when>
            <c:otherwise>
            <c:forTokens items="${requestScope.negativeFiles}"
                         delims="," var="filename">
            <c:out value = "${filename}"/><p>
            </c:forTokens>
            </c:otherwise>
            </c:choose>
        </div>
        <c:choose>
        <c:when test="${empty requestScope.error}">
            <b>Everything went fine ^_^</b>
        </c:when>
        <c:otherwise>
        <c:forTokens items="${requestScope.Error}"
                     delims="," var="filename">
        <c:out value = "${filename}"/><p>
        </c:forTokens>
        </c:otherwise>
        </c:choose>
    </div>
    <div class="row"></div>
    <div class="row"></div>
</div>
</body>
</html>