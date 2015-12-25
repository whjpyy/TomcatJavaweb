<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
din.jsp is including content.jsp
<% int var = 1;
    request.setAttribute("username", "chen");
%>
<jsp:include page="content.jsp" flush="true" />
<p />
din.jsp is doing something else.
</body>
</html>
