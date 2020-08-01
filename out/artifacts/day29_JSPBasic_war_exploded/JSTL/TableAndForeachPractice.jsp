<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="JavaFile.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>practice</title>
</head>
<body>

    <%
        List list = new ArrayList();
        list.add(new User("张三", 18, new Date()));
        list.add(new User("李四", 19, new Date()));
        list.add(new User("王五", 20, new Date()));
        request.setAttribute("list", list);
    %>

    <table align="center" border="1" width="50%">
        <tr align="center">
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>出生日期</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="user" varStatus="s">
            <tr align="center">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.locBir}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
