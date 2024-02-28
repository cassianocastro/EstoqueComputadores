package main;

import java.sql.Connection;
import java.sql.SQLException;
import model.DBConfig;
import model.dao.ConnectionFactory;

/**
 *
 */
public class App
{

    public void start()
    {
        DBConfig config = new DBConfig(null);

        try (Connection connection = new ConnectionFactory().getConnection(config))
        {

        }
        catch ( SQLException e )
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}