package ex8;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

public class CounterServlet extends HttpServlet {
    private Counter counter = new Counter();
    private Properties properties = new Properties();

    public void init(){
        ServletContext servletContext = this.getServletContext();
        InputStream is = servletContext.getResourceAsStream("/WEB-INF/classes/count.properties");
        try {
            properties.load(is);
            counter.setCount(Integer.parseInt(properties.getProperty("visit_count")));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("enter the init method");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        counter.add();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1 align='center'>visit_count</h1>");
        out.println("<h1 align='center'>" + counter.toString() + "</h1>");
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {

    }
    public void destroy() {
        storeCount(counter.toString());
        System.out.println("enter the destroy method");
    }

    public void storeCount(String count){
        ServletContext servletContext = this.getServletContext();
        String path = servletContext.getRealPath("/WEB-INF/classes/count.properties");
        System.out.println(path);
        OutputStream os = null;
        try{
            os = new FileOutputStream(path);
            System.out.println(count);
            properties.setProperty("visit_count", count);
            properties.store(os,"deploy server!");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

