package Demo01Servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletImpl implements Servlet {
    /**
     *
     * @param servletConfig
     * @throws ServletException
     * 初始化方法：
     * 在Servlet被创建时执行，只会执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次Servlet被访问时，都会执行。
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet...");
    }

    /**
     * 获取Servlet的一些信息，版本，作者等等。
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时，执行一次。
     */
    @Override
    public void destroy() {
        System.out.println("destroyed...");
    }
}
