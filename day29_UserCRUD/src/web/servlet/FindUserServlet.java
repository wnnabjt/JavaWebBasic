package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;
import userCRUD.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户id
        String id = request.getParameter("id");
        // 使用service查询数据库中id对应的user用户
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        // 将user对象存到request域中
        request.setAttribute("user", user);
        // 转发到update.jsp页面
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
