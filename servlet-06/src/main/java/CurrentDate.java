import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @uthor Fegert
 * @Date 2020/1/29 17:00
 */
public class CurrentDate extends HttpServlet {
    //Date 类的使用
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //设置响应头信息
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html");
//        Date currentDate = new Date();
//        String title = "显示当前的日期和时间";
//        PrintWriter out = response.getWriter();
//        out.println("<html><head><title>" + title + "</title></head>" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">"+title+"</h1>\n" +
//                "<h2 align=\"center\">"+currentDate.toString()+"</h2>\n" +
//                "</body></html>");
//
//
//    }

    //SimpleDateFormat类的使用
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String title = "显示当前时间和日期";
        Date date = new Date();
        PrintWriter out = response.getWriter();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyy.MM.dd 'at' hh:mm:ss a zz ");
        out.println("<html><head><title>" + title + "</title></head>" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">" + simpleDateFormat.format(date) + "</h2>\n" +
                "</body></html>");
        /**
         * SimpleDataFormat类
         * 常用构造方法
         *      SimpleDataFormat(String)//String 参数通常为事件模式字符串
         * 常用方法
         *      String format(Date)//返回通过Date对象创建的时间字符串
         *
         * 时间模式字符串用来指定时间格式。在此模式下，所有的ASCII字母保留作为模式字符
         * y    年        yyyy 2020
         * M    月        MM   01
         * d    日        dd   09
         * H    时        HH   17
         * m    分        mm   56
         * s    秒        ss   46
         * S    毫秒      SS   45
         * E    星期      E    星期三
         * a    AM/PM     a    上午/下午
         * z    时区      ZZZ
         * '    文字界定符
         * G     纪元标记  AD
         *
         */
    }
}
