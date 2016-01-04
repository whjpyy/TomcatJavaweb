<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
(1) ${empty pageScope.container} <br />
<%
    HashMap container = new HashMap();
    pageContext.setAttribute("container", container, PageContext.PAGE_SCOPE);
%>
(2) ${empty pageScope.container} <br />
<% container.put("name", "chen"); %>
(3) ${empty pageScope.container} <br />
(4) ${empty param.username} <br />
(5) ${!empty param.username} <br />
${1+1}
</body>
</html>
