package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

/**
 * @uthor Fegert
 * @Date 2020/1/19 20:42
 */
public class ReadAllParaServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "ReadAllParaServlet";
        /**
         * 标签简介：
         * 斜线　<i> </i>
         * 表格
         * <table>
         *      <tr>
         *          <th>表头1</th>
         *          <th>表头2</th>
         *      </tr>
         *      <tr>
         *          <td>表格内容1</td>
         *          <td>表格内容2</td>
         *      </tr>
         * </table>
         */
        out.println(
                "<html>\n " +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align=\"center\">" + title + "</h1>\n" +
                        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                        "<tr>\n" +
                        "<th>参数名</th><th>参数值</th>\n" +
                        "</tr>\n");
        //请求对象获取所有请求参数名
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            out.println("<tr><td>" + paramName + "</td>\n<td>");
            //获取所有参数名对应的参数值
            String[] paramValues = request.getParameterValues(paramName);
            //读取单个数据
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];

                if (paramValue.length() == 0)//单个参数字符串为为空
                    out.println("<i>No Value</i>");
                else out.println(paramValue);
            } else {
                //读取多个数据
                //通过无序列表展示数据
                out.println("<ul>");
                for (int i = 0; i < paramValues.length; i++) {
                    out.println("<li>" + paramValues[i] + "</li>");
                }
                out.println("</ul>");
            }
            out.println("</td>");
        }
        out.println("</tr>\n</table>\n</body><html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
