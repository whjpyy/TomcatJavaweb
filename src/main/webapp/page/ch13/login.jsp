<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mm" uri="/mytaglib" %>
<html>
<%
    String language = request.getParameter("language");
    if(language == null){
        language = "English";
    }
    session.setAttribute("language", language);
%>
<head>
    <title><mm:message key="login.title" /></title>
</head>
<body>
<mm:message key="login.user" />: <input /> <br />
<mm:message key="login.password" />: <input type="password" /> <br />
<mm:message key="login.submit" />
</body>
</html>
