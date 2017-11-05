<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal">

    <fieldset>

        <!-- Form Name -->
        <legend>Configuration</legend>

        <!-- Textarea -->
        <div class="form-group" role="document" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
             aria-hidden="true">
            <div class="col-md-0">
                <textarea class="form-control" id="Configuration" name="Configuration">
                    <c:forEach var="Settings" items="${Settings}" varStatus="loop">
                        <c:out value="[${loop.index+1}]"/>: <c:out value="${Settings}"/><br>
                    </c:forEach>
                </textarea>
            </div>
        </div>
        </div>
        <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog" role="document" style="width: auto">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Configuration</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <c:forEach var="Settings" items="${Settings}" varStatus="loop">
                            <c:out value="[${loop.index+1}]"/>: <c:out value="${Settings}"/><br>
                        </c:forEach>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>


    </fieldset>
</form>