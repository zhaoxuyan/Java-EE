package com.zhaoxuyan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "UploadServlet", urlPatterns = "/UploadServlet")
@MultipartConfig(
        location = "/Users/zhaoxuyan/IdeaProjects/Java EE/day05/upload", // 上传文件到本地的位置
        maxFileSize = 83008608, // 最大上传文件大小
        fileSizeThreshold = 819200, // 当数量大于该值时，内容将被写入文件
        maxRequestSize = -1 // 针对multipart/form-data 请求最大数量，默认值为-1，表示没有限制。以字节为单位。
)
public class UploadServlet extends HttpServlet {
    /**
     * Constructor of the object.
     */
    public UploadServlet()

    {
        super();
    }

    public void init() throws ServletException {
        // Put your code here
    }

    /**
     * Destruction of the UploadServlet. <br>
     */
    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            String contentDisposition = part.getHeader("content-disposition");
            System.out.println("content-disposition=" + contentDisposition);
            String filename = null;
            Pattern pattern = Pattern.compile("filename=\".+\"");
            Matcher matcher = pattern.matcher(contentDisposition);
            if (matcher.find()) {
                filename = matcher.group();
                System.out.println("filename=" + filename);
                filename = filename.substring(10, filename.length() - 1);
                System.out.println("subfilename=" + filename);
            }
            if (filename != null) {
                part.write(filename);
            }
        }
    }
}
