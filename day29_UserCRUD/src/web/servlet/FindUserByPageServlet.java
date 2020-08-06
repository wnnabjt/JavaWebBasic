package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;
import userCRUD.PageBean;
import userCRUD.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if(currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if(Integer.parseInt(currentPage) < 1) {
            currentPage = "1";
        }
        Map<String, String[]> map = request.getParameterMap();

        if(rows == null || "".equals(rows)) {
            rows = "5";
        }
        UserService service = new UserServiceImpl();
        PageBean<User> pb = new PageBean<User>();
        pb = service.findUserByPage(currentPage, rows, map);
        request.setAttribute("pb", pb);
        request.setAttribute("condition", map);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
