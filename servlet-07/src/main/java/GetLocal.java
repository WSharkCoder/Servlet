import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * @uthor Fegert
 * @Date 2020/1/30 12:40
 * 地区语言信息
 */
public class GetLocal extends HttpServlet {
    /**
     *java.util.Local  request.getLocal()
     *
     * java.util.Local 类的常用方法
     * 1. String getCountry()
     * 以2个大写字母形式的ISO 3166格式返回该区域设置的国家/地区代码
     * 2.String getDisplayCountry()
     * 返回适合向用户显示的区域设置的国家名称
     * 3.String getLanguage()
     * 以小写字母形式返回ISO 639格式返回该区域设置的语言代码
     * 4.String getDisplayLanguage()
     * 返回适合向用户显示的区域设置的语言的名称
     *
     * 5.String getISO3Country()
     * 返回该区域设置的国家的三个字母缩写
     * 6.String getISO3Language()
     * 返回该区域设置的云烟的三个字母缩写
     *
     */


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Locale local = request.getLocale();
        String country = local.getCountry();
        String language = local.getDisplayLanguage();
        String displayCountry = local.getDisplayCountry();
        String displayLanguage = local.getDisplayLanguage();
        String ISO3Country = local.getISO3Country();
        String ISO3Language = local.getISO3Language();
        String title = "检测区域设置";
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println(
                "<html><head><title>" +title+  "</title></head>" +
                        "<body bgcolor=\"#f0f0f0\">" +
                        "<h1 align=\" center\"> " +"country: "+ country + "</h1>" +
                        "<h2 align=\"center\">" +"language: "+ language + "</h2>" +
                        "<h3 align=\" center\"> " +"displayCountry: "+ displayCountry + "</h3>" +
                        "<h4 align=\"center\">" +"displayLanguage: "+ displayLanguage + "</h4>" +
                        "<h5 align=\" center\"> " +"ISO3country: "+ ISO3Country + "</h5>" +
                        "<h6 align=\"center\">" +"ISO3language: "+ ISO3Language + "</h6>" +
                        "</body></html>"
        );

    }
}
