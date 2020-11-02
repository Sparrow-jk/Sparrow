import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 从servlet开始
 *
 * @author Sparrow
 * @version 1.0
 * @date 2019/7/29 15:47
 * @since JDK 1.8
 *     <p>Copyright (c) 2019, Sparrow All Rights Reserved.
 */

// loadOnStartup
// 1.元素标记容器是否应该在web应用程序启动的时候就加载这个servlet。
// 2.它的值必须是一个整数，表示servlet被加载的先后顺序。
// 3 .如果该元素的值为负数或者没有设置，则容器会当Servlet被请求时再加载。
// 4.如果值为正整数或者0时，表示容器在应用启动时就加载并初始化这个servlet，值越小，servlet的优先级越高，就越先被加载。值相同时，容器就会自己选择顺序来加载。
@WebServlet(
    name = "ServletSample",
    urlPatterns = {"/ServletSample"},
    loadOnStartup = 0,
    asyncSupported = false,
    initParams = {@WebInitParam(name = "url", value = "/ServletSample")})
// 该注解主要是为了辅助 Servlet 3.0 中 HttpServletRequest 提供的对上传文件的支持。该注解标注在 Servlet 上面，以表示该 Servlet 希望处理的请求的
// MIME 类型是 multipart/form-data。
// 另外，它还提供了若干属性用于简化对上传文件的处理
@MultipartConfig(
    fileSizeThreshold = 1,
    location = "E:\\servlet",
    maxFileSize = -1,
    maxRequestSize = -1)
public class ServletSample extends HttpServlet {
  @Override
  public void init() throws ServletException {

    super.init();
    System.out.println("ServletSample init");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String servletName = getServletName();
    String initParameter = getInitParameter("url");
    ServletContext servletContext = getServletContext();
    String serverInfo = servletContext.getServerInfo();
    String contextPath = servletContext.getContextPath();
    String servletContextName = servletContext.getServletContextName();
    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/DispatcheredServlet");
    req.setAttribute("dispatcher","ServletSample");
    //这一步进入 DispatcheredServlet 的service方法
    requestDispatcher.forward(req, resp);
    //这一步由DispatcheredServlet 的service方法 返回
    /**
     *  requestDispatcher.forward(req, resp); 似乎和Filter及其相似，Filter可能由servlet的转发实现
     */


    System.out.println("servletName :" + servletName);
    System.out.println("initParameter :" + initParameter);
    System.out.println("serverInfo :" + serverInfo);
    System.out.println("contextPath :" + contextPath);
    System.out.println("servletContextName :" + servletContextName);
  }

  @Override
  public void destroy() {
    System.out.println("ServletSample destroy");
    super.destroy();
  }
}
