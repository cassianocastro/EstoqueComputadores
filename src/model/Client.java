package model;

import java.util.Calendar;

/**
 *
 */
public class Client extends Person
{

    public Client(Long id, String name, String cpf, Sex sex, Calendar birthDate)
    {
        super(id, name, cpf, sex, birthDate);
    }
}