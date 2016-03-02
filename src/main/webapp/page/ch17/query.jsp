<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1>sql:query</h1>
<ol>
    <li>
        <sql:setDataSource url="jdbc:mysql://localhost:3306/bookDB?useUnicode=true&characterEncoding=UTF-8"
            driver="com.mysql.jdbc.Driver" user="root" password="mysql" />
        <sql:setDataSource dataSource="jdbc/BookDB" var="myRes" />
        
        <!-- 使用默认数据源 -->
        <sql:query sql="select ID,NAME,TITLE,PRICE FROM BOOKS" var="books" />
        共有${books.rowCount}本书，具体如下：
        <table border="1">
        <tr>
            <c:forEach var="col" items="${books.columnNames}">
            <td>${col}</td>
            </c:forEach>
        </tr>
        <c:forEach var="book" items="${books.rows}">
        <tr>
            <td>${book.ID}</td>
            <td>${book.NAME}</td>
            <td>${book.TITLE}</td>
            <td>${book.PRICE}</td>
        </tr>
        </c:forEach>
        </table>
    </li>
    <li>
        <sql:query var="books" dataSource="${myRes}" startRow="1" maxRows="4">
            SELECT ID,NAME,TITLE,PRICE FROM BOOKS
        </sql:query>
        <table border="1">
            <c:forEach var="book" items="${books.rowsByIndex}">
                <tr>
                    <td>${book[0]}</td>
                    <td>${book[1]}</td>
                    <td>${book[2]}</td>
                    <td>${book[3]}</td>
                </tr>
            </c:forEach>
        </table>
    </li>
    <li>
        <sql:query var="books">
            SELECT ID,NAME,TITLE,PRICE FROM BOOKS WHERE NAME LIKE ? AND PRICE > ?
            <sql:param>%卫%</sql:param>
            <sql:param>45</sql:param>
        </sql:query>
        <table border="1">
            <c:forEach var="book" items="${books.rowsByIndex}">
                <tr>
                    <td>${book[0]}</td>
                    <td>${book[1]}</td>
                    <td>${book[2]}</td>
                    <td>${book[3]}</td>
                </tr>
            </c:forEach>
        </table>
    </li>
</ol>
</body>
</html>
