import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自动跳转案例
 * 访问此资源，会自动跳转到responseDemo02资源，状态码3xx。
 */

@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
        System.out.println("responseDemo01........");
        // 1.设置状态码
        response.setStatus(302);
        // 2.设置响应头location
        response.setHeader("location", "/day23/responseDemo02");
    */
        //response内封装了特定的用于重定向的方法sendRedirect
        response.sendRedirect("https://baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
