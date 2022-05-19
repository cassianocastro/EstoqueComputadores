package model.interfaces;

import model.Person;
import java.sql.*;

/**
 *
 */
public interface PersonDAO extends Dao
{

    public void create(Person person) throws SQLException;

    public void update(Person person) throws SQLException;

    public Person findByID(int index) throws SQLException;

}
