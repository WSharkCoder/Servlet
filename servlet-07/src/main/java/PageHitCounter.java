import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/29 18:30
 * 点击页面
 */
public class PageHitCounter extends HttpServlet {
    private int hitCount;

    @Override
    public void init() {
        //重置点击计数器
        hitCount=0;
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //增加hitcounter
        hitCount++;

        PrintWriter out=response.getWriter();
        String title = "网页点击计数";
        out.println("<html><head><title>" +title+"</title></head>" +
                "<body bgcolor=\"#f0f0f\">" +
                "<h1 align=\"center\">点击量："+hitCount+"</h1>" +
                "</body></html>\n" );
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
