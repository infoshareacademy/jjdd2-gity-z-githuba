<%@ page language="java" contentType="text/html; charset=ISO-8859-2" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/highLineEmails.css">

    <script language="JavaScript">

        $(document).ready(function () {
            var sentences = $('#sentences');
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
<h3>Keywords</h3>
<br>
<div id="keywords">
    <c:forEach var="keywords" items="${keywords}" varStatus="loop">
        <c:out value="[${loop.index+1}]"/>: <c:out value="${keywords}"/>
    </c:forEach>
</div>
<br>
<h3>Emails</h3>
<c:if test="${empty foundEmails}">
<p>Messages do not content emails addresses
<p>
    </c:if>
    <c:forEach var="foundEmails" items="${foundEmails}" varStatus="loop">
        <c:out value="[${loop.index+1}]"/>: <c:out value="${foundEmails}"/><br>
    </c:forEach>
    <br>
<h3>Phone</h3>
<c:if test="${empty foundPhone}">
<p>Messages do not content phones
<p>
    </c:if>
    <c:forEach var="foundEmails" items="${foundPhone}" varStatus="loop">
        <c:out value="[${loop.index+1}]"/>: <c:out value="${foundPhone}"/><br>
    </c:forEach>
        <br>
<h3>Websites</h3>
<c:if test="${empty foundWebsites}">
<p>Messages do not content website addresses
<p>
    </c:if>
    <c:forEach var="foundEmails" items="${foundWebsites}" varStatus="loop">
        <c:out value="[${loop.index+1}]"/>: <c:out value="${foundWebsites}"/><br>
    </c:forEach>
<h3>Message</h3>
<div id="sentences">
    <c:if test="${empty question}">
    <p>No e-mails found matching the criteria
    <p>
        </c:if>
        <c:forEach var="question" items="${question}" varStatus="loop">
            <c:out value="[${loop.index+1}]"/>: <c:out value="${question}"/><br/>
        </c:forEach>
</div>
<br>
<a href="choice">Go to home</a>
</body>
</html>