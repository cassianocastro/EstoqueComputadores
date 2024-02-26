package model;

import java.text.SimpleDateFormat;

/**
 *
 */
public class Formatter
{

    public String formatPerson(Person person)
    {
        return String.format(
            "\n\nID: %d"
            + "\nName: %s"
            + "\nSex: %s"
            + "\nCPF: %s"
            + "\nBirth Date: %s",
            person.getID(),
            person.getName(),
            person.getSex(),
            person.getCPF(),
            new SimpleDateFormat("dd/MM/yyyy").format(person.getBirthDate())
        );
    }

    public String formatComputer(Computer computer)
    {
        return String.format(
            "\n\nID: %d"
            + "\nMarca: %s"
            + "\nModelo: %s"
            + "\nMemória RAM: %dGB"
            + "\nArmazenamento: %dGB"
            + "\nProcessador: %s"
            + "\nTipo: %s"
            + "\nTamanho da Tela: %f\""
            + "\nCor: %s",
            computer.getID(),
            computer.getMark(),
            computer.getModel(),
            computer.getRAM(),
            computer.getStorage(),
            computer.getProcessor(),
            computer.getType(),
            computer.getScreenSize(),
            computer.getColor()
        );
    }
}