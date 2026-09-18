CREATE DATABASE IF NOT EXISTS employee_db;

USE employee_db;

CREATE TABLE IF NOT EXISTS employees (

    id INT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    email VARCHAR(150) NOT NULL UNIQUE,

    phone VARCHAR(20) NOT NULL,

    department VARCHAR(100) NOT NULL,

    designation VARCHAR(100) NOT NULL,

    salary DECIMAL(12,2) NOT NULL,

    joining_date DATE NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

INSERT INTO employees
(name, email, phone, department, designation, salary, joining_date)
VALUES
(
    'Rahul Kumar',
    'rahul@example.com',
    '9876543210',
    'IT',
    'Software Engineer',
    55000,
    '2024-01-15'
);

INSERT INTO employees
(name, email, phone, department, designation, salary, joining_date)
VALUES
(
    'Priya Sharma',
    'priya@example.com',
    '9876543211',
    'HR',
    'HR Executive',
    45000,
    '2023-08-20'
);

INSERT INTO employees
(name, email, phone, department, designation, salary, joining_date)
VALUES
(
    'Arjun Reddy',
    'arjun@example.com',
    '9876543212',
    'Finance',
    'Financial Analyst',
    60000,
    '2022-06-10'
);

INSERT INTO employees
(name, email, phone, department, designation, salary, joining_date)
VALUES
(
    'Sneha Rao',
    'sneha@example.com',
    '9876543213',
    'Marketing',
    'Marketing Manager',
    65000,
    '2021-11-05'
);

INSERT INTO employees
(name, email, phone, department, designation, salary, joining_date)
VALUES
(
    'Vikram Singh',
    'vikram@example.com',
    '9876543214',
    'Operations',
    'Operations Executive',
    48000,
    '2023-03-18'
);
