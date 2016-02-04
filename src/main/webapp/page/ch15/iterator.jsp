<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.chen.learn.ch15.Test" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>c:forEach </h1>
<ol>
    <li>
        <%
            Set<String> set = new HashSet<String>();
            set.add("chen");
            set.add("you");
            set.add("zeng");
            pageContext.setAttribute("set", set);

/*            Set<String> colors = new HashSet<>();
            colors.add("red");
            colors.add("yellow");
            colors.add("green");
            colors.add("blue");
            colors.add("black");
            pageContext.setAttribute("colors", colors);*/
            pageContext.setAttribute("colors", Test.getColors());
        %>
        <table border="1">
            <tr>
                <td>序号</td>
                <td>索引</td>
                <td>是否是第一个元素</td>
                <td>是否是最后一个元素</td>
                <td>元素的值</td>
            </tr>
            <c:forEach var="item" items="${set}" varStatus="sta">
                <tr>
                    <td>${sta.count}</td>
                    <td>${sta.index}</td>
                    <td>${sta.first}</td>
                    <td>${sta.last}</td>
                    <td>
                        <c:choose>
                            <c:when test="${sta.last}">
                                <span style="color: red">${item}</span>
                            </c:when>
                            <c:otherwise>
                                <span style="color: green;">${item}</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </li>
    <li>
        <c:forEach var="item" items="${colors}" begin="1" end="3" step="2">
            ${item}
        </c:forEach>
    </li>
    <li>
        <jsp:useBean id="weeks" scope="application" class="java.util.HashMap"/>
        <c:set target="${weeks}" property="one" value="Monday"/>
        <c:set target="${weeks}" property="two" value="TuesDay"/>

        <c:forEach var="entry" items="${weeks}">
            ${entry.key}: ${entry.value}<br/>
        </c:forEach>
    </li>
    <li>
        <c:forEach var="name" items="chen,you,zeng">
            ${name}&nbsp;
        </c:forEach>
    </li>
</ol>
<h1>c:forTokens</h1>
<ol>
    <li>
        <c:forTokens var="name" items="chen:you:zeng" delims=":">
            ${name}:
        </c:forTokens>
    </li>
</ol>
</body>
</html>
