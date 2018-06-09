# day05

## 项目树

<img src="https://ws3.sinaimg.cn/large/006tKfTcgy1fs4xgwilumj30jw0rw0v4.jpg" width="300px">

## Filter

### LoginFilter

实现访问控制：

在未登录时，不能访问success.jsp，替代如下代码：

![](https://ws2.sinaimg.cn/large/006tKfTcgy1fs4xmmx02xj31ic0xqjxt.jpg)

```java
package com.zhaoxuyan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("this is LoginFilter..........................");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        // 判断session是否有用户名，如果无此步骤，可绕过登录直接访问success.jsp
        String name = (String) session.getAttribute("current_username");
        if (name == null) {
            // 保存错误信息
            request.setAttribute("error_message", "您忘了登录哦~！");
            // 非法访问 跳转到登录界面
            request.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
```



### CharacterFilter

来代替每一个`doGet`中的`request.setCharacterEncoding("utf-8");`

![](https://ws2.sinaimg.cn/large/006tKfTcgy1fs4xo2dut6j31kw10awm9.jpg)

## Upload文件

### upload.jsp

![](https://ws3.sinaimg.cn/large/006tKfTcgy1fs4xsqbz0oj315q0qeq7c.jpg)

### UploadServlet

```java
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
```

### 上传到本地目录

![](https://ws2.sinaimg.cn/large/006tKfTcgy1fs4xy04ekhj30ts0ccq54.jpg)

## Tomcat 3.0+中的异步支持

### web.xml

![](https://ws4.sinaimg.cn/large/006tKfTcgy1fs4xuu2z6mj312k0bsjtn.jpg)

### WhileServlet

```java
package com.zhaoxuyan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WhileServlet", urlPatterns = "/WhileServlet")
public class WhileServlet extends HttpServlet {
    /**
     * Constructor of the object.
     */
    public WhileServlet()

    {
        super();
    }

    public void init() throws ServletException {
        // Put your code here
    }

    /**
     * Destruction of the WhileServlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理响应的中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("即将进入死循环");
        out.flush();
        out.close();
        int i = 0;
        while (true) {
            System.out.println(i++);
        }
    }
}
```

