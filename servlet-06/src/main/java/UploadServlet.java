import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @uthor Fegert
 * @Date 2020/1/28 18:00
 */
public class UploadServlet extends HttpServlet {
    //标识请求消息中的内容是否为"multipart/form-data"类型”
    private boolean isMultipart;
    //存储web.xml文件存储的文件存储路径
    private String filePath;
    //DiskFileItemFactory 属性 临界值
    private int maxFileSize = 1 * 1024 * 1024 * 1024;
    //ServletFileUpload 属性 请求消息实体内容的最大尺寸限制
    private int maxMemSize = 1 * 1024;
    private File file;

    public void init() {
        //同过ServletContext获取file存放路径
        filePath = this.getServletContext()
                .getInitParameter("file-upload");

    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //判断请求消息中内容是否是"multipart/form"类型
        isMultipart = ServletFileUpload.isMultipartContent(request);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!isMultipart) {
            out.println(
                    "<html>" +
                            "<head><title>" +
                            "Servlet upload" +
                            "</title></head>" +
                            "<body>" +
                            "<p>No file uploaded</p>" +
                            "</body></html>"
            );
            return;
        }
        /**
         * DiskFileItemFactory 作用判断文件是存储于内存中还是存储在临时目录中
         * sizeThreshold    临界值
         * repository       临时目录
         *
         */

        DiskFileItemFactory factory = new DiskFileItemFactory();
        //文件小于最大值将被存储在内存中
        factory.setSizeThreshold(maxMemSize);
        //Location on save data this id larger than maxMemSize
        File file1 = new File("d:\\Users\\FangJunXiong\\Desktop\\temp");
        file1.mkdir();
        factory.setRepository(file1);


        //使用 DiskFileItemFactory对象 创建ServletFileUpload对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        //允许上传的文件大小的最大值
        upload.setSizeMax(maxFileSize);//设置请求消息实体内容（即所有上传数据）的最大尺寸限制。单位:/字节


        try {
            //解析出FORM表单中的每一个字段的数据，
            // 并将它们分别包装成独立的FileItem对象,
            // 然后将这些FileItem对象加入进一个List类型的集合对象中返回

            List fileItems = upload.parseRequest(request);

            //获取List迭代器
            Iterator i = fileItems.iterator();

            out.println(
                    "<html><head><title>Servlet Upload</title></head>" +
                            "<body>"
            );
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    String filedName = fi.getFieldName();//返回表单字段的名称;例如  <input type="file" name="file" size="50"/>中的file
                    String fileName = fi.getName();//返回客户端文件系统中原始文件命名
                    String contextType = fi.getContentType();//返回浏览器传递的内容类型，或者null如果未定义
                    Boolean isInMemory = fi.isInMemory();//是否从内存中读取文件内容的提示
                    long sizeInBytes = fi.getSize();//返回文件的大小

                    //写入文件
                    if (fileName.lastIndexOf("\\") >= 0) {
                        //创建文件
                        file = new File(filePath +
                                fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        //创建文件
                        file = new File(
                                filePath + fileName.substring(filedName.lastIndexOf("\\") + 1)
                        );
                    }
                    //一种将上传的项目写入磁盘的简便方法。
                    // 客户端代码与该项目是否存储在内存中或临时位置的磁盘上无关。
                    // 只是将上传的项目写入文件。
                    fi.write(file);
                    out.println(
                            "Uploaded FileName" + filedName + "<br/>");
                }
            }
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (file1.exists()) file1.delete();

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        throw new ServletException("Get Method used with" +
                getClass().getName() + ":Post　method required!");
    }
}
