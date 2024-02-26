package model;

import java.util.Calendar;

/**
 *
 */
public class Employee extends Person
{

    public Employee(Long id, String name, String cpf, Sex sex, Calendar birthDate)
    {
        super(id, name, cpf, sex, birthDate);
    }
}