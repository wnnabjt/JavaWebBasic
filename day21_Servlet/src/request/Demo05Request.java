package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 改程序用来演示Request获取请求参数的通用方法
 */

@WebServlet("/demo05Request")
public class Demo05Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
            2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
            3. Enumeration<String> getParameterNames():获取所有请求的参数名称
            4. Map<String,String[]> getParameterMap():获取所有参数的map集合
         */
        // 1. String getParameter(String name):根据参数名称获取参数值
        /*System.out.println("Normal:");
        String username = request.getParameter("username");
        System.out.println("username is " + username);
        String password = request.getParameter("password");
        System.out.println("password is " + password);
        // 2. String[] getParameterValues(String name):根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        System.out.print("hobbies is ");
        for (String hobby : hobbies) {
            System.out.print(hobby);
        }
        System.out.println("");
        // 3. Enumeration<String> getParameterNames():获取所有请求的参数名称
        System.out.println("Enumeration:");
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String[] values = request.getParameterValues(name);
            for (String value : values) {
                System.out.print(value + " ");
            }
        }
        //4. Map<String,String[]> getParameterMap():获取所有参数的map集合
        System.out.println("Map:");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String key : strings) {
            System.out.println(key);
            String[] values = request.getParameterValues(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
        }*/
        // 中文乱码问题
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println("username is " + username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}


