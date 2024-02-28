package model.dao;

import model.DBConfig;
import java.sql.*;

/**
 *
 */
public class ConnectionFactory
{

    private Connection connection;

    public Connection getConnection(DBConfig config) throws SQLException
    {
        if ( this.connection == null )
        {
            this.connection = DriverManager.getConnection(
                config.getDSN(),
                config.getUser(),
                config.getPassword()
            );
        }

        return this.connection;
    }
}