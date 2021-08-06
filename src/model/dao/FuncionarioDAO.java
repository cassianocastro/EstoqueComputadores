package model.dao;

import model.interfaces.PersonDAO;
import model.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author User
 */
public class FuncionarioDAO implements PersonDAO{
    
    private Connection connection;
    
    public void update(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public void create(Person person) throws SQLException {
        String SQL = "INSERT INTO funcionarios " +
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
        List<Funcionario> list = new LinkedList<>();
        String SQL = "SELECT * FROM funcionarios";
        try( PreparedStatement statement = this.connection.prepareStatement(SQL);
             ResultSet rs = statement.executeQuery() )
        {
            while ( rs.next() ){
                int ID      = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String cpf  = rs.getString("cpf");
                Sex sexo    = Sex.valueOf(
                              rs.getString("sexo"));
                java.util.
                Date data   = rs.getDate("data_nasc");
                list.add(new Funcionario(ID, nome, cpf, sexo, data));
            }
            return list;
        }
    }

    @Override
    public void update(Person person) throws SQLException {
        Funcionario funcionario = ( Funcionario ) person;
        String SQL = "UPDATE funcionarios SET " +
                     "nome = ?, " +
                     "sexo = ?, " +
                     "cpf = ?, " +
                     "data_nasc = ? " +
                     "WHERE codigo = ?";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getSexo());
            statement.setString(3, funcionario.getCpf());
            statement.setDate  (4, new Date(funcionario.getNascimento().getTime()));
            statement.setInt   (5, funcionario.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(int ID) throws SQLException {
        String SQL = "DELETE FROM funcionarios WHERE codigo = ?";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, ID);
            statement.executeUpdate();
        }
    }
    
    @Override
    public Person findByID(int index) throws SQLException{
        String SQL = "SELECT * FROM funcionarios WHERE codigo = ?";
        try(PreparedStatement statement = this.connection.prepareStatement(SQL))
        {
            statement.setInt(1, index);
            try ( ResultSet rs = statement.executeQuery() ){
                if ( rs.next() ){
                    int ID      = rs.getInt("codigo");
                    String nome = rs.getString("nome");
                    String cpf  = rs.getString("cpf");
                    Sex sexo   = Sex.valueOf(rs.getString("sexo"));
                    Date data   = rs.getDate("data_nasc");
                    return new Funcionario(ID, nome, cpf, sexo, data);
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean exists(int ID) throws SQLException{
        String SQL = "SELECT EXISTS( SELECT codigo FROM funcionarios WHERE codigo = ? ) as result";
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
