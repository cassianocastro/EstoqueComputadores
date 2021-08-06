package model.interfaces;

import model.interfaces.Dao;
import model.Person;
import java.sql.*;

/**
 *
 * @author cassiano
 */
public interface PersonDAO extends Dao{
    
    public void create(Person person) throws SQLException;

    public void update(Person person) throws SQLException;
    
    public Person findByID(int index) throws SQLException;
    
}
