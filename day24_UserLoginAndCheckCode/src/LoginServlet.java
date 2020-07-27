import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      1. 设置request的编码
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        String inputCheckCode = parameterMap.get("checkCode")[0];
        String password = parameterMap.get("password")[0];
        String username = parameterMap.get("username")[0];
        HttpSession session = request.getSession();
        Object checkCode = session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if(checkCode != null && inputCheckCode.equalsIgnoreCase((String)checkCode)) {
            User loginUser = new User();
            loginUser.setUsername(username);
            loginUser.setPassword(password);
            UserDao dao = new UserDao();
            User user = dao.login(loginUser);
            if(user == null) {
//            if("zhangsan".equals(username) && "123".equals(password)) {
                session.setAttribute("user", username);
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                request.setAttribute("login_error", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("cc_error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}