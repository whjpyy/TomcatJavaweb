<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<%@ page import="java.text.MessageFormat" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>resourceBundle</title>
</head>
<body>
<%
    Locale defaultLocal = Locale.getDefault();
    out.println(defaultLocal + "<br />");
    ResourceBundle resourceBundle = ResourceBundle.getBundle("ch16/resource");
    Enumeration<String> keys = resourceBundle.getKeys();
    while(keys.hasMoreElements()){
        String key = keys.nextElement();
//        String value = new String(resourceBundle.getString(key).getBytes("ISO-8859-1"), "UTF-8");
        String value = resourceBundle.getString(key);
        out.println(key + "=" + value + "<br />");
//        System.out.println(key + "=" + value);
    }
    String age = MessageFormat.format(resourceBundle.getString("age"), 24);
    out.println("age=" + age + "<br />");
%>
<hr />
<f:setLocale value="zh_CN" scope="session" />
1.${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'].language}<br />
<%
    Locale locale = (Locale)Config.find(pageContext, Config.FMT_LOCALE);
%>
2.<%=locale.getLanguage()%><br />
<f:bundle basename="ch16/resource" >
    hello=<f:message key="hello" />
    name=<f:message key="name" />
    age=
    <f:message key="age" >
        <f:param value="24" />
    </f:message>
</f:bundle>
</body>
</html>
