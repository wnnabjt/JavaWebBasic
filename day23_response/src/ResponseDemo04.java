import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过服务器向客户端使用字节输出流
 */

@WebServlet("/responseDemo04")
public class ResponseDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            需要通过响应头告诉浏览器我发送数据的编码形式，不然很有可能在浏览器端出现乱码
         */
        response.setContentType("text/html;charset=utf-8"); // 一定要在获取流之前设置
        ServletOutputStream sos = response.getOutputStream();
//        pw.write("<p1>Hello printWriter</p1>");
        sos.write("你好啊".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
