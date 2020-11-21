import javax.servlet.*;
import java.io.IOException;


/**
 * @uthor Fegert
 * @Date 2020/1/29 18:56
 * 通过过滤器实现网站的点击量
 *
 */
public class SiteHitCounter implements Filter {
    private int hitCounter;//点击量计数器

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //重置计数器的值
        hitCounter=0;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //计数器的值加1
        hitCounter++;
        //输出计数器的值
        System.out.println("网站访问量：" + hitCounter);
        //将请求返回过滤链
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
