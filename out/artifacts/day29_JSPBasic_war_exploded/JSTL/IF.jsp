<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IF语句</title>
</head>
<body>

    <%--
        1. if:相当于java代码的if语句
			1. 属性：
	            * test 必须属性，接受boolean表达式
	                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
	                * 一般情况下，test属性值会结合el表达式一起使用
       		 2. 注意：
	       		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
    --%>

    <%
        request.setAttribute("number", 4);
    %>

    <c:if test="${requestScope.number % 2 != 0}">
        <h1>${requestScope.number}是奇数</h1>
    </c:if>

    <c:if test="${requestScope.number % 2 == 0}">
        <h1>${requestScope.number}是偶数</h1>
    </c:if>

</body>
</html>
