<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>format</title>
</head>
<body>

<h1>f:timeZone</h1>
<ol>
    <li>
        <f:setLocale value="en_US" />
        <f:setTimeZone value="GMT" var="myZone" scope="session" />
        <f:timeZone value="GMT">
            <f:formatDate value="<%=new Date()%>" type="both" />
        </f:timeZone>
    </li>
</ol>
<h1>f:formatNumber</h1>
<ol>
    <li>
        <f:setLocale value="en_US" />
        1.<f:formatNumber value="12345" type="currency" /><br />
        <f:setLocale value="zh_CN" />
        2.<f:formatNumber value="12345" type="currency" /><br />
        3.<f:formatNumber value="12345" type="currency" currencySymbol="$" /><br />
    </li>
</ol>
<h1>f:parseNumber</h1>
<ol>
    <li>
        <f:parseNumber value="123,345.78" type="number" /><br />
        <f:parseNumber value="$123,345.78" type="currency" parseLocale="en_US" /><br />
        <f:parseNumber value="72%" type="percent" /><br />
        <f:parseNumber value="34.600" pattern=".000" var="num" scope="request" /><br />
        ${num}
    </li>
</ol>
<h1>f:formatDate</h1>
<ol>
    <li>
        <c:set var="now" value="<%=new Date()%>" />
        <f:setLocale value="en_US" />
        <f:formatDate value="${now}" type="both" /><br />
        <f:setLocale value="zh_CN" />
        <f:formatDate value="${now}" type="both" /><br />
        <f:formatDate value="${now}" type="date" /><br />
        <f:formatDate value="${now}" type="time" /><br />
    </li>
    <li>
        default:<f:formatDate value="${now}" type="both" /><br />
        short:<f:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br />
        medium:<f:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" /><br />
        long:<f:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long" /><br />
        full:<f:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br />
    </li>
    <li>
        en_US:
        <f:setLocale value="en_US" />
        <f:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br />
        ja_JP:
        <f:setLocale value="ja_JP" />
        <f:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br />
        zh_TW:
        <f:setLocale value="zh_TW" />
        <f:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br />

    </li>
</ol>
<h1>f:parseDate</h1>
<ol>
    <li>
        <f:parseDate value="2016-2-29 9:34:45" parseLocale="zh_CN" type="both" var="dd" />
        <f:formatDate value="${dd}" type="both" dateStyle="long" timeStyle="long" />
    </li>
</ol>
</body>
</html>
