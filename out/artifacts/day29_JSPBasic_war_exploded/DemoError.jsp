<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>服务器繁忙，请稍后重试</h1>
<%
    String message = exception.getMessage();
    out.write(message);
%>
</body>
</html>
