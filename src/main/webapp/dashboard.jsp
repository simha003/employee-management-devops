<%

    if (session.getAttribute("username") == null) {

        response.sendRedirect("login.jsp");

        return;
    }

%>

<!DOCTYPE html>
<html>

<head>

    <title>Dashboard</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="navbar">

    <div class="logo">
        Employee Management System
    </div>

    <div>

        <span>
            Welcome, <%= session.getAttribute("username") %>
        </span>

        <a href="logout">
            Logout
        </a>

    </div>

</div>

<div class="container">

    <h1>Dashboard</h1>

    <div class="cards">

        <div class="card">

            <h3>Total Employees</h3>

            <p>
                <%= request.getAttribute("totalEmployees") %>
            </p>

        </div>

        <div class="card">

            <h3>Departments</h3>

            <p>6</p>

        </div>

        <div class="card">

            <h3>System Status</h3>

            <p>Active</p>

        </div>

    </div>

    <div class="menu">

        <a href="employees"
           class="menu-button">
            Manage Employees
        </a>

        <a href="add-employee.jsp"
           class="menu-button">
            Add Employee
        </a>

    </div>

</div>

</body>

</html>
