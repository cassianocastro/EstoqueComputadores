package view;

import javax.swing.JOptionPane;

/**
 *
 * @author cassiano
 */
public class ComputadorView extends View{

    @Override
    public String[] insert() {
        return new String[] {
            JOptionPane.showInputDialog("Marca:"),
            JOptionPane.showInputDialog("Modelo:"),
            JOptionPane.showInputDialog("Processador:"),
            JOptionPane.showInputDialog(
                null,
                "Selecione uma das opções abaixo:",
                "Tipo de Aparelho",
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] { "Desktop", "Notebook", "Tablet", "Smartphone", "Cafeteira(Trolls)" },
                null
            ).toString(),
            JOptionPane.showInputDialog("Cor:"),
            JOptionPane.showInputDialog("Memória RAM:"),
            JOptionPane.showInputDialog("Capacidade de Armazenamento:"),
            JOptionPane.showInputDialog("Tamanho da tela:")
        };
    }

    @Override
    public String[] update() {
        String atributo = JOptionPane.showInputDialog(
            null,
            "Tipo de Atributo:", "Alterar...",
            JOptionPane.DEFAULT_OPTION,
            null,
            new String[] {"Marca", "Modelo", "Processador", "Tipo",
                          "Cor", "RAM", "Armazenamento", "Tamanho da Tela"},
            null
        ).toString();
        String novoDado = JOptionPane.showInputDialog(null, atributo + ":");
        return new String[] {
            atributo,
            novoDado
        };
    }

}
