<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dbaccess.jsp</title>
</head>
<body>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        // 加载驱动器
        Class.forName("com.mysql.jdbc.Driver");
        // 注册Mysql驱动器
        DriverManager.registerDriver(new Driver());
        // 连接数据库
        String dbUrl = "jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=utf-8";
        String dbUser = "root";
        String dbPwd = "mysql";
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        // 创建一个声明
        stmt = conn.createStatement();
        // 增加新纪录
        stmt.executeUpdate("insert into books(id,name,title,price) values('999','Tom', 'Tomcat', 44.5)");
        // 查询记录
        rs = stmt.executeQuery("select id,name,title,price from books");
        // 输出结果
        out.println("<table border=1 width=400>");
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String title = rs.getString(3);
            float price = rs.getFloat(4);
            out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + title + "</td><td>" + price + "</td></tr>");
        }
        out.println("</table>");
        // 删除新纪录
        stmt.executeUpdate("delete from books where id = '999'");

    }catch (Exception e ){
        out.println(e.getMessage());
    } finally {
        if (rs != null)
            rs.close();
        if(stmt != null)
            stmt.close();
        if(conn != null )
            conn.close();
    }
%>
</body>
</html>
