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
        <style>.color-orange {
            color: orange;
        }</style>
    </head>
<body>
<jsp:include page="menu.jsp"/>
<p>Files uploaded: </p>
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <b>Valid files:</b>
            <c:choose>
                <c:when test="${empty requestScope.fileOK}">
                    <b class="color-red">There is no proper files</b>
                </c:when>
                <c:otherwise>
                    <c:forTokens items="${requestScope.fileOK}"
                                 delims="," var="fileName">
            <div class="color-green"><c:out value = "${fileName}"/></div>
                    </c:forTokens>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-md-4">
            <b>Invalid Files:</b>
            <c:choose>
            <c:when test="${empty requestScope.fileNotOK}">
                <b class="color-green">There is no invalid files</b>
            </c:when>
            <c:otherwise>
            <c:forTokens items="${requestScope.fileNotOK}"
                         delims="," var="fileName">
                <div class="color-red"><c:out value = "${fileName}"/></div>
            </c:forTokens>
            </c:otherwise>
            </c:choose>
        </div>
        <div class="col-md-3">
            <b>Warnings:</b>
            <c:choose>
                <c:when test="${empty requestScope.fileWarn}">
                <b class="color-green">No warnings</b>
                </c:when>
            <c:otherwise>
            <c:forTokens items="${requestScope.fileWarn}"
                     delims="," var="fileName">
            <div class="color-orange"><c:out value = "${fileName}"/></div>
            </c:forTokens>
            </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="row"></div>
    <div class="row"></div>
</div>
</body>
</html>