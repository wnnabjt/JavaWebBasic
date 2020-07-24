import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/**
 * GenericServlet是Servlet接口的一个实现抽象类，他覆写了除service方法外的所有方法。
 * 但是一般不推荐使用
 */

@WebServlet("/demoGenericServlet")
public class Demo01GenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet");
    }
}
