package controll;

import java.sql.SQLException;
import model.interfaces.ControllStrategy;

/**
 *
 */
public class ControllerContext
{

    private ControllStrategy strategy;

    public void setStrategy(ControllStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void create() throws SQLException
    {
        this.strategy.create();
    }

    public void read() throws SQLException
    {
        this.strategy.read();
    }

    public void update() throws SQLException
    {
        this.strategy.update();
    }

    public void delete() throws SQLException
    {
        this.strategy.delete();
    }

    public void search() throws SQLException
    {
        this.strategy.search();
    }

    public void isValid(int ID) throws SQLException
    {
        this.strategy.isValid(ID);
    }

}
