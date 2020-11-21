import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @uthor Fegert
 * @Date 2020/1/24 18:20
 * session 跟踪用户访问信息演示
 */
public class SessionTrackServlet extends HttpServlet {
    /**
     *
     * 对HttpSession对象的常用方法进行归纳：
     *
     *
     * public Object getAttribute(String name)
     * 返回session会话中的具有的指定name的对象，如果没有指定name的对象，则返回null
     *
     * public void  removeAttribute(String name)
     * 从session会话中移除指定name的对象
     *
     * public void setAttribute(String name,Object value)
     * 使用指定的name绑定一个对象（value）到会话框
     *
     * public Enumeration getAttributeNames()
     * 返回String对象的枚举，String对象包含所有绑定到该session会话对象的名称
     *
     *
     *
     *
     *
     * public long getCreationTime()
     * 返回该session会话创建时间，自格林治标准时间1970年1月1号算起，以毫秒为单位
     *
     * public long getLastAccessedTime()
     * 返回客户端最后一次发送与该session会话相关的请求的时间自格林治标准时间1970年1月1号日午夜算起，以毫秒为单位
     *
     * public long getMaxInactiveInterval()
     * 返回Servlet容器在客户端访问时保存session会话打开的最大时间间隔，以秒为单位
     *
     * public void setMaxInactiveInterval(int interval)
     * 在Servlet容器指示该session会话无效时之前，指定客户端请求之间的时间，以秒为单位
     *
     *
     *
     *
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //如果session会话不存在，则创建一个session对象
        System.out.println();
        HttpSession session=request.getSession(true);
        //获取session创建时间
        Date createTime= new Date(session.getCreationTime());
        //获取网页的最后一次访问时间
        Date lastTime=new Date(session.getLastAccessedTime());

        String title="欢迎回到我的网站";
        Integer visitCount=new Integer(0);
        String visitCountKey=new String("visitCount");
        String userIDKey=new  String("UserID");
        String userID=new String("ABCD");

        //检查网页是否有新的访问者
        String userID2= (String) session.getAttribute(userIDKey);
        if(userID2==null){
            title = "欢迎来到我的网站";
            session.setAttribute(userIDKey,userID);//使用指定的名称绑定一个对象到该session会话
        }else{
            visitCount=(Integer)session.getAttribute(visitCountKey);
            visitCount= visitCount+1;
            userID=(String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey,visitCount);

        //设置相响应内容类型
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();
        out.println(
                "<html>\n" +
                        "<head><title>"+title+"</title></head>\n" +
                        "<body bfcolor=\"#f0f0f0\">\n" +
                        "<h1 align=\"center\">"+title+"</h1>\n" +
                        "<h2 align=\"center\">Session信息</h2>\n" +
                        "<table borden=\" 1\" align=\"center\">\n" +
                        "<tr bgcolor=\"#f949494\">\n" +
                        "<th>Session信息</th><th>值</th></tr>\n" +
                        "<tr>\n" +
                        "<td>id</td>\n" +
                        "<td>"+session.getId()+"</td></tr>\n" +
                        "<tr>\n" +
                        "<td>Creation Time</td>\n" +
                        "<td>"+createTime+
                        "</td></tr>\n" +
                        "<tr>\n" +
                        "<td>Time of Last Access</td>\n" +
                        "<td>"+lastTime+
                        "</td></tr>\n" +
                        "<tr>\n" +
                        "<td>User ID</td>\n" +
                        "<td>"+userID+
                        "</td></tr>\n" +
                        "<tr>\n" +
                        "<td>Number of visit</td>\n " +
                        "<td>"+visitCount+"</td></tr>\n" +
                        "</table>\n" +
                        "</body></html>"
        );

    }
}
