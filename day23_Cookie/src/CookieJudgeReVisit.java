import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
    1. 需求：
        1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
        2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串

    2. 分析：
        1. 可以采用Cookie来完成
        2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
            1. 有：不是第一次访问
                1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
                2. 写回Cookie：lastTime=2018年6月10日11:50:01
            2. 没有：是第一次访问
                1. 响应数据：您好，欢迎您首次访问
                2. 写回Cookie：lastTime=2018年6月10日11:50:01
*/

@WebServlet("/CookieJudgeReVisit")
public class CookieJudgeReVisit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    flag = true;
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为： " + value + "</h1>");
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String date_str = sdf.format(date);
                    date_str = URLEncoder.encode(date_str, "utf-8");
                    cookie.setValue(date_str);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if(flag == false || cookies.length == 0 || cookies == null) {
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String date_str = sdf.format(date);
            date_str = URLEncoder.encode(date_str, "utf-8");
            Cookie cookie = new Cookie("lastTime", date_str);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
