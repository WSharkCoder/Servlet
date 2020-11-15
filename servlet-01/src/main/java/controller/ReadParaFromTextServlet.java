package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/19 15:28
 * Servlet 基本表单提交
 */

public class ReadParaFromTextServlet extends HttpServlet {
    /**
     * Servlet
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        String title = "Servlet Read Para";
        writer.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align=\"center\">" + title + "</h1>\n" +
                        "<ul>\n" +
                        "<li><b>名字</b>:" +
                        request.getParameter("first_name") + "\n" +
                        "<li><b>姓氏</b>:" +
                        request.getParameter("second_name") + "\n" +
                        "</ul>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
