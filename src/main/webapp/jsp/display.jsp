<%@ page language="java" contentType="text/html; charset=ISO-8859-2"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/display.css">

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
    <h3>Keywords</h3>
    <br>
    <div id="keywords">
        Null kasa
    <c:forEach var="keywords" items="${keywords}" varStatus="loop">
        <c:out value="[${loop.index+1}]" />: <c:out value="${keywords}"/>
    </c:forEach>
    </div>
    <br/>
</div>
    <br>
    <h3>Message</h3>
    <br>
    <div id="sentences">
        Null kasa kasa sdsd
<c:forEach var="question" items="${question}" varStatus="loop">
    <c:out value="[${loop.index+1}]" />: <c:out value="${question}"/><br/>
</c:forEach>
    </div>
    <a href="choice">Go to home</a>


</body>
</html>