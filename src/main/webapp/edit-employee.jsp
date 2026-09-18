<%@ page import="com.employee.model.Employee" %>

<%

    Employee employee =
            (Employee) request.getAttribute("employee");

%>

<!DOCTYPE html>

<html>

<head>

    <title>Edit Employee</title>

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

        <a href="employees">
            Employees
        </a>

    </div>

</div>

<div class="form-container">

    <h1>Edit Employee</h1>

    <form action="employees"
          method="post">

        <input type="hidden"
               name="action"
               value="update">

        <input type="hidden"
               name="id"
               value="<%= employee.getId() %>">

        <label>Full Name</label>

        <input type="text"
               name="name"
               value="<%= employee.getName() %>"
               required>

        <label>Email</label>

        <input type="email"
               name="email"
               value="<%= employee.getEmail() %>"
               required>

        <label>Phone</label>

        <input type="text"
               name="phone"
               value="<%= employee.getPhone() %>"
               required>

        <label>Department</label>

        <select name="department">

            <option>
                <%= employee.getDepartment() %>
            </option>

            <option>IT</option>
            <option>HR</option>
            <option>Finance</option>
            <option>Marketing</option>
            <option>Operations</option>
            <option>Sales</option>

        </select>

        <label>Designation</label>

        <input type="text"
               name="designation"
               value="<%= employee.getDesignation() %>"
               required>

        <label>Salary</label>

        <input type="number"
               name="salary"
               step="0.01"
               value="<%= employee.getSalary() %>"
               required>

        <label>Joining Date</label>

        <input type="date"
               name="joiningDate"
               value="<%= employee.getJoiningDate() %>"
               required>

        <button type="submit">
            Update Employee
        </button>

    </form>

</div>

</body>

</html>
