package controll;

import model.dao.FuncionarioDAO;
import model.*;
import view.*;
import java.sql.SQLException;
import model.interfaces.ControllStrategy;

/**
 *
 */
public class FuncionarioStrategy implements ControllStrategy
{

    private final FuncionarioDAO funcionarioDAO;
    private final View funcionarioView;

    public FuncionarioStrategy(FuncionarioDAO funcionarioDAO)
    {
        this.funcionarioDAO  = funcionarioDAO;
        this.funcionarioView = new FuncionarioView();
    }

    @Override
    public void create() throws SQLException
    {
        String[] dados = this.funcionarioView.insert();
        if ( dados == null )
        {
            return;
        }

        /*
            String nome = dados[0];
            String cpf  = dados[1];
            Sexo sexo   = Sexo.valueOf(dados[2]);
            Date date   = new SimpleDateFormat("dd/MM/yyyy").parse(dados[3]);

            this.funcionarioDAO.create(
                new Funcionario( 0, nome, cpf, sexo, date )
            );
        */
        this.funcionarioView.show("Funcionário cadastrado");
    }

    @Override
    public void read() throws SQLException
    {
        this.funcionarioView.show(
            this.funcionarioDAO.read().toString()
        );
    }

    @Override
    public void update() throws SQLException
    {
        int ID = converterID();

        if ( !isValid(ID) )
        {
            this.funcionarioView.show("Funcionário não encontrado.");
            return;
        }

        Funcionario funcionario = (Funcionario) this.funcionarioDAO.findByID(ID);
        String[] dados = this.funcionarioView.update();
        switch ( dados[0] )
        {
            case "Nome":
                funcionario.setNome(dados[1]);
                break;
            case "CPF":
                funcionario.setCpf(dados[1]);
                break;
            case "Sexo":
                funcionario.setSexo(Sex.valueOf(dados[1]));
                break;
            default:
            /*
                funcionario.setNascimento(
                    new SimpleDateFormat("dd/MM/yyyy").parse(dados[1])
                );
            */
        }
        this.funcionarioDAO.update(funcionario);
        this.funcionarioView.show("Registro atualizado.");
    }

    @Override
    public void delete() throws SQLException
    {
        int ID = converterID();

        if ( isValid(ID) )
        {
            this.funcionarioDAO.delete(ID);
            this.funcionarioView.show("Funcionário excluído");
            return;
        }
        this.funcionarioView.show("Funcionário não encontrado.");
    }

    @Override
    public void search() throws SQLException
    {
        int ID = converterID();

        if ( isValid(ID) )
        {
            Funcionario funcionario = (Funcionario) this.funcionarioDAO.findByID(ID);
            this.funcionarioView.show(funcionario.toString());
            return;
        }
        this.funcionarioView.show("Funcionário não encontrado.");
    }

    private int converterID()
    {
        return Integer.parseUnsignedInt(
            this.funcionarioView.getID()
        );
    }

    @Override
    public boolean isValid(int ID) throws SQLException
    {
        return this.funcionarioDAO.exists(ID);
    }
}
