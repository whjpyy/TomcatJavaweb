<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>locale</title>
</head>
<body>
<%
    Locale locale = request.getLocale();
    Enumeration<Locale> allUserSupporedLocales = request.getLocales();
    Locale defaultLocal = Locale.getDefault();
    request.setAttribute("locale", locale);
    request.setAttribute("allUserSupporedLocales", allUserSupporedLocales);
    request.setAttribute("defaultLocal", defaultLocal);
%>
<p>The user's preffered Locale is ${locale}</p>
<ul>
<c:forEach items="${allUserSupporedLocales}" var="entry" >
    <li>locale: ${entry} - ${entry.displayName}</li>
</c:forEach>
</ul>
<p>The container's Locale ${defaultLocal}</p>
</body>
</html>
