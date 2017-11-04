<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
   <head>
      <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
      <!-- jQuery library -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <!-- Latest compiled JavaScript -->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <!-- Custom CSS section -->
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu_css.css">
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
   </head>
   <body >
      <jsp:include page="../shared/menu.jsp" />
      <div id="main"  >
      	<div style=" height: 90%;">
      	 <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>
          <p>Here comes best demo!</p>
      	</div>
        <div>
           <jsp:include page="../shared/footer.jsp" />
         </div>
      </div>
    
   </body> 
   <script>

   $(document).ready(function () {
   		openNav();
   });
   </script>
</html>