<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=titleName%></title>
</head>
<body>
<table style="width: 100%;height: 100%">
    <tr>
        <!-- 网页左侧 -->
        <td width="150" valign="top" align="left" bgcolor="#CCFFCC">
            <%@include file="sidebar.html"%>
        </td>
        <td height="100%">
            <table style="width: 100%;height: 100%">
                <tr>
                    <td valign="top" height="15%"><%@include file="header.html"%></td>
                </tr>
                <tr>
                    <td valign="top"><jsp:include page="<%=bodyFile%>" /></td>
                </tr>
                <tr>
                    <td valign="top" height="15%"><%@include file="footer.html"%></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
