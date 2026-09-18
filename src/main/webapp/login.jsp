<!DOCTYPE html>
<html>

<head>

    <title>Employee Management System</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="login-container">

    <div class="login-card">

        <h1>Employee Management</h1>

        <p class="subtitle">
            Admin Login
        </p>

        <% if (request.getAttribute("error") != null) { %>

            <div class="error">
                <%= request.getAttribute("error") %>
            </div>

        <% } %>

        <form action="login" method="post">

            <label>Username</label>

            <input type="text"
                   name="username"
                   placeholder="Enter username"
                   required>

            <label>Password</label>

            <input type="password"
                   name="password"
                   placeholder="Enter password"
                   required>

            <button type="submit">
                Login
            </button>

        </form>

        <p class="login-info">
            Demo Login: admin / admin123
        </p>

    </div>

</div>

</body>

</html>
