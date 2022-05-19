package model.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 */
public interface Dao
{

    public List read() throws SQLException;

    public void delete(int ID) throws SQLException;

    public boolean exists(int ID) throws SQLException;
    
}
