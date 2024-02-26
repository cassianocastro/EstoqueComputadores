package view;

import javax.swing.JOptionPane;

/**
 *
 */
public class ClientView extends View
{

    @Override
    public String[] insert()
    {
        return new FormView().getData();
    }

    @Override
    public String[] update()
    {
        String attribute = JOptionPane.showInputDialog(
            null,
            "Attribute:",
            "To alter...",
            JOptionPane.DEFAULT_OPTION,
            null,
            new String[]
            {
                "Name", "CPF", "Sex", "Birth Date"
            },
            null
        ).toString();

        String newData = JOptionPane.showInputDialog(null, attribute + ":");

        return new String[]
        {
            attribute, newData
        };
    }
}