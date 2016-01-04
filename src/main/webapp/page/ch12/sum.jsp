<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mm" uri="/mytaglib" %>
<html>
<head>
    <title>functions</title>
</head>
<body>
<h3>Add Numbers</h3>
<form action="sum.jsp" method="get">
    user = <input name="user" value="${mm:convert(param.user, 'ISO-8859-1', 'UTF-8')}" /> <br />
    x = <input name="x" value="${param.x}" /> <br />
    y = <input name="y" value="${param.y}" /> <br />
    <input type="submit" value="Add Numbers" />
</form>
<p>
    user: ${mm:convert(param.user, 'ISO-8859-1', 'UTF-8')} <br />
    the sum is: ${mm:add(param.x, param.y)}
</p>
</body>
</html>
