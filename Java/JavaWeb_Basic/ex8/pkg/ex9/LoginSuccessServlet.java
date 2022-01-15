package pkg.ex9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSuccessServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        out.print("欢迎"+request.getAttribute("username")+"!,系统登录成功!");
        out.close();
    }
}
