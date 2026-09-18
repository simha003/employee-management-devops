package com.employee.controller;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

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

        String action = request.getParameter("action");

        if (action == null) {

            listEmployees(request, response);

        } else if (action.equals("delete")) {

            deleteEmployee(request, response);

        } else if (action.equals("edit")) {

            showEditForm(request, response);

        } else if (action.equals("search")) {

            searchEmployees(request, response);

        } else {

            listEmployees(request, response);
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {

            addEmployee(request, response);

        } else if ("update".equals(action)) {

            updateEmployee(request, response);

        } else {

            listEmployees(request, response);
        }
    }

    private void listEmployees(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employees =
                employeeDAO.getAllEmployees();

        request.setAttribute("employees", employees);

        request.getRequestDispatcher(
                "employees.jsp"
        ).forward(request, response);
    }

    private void addEmployee(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Employee employee = new Employee();

        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setPhone(request.getParameter("phone"));
        employee.setDepartment(request.getParameter("department"));
        employee.setDesignation(request.getParameter("designation"));

        employee.setSalary(
                Double.parseDouble(
                        request.getParameter("salary")
                )
        );

        employee.setJoiningDate(
                request.getParameter("joiningDate")
        );

        employeeDAO.addEmployee(employee);

        response.sendRedirect("employees");
    }

    private void updateEmployee(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Employee employee = new Employee();

        employee.setId(
                Integer.parseInt(
                        request.getParameter("id")
                )
        );

        employee.setName(request.getParameter("name"));
        employee.setEmail(request.getParameter("email"));
        employee.setPhone(request.getParameter("phone"));
        employee.setDepartment(request.getParameter("department"));
        employee.setDesignation(request.getParameter("designation"));

        employee.setSalary(
                Double.parseDouble(
                        request.getParameter("salary")
                )
        );

        employee.setJoiningDate(
                request.getParameter("joiningDate")
        );

        employeeDAO.updateEmployee(employee);

        response.sendRedirect("employees");
    }

    private void deleteEmployee(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id =
                Integer.parseInt(
                        request.getParameter("id")
                );

        employeeDAO.deleteEmployee(id);

        response.sendRedirect("employees");
    }

    private void showEditForm(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id =
                Integer.parseInt(
                        request.getParameter("id")
                );

        Employee employee =
                employeeDAO.getEmployeeById(id);

        request.setAttribute(
                "employee",
                employee
        );

        request.getRequestDispatcher(
                "edit-employee.jsp"
        ).forward(request, response);
    }

    private void searchEmployees(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String keyword =
                request.getParameter("keyword");

        List<Employee> employees =
                employeeDAO.searchEmployees(keyword);

        request.setAttribute(
                "employees",
                employees
        );

        request.getRequestDispatcher(
                "employees.jsp"
        ).forward(request, response);
    }
}
