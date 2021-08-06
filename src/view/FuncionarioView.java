package view;

import javax.swing.*;

/**
 *
 * @author User
 */
public class FuncionarioView extends View{
    
    @Override
    public String[] insert(){
        Cadastro cadastro = new Cadastro();
        return cadastro.getDados();
    }
    
    @Override
    public String[] update(){
        String atributo = JOptionPane.showInputDialog(
            null,
            "Tipo de Atributo:", "Alterar...",
            JOptionPane.DEFAULT_OPTION,
            null,
            new String[] {"Nome", "CPF", "Sexo", "Data de Nascimento"},
            null
        ).toString();
        String novoDado = JOptionPane.showInputDialog(null, atributo + ":");
        return new String[] {
            atributo,
            novoDado
        };
    }

}
