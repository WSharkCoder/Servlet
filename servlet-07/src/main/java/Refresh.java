import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @uthor Fegert
 * @Date 2020/1/29 19:14
 *
 */
public class Refresh extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置刷新时间为5秒钟
        response.setIntHeader("Refresh", 5);
        //设置响应内容内容与字符集
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //获取当前时间
        Calendar calendar = new GregorianCalendar();
        String am_pm;
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        if (calendar.get(Calendar.AM_PM) == 0) {
            am_pm = "AM";
        } else am_pm = "PM";
        String CT = hour + ":"+minute+":"+second+" "+am_pm;

        PrintWriter out = response.getWriter();

        String title = "使用Servlet自动刷新网页";
        out.println(
                "<html><head><title>"+title+"</title></head>" +
                        "<body bgcolor=\"#f0f0f0\">" +
                        "<h1 align=\"center\">\n" +title+"</h1>\n" +
                        "<p>当前时间</p>"+CT+"</p>\n"

        );
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
