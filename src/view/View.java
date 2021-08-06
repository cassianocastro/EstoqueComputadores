package view;

import javax.swing.JOptionPane;

/**
 *
 * @author cassiano
 */

public abstract class View {
    public abstract String[] insert();
    public abstract String[] update();

    public final int getOption(){
        return JOptionPane.showOptionDialog(
            null,
            "Escolha a opção:", "Olá",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[] {"Inserir", "Exibir", "Procurar", "Atualizar", "Remover", "Voltar"},
            null
        );
    }
    
    public final void show(CharSequence message){
        JOptionPane.showMessageDialog(
            null,
            message,
            null,
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public final String getID(){
        return JOptionPane.showInputDialog("Informe o ID:");
    }
    
}
