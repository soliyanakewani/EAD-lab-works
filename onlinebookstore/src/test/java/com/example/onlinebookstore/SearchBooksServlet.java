package com.example.onlinebookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchBooks")
public class SearchBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection connection = new DBConnectionManager().openConnection()) {
            String sql = "SELECT * FROM Books WHERE title LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();

            out.println("<html><body><h2>Search Results</h2><table border='1'>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>" + rs.getString("title") + "</td><td>" + rs.getString("author") + "</td><td>" + rs.getDouble("price") + "</td></tr>");
            }
            out.println("</table></body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

