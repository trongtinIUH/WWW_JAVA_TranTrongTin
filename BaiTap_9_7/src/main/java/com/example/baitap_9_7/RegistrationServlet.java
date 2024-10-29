package com.example.baitap_9_7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegistrationForm", value = "/RegistrationForm")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/baitap4";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "sapassword";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private boolean kiemtraUsername(Connection connection, String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            return statement.executeQuery().next();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String facebook = request.getParameter("facebook");
        String bio = request.getParameter("bio");
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("Error: Unable to load MariaDB driver.");
            return;
        }

        try(Connection connection= DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            if(kiemtraUsername(connection, username)){
                out.println("Username đã tồn tại ! Vui lòng nhập username khác");
                return;
            }

        String sql="INSERT INTO users (first_name, last_name, username, password, email, facebook, bio) VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            statement.setString(3,username);
            statement.setString(4,password);
            statement.setString(5,email);
            statement.setString(6,facebook);
            statement.setString(7,bio);
            statement.executeUpdate();
        }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: Unable to save data.");
            return;
        }


        String html = "<html>" +
                "<head><title>Result Page</title></head>" +
                "<body>" +
                "First Name: " + firstName + "<br>" +
                "Last Name: " + lastName + "<br>" +
                "Username: " + username + "<br>" +
                "Password: " + password + "<br>" +
                "Email: " + email + "<br>" +
                "Facebook URL: " + facebook + "<br>" +
                "Short Bio: " + bio + "<br>" +
                "</body>" +
                "</html>";

        out.println(html);
    }
}