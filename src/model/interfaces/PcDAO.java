package model.interfaces;

import model.interfaces.Dao;
import model.Computer;
import java.sql.*;

/**
 *
 * @author cassiano
 */
public interface PcDAO extends Dao{
    public void create(Computer computador) throws SQLException;

    public void update(Computer computador) throws SQLException;
    
    public Computer findByID(int ID) throws SQLException;
}
