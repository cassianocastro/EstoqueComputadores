package model.dao;

import model.interfaces.PcDAO;
import model.Computer;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class ComputadorDAO implements PcDAO
{

    private Connection connection;

    public void update(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public void create(Computer computador) throws SQLException
    {
        String SQL = "INSERT INTO computadores "
            + "( marca, modelo, processador, ram, armazenamento, tipo, cor, tamanho_tela ) "
            + "VALUES "
            + "( ?, ?, ?, ?, ?, ?, ?, ? )";

        try (PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, computador.getMarca());
            statement.setString(2, computador.getModelo());
            statement.setString(3, computador.getProcessador());
            statement.setInt(4, computador.getRam());
            statement.setInt(5, computador.getArmazenamento());
            statement.setString(6, computador.getTipo());
            statement.setString(7, computador.getCor());
            statement.setFloat(8, computador.getTamanhoTela());
            statement.executeUpdate();
        }
    }

    @Override
    public List read() throws SQLException
    {
        List<Computer> list = new LinkedList<>();
        String SQL = "SELECT * FROM computadores";

        try (PreparedStatement statement = this.connection.prepareStatement(SQL);
            ResultSet rs = statement.executeQuery())
        {
            while ( rs.next() )
            {
                int ID = rs.getInt("id");
                int ram = rs.getInt("ram");
                int armzmnto = rs.getInt("armazenamento");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String processador = rs.getString("processador");
                String tipo = rs.getString("tipo");
                String cor = rs.getString("cor");
                float tamanhoTela = rs.getFloat("tamanho_tela");
                list.add(new Computer(
                    ID, ram, armzmnto, tamanhoTela, marca, modelo, processador, cor, tipo
                ));
            }
            return list;
        }
    }

    @Override
    public void update(Computer computador) throws SQLException
    {
        String SQL = "UPDATE computadores SET "
            + "marca = ?, "
            + "modelo = ?, "
            + "processador = ?, "
            + "ram = ?, "
            + "armazenamento = ?,"
            + "tipo = ?, "
            + "cor = ?, "
            + "tamanho_tela = ? "
            + "WHERE id = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, computador.getMarca());
            statement.setString(2, computador.getModelo());
            statement.setString(3, computador.getProcessador());
            statement.setInt(4, computador.getRam());
            statement.setInt(5, computador.getArmazenamento());
            statement.setString(6, computador.getTipo());
            statement.setString(7, computador.getCor());
            statement.setFloat(8, computador.getTamanhoTela());
            statement.setInt(9, computador.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(int ID) throws SQLException
    {
        String SQL = "DELETE FROM computadores WHERE id = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, ID);
            statement.executeUpdate();
        }
    }

    @Override
    public Computer findByID(int index) throws SQLException
    {
        String SQL = "SELECT * FROM computadores WHERE id = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, index);
            try (ResultSet rs = statement.executeQuery())
            {
                while ( rs.next() )
                {
                    int ID = rs.getInt("id");
                    int ram = rs.getInt("ram");
                    int armzmnto = rs.getInt("armazenamento");
                    String marca = rs.getString("marca");
                    String modelo = rs.getString("modelo");
                    String processador = rs.getString("processador");
                    String tipo = rs.getString("tipo");
                    String cor = rs.getString("cor");
                    float tamanhoTela = rs.getFloat("tamanho_tela");
                    return new Computer(
                        ID, ram, armzmnto, tamanhoTela, marca, modelo, processador, cor, tipo
                    );
                }
            }
        }
        return null;
    }

    @Override
    public boolean exists(int ID) throws SQLException
    {
        String SQL = "SELECT EXISTS( SELECT id FROM computadores WHERE id = ? ) AS result";

        try (PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, ID);
            try (ResultSet rs = statement.executeQuery())
            {
                if ( rs.next() )
                {
                    return rs.getInt("result") == 1;
                }
            }
        }
        return false;
    }
}
