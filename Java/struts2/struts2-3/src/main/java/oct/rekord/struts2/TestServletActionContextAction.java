package oct.rekord.struts2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

public class TestServletActionContextAction {
    
    public String execute(){
        
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = ServletActionContext.getRequest().getSession();
        ServletContext servletContext = ServletActionContext.getServletContext();
        
        System.out.println("execute...");

        return "success";
    }
    
    public String save(){
        
        return null;
    }

}