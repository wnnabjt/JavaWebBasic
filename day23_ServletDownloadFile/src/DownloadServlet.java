import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/*
    1. 定义页面，编辑超链接href属性，指向Servlet，传递资源名称filename
    2. 定义Servlet
        1. 获取文件名称
        2. 使用字节输入流加载文件进内存
        3. 指定response的响应头： content-disposition:attachment;filename=xxx
        4. 将数据写出到response输出流
 */

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        // 2.使用字节输入流加载文件进内存
        // 2.1找到文件服务器路径
        ServletContext sc = this.getServletContext();
        String realPath = sc.getRealPath("/img/" + filename);
        // 2.2使用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        // 3.设置response的响应头
        // 3.1设置响应头类型：content-type
        String mimeType = sc.getMimeType(filename);
        response.setHeader("content-type", mimeType);

        // 解决中文文件名显示错误的问题
        // 1.获取user-agent请求头
        String agent = request.getHeader("user-agent");
        // 2.使用工具类方法编码文件名的即可
        filename = DownLoadUtils.getFileName(agent, filename);
        // 3.2设置响应头打开方式
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        // 4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024 * 8];
        while((len = fis.read(bytes)) != -1) {
            sos.write(bytes, 0, len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
