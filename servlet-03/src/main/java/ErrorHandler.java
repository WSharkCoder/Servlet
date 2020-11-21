import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.TableHeaderUI;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/21 21:39
 * Servlet异常处理
 */
public class ErrorHandler extends HttpServlet {
    /**
     * 错误处理的Servlet可以访问的请求属性列表,用来分析错误/异常的性质
     * 1.javax.servlet.error.status_code
     * 该属性给出状态码，状态码可被存储，并在存储为java.lang.Integer数据类型可被分析
     * 2.javax.servlet.error.exception_type
     * 该属性给出异常类型的信息，异常类型可以被存储,并在存储为java.servlet.Class数据类型后可以被分析
     * 3.javax.servlet.error.message
     * 该属性给出确切的错误的信息，信息可被存储，并在存储为java.lang.String类型后可以被分析
     * 4.javax.servlet.error.request_uri
     * 该属性给出有关URL调用Servlet的信息，信息可以被存储,并在存储为java.lang.String数据类型后可以被分析
     * 5.javax.servlet.error.exception
     * 该属性给出异常产生的信息，信息可以被存储，并存储为java.lang.Throwable数据类型后可以被分析
     * 6.javax.servlet.error.servlet_name
     * 该属性给出Servlet名称，名称可被存储,并在存储为java.lang.String数据类型后可以被分析
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //分析servlet异常
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestURL = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestURL == null) {
            requestURL = "Unknown";
        }


        //设置响应头
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "ERROR/Exception Information";
        out.println("<html>\n " +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        if(throwable==null&&statusCode==null){
            out.println("<h2>Error information is missing</h2>");
            out.println("please return to the <a href=\""+
                    response.encodeURL("http://localhost:8080/servlet1_test03_war/")+
                    "\">Home page</a>.");
        }else if(statusCode!=null){
            out.println("The status code:"+statusCode);
        }else {
            out.println("<h2 class=\"tutheader\")Error information</h2>" );
            out.println("Servlet Name:"+servletName+"</br></br");
            out.println("Exception Type:"+throwable.getClass().getName()+"</br></br>");
            out.println("The request URI:"+requestURL+"</br></br>");
            out.println("The exception message:"+throwable.getMessage());
        }
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
