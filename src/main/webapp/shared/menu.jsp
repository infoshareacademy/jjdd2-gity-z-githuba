<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Mail Analyzer</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/jsp/index3.jsp">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/file_upload.jsp">Upload Files</a></li>
            <li><a href="${pageContext.request.contextPath}/checkFiles">Check files</a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/SearchingBySenderWords.jsp">Keywords</a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/keywords.jsp">Helper</a></li>
        </ul>
    </div>
</nav>
