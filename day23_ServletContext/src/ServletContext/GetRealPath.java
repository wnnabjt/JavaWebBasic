package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getRealPath")
public class GetRealPath extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        String realPath1 = sc.getRealPath("/b.txt");
        System.out.println(realPath1);
        System.out.println("--------------------------------------------");
        String realPath2 = sc.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath2);
        System.out.println("--------------------------------------------");
        String realPath3 = sc.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(realPath3);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
