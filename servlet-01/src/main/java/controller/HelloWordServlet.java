package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/19 12:34
 * 返回HTML页面
 */
public class HelloWordServlet extends HttpServlet {
    private String message;
    @Override
    public void init() {
        message = "HelloWorld";
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Content-Type:text/html
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h>" + message + "</h>");
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}
