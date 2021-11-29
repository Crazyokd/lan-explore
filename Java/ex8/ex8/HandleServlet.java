package ex8;

import java.io.*;
import java.net.PasswordAuthentication;

import javax.servlet.ServletConfig;
import javax.servlet.http.*;

public class HandleServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
        System.out.println("enter HandleServlet init method");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // request.getParameter("")
        
        // response.setContentType("text/html");
        // // Hello
        // PrintWriter out = response.getWriter();
        // out.println("<html><body>");
        // out.println("<h1>" + message + "</h1>");
        // out.println("<h1>" + message + "</h1>");
        // out.println("</body></html>");
    }
    public void loginSuccess(){

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ServletConfig config = this.getServletConfig();
        String username = request.getParameter("username");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(config.getInitParameter(username)==null){
            out.println("Username is not available");
        }else{
            String password = request.getParameter("password");
            if(password.equals(getInitParameter(username))){
                out.println("Welcome "+username);
            }else{
                out.println("Password is incorrect");
            }
        }
        out.close();
    }
    public void destroy() {
        System.out.println("enter HandleServlet destroy method");
    }
}

