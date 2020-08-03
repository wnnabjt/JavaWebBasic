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

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if(currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if(Integer.parseInt(currentPage) < 1) {
            currentPage = "1";
        }

        if(rows == null || "".equals(rows)) {
            rows = "5";
        }
        UserService service = new UserServiceImpl();
        PageBean<User> pb = new PageBean<User>();
        pb = service.findUserByPage(currentPage, rows);
        request.setAttribute("pb", pb);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
