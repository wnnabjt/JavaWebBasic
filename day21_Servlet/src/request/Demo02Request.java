package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 此程序用来演示request中用来获取请求头的方法。
 */

@WebServlet("/demo02Request")
public class Demo02Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * (*)String getHeader(String name):通过请求头的名称获取请求头的值
         * Enumeration<String> getHeaderNames():获取所有的请求头名称
         */
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.print(s + ":");
            System.out.println(request.getHeader(s));
        }
        String header = request.getHeader("user-agent");
        if(header.contains("Chrome")) {
            System.out.println("Google来了....");
        } else {
            System.out.println("IE来了");
        }
    }
}
