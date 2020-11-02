import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 被转发的servlet
 *
 * @author Sparrow
 * @version 1.0
 * @date 2019/7/30 15:33
 * @since JDK 1.8
 *     <p>Copyright (c) 2019, Sparrow All Rights Reserved.
 */
@WebServlet(name = "DispatcheredServlet", urlPatterns = "/DispatcheredServlet")
public class DIspatcheredServlet extends GenericServlet {
  @Override
  public void destroy() {
    super.destroy();
    System.out.println("DispatcheredServlet destroy");
  }

  @Override
  public void init() throws ServletException {
    super.init();
    System.out.println("DispatcheredServlet init");
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    String dispatcher = (String) servletRequest.getAttribute("dispatcher");
    System.out.println("dispatcher from :" + dispatcher);
  }
}
