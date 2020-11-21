import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * 全局过滤器
 */
//自定义Filter实现类
public class GlobalFilter implements Filter {

    /**
     * 由web容器调用，指示一个过滤器被放入服务
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        String site=filterConfig.getInitParameter("Site");
        System.out.println("百度网址："+site);


    }

    /**
     *该方法在每次一个请求/响应对应客户端在链末端请求资源而通过链传递时由容器调用
     * @param servletRequest 请求
     * @param servletResponse 响应
     * @param filterChain  过滤器链
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取客户端的IP地址
        String ipAddress=servletRequest.getRemoteAddr();
        //记录Ip地址和当前时间戳
        System.out.println("IP"+ipAddress+",Time"+new Date().toString());
        //把请求传回过滤链
        filterChain.doFilter(servletRequest,servletResponse);

    }

    /**
     *由web容器调用，指示一个容器过滤器被取出服务
     */
    @Override
    public void destroy() {
        //在Filter示例被web容器从服务移除之前调用
    }
}
