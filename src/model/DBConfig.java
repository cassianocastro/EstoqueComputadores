package model;

import java.io.Serializable;
import org.json.JSONObject;

/**
 *
 */
final public class DBConfig implements Serializable
{

    private final int port;
    private final String host, driver, database, user, password;

    public DBConfig(int port, String host, String driver, String database, String user, String password)
    {
        this.port     = port;
        this.host     = host;
        this.driver   = driver;
        this.database = database;
        this.user     = user;
        this.password = password;
    }

    public DBConfig(JSONObject json)
    {
        this.port     = json.getInt("port");
        this.host     = json.getString("host");
        this.driver   = json.getString("driver");
        this.database = json.getString("database");
        this.user     = json.getString("user");
        this.password = json.getString("password");
    }

    public JSONObject toJSON()
    {
        JSONObject json = new JSONObject();

        json.put("host", this.host);
        json.put("port", this.port);
        json.put("driver", this.driver);
        json.put("database", this.database);
        json.put("user", this.user);
        json.put("password", this.password);

        return json;
    }

    public String getUser()
    {
        return this.user;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getDSN()
    {
        return String.format(
            "jdbc:%s://%s:%d/%s", this.driver, this.host, this.port, this.database
        );
    }
}