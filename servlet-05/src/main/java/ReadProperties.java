import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @uthor Fegert
 * @Date 2020/1/28 16:11
 * 读取配置文件
 */
public class ReadProperties extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        InputStream inputStream = this.getServletContext().getResourceAsStream("DataSource.properties");
        InputStream inputStream=ReadProperties.class.getClassLoader().getResourceAsStream("DataSource.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String name=(String)properties.get("DataSource_name");
        String password=(String)properties.get("DataSource_password");
        System.out.println(name+"   "+password  );
    }
}
