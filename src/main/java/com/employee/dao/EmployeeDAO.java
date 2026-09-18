package com.employee.dao;

import com.employee.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public boolean addEmployee(Employee employee) {

        String sql =
                "INSERT INTO employees " +
                "(name,email,phone,department,designation,salary,joining_date) " +
                "VALUES (?,?,?,?,?,?,?)";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getDepartment());
            statement.setString(5, employee.getDesignation());
            statement.setDouble(6, employee.getSalary());
            statement.setString(7, employee.getJoiningDate());

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees ORDER BY id DESC";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet result =
                        statement.executeQuery()
        ) {

            while (result.next()) {

                Employee employee = new Employee();

                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setEmail(result.getString("email"));
                employee.setPhone(result.getString("phone"));
                employee.setDepartment(result.getString("department"));
                employee.setDesignation(result.getString("designation"));
                employee.setSalary(result.getDouble("salary"));
                employee.setJoiningDate(result.getString("joining_date"));

                employees.add(employee);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return employees;
    }

    public Employee getEmployeeById(int id) {

        String sql =
                "SELECT * FROM employees WHERE id=?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            ResultSet result =
                    statement.executeQuery();

            if (result.next()) {

                return new Employee(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("phone"),
                        result.getString("department"),
                        result.getString("designation"),
                        result.getDouble("salary"),
                        result.getString("joining_date")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public boolean updateEmployee(Employee employee) {

        String sql =
                "UPDATE employees SET " +
                "name=?, email=?, phone=?, department=?, " +
                "designation=?, salary=?, joining_date=? " +
                "WHERE id=?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPhone());
            statement.setString(4, employee.getDepartment());
            statement.setString(5, employee.getDesignation());
            statement.setDouble(6, employee.getSalary());
            statement.setString(7, employee.getJoiningDate());
            statement.setInt(8, employee.getId());

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteEmployee(int id) {

        String sql =
                "DELETE FROM employees WHERE id=?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public List<Employee> searchEmployees(String keyword) {

        List<Employee> employees = new ArrayList<>();

        String sql =
                "SELECT * FROM employees " +
                "WHERE name LIKE ? " +
                "OR department LIKE ? " +
                "OR designation LIKE ? " +
                "ORDER BY id DESC";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            String search = "%" + keyword + "%";

            statement.setString(1, search);
            statement.setString(2, search);
            statement.setString(3, search);

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                employees.add(
                        new Employee(
                                result.getInt("id"),
                                result.getString("name"),
                                result.getString("email"),
                                result.getString("phone"),
                                result.getString("department"),
                                result.getString("designation"),
                                result.getDouble("salary"),
                                result.getString("joining_date")
                        )
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return employees;
    }
}
