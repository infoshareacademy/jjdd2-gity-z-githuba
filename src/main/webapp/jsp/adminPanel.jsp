<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalrichert
  Date: 26.10.17
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <title></title>
    <script src="../js/menu.js"></script>
    <link href="../css/display.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<jsp:include page="../shared/menu.jsp" />
<div id="main">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>

<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Welcome Admin</legend>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Report">Report</label>
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/jsp/SearchingBySenderWords.jsp" class="btn btn-default" type="button">Show me messages with certain word</a>

                </button>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="Report">Report</label>
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/jsp/log.jsp" class="btn btn-default" type="button">Show me messages with certain word</a>

                </button>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Configuration" data-toggle="modal"
                   data-target="#newLetter">Configuration</label>
            <div class="col-md-4">
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#exampleModalLong">
                    Show configuration</button>
            </div>
        </div>
            <div class="modal fade" id="newLetter" tabindex="-1" role="dialog" aria-labelledby="newLetterLabel"
                 aria-hidden="true">
                <jsp:include page="modalofConfigPanel.jsp"/>
            </div>
        </div>

    </fieldset>
</form>



</body>
</html>
