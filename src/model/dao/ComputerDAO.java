package model.dao;

import model.Computer;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class ComputerDAO
{

    private final Connection connection;

    public ComputerDAO(Connection connection)
    {
        this.connection = connection;
    }

    public void insert(Computer computer) throws SQLException
    {
        final String SQL = "INSERT INTO computer(mark, model, processor, ram, storage, type, color, screenSize) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, computer.getMark());
            statement.setString(2, computer.getModel());
            statement.setString(3, computer.getProcessor());
            statement.setInt(4, computer.getRAM());
            statement.setInt(5, computer.getStorage());
            statement.setString(6, computer.getType());
            statement.setString(7, computer.getColor());
            statement.setFloat(8, computer.getScreenSize());

            statement.executeUpdate();
        }
    }

    public void update(Computer computer) throws SQLException
    {
        final String SQL = "UPDATE computer SET mark = ?, model = ?, processor = ?, "
            + "ram = ?, storage = ?, type = ?, color = ?, screenSize = ? WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, computer.getMark());
            statement.setString(2, computer.getModel());
            statement.setString(3, computer.getProcessor());
            statement.setInt(4, computer.getRAM());
            statement.setInt(5, computer.getStorage());
            statement.setString(6, computer.getType());
            statement.setString(7, computer.getColor());
            statement.setFloat(8, computer.getScreenSize());
            statement.setString(9, computer.getID().toString());

            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException
    {
        final String SQL = "DELETE FROM computer WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, id);

            statement.executeUpdate();
        }
    }

    public List<Computer> getAll() throws SQLException
    {
        final String SQL = "SELECT PK_ID, ram, storage, mark, model, processor,type, color, screenSize FROM computer";

        try (var statement = this.connection.createStatement();
            var rs = statement.executeQuery(SQL))
        {
            List<Computer> list = new LinkedList<>();

            while ( rs.next() )
            {
                long id          = rs.getInt("PK_ID");
                int ram          = rs.getInt("ram");
                int storage      = rs.getInt("storage");
                String mark      = rs.getString("mark");
                String model     = rs.getString("model");
                String processor = rs.getString("processor");
                String type      = rs.getString("type");
                String color     = rs.getString("color");
                float screenSize = rs.getFloat("screenSize");

                list.add(new Computer(id, ram, storage, screenSize, mark, model, processor, color, type));
            }

            return list;
        }
    }

    public Computer findByID(Long id) throws SQLException
    {
        final String SQL = "SELECT ram, storage, mark, model, processor,type, color, screenSize FROM computer WHERE PK_ID = ?";

        try (var statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, id.toString());

            var rs = statement.executeQuery();

            if ( ! rs.next() )
            {
                throw new SQLException("Computer not found!");
            }

            int ram          = rs.getInt("ram");
            int storage      = rs.getInt("storage");
            String mark      = rs.getString("mark");
            String model     = rs.getString("model");
            String processor = rs.getString("processor");
            String type      = rs.getString("type");
            String color     = rs.getString("color");
            float screenSize = rs.getFloat("screenSize");

            return new Computer(id, ram, storage, screenSize, mark, model, processor, color, type);
        }
    }

    public boolean exists(Long id) throws SQLException
    {
        final String SQL = "SELECT exists(SELECT id FROM computadores WHERE id = ?) AS result";

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