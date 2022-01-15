package pkg.ex10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InputNumberServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        Object totalCountObj = session.getAttribute("totalCount");
        String status = (String)session.getAttribute("status");
        if(status != null && status.strip() != ""){
            out.println(status+"<br>");
        }
        if(totalCountObj == null || totalCountObj.toString().equals("0")){
            //第一次访问
            session.setAttribute("totalCount", 0);
            int GUESS = Math.abs(new Random().nextInt())%100+1;
            session.setAttribute("GUESS", GUESS);
            System.out.println("第一次访问，设定GUESS="+GUESS);
        }
        Cookie cookie = new Cookie("GSESSIONID", session.getId());
        // cookie.setMaxAge(60*60*24);
        cookie.setPath("/ex8");
        response.addCookie(cookie);

        
        out.write("<!DOCTYPE html> "+
        "<html>"+
            "<head>"+
                "<title>GUESS</title>"+
                "<meta charset='UTF-8'/>"+
            "</head>"+
            "<body>"+
                "系统随机生成一个1到100之间的数<br>"+
                "请在下面的文本框中输入你猜的数<br>"+
                "<form method='post' action='/ex8/guess-servlet'>"+
                  "<input name='guessNumber'/>"+
                    "<input type='submit'/>"+
                "</form>"+
            "</body>"+
        "</html>");
        out.close();
    }  
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        doGet(request, response);
    }
        
}
