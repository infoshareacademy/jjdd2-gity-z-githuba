<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="question" items="${question}" varStatus="loop">
    <c:out value="[${loop.index}]" />: <c:out value="${question}"/><br/>
</c:forEach>

