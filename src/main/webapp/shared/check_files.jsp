<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>
    <style>
        .color-orange {
            color: orange;
        }

        .color-green {
            color: yellowgreen;
        }

        .color-red {
            color: indianred;
        }

        .color-white {
            color: white;
        }
    </style>
</head>
<body onload="openNav()">
<jsp:include page="../shared/menu.jsp"/>
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>
<p></p>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h2 class="color-white">Valid files:</h2>
            <c:choose>
                <c:when test="${empty requestScope.fileOK}">
                    <h3 class="color-red">There is no proper files</h3>
                </c:when>
                <c:otherwise>
                    <c:forTokens items="${requestScope.fileOK}"
                                 delims="," var="fileName">
                        <h3 class="color-green"><c:out value="${fileName}"/></h3>
                    </c:forTokens>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-md-4">
            <h3 class="color-white">Invalid Files:</h3>
            <c:choose>
                <c:when test="${empty requestScope.fileNotOK}">
                    <h3 class="color-green">There is no invalid files</h3>
                </c:when>
                <c:otherwise>
                    <c:forTokens items="${requestScope.fileNotOK}"
                                 delims="," var="fileName">
                        <h3 class="color-red"><c:out value="${fileName}"/></h3>
                    </c:forTokens>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-md-4">
            <h3 class="color-white">Warnings:</h3>
            <c:choose>
                <c:when test="${empty requestScope.fileWarn}">
                    <h3 class="color-green">No warnings</h3>
                </c:when>
                <c:otherwise>
                    <c:forTokens items="${requestScope.fileWarn}"
                                 delims="," var="fileName">
                        <div class="color-orange"><c:out value="${fileName}"/></div>
                    </c:forTokens>
                </c:otherwise>
            </c:choose>
        </div>
        <div id="keywords">
            <c:forEach var="fileOK" items="${fileOK}" varStatus="loop">
                <c:out value="[${loop.index+1}]"/>
                :
                <c:out value="${fileOK}"/>
            </c:forEach>
        </div>

    </div>
    <div class="row"></div>
    <div class="row"></div>
</div>
</body>
</html>