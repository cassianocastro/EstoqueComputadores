package controller;

import java.sql.SQLException;
import model.*;
import model.dao.ComputerDAO;
import view.*;

/**
 *
 */
public class ComputersController
{

    private final ComputerDAO computerDAO;
    private final View computerView;

    public ComputersController(ComputerDAO dao)
    {
        this.computerDAO  = dao;
        this.computerView = new ComputerView();
    }

    public void create() throws SQLException
    {
        String[] data = this.computerView.insert();

        if ( data == null ) return;

        String mark      = data[0];
        String model     = data[1];
        String processor = data[2];
        String type      = data[3];
        String color     = data[4];
        int ram          = Integer.parseInt(data[5]);
        int storage      = Integer.parseInt(data[6]);
        float screenSize = Float.parseFloat(data[7]);

        this.computerDAO.insert(new Computer(
            0L, ram, storage, screenSize, mark, model, processor, color, type
        ));

        this.computerView.show("Computador cadastrado.");
    }

    public void read() throws SQLException
    {
        this.computerView.show(this.computerDAO.getAll().toString());
    }

    public void update() throws SQLException
    {
        long id = Integer.parseUnsignedInt(this.computerView.getID());

        if ( ! this.isValid(id) )
        {
            this.computerView.show("Computador não encontrado.");

            return;
        }

        Computer computer = this.computerDAO.findByID(id);
        String[] data     = this.computerView.update();

        switch ( data[0] )
        {
            case "Marca":
                computer.setMark(data[1]);
                break;
            case "Modelo":
                computer.setModel(data[1]);
                break;
            case "Processador":
                computer.setProcessor(data[1]);
                break;
            case "Tipo":
                computer.setType(data[1]);
                break;
            case "Cor":
                computer.setColor(data[1]);
                break;
            case "RAM":
                computer.setRAM(Integer.parseInt(data[1]));
                break;
            case "Armazenamento":
                computer.setStorage(Integer.parseInt(data[1]));
                break;
            default:
                computer.setScreenSize(Float.parseFloat(data[1]));
        }

        this.computerDAO.update(computer);
        this.computerView.show("Registro atualizado.");
    }

    public void delete() throws SQLException
    {
        int id = Integer.parseUnsignedInt(this.computerView.getID());

        if ( this.isValid(id) )
        {
            this.computerDAO.delete(id);
            this.computerView.show("Computador excluído.");

            return;
        }

        this.computerView.show("Computador não encontrado.");
    }

    public void search() throws SQLException
    {
        long id = Integer.parseUnsignedInt(this.computerView.getID());

        if ( this.isValid(id) )
        {
            Computer computer = this.computerDAO.findByID(id);

            this.computerView.show(computer.toString());

            return;
        }

        this.computerView.show("Computador não encontrado.");
    }

    public boolean isValid(long id) throws SQLException
    {
        return this.computerDAO.exists(id);
    }
}