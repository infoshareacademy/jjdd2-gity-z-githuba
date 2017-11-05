<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${empty isAdmin}">
    <c:redirect url="sender"/>
</c:if>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu_css.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            var data = google.visualization.arrayToDataTable([
                ['Word', 'Quantity'],
                <c:forEach var="WordsMap" items="${WordsMap}">
                ['${WordsMap.key}', ${WordsMap.value}],
                </c:forEach>
            ]);

            var options = {
                title: 'Searched words'
            };

            var chart = new google.visualization.PieChart(document.getElementById('pieWord'));

            chart.draw(data, options);
        }
    </script>
    <script type="text/javascript">
        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            var data = google.visualization.arrayToDataTable([
                ['Emails', 'Quantity'],
                <c:forEach var="EmailsMap" items="${EmailsMap}">
                ['${EmailsMap.key}', ${EmailsMap.value}],
                </c:forEach>
            ]);

            var options = {
                title: 'Searched emails'
            };

            var chart = new google.visualization.PieChart(document.getElementById('pieEmails'));

            chart.draw(data, options);
        }
    </script>
    <script type="text/javascript">
        google.charts.load("current", {packages: ["corechart"]});
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Phones', 'Quantity'],
                <c:forEach var="PhonesMap" items="${PhonesMap}">
                ['${PhonesMap.key}', ${PhonesMap.value}],
                </c:forEach>
            ]);

            var options = {
                title: 'Searched phones',
                pieHole: 0.4,
            };

            var chart = new google.visualization.PieChart(document.getElementById('piePhones'));
            chart.draw(data, options);
        }
    </script>
    <script type="text/javascript">
        google.charts.load("current", {packages: ["corechart"]});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Website', 'Quantity'],
                <c:forEach var="WebsitesMap" items="${WebsitesMap}">
                ['${WebsitesMap.key}', ${WebsitesMap.value}],
                </c:forEach>
            ]);

            var options = {
                title: 'Searched websites',
                pieHole: 0.4,
            };

            var chart = new google.visualization.PieChart(document.getElementById('pieWebsites'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
<jsp:include page="../shared/menu.jsp"/>
<div id="main">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>
    <div class="container">
        <div id="pieWord" style="width: 900px; height: 500px; float: left"></div>
        <div id="pieEmails" style="width: 900px; height: 500px; float: left"></div>
        <div id="piePhones" style="width: 900px; height: 500px; float: left"></div>
        <div id="pieWebsites" style="width: 900px; height: 500px; float: left"></div>
    </div>
</div>
</body>
</html>
