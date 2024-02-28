package controller;

import java.sql.SQLException;
import model.dao.ClientDAO;
import model.*;
import view.*;

/**
 *
 */
public class ClientsController
{

    private final ClientDAO clientDao;
    private final View clientView;

    public ClientsController(ClientDAO dao)
    {
        this.clientDao  = dao;
        this.clientView = new ClientView();
    }

    public void create() throws SQLException
    {
        String[] data = this.clientView.insert();

        if ( data == null ) return;

        /*
            String name = data[0];
            String cpf  = data[1];
            Sexo sex    = Sex.valueOf(data[2]);
            Date date   = new SimpleDateFormat("dd/MM/yyyy").parse(data[3]);

            this.clientDao.insert(new Client(0, name, cpf, sex, date));
        */
        this.clientView.show("Cliente cadastrado.");
    }

    public void read() throws SQLException
    {
        this.clientView.show(this.clientDao.getAll().toString());
    }

    public void update() throws SQLException
    {
        long id = Integer.parseUnsignedInt(this.clientView.getID());

        if ( ! this.isValid(id) )
        {
            this.clientView.show("Cliente não encontrado.");

            return;
        }

        Client client = this.clientDao.findByID(id);
        String[] data = this.clientView.update();

        switch ( data[0] )
        {
            case "Nome":
                client.setName(data[1]);
                break;
            case "CPF":
                client.setCPF(data[1]);
                break;
            case "Sexo":
                client.setSex(Sex.valueOf(data[1]));
                break;
            default:
                // client.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(data[1]));
        }

        this.clientDao.update(client);
        this.clientView.show("Registro atualizado.");
    }

    public void delete() throws SQLException
    {
        int id = Integer.parseUnsignedInt(this.clientView.getID());

        if ( this.isValid(id) )
        {
            // this.clientDao.delete(id);
            this.clientView.show("Cliente excluído.");

            return;
        }

        this.clientView.show("Cliente não encontrado.");
    }

    public void search() throws SQLException
    {
        long id = Integer.parseUnsignedInt(this.clientView.getID());

        if ( this.isValid(id) )
        {
            Client client = this.clientDao.findByID(id);

            this.clientView.show(client.toString());

            return;
        }

        this.clientView.show("Cliente não encontrado.");
    }

    public boolean isValid(long id) throws SQLException
    {
        return this.clientDao.exists(id);
    }
}