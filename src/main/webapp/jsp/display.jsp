<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/highLineEmails.css">

    <script language="JavaScript">

        $( document ).ready(function() {
            var sentences = $('#sentences');
            var keywords = $('#keywords');

            keywords.click(function () {

                var text = sentences.html();
                var selection = window.getSelection() || document.getSelection() || document.selection.createRange();
                var selObj = document.getSelection();
                alert(selObj);
                var word = $.trim(selection.toString());
                console.log(word);

                var regex = new RegExp('(' + word + ')', 'ig');
                text = text.replace(regex, '<span class="highlight">$1</span>');
                sentences.html(text);
            });

            sentences.click(function() {
                location.reload();
            });
        });

    </script>
</head>
    <body>
        <div class="container">
            <br>
            <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
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
                    <div class="panel panel-default">
                        <div class="panel-heading">Message</div>
                        <div class="panel-body">
                            <div id="sentences">
                            <c:forEach var="question" items="${question}" varStatus="loop">
                            <c:out value="[${loop.index+1}]" />: <c:out value="${question}"/><br/>
                            </c:forEach>

                            <c:forEach var="value" items="${value}" varStatus="loop">
                            <c:out value="[${loop.index+1}]" />: <c:out value="${question}"/><br/>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <a href="choice" class="btn btn-primary" type="button">Go to home</a>
            </div>
            <div class="col-md-4"></div>
            </div>
        </div>
</body>
</html>