<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Log file:</title>
</head>
<body>
<h1>${requestScope.header}</h1>
<br>
<style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
    .tg .tg-q212{font-style:italic;color:#34ff34;vertical-align:top}
    .tg .tg-yw4l{vertical-align:top}
    @media screen and (max-width: 767px) {.tg {width: auto !important;}.tg col {width: auto !important;}.tg-wrap {overflow-x: auto;-webkit-overflow-scrolling: touch;}}</style>
<div class="tg-wrap"><table class="tg">
    <tr>
        <th class="tg-q212">${requestScope.body.id}</th>
        <th class="tg-yw4l">${requestScope.body.level}</th>
        <th class="tg-yw4l">${requestScope.body.message}</th>
        <th class="tg-yw4l">${requestScope.body.time}</th>
    </tr>
</table></div>
</body>
</html>