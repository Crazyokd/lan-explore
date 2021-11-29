package hello;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
        for(int i=0;i<10;i++)
            System.out.println("init:Hello World!");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String c=request.getParameter("color");
        BeerExpert t=new BeerExpert();
        List<String> result = t.getBrands(c);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Beer Selection Advice<br>");
        Iterator<String> it= result.iterator();
        while(it.hasNext()){
            out.print("<br>try:"+it.next());
        }
    }
    public void destroy() {
    }
}

