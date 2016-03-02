<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<h3>1.fn:contains</h3>
<ul>
    <li>
        ${fn:contains("Tomcat", "cat")},
        ${fn:contains("Tomcat", "CAT")}
    </li>
</ul>
<h3>2.fn:containsIgnoreCase</h3>
<ul>
    <li>
        ${fn:containsIgnoreCase("Tomcat", "Mike")},
        ${fn:containsIgnoreCase("Tomcat", "CAT")}
    </li>
</ul>
<h3>3.fn:startWith</h3>
<ul>
    <li>
        ${fn:startsWith("Tomcat", "tom")},
        ${fn:startsWith("Tomcat", "Tom")}
    </li>
</ul>
<h3>4.fn:endWith</h3>
<ul>
    <li>
        ${fn:endsWith("Tomcat", "cat")},
        ${fn:endsWith("Tomcat", "c")}
    </li>
</ul>
<h3>5.fn:indexOf</h3>
<ul>
    <li>
        ${fn:indexOf("Tomcat", "cat")},
        ${fn:indexOf("1212212", "221")},
        ${fn:indexOf("xx", "221")}
    </li>
</ul>
<h3>6.fn:replace</h3>
<ul>
    <li>
        ${fn:replace("Tomcat", "cat", "CAT")},
        ${fn:replace("2008/1/9", "/", "-")}
    </li>
</ul>
<h3>7.fn:substring</h3>
<ul>
    <li>
        ${fn:substring("Tomcat", "2", "4")},
        ${fn:substring("Tomcat", "1", "4")}
    </li>
</ul>
<h3>8.fn:substringBefore</h3>
<ul>
    <li>
        ${fn:substringBefore("Tomcat", "cat")},
        ${fn:substringBefore("mydata.txt", ".txt")}
    </li>
</ul>
<h3>9.fn:substringAfter</h3>
<ul>
    <li>
        ${fn:substringAfter("Tomcat", "To")},
        ${fn:substringAfter("mydata.txt", ".")}
    </li>
</ul>
<h3>10.fn:split</h3>
<ul>
    <li>
        <c:set var="strs" value="${fn:split('www.baidu.com', '.')}" />
        <c:forEach items="${strs}" var="str">
            ${str},
        </c:forEach>
    </li>
</ul>
<h3>11.fn:join</h3>
<ul>
    <li>
        <c:set var="strs" value="${fn:split('www.baidu.com', '.')}" />
        ${fn:join(strs, '-')}
    </li>
</ul>
<h3>12.fn:toLowerCase</h3>
<ul>
    <li>
        ${fn:toLowerCase("TomCat")}
    </li>
</ul>
<h3>13.fn:toUpperCase</h3>
<ul>
    <li>
        ${fn:toUpperCase("TomCat")}
    </li>
</ul>
</body>
<h3>14.fn:trim</h3>
<ul>
    <li>
        ${fn:trim("  TomCat  ")}
    </li>
</ul>
<h3>15.fn:escapeXml</h3>
<ul>
    <li>
        ${fn:escapeXml("<b>表示粗体字</b>")} <br />
        <c:out value="<b>表示粗体字</b>" escapeXml="true" /> <br />
        <c:out value="<b>表示粗体字</b>" escapeXml="false" /> <br />
        ${"<b>表示粗体字</b>"} <br />
    </li>
</ul>
<h3>16.fn:length</h3>
<ul>
    <li>
        <%
            int[] array = {1,2,3,4};
            List<String> list = new ArrayList<String>();
            list.add("one");
            list.add("two");
            list.add("three");
        %>
        <c:set value="<%=array%>" var="array" />
        <c:set value="<%=list%>" var="list" />
        数组长度：${fn:length(array)} <br />
        集合长度：${fn:length(list)} <br />
        字符串长度：${fn:length("Tomcat")} <br />
    </li>
</ul>
</body>
</html>
