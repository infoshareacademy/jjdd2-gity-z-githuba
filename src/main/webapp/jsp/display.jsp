<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/display.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="keywords">
    <c:forEach var="keywords" items="${keywords}" varStatus="loop">
        <c:out value="[${loop.index}]" />: <c:out value="${keywords}"/>
    </c:forEach>
</div>
<div id="sentences">
<c:forEach var="question" items="${question}" varStatus="loop">
    <c:out value="[${loop.index}]" />: <c:out value="${question}"/><br/>
</c:forEach>
</div>

