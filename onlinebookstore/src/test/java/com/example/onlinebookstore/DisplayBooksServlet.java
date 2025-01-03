package com.example.onlinebookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayBooks")
public class DisplayBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Books List</h2><table border='1'><tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th></tr>");

        try (Connection connection = new DBConnectionManager().openConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Books");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>" + rs.getString("title") + "</td><td>" + rs.getString("author") + "</td><td>" + rs.getDouble("price") + "</td></tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("</table></body></html>");
    }
}
