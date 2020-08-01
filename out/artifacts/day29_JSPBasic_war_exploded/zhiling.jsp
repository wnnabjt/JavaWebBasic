<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="DemoError.jsp"%>
<%@ include file="Top.jsp"%>
<%@ taglib prefix="c" tagdir="WEB-INF/lib/druid-1.0.9.jar" %>

<%--
    JSP页面注释
        <!-- --> ：只能用来注释HTML片段，而且使用这种注释时，JSP文件被解析为Servlet页面时，会将该注释的内容也解析显示。
        <%-- 注释全部JSP页面，且JSP文件被解析后，不会显示注释部分的任何内容--%>

<%--
    JSP的指令共有3种
        1. page		： 配置JSP页面的
            * contentType：等同于response.setContentType()
                1. 设置响应体的mime类型以及字符集
                2. 设置当前jsp页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
            * import：导包
            * errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
            * isErrorPage：标识当前也是是否是错误页面。
                * true：是，可以使用内置对象exception
                * false：否。默认值。不可以使用内置对象exception


        2. include	： 页面包含的。导入页面的资源文件
            * <%@include file="top.jsp"%>
        3. taglib	： 导入资源
            * <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                * prefix：前缀，自定义的
    JSP指令的作用：用于配置JSP页面，导入资源文件。
    使用格式：<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>

--%>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        List<String> list = new ArrayList<>();
    %>

    <p1>
        我是调用头文件的jsp文件....
    </p1>



</body>
</html>
