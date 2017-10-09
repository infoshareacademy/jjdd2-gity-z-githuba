<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/display.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="keywords">
    <p><h3>Keywords</h3></p>
    <br>
    <c:forEach var="keywords" items="${keywords}" varStatus="loop">
        <c:out value="[${loop.index+1}]" />: <c:out value="${keywords}"/>
    </c:forEach>
    <br>
</div>
<div id="sentences">
    <br>
    <p><h3>Message</h3></p>
    <br>
<c:forEach var="question" items="${question}" varStatus="loop">
    <c:out value="[${loop.index+1}]" />: <c:out value="${question}"/><br/>
</c:forEach>
    <a href="choice"/>Go to home</a>
</div>

