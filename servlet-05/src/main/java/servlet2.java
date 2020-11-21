import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/28 13:58
 */
public class servlet2 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //获取servletContext的某个属性
        //1.获取ServletContext
        ServletContext context = this.getServletContext();
        //2.取出属性
        String name = (String) context.getAttribute("name");
        PrintWriter out=response.getWriter();
        out.println(
                "name=" + name
        );
        /**
         * ServletContext常用方法
         *
         * public void setAttribute(String name,Object obj)
         * 向ServletContext中添加属性
         *
         * public Object getAttribute(String name)
         * 根据name得到值obj
         *
         * public void removeAttribute(String  name)
         * 删除属性
         *
         */

    }
}
