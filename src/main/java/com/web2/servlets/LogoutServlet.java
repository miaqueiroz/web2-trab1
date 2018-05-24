package com.web2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/Logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        session.invalidate();

        request.getRequestDispatcher("login.jsp").include(request, response);

    } 
}
