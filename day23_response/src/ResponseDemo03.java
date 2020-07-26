import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过服务器向客户端使用字符输出流
 */

@WebServlet("/responseDemo03")
public class ResponseDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            需要通过响应头告诉浏览器我发送数据的编码形式，不然很有可能在浏览器端出现乱码
         */
        response.setContentType("text/html;charset=utf-8"); // 一定要在获取流之前设置，因为流的获取默认编码为ISO-8859-1
        PrintWriter pw = response.getWriter();
//        pw.write("<p1>Hello printWriter</p1>");
        pw.write("你好啊 response");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
