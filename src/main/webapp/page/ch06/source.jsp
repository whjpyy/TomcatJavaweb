<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>forward before</p>
<jsp:forward page="target.jsp" >
    <jsp:param name="username" value="chen" />
</jsp:forward>
<p>forward after</p>
</body>
</html>
