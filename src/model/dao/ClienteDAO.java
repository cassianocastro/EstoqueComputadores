package model.dao;

import model.interfaces.PersonDAO;
import model.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cassiano
 */
public class ClienteDAO implements PersonDAO{
    private Connection connection;
    
    public void update(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Person person) throws SQLException {
        String SQL = "INSERT INTO clientes " +
                     "( nome, sexo, cpf, data_nasc ) " +
                     "VALUES " +
                     "( ?, ?, ?, ? )";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, person.getNome());
            statement.setString(2, person.getSexo());
            statement.setString(3, person.getCpf());
            statement.setDate  (4, new Date(person.getNascimento().getTime()));
            statement.executeUpdate();
        }
    }

    @Override
    public List read() throws SQLException {
        List<Client> list = new LinkedList<>();
        String SQL = "SELECT * FROM clientes";
        try( PreparedStatement statement = this.connection.prepareStatement(SQL);
             ResultSet rs = statement.executeQuery() )
        {
            while ( rs.next() ){
                int ID      = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf  = rs.getString("cpf");
                Sex sexo   = Sex.valueOf(
                              rs.getString("sexo"));
                java.util.
                Date data   = rs.getDate("data_nasc");
                list.add(new Client(ID, nome, cpf, sexo, data));
            }
            return list;
        }
    }

    @Override
    public void update(Person person) throws SQLException {
        Client cliente = ( Client ) person;
        String SQL = "UPDATE clientes SET " +
                     "nome = ?, " +
                     "sexo = ?, " +
                     "cpf = ?, " +
                     "data_nasc = ? " +
                     "WHERE id = ?";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getSexo());
            statement.setString(3, cliente.getCpf());
            statement.setDate  (4, new Date(cliente.getNascimento().getTime()));
            statement.setInt   (5, cliente.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(int ID) throws SQLException {
        String SQL = "DELETE FROM clientes WHERE id = ?";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, ID);
            statement.executeUpdate();
        }
    }

    @Override
    public Person findByID(int index) throws SQLException {
        String SQL = "SELECT * FROM clientes WHERE id = ?";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, index);
            try ( ResultSet rs = statement.executeQuery() ){
                while ( rs.next() ){
                    int ID      = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String cpf  = rs.getString("cpf");
                    Sex sexo   = Sex.valueOf(rs.getString("sexo"));
                    Date data   = rs.getDate("data_nasc");
                    return new Client(ID, nome, cpf, sexo, data);
                }
            }
        }
        return null;
    }

    @Override
    public boolean exists(int ID) throws SQLException {
        String SQL = "SELECT EXISTS( SELECT id FROM clientes WHERE id = ? ) as result";
        try( PreparedStatement statement = this.connection.prepareStatement(SQL) ){
            statement.setInt(1, ID);
            ResultSet rs = statement.executeQuery();
            if ( rs.next() ){
                return rs.getInt("result") == 1;
            }
        }
        return false;
    }
    
}
