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

        <!-- 新增记录 -->
        <sql:update var="result">
            INSERT INTO BOOKS(ID, NAME, TITLE, PRICE) VALUES(?, ?, ?, ?)
            <sql:param>1/</sql:param>
            <sql:param>测试</sql:param>
            <sql:param>标题</sql:param>
            <sql:param>20</sql:param>
        </sql:update>
        一共添加了${result}条记录。<br />

        <!-- 修改记录 -->
        <sql:update>
            UPDATE BOOKS SET NAME = ? WHERE ID = ?
            <sql:param>1</sql:param>
            <sql:param>测试2</sql:param>
        </sql:update>
        一共修改了${result}条记录。<br />

        <!-- 删除记录 -->
        <sql:update>
            DELETE FROM BOOKS WHERE ID = ?
            <sql:param>1</sql:param>
        </sql:update>
        一共删除了${result}条记录。<br />
    </li>
</ol>
</body>
</html>
