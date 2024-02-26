package controller;

import java.sql.SQLException;
import model.dao.EmployeeDAO;
import model.*;
import view.*;

/**
 *
 */
public class EmployeesController
{

    private final EmployeeDAO employeeDAO;
    private final View employeeView;

    public EmployeesController(EmployeeDAO dao)
    {
        this.employeeDAO  = dao;
        this.employeeView = new EmployeeView();
    }

    public void create() throws SQLException
    {
        String[] data = this.employeeView.insert();

        if ( data == null ) return;

        /*
            String name = data[0];
            String cpf  = data[1];
            Sexo sex    = Sex.valueOf(data[2]);
            Date date   = new SimpleDateFormat("dd/MM/yyyy").parse(data[3]);

            this.employeeDAO.insert(new Employee(0, name, cpf, sex, date));
        */
        this.employeeView.show("Funcionário cadastrado");
    }

    public void read() throws SQLException
    {
        this.employeeView.show(this.employeeDAO.getAll().toString());
    }

    public void update() throws SQLException
    {
        long id = converterID();

        if ( ! this.isValid(id) )
        {
            this.employeeView.show("Funcionário não encontrado.");
            return;
        }

        Employee employee = this.employeeDAO.findByID(id);
        String[] data     = this.employeeView.update();

        switch ( data[0] )
        {
            case "Nome":
                employee.setName(data[1]);
                break;
            case "CPF":
                employee.setCPF(data[1]);
                break;
            case "Sexo":
                employee.setSex(Sex.valueOf(data[1]));
                break;
            default:
                // employee.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(data[1]));
        }
        this.employeeDAO.update(employee);
        this.employeeView.show("Registro atualizado.");
    }

    public void delete() throws SQLException
    {
        long id = this.converterID();

        if ( this.isValid(id) )
        {
            // this.employeeDAO.delete(id);
            this.employeeView.show("Funcionário excluído");

            return;
        }
        this.employeeView.show("Funcionário não encontrado.");
    }

    public void search() throws SQLException
    {
        long id = this.converterID();

        if ( this.isValid(id) )
        {
            Employee employee = this.employeeDAO.findByID(id);
            this.employeeView.show(employee.toString());

            return;
        }
        this.employeeView.show("Funcionário não encontrado.");
    }

    private int converterID()
    {
        return Integer.parseUnsignedInt(this.employeeView.getID());
    }

    public boolean isValid(long id) throws SQLException
    {
        return this.employeeDAO.exists(id);
    }
}