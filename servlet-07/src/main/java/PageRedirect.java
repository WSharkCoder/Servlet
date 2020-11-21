import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @uthor Fegert
 * @Date 2020/1/29 18:19
 * 演示网页重定向
 */
public class PageRedirect extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        //设置响应内容
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //要重定向的位置
        String site = new String("https://www.baidu.com");
        response.setStatus(response.SC_MOVED_TEMPORARILY);//302
        response.setHeader("Location",site);//设置重定向的地址
    }
}
