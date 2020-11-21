import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @uthor Fegert
 * @Date 2020/1/30 13:28
 * 全球化
 */
public class Global extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //根据区域设置时间格式
        Locale locale = request.getLocale();
        String date = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, locale).format(new Date());
        //根据区域设置货币
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String formattedCurr = numberFormat.format(10000000);
        //根据地区设置百分比
        NumberFormat numberFormat1 = NumberFormat.getPercentInstance(locale);
        String formattedPerc = numberFormat1.format(0.45);
        String title = "根据区域设置";
        out.println(
                "<html><head><title>" + title + "</title></head>" +
                        "<body>" +
                        "<h1 align=\"center\">时间地区格式化：" + date + "</h1>" +
                        "<h2 align=\"center\">货币地区格式化："+formattedCurr+"</h2>" +
                        "<h3 align=\"center\">百分比地区格式化："+formattedPerc+"</h3>" +
                        "</body></html>"
        );
    }
}
