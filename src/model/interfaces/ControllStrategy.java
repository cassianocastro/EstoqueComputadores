package model.interfaces;
import java.sql.SQLException;
/**
 * @author cassiano
 */
public interface ControllStrategy {

    public void create() throws SQLException;

    public void read() throws SQLException;

    public void update() throws SQLException;

    public void delete() throws SQLException;

    public void search() throws SQLException;

    public boolean isValid(int ID) throws SQLException;
}
