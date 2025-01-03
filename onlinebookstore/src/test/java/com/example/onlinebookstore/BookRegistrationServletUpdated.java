package com.example.onlinebookstore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/registerBookUpdated")
public class BookRegistrationServletUpdated extends HttpServlet {
    private DBConnectionManager dbManager;

    // Constructor for Spring IoC
    public BookRegistrationServletUpdated() {
        // Load Spring context from applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.dbManager = (DBConnectionManager) context.getBean("dbConnectionManager");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get book details from request
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        try (Connection connection = dbManager.openConnection()) {
            // Insert book details into the database BookstoreDB
            String sql = "INSERT INTO Books (title, author, price) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setDouble(3, price);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Respond with a success message
        PrintWriter out = response.getWriter();
        out.println("Book registered successfully hahahah!");
    }
}
