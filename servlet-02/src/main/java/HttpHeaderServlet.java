import javax.servlet.ServletInputStream;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;

/**
 * @uthor Fegert
 * @Date 2020/1/20 19:31
 */
public class HttpHeaderServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /** 常见请求头参数
         * Accept               浏览器或其他客户端能够处理的MIME类型  常见： image/png或 image/jpeg
         * Accept-Charset       浏览器可以用来显示信息的字符集
         * Accept-Encoding      浏览器知道如何处理的编码类型         常见：gzip 或 compress
         * Accept-Language      客户端首选语言,在这种情况下,Servlet会产生多种语言结果.例如: en,en-us,ru等
         * Authorization        用于客户端在访问受密码保护的网页时识别自己身份
         * Connection           指示客户端是否能够处理长久Http连接，持久连接允许客户端或其他浏览器通过单请求来检索多文件。值Keep-Alive表示使用持续连接
         * Content-Length       只适用于POSt  方法，并给出POST数据的大小（字节为单位）
         * Cookie               把之前发送给浏览器的Cookie返回给服务器
         * Host                 原始的URL中的主机和端口
         * If-Modified-Since    当前页面在指定的日期后已更改时，客户端想要的页面，如果没有新的结果使用，服务器就会发送304
         * If-Unmodified-Since  文件早于指定日期时，操作才会成功
         * Refer                指示所指向的Web页面的Url.例如，如果您在网页 1，点击一个链接到网页 2，当浏览器请求网页 2 时，网页 1 的 URL 就会包含在 Referer 头信息中。
         * User-Agent           设别发出请求的浏览器或客户端，并可以向不同类型的浏览器返回不同内容
         *
         */
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        String title = "Http Header 请求示例";
        out.println(
                "<html>\n"
                        + "<head><title>" + title + "</title></head>" +
                        "<body bgcolor=\"#f0f0f0\">\n" +
                        "<h1 align=\"center\"" + title + "</h1>\n" +
                        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                        "<tr bgcolor=\"#f0f0f0\"\n" +
                        "<th>Header名称></th><th>Header值</th>\n" +
                        "</th>\n"
        );
        //获取请求头中的参数名
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String paramName = (String) headerNames.nextElement();
            out.println("<tr><td>" + paramName + "</td>\n");
            //获取参数值
            String paramValue = request.getHeader(paramName);
            out.println("<td>" + paramValue + "</td><tr>\n");
        }
        out.println("</table>\n</body></tml>");
//        /**
//         *HttpServletRequest 类
//         */
//        //返回客户端发送请求的所有的Cookie对象数组
//        Cookie[] cookies= request.getCookies();
//        //返回请求可用的属性名称的枚举
//        Enumeration enumeration=request.getAttributeNames();
//        //返回请求头包含所有的头名的枚举
//        Enumeration enumeration1=request.getHeaderNames();
//        //返回一个String对象的枚举，包含在请求中的参数的名称
//        Enumeration enumeration2=request.getParameterNames();
//        //返回与该请求关联的当前session会话,如果请求没有session会话，就创建一个
//        HttpSession httpSession=request.getSession();
//        //返回与该请求关联的当前HttpSession,或如果没有当前会话，且create为真,就返回一个新session会话
//        HttpSession httpSession1=request.getSession(true);
//        //基于Accept-Language头，返回客户端接受内容的首选的区域设置
//        Locale locale=request.getLocale();
//        //以对象形式返回已经命名属性的值，如果没有给定名称的属性存在，则返回null
//        Object object=request.getAttribute("name");
//        //以二进制形式检索请求主体
//        ServletInputStream inputStream=request.getInputStream();
//        //返回用于保护Servlet的身份验证方案的名字
//        String string=request.getAuthType();
//        //返回请求主体中使用的字符编码的名称
//        String string1=request.getCharacterEncoding();
//        //返回请求的Http方法名称
//        String method=request.getMethod();
//        //以字符串形式返回请求参数的值，或如果参数不存在则返回null
//        String params=request.getParameter("name");
//        //当前请求发出时，返回与客户端发送的URL相关的任何额外的路劲信息
//        String pathInfo=request.getPathInfo();
//        //返回请求协议的名称和版本
//        String protocol=request.getProtocol();
//        //返回包含在路径后的请求URL中的查询字符串
//        String queryString=request.getQueryString();
//        //返回请求客户端的Ip地址
//        String ipAddress=request.getRemoteAddr();
//        //返回发送请求的客户端的完全限定名称
//        String remoteHost=request.getRemoteHost();
//        //如果用户已经通过身份验证，则返回发送请求的登陆用户，或者如果用户未通过身份验证，则返回null
//        String remoteUser=request.getRemoteUser();
//        //从协议名称直到Http请求的第一行的查询字符中,返回该请求的URL的一部分
//        StringBuffer url=request.getRequestURL();
//        //返回由客户端指定的session会话ID
//        String sessionID=request.getRequestedSessionId();
//        //返回调用JSP的请求的URL的一部分
//        String servletPath=request.getServletPath();
//        //返回一个字符串对象数组，包含所有给定的请求参数的值，如果参数不存在则返回null
//        String[]  paramValues =request.getParameterValues("name");
//        //返回一个布尔值，指示请求是否使用安全通道，如https
//        Boolean flag=request.isSecure();
//        //以字节为单位返回请求主体的长度,并提供输入流,或者如果长度未知则返回-1
//        int contentLength=request.getContentLength();
//        //返回指定的请求头的值为一个int值
//        int header=request.getIntHeader("name");
//        //返回接收到这个请求的端口号
//        int serverPort= request.getServerPort();

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
