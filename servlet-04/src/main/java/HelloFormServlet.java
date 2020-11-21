import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/22 14:57\
 * Cookie登陆机制详解
 * <p>
 * Cookie是存储在客户端计算机上的文本文件，并保存了各种跟踪信息。
 * 识别返回用户包括三个步骤：
 * 1.浏览器第一次向服务器发起请求（通常时登陆请求）时，服务器脚本向浏览器发送一组Cookie.（Cookie包含用户的唯一标识）
 * 2.浏览器将Cookie存储在本地计算机，以备后续使用。
 * 3.当下一次浏览器向web服务器发送任何请求时，浏览器会把这些Cookie信息发送到服务器，服务器将使用这些信息来识别用户。
 */
/**
 * 以用户登陆情形为例：
 * 用户登陆后，servlet返回HTTP响应给浏览器，此时有两种方案设置Cookie:
 * 方案一：
 *      前端从HTTP响应中获取信息后通过javaScript直接在浏览器上设置一个cookie
 *方案二：
 *      servlet返回带Set-Cookie头信息的HTTP响应，浏览器获取Set-Cookie中的信息设置Cookie
 * 包含Set-Cookie信息头的HTTP响应：
 * HTTP/1.1 200 OK
 * Date: Fri, 04 Feb 2000 21:03:38 GMT
 * Server: Apache/1.3.9 (UNIX) PHP/4.0b3
 * Set-Cookie: name=xyz;                                  //名称值对   名称和值会被URL编码
 *             expires=Friday, 04-Feb-07 22:03:38 GMT;    //GMT日期　　告知浏览器在给定时间和日期后“忘记”该Cookie
 *             path=/;                                    //路径
 *             domain=w3cschool.cn                        //域
 * Connection: close
 * Content-Type: text/html
 *
 *
 *当用户的浏览器指向任何匹配上述Cookie的路径和域页面，它会重新发送Cookie服务器.发送请求头信息如下：
 *Get /HTTP/1.0
 *Connection:Keep-Alive
 *User-Agent: Mozilla/4.6 (X11; I; Linux 2.2.6-15apmac ppc)
 *Host: zink.demon.co.uk:1126
 *Accept: image/gif,
 *Accept-Encoding: gzip
 *Accept-Language: en
 *Accept-Charset: iso-8859-1,*,utf-8
 *Cookie: name=xyz
 *
 */

public class HelloFormServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /**
         * Cookie类使用说明：
         * 创建Cookie对象：
         * Cookie cookie=new Cookie("cookieKey","cookieValue ");
         * 注意：cookieKey 与 cookieValue 不应该包含以下字符：
         * [] () , =  "  / ? @ : ;
         *
         * 方法说明:
         * public void setComment(String purpose)
         * 规定了描述cookie目的的注释。
         * public void getComment()
         * 返回表述cookie目的的注释
         */
        //为名字和姓氏创建Cookie
        Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
        Cookie secondName = new Cookie("second_name", request.getParameter("last_name"));

        //设置两个Cookie过期时间为15分钟
        firstName.setMaxAge(15 * 60);
        secondName.setMaxAge(15 * 60);
        //在响应头中添加两个cookie
        response.addCookie(firstName);
        response.addCookie(secondName);
        //设置响应内容类型
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String title = "设置Cookie实例";
        out.println(
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "<li><b>名称</b>:" +
                request.getParameter("first_name") + "\n" +
                "<li><b>姓氏</b>:" +
                request.getParameter("last_name") + "\n" +
                        "</ul>\n" +
                        "</body></html>");
    }

}
