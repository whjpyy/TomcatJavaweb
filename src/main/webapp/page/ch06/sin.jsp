<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
sin.jsp is including content.jsp
<% int var = 1;
    request.setAttribute("username", "chen");
%>
<%@include file="content.jsp"%>
<p />
sin.jsp is doing something else.
</body>
</html>
