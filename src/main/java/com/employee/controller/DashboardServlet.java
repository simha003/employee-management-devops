package com.employee.controller;

import com.employee.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;

    @Override
    public void init() {

        employeeDAO = new EmployeeDAO();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null ||
                session.getAttribute("username") == null) {

            response.sendRedirect("login.jsp");

            return;
        }

        int totalEmployees =
                employeeDAO.getAllEmployees().size();

        request.setAttribute(
                "totalEmployees",
                totalEmployees
        );

        request.getRequestDispatcher(
                "dashboard.jsp"
        ).forward(request, response);
    }
}
