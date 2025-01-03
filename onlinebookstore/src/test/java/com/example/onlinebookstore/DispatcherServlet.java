package com.example.onlinebookstore;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/registerBook":
                new BookRegistrationServletUpdated().doPost(request, response);
                break;
            case "/displayBooks":
                new DisplayBooksServlet().doGet(request, response);
                break;
            case "/deleteBook":
                new DeleteBookServlet().doPost(request, response);
                break;
            default:
                response.getWriter().println("please input a valid Request!");
        }
    }
}
