import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @uthor Fegert
 * @Date 2020/1/21 14:54
 * 响应信息
 */
public class RefreshServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /**
         *响应头信息
         * Allow            指定服务器支持的请求方法
         * Cache-Control    指定响应头在何种情况下可以安全缓存
         *                  取值范围: public 文件可以缓存
         *                          private 文件是单用户私人文档，只能存储在私有缓存中
         *                          no-cache 文档不应该被缓存
         *Connection        指示浏览器是否支持持久HTTP连接
         *                  取值返回:close 浏览器不使用持久Http连接
         *                          keep-alive 使用持久连接
         *Content-Disposition   请求浏览要求用户以给定名称的文件把响应保存到磁盘
         *Content-Encoding      指定页面的编码方式
         *Content-Language      文档编写使用的语言
         *Content-Length        指示响应中字节数.只有当浏览器使用持久（keep-alive)，Http连接时才需要这些信息
         *Content-Type          响应文档的MIME类型
         *Expires               指定内容过期时间,在这之后内容不再被缓存
         *Last-Modified         指示文档的最后的修改时间;然后,客户端可以缓存文件, 并在以后的请求中通过If-Modified-Since请求头信息提供一个日期
         *Location              本头信息应该包含在所有的带状态码的响应中。在300s内，这会通知浏览器文档的地址。浏览器会自动重新连接到这个位置,并获取新的文档
         * RefreshServlet              这个头信息指定浏览器应该如何尽快请求更新的页面，您可以指定页面刷新的秒数
         * Retry-After          本信息头可以503相应配合使用，这会告诉客户端多久就可以重复它的请求
         * Set-Cookie           本头信息指定一个与页面相关的cookie
         */
        //设置刷新时间
        response.setCharacterEncoding("utf-8");
        response.setIntHeader("refresh",5);
        //设置响应内容类型
        response.setContentType("text/html");
        //日历类
        Calendar calendar=new GregorianCalendar();
        String am_pm;
        int hour=calendar.get(Calendar.HOUR);
        int minute=calendar.get(Calendar.MINUTE);
        int second=calendar.get(Calendar.SECOND);
        if(calendar.get(Calendar.AM_PM)==0)
            am_pm="AM";
        else am_pm="PM";
        String CT=hour+":"+minute+":"+second+" "+am_pm;

        PrintWriter out=response.getWriter();
        String title="自动刷新Header设置";
        out.println("<html>\n" +
                "<head><title>"+title+"</title></head>\n" +
                "<body >\n" +
                "<h1 align=\"center\" >"+title+ "</h1>\n" +
                "<p>当前时间是："+CT+"</p>\n");

        /**
         * HttpServletResponse类
         *void sendRedirect(String location)
         *使用指定的重定向位置URL发送临时重定向响应到客户端
         *String encodeRedirectURl(String url)
         *为sendRedirect方法中使用的指定的URL进行编码，或者如果编码不是必须的，则返回URL未改变
         *String encodeURl(String url)
         *对包含session会话ID的指定URL进行编码，或者如果编码不是必需要的就返回URL未改变
         *boolean containHeader(String  name)　
         *返回一个布尔值，指示是否已经设置已经命名的响应报头
         * boolean isCommitted()
         *返回一个布尔值，指示响应是否已经提交
         * void addCookie(Cookie cookie)
         * 把指定的cookie添加到响应头中
         *
         *
         * void addDataHeader(String name,long date)
         * 添加一个带有给定的名称和日期值的响应报头
         * void addHeader(String name ,String value)
         * 添加一个带有给定的名称和值的响应报头
         * void addIntHeader(String name,int value)
         * 添加一个带有给定的名称和整数值的响应报头
         *
         * void flushBuffer()
         * 强制任何在缓冲区的内容被写入到客户端
         * void reset()
         * 清除缓冲区中存在的任何数据，包括状态码和头
         * void resetBuffer()
         * 清除缓冲区中基础缓冲区的内容,不清除状态码和头
         * void sendError(int sc)
         * 使用指定的状态码返回错误响应到客户端,并清除缓冲区
         * void sendError(int sc,String msg)
         * 使用指定的状态发送错误响应到客户端
         * void setBufferSize(int size)
         * 为响应主体设置首选的缓冲区大小
         * void setCharacterEncoding(String charset)
         * 设置被发送到客户端的响应的字符集编码（MIME字符集）,UTF-8
         * void setContentLength(int len)
         * 设置在HTTP Servlet响应中的内容主体的长度,该方法设置Http Content-Length
         * void setContentType(int len)
         * 如果响应应该还未被提交，设置被发送到客户端的响应的内容
         *
         * void setDateHeader(Sting name,long date)
         * 设置一个带给定的名称和值的响应报头
         * void setHeader(String name,String value)
         * 设置一个带有给定的名称和值的响应报头
         * void setIntHeader(String name,int value)
         * 设置一个带给定的名称和整数值的响应报头
         * void setLocal(Local loc)
         * 如果响应还未被提交，设置响应的区域
         * void serStatus(int sc)
         * 为响应设置状态码
         *
         */

    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
