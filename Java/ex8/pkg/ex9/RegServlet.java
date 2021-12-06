package pkg.ex9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.write("hello");
        out.close();
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //
        response.setContentType("text/html;charset=utf-8");
        ServletConfig config = this.getServletConfig();
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        
        
        PrintWriter out = response.getWriter();
        
        if(config.getInitParameter(username)==null){
            loginFail(request, response, out);
        }else{
            String password = request.getParameter("password");
            if(password.equals(getInitParameter(username))){
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ls-servlet");
                request.setAttribute("username", username);
                rd.forward(request, response);
            }else{
                loginFail(request,response,out);
            }
        }
        out.close();
    }
    public void loginFail(HttpServletRequest request,HttpServletResponse response,PrintWriter out){
        out.print("登录失败，请重新登录......");
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/login.jsp");
        try {
            rd.include(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
