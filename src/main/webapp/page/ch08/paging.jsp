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

    final int e = 3; // 每页显示的记录数
    int total = 0; // 总条数
    int currentPage = 1; // 当前页面编号
    int totalPages = 0; // 总页数
    int p = 0;

    try {
        String currentPage1 = request.getParameter("currentPage");
        if(currentPage1 != null){
            currentPage = Integer.parseInt(currentPage1);
        }

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

        // 总条数
        rs = stmt.executeQuery("select count(*) from books");
        if(rs.next()){
            total = rs.getInt(1);
            totalPages = total % e == 0 ? total / e : (total / e + 1);
            if(totalPages == 0) totalPages = 1;

            // 修正当前页面的编号，确保1<=currentPage<=totalPages
            if(currentPage > totalPages){
                currentPage = totalPages;
            }else if(currentPage < 1){
                currentPage = 1;
            }

            // 计算当前页面所显示的第一条记录的索引
            p = (currentPage - 1) * e;
            String sql = "select id,name,title,price from books order by id limit " + p +"," + e;
            rs = stmt.executeQuery(sql);
%>
页码：
<%
    for(int i = 1;i <= totalPages;i ++){
        if(i == currentPage){
            %>
            <%=i%>
            <%
        }else{
            %>
            <a href="paging.jsp?currentPage=<%=i%>"><%=i%></a>
            <%
        }
    }
%>
&nbsp;共<%=totalPages%>页，共<%=total%>条记录
<table border="1" width="400">
    <tr>
        <td bgcolor="#D8E4F1"><b>书编号</b></td>
        <td bgcolor="#D8E4F1"><b>作者</b></td>
        <td bgcolor="#D8E4F1"><b>书名</b></td>
        <td bgcolor="#D8E4F1"><b>价格</b></td>
    </tr>
    <%
     while(rs.next()){
         String id = rs.getString(1);
         String name = rs.getString(2);
         String title = rs.getString(3);
         float price = rs.getFloat(4);
    %>
    <tr>
        <td><%=id%></td>
        <td><%=name%></td>
        <td><%=title%></td>
        <td><%=price%></td>
    </tr>
    <%}%>
</table>
<%
        }

    }catch (Exception ex ){
        out.println(ex.getMessage());
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
