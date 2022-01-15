package oct.rekord.struts2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

public class TestServletAwareAction implements ServletRequestAware, ServletContextAware {

    public String execute() {

        System.out.println("execute...");

        return "success";
    }



    public void setServletRequest(HttpServletRequest request) {
        System.out.println(request);
    }

    public void setServletContext(ServletContext servletContext) {
        System.out.println(servletContext);
    }
}