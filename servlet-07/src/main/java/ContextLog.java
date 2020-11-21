import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/30 11:50
 * Servlet 简单输出信息方法
 * ServletContext log
 */
public class ContextLog extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //调用ServletContext对象的log方法记录日志
        ServletContext context = getServletContext();
        //假设从请求中获取par1的属性值
        String par = request.getParameter("par1");

        if (par == null || par.equals("")) {
            //通过Throwable参数记录版本
            context.log("no message received", new IllegalStateException("Missing message"));
        } else context.log("Here is the visitor's message " + par);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Servlet 简答log";

        out.println(
                "<html><head><title>" + title + "</head></title>" +
                        "<body bgcolor=\"#f0f0f0\"><h1 align=\"center\">" + title + "</h1>" +
                        "<p>par = " + par + "</p>" +
                        "</body></html>"
        );

    }
}
