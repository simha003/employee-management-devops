<!DOCTYPE html>

<html>

<head>

    <title>Add Employee</title>

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

    <h1>Add New Employee</h1>

    <form action="employees"
          method="post">

        <input type="hidden"
               name="action"
               value="add">

        <label>Full Name</label>

        <input type="text"
               name="name"
               required>

        <label>Email</label>

        <input type="email"
               name="email"
               required>

        <label>Phone</label>

        <input type="text"
               name="phone"
               required>

        <label>Department</label>

        <select name="department" required>

            <option value="">
                Select Department
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
               required>

        <label>Salary</label>

        <input type="number"
               name="salary"
               step="0.01"
               required>

        <label>Joining Date</label>

        <input type="date"
               name="joiningDate"
               required>

        <button type="submit">
            Add Employee
        </button>

    </form>

</div>

</body>

</html>
