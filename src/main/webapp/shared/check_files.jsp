<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <style>
        .color-orange {
            color: orangered;
        }

        .color-green {
            color: yellowgreen;
        }

        .color-red {
            color: tomato;
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
            <h3 class="color-white">Valid files:</h3>
            <c:choose>
                <c:when test="${empty sessionScope.fileOK}">
                    <h3 class="color-red">There is no proper files</h3>
                </c:when>
                <c:otherwise>
                    <c:forTokens items="${sessionScope.fileOK}"
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
    </div>
</div>
<div class="row"></div>
<div class="row"></div>
</body>
</html>