import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/28 11:47
 */
public class servlet1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //获取ServletContext对象的引用
        //第一种方法
        ServletContext context=this.getServletContext();

        //第二种方法
//        ServletContext context1=this.getServletConfig().getServletContext();
        context.setAttribute("name","小明");

        PrintWriter out=response.getWriter();
        out.println(
                "将name=小明写入了ServletContext中"
        );
    }
    /**
     *ServletContext的作用：
     * 1.多个Servlet之间进行数据共享
     * 2.实现Servlet的请求转发
     * 方法一：
     *          request
     *         .getRequestDispatcher("/servlet2")
     *         .forward(request,response);
     * 方法二：
     *          this
     *          .getServletContext()
     *          .getRequestDispatcher("/servlet2")
     *          .forward(request,response);
     * 3.获取web应用的初始化参数
     * 方法一(针对单个servlet)：
     *      web.xml
     *          <servlet>
     *              <servlet-name>servlet1</servlet-name>
     *              <servlet-class>servlet</servlet-class>
     *              <init-param>
     *                  <param-name>encoding</param-name>
     *                  <param-value>utf-8</param-value>
     *              </init-param>
     *          </servlet>
     *      String encoding=
     *      this
     *      .getServletConfig()
     *      .gerInitParameter("encoding");
     * 方法二(针对本项目的所有的servlet):
     *      web.xml
     *      <context-param>
     *         <param-name>name</param-name>
     *         <param-vlue>value</param-vlue>
     *      </context-param>
     *      Sting value=
     *      this
     *      .getServletContext()
     *      .getInitParameter("name");
     *
     * 4.读取配置文件
     * 方法一：
     * DataSource.properties文件放置在src/resources目录下时：
     * InputStream input=ReadProperties.class.getClassLoader().getResourceAsStream("DataSource.properties");
     * 方法二：
     * DataSource.properties文件放置在webapp/目录下
     * InputStream input=this.getServletContext().getResourceAsStream("DataSource.properties");
     *
     * ServletContext只能读取web应用的根目录下(通常为webapp)时,才能获取文件的全路径;如下获取webapp/img/1.jpg例：
     * Sting path=this.getServletContext().getRealPath("img/1.jpg" );
     *
     *
     *
     */
}

