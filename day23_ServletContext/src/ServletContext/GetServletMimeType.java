package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * MIME类型:在互联网通信过程中定义的一种文件数据类型
 * 格式： 大类型/小类型   text/html		image/jpeg
 * 获取：String getMimeType(String file)
 */

@WebServlet("/getServletMimeType")
public class GetServletMimeType extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "a.jpg";
        ServletContext sc = this.getServletContext();
        String mimeType = sc.getMimeType(fileName);
        System.out.println(mimeType);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
