package model.dao;

import model.*;
import java.sql.*;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class ClientDAO
{

    private final Connection connection;

    public ClientDAO(Connection connection)
    {
        this.connection = connection;
    }

    public void insert(Client client) throws SQLException
    {
        final String SQL = "INSERT INTO client(name, sex, cpf, birthDate) VALUES (?, ?, ?, ?)";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSex());
            statement.setString(3, client.getCPF());
            statement.setLong(4, client.getBirthDate().getTimeInMillis());

            statement.executeUpdate();
        }
    }

    public void update(Client client) throws SQLException
    {
        final String SQL = "UPDATE client SET name = ?, sex = ?, cpf = ?, birthDate = ? WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSex());
            statement.setString(3, client.getCPF());
            statement.setLong(4, client.getBirthDate().getTimeInMillis());
            statement.setString(5, client.getID().toString());

            statement.executeUpdate();
        }
    }

    public void delete(Client client) throws SQLException
    {
        final String SQL = "DELETE FROM client WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, client.getID().toString());

            statement.executeUpdate();
        }
    }

    public List<Client> getAll() throws SQLException
    {
        final String SQL = "SELECT PK_ID, name, cpf, sex, birthDate FROM client";

        try (var statement = this.connection.createStatement();
            var rs = statement.executeQuery(SQL))
        {
            List<Client> list = new LinkedList<>();

            while ( rs.next() )
            {
                String id     = rs.getString("PK_ID");
                String name   = rs.getString("name");
                String cpf    = rs.getString("cpf");
                Sex sex       = Sex.valueOf(rs.getString("sex"));
                Calendar date = Calendar.getInstance();

                date.setTimeInMillis(rs.getLong("birthDate"));

                list.add(new Client(Long.parseLong(id), name, cpf, sex, date));
            }

            return list;
        }
    }

    public Client findByID(Long id) throws SQLException
    {
        final String SQL = "SELECT name, cpf, sex, birthDate FROM client WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, id.toString());

            var rs = statement.executeQuery();

            if ( ! rs.next() )
            {
                throw new SQLException("Client not found!");
            }

            String name   = rs.getString("name");
            String cpf    = rs.getString("cpf");
            Sex sex       = Sex.valueOf(rs.getString("sex"));
            Calendar date = Calendar.getInstance();

            date.setTimeInMillis(rs.getLong("birthDate"));

            return new Client(id, name, cpf, sex, date);
        }
    }

    public boolean exists(Long id) throws SQLException
    {
        final String SQL = "SELECT exists(SELECT PK_ID FROM client WHERE PK_ID = ?) AS result";

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