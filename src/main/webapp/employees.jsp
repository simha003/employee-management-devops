<%@ page import="java.util.List" %>
<%@ page import="com.employee.model.Employee" %>

<%

    if (session.getAttribute("username") == null) {

        response.sendRedirect("login.jsp");

        return;
    }

    List<Employee> employees =
            (List<Employee>) request.getAttribute("employees");

%>

<!DOCTYPE html>

<html>

<head>

    <title>Employees</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="navbar">

    <div class="logo">
        Employee Management System
    </div>

    <div>

        <a href="dashboard">
            Dashboard
        </a>

        <a href="logout">
            Logout
        </a>

    </div>

</div>

<div class="container">

    <div class="page-header">

        <h1>Employees</h1>

        <a href="add-employee.jsp"
           class="add-button">
            + Add Employee
        </a>

    </div>

    <form action="employees"
          method="get"
          class="search-form">

        <input type="hidden"
               name="action"
               value="search">

        <input type="text"
               name="keyword"
               placeholder="Search by name, department or designation">

        <button type="submit">
            Search
        </button>

    </form>

    <div class="table-container">

        <table>

            <thead>

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Department</th>
                <th>Designation</th>
                <th>Salary</th>
                <th>Joining Date</th>
                <th>Actions</th>
            </tr>

            </thead>

            <tbody>

            <%

                if (employees != null) {

                    for (Employee employee : employees) {

            %>

            <tr>

                <td>
                    <%= employee.getId() %>
                </td>

                <td>
                    <%= employee.getName() %>
                </td>

                <td>
                    <%= employee.getEmail() %>
                </td>

                <td>
                    <%= employee.getPhone() %>
                </td>

                <td>
                    <%= employee.getDepartment() %>
                </td>

                <td>
                    <%= employee.getDesignation() %>
                </td>

                <td>
                    ₹<%= employee.getSalary() %>
                </td>

                <td>
                    <%= employee.getJoiningDate() %>
                </td>

                <td>

                    <a href="employees?action=edit&id=<%= employee.getId() %>"
                       class="edit">
                        Edit
                    </a>

                    <a href="employees?action=delete&id=<%= employee.getId() %>"
                       class="delete"
                       onclick="return confirmDelete()">
                        Delete
                    </a>

                </td>

            </tr>

            <%

                    }

                }

            %>

            </tbody>

        </table>

    </div>

</div>

<script src="js/script.js"></script>

</body>

</html>
