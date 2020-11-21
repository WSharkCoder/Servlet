import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/22 16:33
 * 读取Cookie演示
 */
public class ReadCookieServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie=null;
        Cookie[] cookies=null ;
        //获取与该域相关的Cookie的数组
        cookies=request.getCookies();

        //设置响应的内容
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String title ="Reading Cookie Example ";
        PrintWriter out=response.getWriter();

        out.println("<html>\n" +
                "<head><title>"+title+"</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" );
        if(cookies!=null){
            out.println("<h2>查找Cookie名字和值</h2>");
            for(int i=0; i<cookies.length;i++) {
                cookie = cookies[i];
                out.println("名称：" + cookie.getName() + ",");
                out.println("值：" + cookie.getValue() + "</br>");
            }
        }else {
            out.println("<h2 Class=\"tutheader\">未找到Cookie</h2>");
        }
        out.println("</body></html>" );
    }

}
