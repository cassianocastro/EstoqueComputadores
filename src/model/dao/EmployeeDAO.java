package model.dao;

import model.*;
import java.sql.*;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class EmployeeDAO
{

    private final Connection connection;

    public EmployeeDAO(Connection connection)
    {
        this.connection = connection;
    }

    public void insert(Employee employee) throws SQLException
    {
        final String SQL = "INSERT INTO employee(name, sex, cpf, birthDate) VALUES (?, ?, ?, ?)";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSex());
            statement.setString(3, employee.getCPF());
            statement.setLong(4, employee.getBirthDate().getTimeInMillis());

            statement.executeUpdate();
        }
    }

    public void update(Employee employee) throws SQLException
    {
        final String SQL = "UPDATE employee SET name = ?, sex = ?, cpf = ?, birthDate = ? WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSex());
            statement.setString(3, employee.getCPF());
            statement.setLong(4, employee.getBirthDate().getTimeInMillis());
            statement.setString(5, employee.getID().toString());

            statement.executeUpdate();
        }
    }

    public void delete(Employee employee) throws SQLException
    {
        final String SQL = "DELETE FROM employee WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, employee.getID().toString());

            statement.executeUpdate();
        }
    }

    public List<Employee> getAll() throws SQLException
    {
        final String SQL = "SELECT PK_ID, name, cpf, sex, birthDate FROM employee";

        try (var statement = this.connection.createStatement();
            var rs = statement.executeQuery(SQL))
        {
            List<Employee> list = new LinkedList<>();

            while ( rs.next() )
            {
                String id     = rs.getString("PK_ID");
                String name   = rs.getString("name");
                String cpf    = rs.getString("cpf");
                Sex sex       = Sex.valueOf(rs.getString("sex"));
                Calendar date = Calendar.getInstance();

                date.setTimeInMillis(rs.getLong("birthDate"));

                list.add(new Employee(Long.parseLong(id), name, cpf, sex, date));
            }

            return list;
        }
    }

    public Employee findByID(Long id) throws SQLException
    {
        final String SQL = "SELECT name, cpf, sex, birthDate FROM employee WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, id.toString());

            var rs = statement.executeQuery();

            if ( ! rs.next() )
            {
                throw new SQLException("Employee not found!");
            }

            String name   = rs.getString("name");
            String cpf    = rs.getString("cpf");
            Sex sex       = Sex.valueOf(rs.getString("sex"));
            Calendar date = Calendar.getInstance();

            date.setTimeInMillis(rs.getLong("birthDate"));

            return new Employee(id, name, cpf, sex, date);
        }
    }

    public boolean exists(Long id) throws SQLException
    {
        final String SQL = "SELECT exists(SELECT PK_ID FROM employee WHERE PK_ID = ?) AS result";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, id.toString());

            var rs = statement.executeQuery();

            if ( rs.next() )
            {
                return rs.getInt("result") == 1;
            }

            return false;
        }
    }
}