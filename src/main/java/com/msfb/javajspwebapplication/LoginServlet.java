package com.msfb.javajspwebapplication;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        if (userId.equals("admin") && password.equals("password")) {
            ServletContext session = req.getServletContext();
            session.setAttribute("userId", userId);

            resp.sendRedirect("welcome");
        } else {
            req.setAttribute("errorMessage", "Invalid user ID or password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
