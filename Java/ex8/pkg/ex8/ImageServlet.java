package pkg.ex8;

import  java.io.*;
import java.util.Properties;

import  javax.imageio.ImageIO;
import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.awt.*;
import  java.awt.image.*;
public class ImageServlet extends HttpServlet{
    private Font font=new Font("Courier", Font.BOLD,12);  //字体
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
    public void doGet(HttpServletRequest request,HttpServletResponse response)
          throws ServletException,IOException{
	  
        String count=counter.toString();
        counter.setCount(Integer.parseInt(count) + 1);
        int len=count.length(); //
        response.setContentType("image/jpeg");
        ServletOutputStream  out=response.getOutputStream();
        BufferedImage  image=new  BufferedImage(11*len,16,BufferedImage.TYPE_INT_RGB);

        Graphics  g=image.getGraphics();
        g.setColor(Color.red);
        g.fillRect(0,0,11*len,16);  
        g.setColor(Color.white);//字体颜色
        g.setFont(font);
        for(int  i=0;i<len;i++)  {
            char c=count.charAt(i);
            g.drawString(c+"",i*11+1,12); //写一个白色的数字
            g.drawLine((i+1)*11-1,0,(i+1)*11-1,16); //画一个白色的竖线
        }
        ImageIO.write(image, "jpg", out);
        System.out.println(count);
        out.close();
  }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
          throws ServletException,IOException  {
        doGet(request,response);
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
              e.printStackTrace();
          }
      }
  }
}
