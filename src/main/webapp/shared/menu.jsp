<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--  nav class="navbar navbar-inverse navbar-fixed-top">
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
</nav-->
<style>

    .sidenav {
        height: 100%;
        width: 0;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
        background-color: #040938;
        overflow-x: hidden;
        transition: 0.5s;
        padding-top: 60px;
    }

    .sidenav a {
        padding: 8px 8px 8px 32px;
        text-decoration: none;
        font-size: 25px;
        color: #818181;
        display: block;
        transition: 0.3s;
    }

    .sidenav a:hover {
        color: #f1f1f1;
    }

    .sidenav .closebtn {
        position: absolute;
        top: 0;
        right: 25px;
        font-size: 36px;
        margin-left: 50px;
    }

    #main {
        transition: margin-left .5s;
        padding: 16px;
    }

    @media screen and (max-height: 450px) {
        .sidenav {
            padding-top: 15px;
        }

        .sidenav a {
            font-size: 18px;
        }
    }
</style>
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="${pageContext.request.contextPath}/jsp/index3.jsp">Home</a></li>
    <a href="${pageContext.request.contextPath}/jsp/file_upload.jsp">Upload Files</a>
    <a href="${pageContext.request.contextPath}/checkFiles">Check files</a>
    <a href="${pageContext.request.contextPath}/jsp/SearchingBySenderWords.jsp">Keywords</a>
    <a href="${pageContext.request.contextPath}/jsp/keywords.jsp">Helper</a>
    <c:if test="${isAdmin}">
        <a href="${pageContext.request.contextPath}/jsp/keywords.jsp">Helper</a>


    </c:if>
</div>
<script>

    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
        //document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementById("main").style.marginLeft = "0";
        document.body.style.backgroundColor = "white";
    }
</script>