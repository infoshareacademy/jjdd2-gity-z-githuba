<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalrichert
  Date: 27.10.17
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>

<form class="form-horizontal">

    <fieldset>

        <!-- Form Name -->
        <legend>Form Name</legend>

        <!-- Textarea -->
        <div class="form-group">
            <div class="col-md-10">
                <textarea class="form-control" id="Configuration" name="Configuration">
                    <c:forEach var="Settings" items="${Settings}" varStatus="loop">
                        <c:out value="[${loop.index+1}]"/>: <c:out value="${Settings}"/><br>
                    </c:forEach>
                </textarea>
            </div>
        </div>

    </fieldset>
</form>
