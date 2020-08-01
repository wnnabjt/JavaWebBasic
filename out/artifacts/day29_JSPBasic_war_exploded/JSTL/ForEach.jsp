<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="JavaFile.User" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ForEach语句</title>
</head>
<body>
    <%
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(18);
        user.setName("张三");
        user.setBirthday(new Date());
        list.add(user);
        request.setAttribute("list", list);
    %>

    <c:forEach items="${requestScope.list}" var="user" varStatus="status">
        ${status.index}
        ${status.count}
        ${user.name}
        ${user.age}
        ${user.locBir}
    </c:forEach>
</body>
</html>
