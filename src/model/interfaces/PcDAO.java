package model.interfaces;

import model.Computer;
import java.sql.*;

/**
 *
 */
public interface PcDAO extends Dao
{

    public void create(Computer computador) throws SQLException;

    public void update(Computer computador) throws SQLException;

    public Computer findByID(int ID) throws SQLException;
    
}
