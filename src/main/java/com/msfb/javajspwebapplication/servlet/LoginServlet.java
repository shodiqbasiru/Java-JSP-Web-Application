package com.msfb.javajspwebapplication.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> users = Map.of(
                "admin", "password",
                "user1", "password",
                "user2", "password",
                "user3", "password",
                "user4", "password",
                "user5", "password"
        );

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        if (users.containsKey(userId) && users.get(userId).equals(password)) {
            ServletContext session = req.getServletContext();
            session.setAttribute("userId", userId);

            resp.sendRedirect("welcome");
        } else {
            req.setAttribute("errorMessage", "Invalid user ID or password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }


}
