import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @uthor Fegert
 * @Date 2020/1/30 13:20
 */
public class DisplaySpanish extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Content-Language", "es");
        PrintWriter out = response.getWriter();
        String title = "En Espa&ntilde;ol";
        out.println(
                "<html><head><title>" + title + "</title></head>" +
                        "<body>" + "<h1>" + "En Espa&ntilde;ol:" + "</h1>\n" +
                        "<h1>" + "&iexcl;Hola Mundo!" + "</h1>\n" +
                        "</body></html>"

        );
    }
}
