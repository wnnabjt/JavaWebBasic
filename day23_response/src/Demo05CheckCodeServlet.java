import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 随机生成一张验证码，并使用字节输出流输出到客户端浏览器上
 */

@WebServlet("/checkCodeServlet")
public class Demo05CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        // 1.创建一个图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 2.美化图片
        // 2.1填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);

        // 2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz1234567890";

        // 2.3随机生成4个字符作为验证码，并写到图片中
        Random rand = new Random();
        for(int i = 1; i <= 4; i ++) {
            int index = rand.nextInt(str.length());
            char c = str.charAt(index);
            g.drawString(c + "", width / 5 * i, height / 2);
        }


        // 2.4画干扰线
        g.setColor(Color.GREEN);
        int num = 5;
        for (int i = 0; i < num; i++) {
            int x1 = rand.nextInt(width);
            int x2 = rand.nextInt(width);
            int y1 = rand.nextInt(height);
            int y2 = rand.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        // 3最后通过字节输出流输出到客户端浏览器
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
