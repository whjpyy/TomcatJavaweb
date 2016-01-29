<%@ page import="com.chen.learn.ch13.BookDetails" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    List<BookDetails> list = new ArrayList<BookDetails>();
    list.add(new BookDetails("Java面向对象编程", "title1", 10, "描述1"));
    list.add(new BookDetails("精通Struts", "title2", 30, "描述2"));
    list.add(new BookDetails("Tomcat与JavaWeb开发技术详解", "title3", 410, "描述3"));
    list.add(new BookDetails("Java网络编程精解", "title4", 20, "描述4"));
%>
<head>
    <title></title>
</head>
<body>

</body>
</html>
