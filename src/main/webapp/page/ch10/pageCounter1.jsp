<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:useBean id="myPageBean" scope="page" class="com.chen.learn.ch10.CounterBean" />
<jsp:setProperty name="myPageBean" property="count" value="<%=myPageBean.getCount()+1%>" />
Current count value is: <jsp:getProperty name="myPageBean" property="count" />
<%
    String[] scopNames = {"No scope", "page", "request", "session", "application"};
    int scope = pageContext.getAttributesScope("myPageBean");
%>
<p>scope = <%=scopNames[scope]%></p>
</body>
</html>
