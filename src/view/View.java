package view;

import javax.swing.JOptionPane;

/**
 *
 */
abstract public class View
{

    abstract public String[] insert();

    abstract public String[] update();

    final public int getOption()
    {
        return JOptionPane.showOptionDialog(
            null,
            "Escolha a opção:", "Olá",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]
            {
                "Inserir", "Exibir", "Procurar", "Atualizar", "Remover", "Voltar"
            },
            null
        );
    }

    final public void show(CharSequence message)
    {
        JOptionPane.showMessageDialog(
            null,
            message,
            null,
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    final public String getID()
    {
        return JOptionPane.showInputDialog("Informe o ID:");
    }

}
