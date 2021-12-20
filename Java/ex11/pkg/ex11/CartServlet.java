package pkg.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        out.write("Hello World!");
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        doGet(request,response);
    }
}