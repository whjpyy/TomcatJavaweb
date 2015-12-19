<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mt" uri="/mytaglib" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <b>Hello: <%=request.getAttribute("USER")%></b><br />
    <b><mt:hello />: <%=request.getAttribute("USER")%></b>
</body>
</html>
