<%@ page language="java" contentType="text/html; charset=ISO-8859-2" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <style>

    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/highLineEmails.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script language="JavaScript">

        $(document).ready(function () {
            var sentences = $('#sentences');
            var normal = $('#sentences');
            var keywords = $('#keywords');

            keywords.click(function () {

                var text = sentences.html();
                var selection = window.getSelection() || document.getSelection() || document.selection.createRange();
                var selObj = document.getSelection();
                var word = $.trim(selection.toString());
                console.log(word);

                var regex = new RegExp('(' + word + ')', 'ig');
                text = text.replace(regex, '<span style="background-color: yellow">$1</span>');
                sentences.html(text);
            });

            sentences.click(function () {
                location.reload();
            });
        });

    </script>
</head>
    <body>
        <div class="container">
            <c:if test="${not empty file}">
                <div class="alert alert-success">
                    <strong>Success!</strong> Everything went well!.
                </div>
            </c:if>
            <c:if test="${file==''}">
                <div class="alert alert-danger">
                    <strong>Achtung!</strong> Upload file.<a href="${pageContext.request.contextPath}/jsp/choice.jsp">  Go to home</a>
                </div>
            </c:if>
            <br>


            <div class="row">
            <div class="col-md-offset-0"></div>
            <div class="col-md-offset-0">
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">Keywords</div>
                        <div class="panel-body">
                            <div id="keywords">
                            <c:forEach var="keywords" items="${keywords}" varStatus="loop">
                            <c:out value="[${loop.index+1}]" />: <c:out value="${keywords}"/>
                            </c:forEach>
                            </div>
                        </div>
                    </div>

                    <c:if test="${not empty question}">
                    <div class="panel panel-default">
                        <div class="panel-heading">Message</div>
                        <div class="panel-body">
                                <div id="sentences">
                                        <c:forEach var="question" items="${question}" varStatus="loop">
                                            <c:out value="[${loop.index+1}]"/>: <c:out value="${question}"/><br/>
                                        </c:forEach>
                                </div>
                            </div>
                        </div>
                    </c:if>
                <c:if test="${not empty foundEmails}">
                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">Emails</div>
                            <div class="panel-body">
                                <div id="keywords">
                                        <c:forEach var="foundEmails" items="${foundEmails}" varStatus="loop">
                                            <c:out value="[${loop.index+1}]"/>: <c:out value="${foundEmails}"/><br>
                                        </c:forEach>
                                </div>
                            </div>
                        </div>
                        </c:if>
                        <c:if test="${not empty foundPhone}">
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">Phone</div>
                                <div class="panel-body">
                                    <div id="keywords">
                                            <c:forEach var="foundEmails" items="${foundPhone}" varStatus="loop">
                                                <c:out value="[${loop.index+1}]"/>: <c:out value="${foundPhone}"/><br>
                                            </c:forEach>
                                    </div>
                                </div>
                            </div>
                            </c:if>

                        <c:if test="${not empty foundWebsites}">
                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading">Website</div>
                                    <div class="panel-body">
                                        <div id="keywords">
                                                <c:forEach var="foundEmails" items="${foundWebsites}" varStatus="loop">
                                                    <c:out value="[${loop.index+1}]"/>: <c:out value="${foundWebsites}"/><br>
                                                </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                </c:if>
                <a href="${pageContext.request.contextPath}/jsp/choice.jsp" class="btn btn-primary" type="button">Go to home</a>
            </div>
            </div>
        </div>
                </div>
            </div>
            </div>
        </div>
</body>
</html>