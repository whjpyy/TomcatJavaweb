<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>requestCounter2</title>
</head>
<body>
<jsp:useBean id="myPageBean" scope="request" class="com.chen.learn.ch10.CounterBean" />
Current count value is: <jsp:getProperty name="myPageBean" property="count" />
</body>
</html>
