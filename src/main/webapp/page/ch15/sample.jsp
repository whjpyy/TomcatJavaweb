<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h1>c:out 打印表达式</h1>
        <ol>
            <li>
                <c:out value="${param.name}" default="默认值" />
                <c:out value="${param.name}">
                    默认值
                </c:out>
            </li>
        </ol>
    </div>

    <div>
        <h2>c:set 为String类型的命名变量赋值</h2>
        <ol>
            <li>
                <c:set var="user" value="chen" />
                ${user}
            </li>
        </ol>
        <h2>c:set 为JavaBean类型的命名变量赋值</h2>
        <ol>
            <li>
                <jsp:useBean id="counterBean" class="com.chen.learn.ch10.CounterBean" scope="session" />
                <c:set target="${counterBean}" property="count" value="3" />
                ${counterBean.count}
            </li>
        </ol>
        <h2>c:set 为Map赋值</h2>
        <ol>
            <li>
                <jsp:useBean id="map" scope="request" class="java.util.HashMap" />
                <c:set target="${map}" property="name" value="chen" />
                map.name: ${map.name}
            </li>
        </ol>
    </div>

    <div>
        <h1>c:remove 删除命名变量</h1>
        <ol>
            <li>
                <c:set var="week" value="monday" />
                <c:remove var="week" />
            </li>
        </ol>
    </div>

    <div>
        <h1>c:catch 捕获异常</h1>
        <ol>
            <li>
                <c:catch var="ex" >
                <%
                    int a = 0, b = 13;
                    int c = b / a;
                %>
                </c:catch>
                <c:out value="${ex.message}" default="No Exception" />
            </li>
        </ol>
    </div>
</body>
</html>
