import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @uthor Fegert
 * @Date 2020/1/21 17:07
 * 状态行信息展示
 * HTTP版本  状态码  状态码的短信息
 */
public class HttpStatusServlet extends HttpServlet {
    /**Http状态码
     *100系列
     *      100 Continue           请求的一部分已经被服务器接受,但只要请求没有被拒绝,客户端应该继续该请求
     *      102 Switching Protocols     服务器切换协议
     *200系列
     *      200 OK          请求成功
     *      202 Created     请求完整,并创建一个新的资源
     *      203 Accepted     该请求被接受处理，但是该处理是不完整的
     *300系列
     *      300 Multiple Choices  链接列表。用户可以选择一个链接,进入到该位置。最多五个地址
     *      301 Moved Permanently 请求的页面已经转移到一个新的URL
     *      302 Found     所请求的页面已经临时转移到一个新的URL
     *      303 See Other 所请求页面可以在另一个不同的URL下别找到
     *      306 Unused 在之前的版本中使用该代码。现在已经再使用
     *      307 Temporary Redirect  所请求的页面已经临时转移到一个新的URL
     *400系列
     *      400 Bad Request 服务器不理解请求
     *      401 Unauthorized 说请求的页面需要用户名和密码
     *      403 Forbidden 禁止访问说请求的页面
     *      404 Not Found 服务器无法找到说请求的页面
     *      405 Method Not Allowed 在请求中指定的方法是不允许的
     *      414 Request-url too long 服务器不接受请求，因为URL太长。
     *      415 Unsupported Media Type 服务器不接受请求,因为媒体类型不被支持
     *500系列
     *      500 Internal Server Error 未完成的请求，服务器遇到意外情况
     *      501 Not Implemented 未完成的请求，服务器不支持所需的功能
     *      502 Bad Gateway 未完成的请求，服务器从上游服务器收到无效响应
     *      503 Service Unavailable 未完成的请求。
     *      504 Gateway Timeout 网关超时
     *
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(407,"Need authentication!!");
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
