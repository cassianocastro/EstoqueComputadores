package view;

import javax.swing.JOptionPane;

/**
 *
 */
public class ContextView
{

    final public int getOption()
    {
        return JOptionPane.showOptionDialog(
            null,
            "Escolha a opção:",
            "Olá",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]
            {
                "Funcionário", "Computador", "Cliente", "Sair"
            },
            null
        );
    }
}
