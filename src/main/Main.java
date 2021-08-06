package main;

import controll.ControllerContext;
import java.sql.*;
import model.ConfigDataBase;
import model.dao.ConnectionSingleton;

/**
 * @author Cassiano
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConfigDataBase config = new ConfigDataBase(null);
        try (Connection connection = ConnectionSingleton.getInstance(config)) {
            
            new ControllerContext();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
