package com.employee.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        if ("admin".equals(username)
                && "admin123".equals(password)) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "username",
                    username
            );

            response.sendRedirect("dashboard");

        } else {

            request.setAttribute(
                    "error",
                    "Invalid username or password"
            );

            request.getRequestDispatcher(
                    "login.jsp"
            ).forward(request, response);
        }
    }
}
