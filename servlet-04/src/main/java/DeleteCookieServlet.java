import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/22 17:35
 * 删除Cookie
 */

/**
 *通过servlet删除cookie
 *1.读取一个现有的 Cookie，并把它存储在Cookie对象中
 *2.使用setMaxAge方法设置cookie的过期时间为0,来删除现有cookie
 *3.把这个cookie添加到响应头中
 *
 */
public class DeleteCookieServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie=null;
        Cookie[] cookies=null;
        //获取与与相关的Cookie的数组
        cookies=request.getCookies();

        //设置响应内容类型
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out=response.getWriter();
        String title="Delete Cookies Example";
        out.println("<html>\n" +
                "<head><title>"+title+"</title><head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        if(cookies!=null){
            out.println("<h2>Cookies 名称和值</h2>");
            for(int i=0;i<cookies.length;i++){
                cookie=cookies[i];
                if(cookie.getName().compareTo("first_name")==0){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.println("已经删除的Cookie："+cookie.getName()+"</br>\n");
                }
                out.println("名称："+cookie.getName());
                out.println("值：" + cookie.getValue());
            }
        }else if(cookies==null){
            out.println("<h2 Class=\"tutheqder\">No cookies founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");

    }
}
