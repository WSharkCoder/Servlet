package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/19 20:15
 * CheckBox参数
 */
public class ReadParaFromCheckBoxServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.setContentType("text/html");
       response.setCharacterEncoding("utf-8");

        PrintWriter out=response.getWriter();
        String title="Servlet Read Para From CheckBox";

        out.println("<html>\n" +
                "<head><title>"+title+"</title></head>\n" +
                "<body>\n" +
                "<h1 align=\"center\">"+title+"</h1>\n" +
                "<ul>\n" +
                "<li><b>数学标识</b>:" +
                request.getParameter("maths") + "\n" +
                "<li><b>物理标识</b>:" +
                request.getParameter("physics") + "\n" +
                "<li><b>化学标识</b>:" +
                request.getParameter("chemistry") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
