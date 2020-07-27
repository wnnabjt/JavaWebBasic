<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <%
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    flag = true;
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value, "utf-8");
    %>
        <h1>欢迎回来，您上次访问时间为：<%=value%> </h1>
    <%
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String date_str = sdf.format(date);
                    date_str = URLEncoder.encode(date_str, "utf-8");
                    cookie.setValue(date_str);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if(flag == false || cookies.length == 0 || cookies == null) {
    %>
        <h1>您好，欢迎您首次访问</h1>
    <%
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String date_str = sdf.format(date);
            date_str = URLEncoder.encode(date_str, "utf-8");
            Cookie cookie = new Cookie("lastTime", date_str);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        }
    %>
</body>
</html>
