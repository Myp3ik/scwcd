package lv.murza.scwcd.application.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.write("<html><head></head><body><form method='post'><input type='submit' value='gfdgdfgdfg'/></form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.write("<html><head></head><body><form method='post'><input type='submit' value='654'/></form></body></html>");
        
        Cookie cookie = new Cookie("POST_1", "simpleCookie");
        resp.addCookie(cookie);   
        
        cookie = new Cookie("POST_2", "httpOblyCookie");
        cookie.setHttpOnly(true);
        resp.addCookie(cookie);
        
        cookie = new Cookie("POST_3", "secureCookie");
        cookie.setSecure(true);
        resp.addCookie(cookie);
                
        req.getSession(true);
    }
}