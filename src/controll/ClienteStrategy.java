package controll;

import model.dao.ClienteDAO;
import model.interfaces.*;
import model.*;
import view.*;
import java.sql.SQLException;

/**
 * 
 */
public class ClienteStrategy implements ControllStrategy
{

    private final PersonDAO clienteDao;
    private final View clienteView;

    public ClienteStrategy(ClienteDAO clientDAO)
    {
        this.clienteDao  = clientDAO;
        this.clienteView = new ClienteView();
    }

    @Override
    public void create() throws SQLException
    {
        String[] dados = this.clienteView.insert();
        if ( dados == null )
        {
            return;
        }

        /*
            String nome = dados[0];
            String cpf  = dados[1];
            Sexo sexo   = Sexo.valueOf(dados[2]);
            Date date   = new SimpleDateFormat("dd/MM/yyyy").parse(dados[3]);

            this.clienteDao.create(
                new Cliente( 0, nome, cpf, sexo, date )
            );
        */
        this.clienteView.show("Cliente cadastrado.");
    }

    @Override
    public void read() throws SQLException
    {
        this.clienteView.show(
            this.clienteDao.read().toString()
        );
    }

    @Override
    public void update() throws SQLException
    {
        int ID = Integer.parseUnsignedInt(
            this.clienteView.getID()
        );
        if ( !isValid(ID) )
        {
            this.clienteView.show("Cliente não encontrado.");
            return;
        }

        Client cliente = (Client) this.clienteDao.findByID(ID);
        String[] dados = this.clienteView.update();
        switch ( dados[0] )
        {
            case "Nome":
                cliente.setNome(dados[1]);
                break;
            case "CPF":
                cliente.setCpf(dados[1]);
                break;
            case "Sexo":
                cliente.setSexo(Sex.valueOf(dados[1]));
                break;
            default:
            /*
                cliente.setNascimento(
                    new SimpleDateFormat("dd/MM/yyyy").parse(dados[1])
                );
            */
        }
        this.clienteDao.update(cliente);
        this.clienteView.show("Registro atualizado.");
    }

    @Override
    public void delete() throws SQLException
    {
        int ID = Integer.parseUnsignedInt(
            this.clienteView.getID()
        );
        if ( isValid(ID) )
        {
            this.clienteDao.delete(ID);
            this.clienteView.show("Cliente excluído.");
            return;
        }
        this.clienteView.show("Cliente não encontrado.");
    }

    @Override
    public void search() throws SQLException
    {
        int ID = Integer.parseUnsignedInt(
            this.clienteView.getID()
        );
        if ( isValid(ID) )
        {
            Object cliente = this.clienteDao.findByID(ID);
            this.clienteView.show(cliente.toString());
            return;
        }
        this.clienteView.show("Cliente não encontrado.");
    }

    @Override
    public boolean isValid(int ID) throws SQLException
    {
        return this.clienteDao.exists(ID);
    }

}
