import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * @uthor Fegert
 * @Date 2020/1/29 19:39
 * Servlet发送邮件演示
 *
 */
public class SendMail extends HttpServlet {
    //发送普通邮件
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //收件人的电子邮箱ID
//        String to = "2638343960@qq.com";
//        //发件人电子邮箱ID
//        String from = "fangjunxiong@outlook.com";
//
//
//
//        //获取系统的属性,主要用来设置邮件相关参数
//        Properties properties = System.getProperties();
//        //设置邮件传输服务器，由于本次是发送邮件操作，所需我们需要配置smtp协议，
//        // 按outlook官方同步邮件的要求，依次配置协议地址，端口号和加密方法
//        properties.setProperty("mail.transport.protocol", "smtp");
//        properties.setProperty("mail.smtp.host", "smtp.office365.com");//配置协议地址
//        properties.setProperty("mail.smtp.port", "587");
//        properties.setProperty("mail.smtp.starttls.enable", "true");
//
//
//
//        //用户验证并返回Session,开启用户验证,设置发送邮件的账号和密码
//        properties.setProperty("mail.smtp.auth", "true");
//
//        Session session = Session.getDefaultInstance(properties,new Authenticator(){
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication(){
//                return new PasswordAuthentication("fangjunxiong@outlook.com", "iloveyou201314");
//            }
//        });
//
//        //设置相应内容类型
//        response.setContentType("text/html");
//        response.setCharacterEncoding("utf-8");
//
//        PrintWriter out = response.getWriter();
//
//
//        //创建MimeMessage消息对象，消息头配置了收发邮箱的地址，消息体包含了邮件标题和邮件内容
//        // 。接收者类型：TO代表直接发送，CC代表抄送，BCC代表秘密抄送。
//        try {
//            //创建一个默认的MimeMessage对象
//            MimeMessage message = new MimeMessage(session);
//            message.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
//            //设置From：header field of the header
//            message.setFrom(new InternetAddress(from));
//
//            /**多收信人设置
//             * void addRecipients(Message.RecipientType.type，Address[] address)
//             * type:To/CC/BCC  CC表示抄送 BCC表示秘密抄送
//             * address 电子邮件ID数组
//             */
//            //设置to: header field of the header
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            //设置Subject, header field
//            message.setSubject("This is the Subject Line ");
//            //设置实际消息
//            message.setText("This is actual message ");
//            //发送消息
//            Transport.send(message);
//            String title = "发送邮件";
//            String res = "成功发送消息。。。";
//            out.println(
//                    "<html><head><title>"+title+"</title></head>" +
//                            "<body bgcolor=\"#f0f0f0\">\n" +
//                            "<h1 align=\"center\">"+title+"</h1>" +
//                            "<p align=\" center\">"+res+"</p>" +
//                            "</body></html>"
//            );
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//
//    }
    //发送HTML邮件
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String to = "2638343960@qq.com";
        String from = "fangjunxiong@outlook.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.transport.protocol", "smtp");//设置传输协议
        properties.setProperty("mail.smtp.host", "smtp.office365.com");//设置邮件服务器
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("fangjunxiong@outlook.com", "iloveyou201314");
            }
        });

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("HTML邮件测试");
            /**
             *   void setContent(Object obj,String type)
             *   type : "text/html;charset=utf-8"
             */


            message.setContent("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                    "    <title>Document</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>HTMl邮件</h1>\n" +
                    "</body>\n" +
                    "</html>", "text/html;charset=utf-8");
            Transport.send(message);
            out.println("<html><head><title>HTMlT</title></head><body><h1>" +
                    "邮件发送中。。。" + "</h1></body></html>");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
