<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <h1>c:if </h1>
    <ol>
        <li>
            <c:if var="result" test="${param.name == 'chen'}">
                 进来了。。
            </c:if>
            ${result}
        </li>
    </ol>

    <h1>c:choosse </h1>
    <ol>
        <li>
           <c:choose>
               <c:when test="${empty param.name}" >
                   Unknown name.
               </c:when>
               <c:when test="${param.name == 'chen'}">
                   ${param.name} is manager.
               </c:when>
               <c:otherwise>
                   ${param.name} is employee.
               </c:otherwise>
           </c:choose>
        </li>
    </ol>
</div>
</body>
</html>
