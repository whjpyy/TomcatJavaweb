<%@ page import="com.chen.learn.ch09.MyData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String action = request.getParameter("action");
    if(action == null){
%>
    <a href="sessionopt.jsp?action=add">加入属性</a> <br />
    <a href="sessionopt.jsp?action=invalidate">结束会话</a> <br />
<%
    }else if("invalidate".equals(action)){
        session.invalidate();
%>
    <a href="sessionopt.jsp">开始新的会话</a> <br />
<%
    }else if("add".equals(action)){
        session.setAttribute("data", new MyData());
%>
    <a href="sessionopt.jsp?action=replace">替换属性</a> <br />
    <a href="sessionopt.jsp?action=remove">删除属性</a> <br />
    <a href="sessionopt.jsp?action=invalidate">结束会话</a> <br />
<%
    }else if("remove".equals(action)){
        session.removeValue("data");
%>
    <a href="sessionopt.jsp?action=add">加入属性</a> <br />
    <a href="sessionopt.jsp?action=invalidate">结束会话</a> <br />
<%
    }else if("replace".equals(action)){
        session.setAttribute("data", new MyData(1));
%>
    <a href="sessionopt.jsp?action=remove">删除属性</a> <br />
    <a href="sessionopt.jsp?action=invalidate">结束会话</a> <br />
<%
    }
%>
</body>
</html>
