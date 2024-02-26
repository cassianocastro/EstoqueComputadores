package view;

import javax.swing.JOptionPane;

/**
 *
 */
public class IndexView
{

    final public int getOption()
    {
        return JOptionPane.showOptionDialog(
            null,
            "Choose an option:",
            "Hello",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[]
            {
                "Employees", "Computers", "Clients", "Exit"
            },
            null
        );
    }
}