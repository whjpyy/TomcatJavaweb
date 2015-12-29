<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies == null){
        out.println("no cookie");
        return;
    }
    for(int i = 0;i < cookies.length; i++){
%>
<p />
<b>Cookie Name:</b> <%=cookies[i].getName()%>
<b>Cookie Value:</b> <%=cookies[i].getValue()%>
<b>max age in senconds:</b> <%=cookies[i].getMaxAge()%>
<%}%>
</body>
</html>
