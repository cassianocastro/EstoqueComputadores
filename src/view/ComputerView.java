package view;

import javax.swing.JOptionPane;

/**
 *
 */
public class ComputerView extends View
{

    @Override
    public String[] insert()
    {
        return new String[]
        {
            JOptionPane.showInputDialog("Mark:"),
            JOptionPane.showInputDialog("Model:"),
            JOptionPane.showInputDialog("Processor:"),
            JOptionPane.showInputDialog(
                null,
                "Choose one of the options below:",
                "Type:",
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]
                {
                    "Desktop", "Notebook", "Tablet", "Smartphone"
                },
                null
            ).toString(),
            JOptionPane.showInputDialog("Color:"),
            JOptionPane.showInputDialog("RAM:"),
            JOptionPane.showInputDialog("Storage:"),
            JOptionPane.showInputDialog("Screen Size:")
        };
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
                "Mark", "Model", "Processor", "Type",
                "Color", "RAM", "Storage", "Screen Size"
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