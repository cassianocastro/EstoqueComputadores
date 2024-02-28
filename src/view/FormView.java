package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 */
final public class FormView extends JDialog implements ActionListener
{

    private JComponent panelLabels, panelFields, panelButtons, panelPrincipal, jOptionPane;
    private GridLayout grid;
    private JFormattedTextField fieldNome, fieldCPF, fieldNascimento;
    private MaskFormatter maskCPF, maskNascimento;
    private JComboBox<String> comboSexo;
    private JButton buttonSalvar, buttonCancelar;
    private String[] dados;

    public FormView()
    {
        super.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);

        this.initComponents();

        super.setContentPane(this.jOptionPane);
        super.pack();
        super.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    private void initComponents()
    {
        this.grid = new GridLayout(4, 1);
        this.panelLabels = new JPanel(this.grid);
        this.panelFields = new JPanel(this.grid);
        this.panelButtons = new JPanel();
        this.panelPrincipal = new JPanel(new BorderLayout(10, 0));

        try
        {
            this.maskCPF = new MaskFormatter("###.###.###-##");
            this.maskNascimento = new MaskFormatter("##/##/####");
        }
        catch ( ParseException e )
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        this.fieldNome = new JFormattedTextField();
        this.fieldCPF = new JFormattedTextField(this.maskCPF);
        this.fieldNascimento = new JFormattedTextField(this.maskNascimento);
        this.comboSexo = new JComboBox<>(new String[] { "m", "f" });

        this.fieldNome.setColumns(20);

        this.buttonSalvar = new JButton("Salvar");
        this.buttonCancelar = new JButton("Cancelar");

        this.buttonSalvar.addActionListener(this);
        this.buttonCancelar.addActionListener(this);

        this.panelLabels.add(new JLabel("Nome:", SwingConstants.RIGHT));
        this.panelLabels.add(new JLabel("CPF:", SwingConstants.RIGHT));
        this.panelLabels.add(new JLabel("Nascimento:", SwingConstants.RIGHT));
        this.panelLabels.add(new JLabel("Sexo:", SwingConstants.RIGHT));

        this.panelFields.add(this.fieldNome);
        this.panelFields.add(this.fieldCPF);
        this.panelFields.add(this.fieldNascimento);
        this.panelFields.add(this.comboSexo);

        this.panelButtons.add(this.buttonSalvar);
        this.panelButtons.add(this.buttonCancelar);

        this.panelPrincipal.add(this.panelLabels, "West");
        this.panelPrincipal.add(this.panelFields, "Center");
        this.panelPrincipal.add(this.panelButtons, "South");

        this.jOptionPane = new JOptionPane(
            "Insira os dados:",
            JOptionPane.INFORMATION_MESSAGE,
            JOptionPane.DEFAULT_OPTION,
            null,
            new Object[]
            {
                this.panelPrincipal
            }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == this.buttonSalvar )
        {
            this.dados = new String[]
            {
                this.fieldNome.getText(),
                this.fieldCPF.getText(),
                this.comboSexo.getSelectedItem().toString(),
                this.fieldNascimento.getText()
            };
        }

        this.dispose();
    }

    public String[] getData()
    {
        return this.dados;
    }
}