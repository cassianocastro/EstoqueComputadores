package model;

import java.util.Calendar;

/**
 *
 */
abstract public class Person
{

    private Long id;
    private String name;
    private String cpf;
    private Sex sex;
    private Calendar birthDate;

    public Person(Long id, String name, String cpf, Sex sex, Calendar birthDate)
    {
        this.id        = id;
        this.name      = name;
        this.sex       = sex;
        this.cpf       = cpf;
        this.birthDate = birthDate;
    }

    public Long getID()
    {
        return this.id;
    }

    public void setID(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCPF()
    {
        return this.cpf;
    }

    public void setCPF(String cpf)
    {
        this.cpf = cpf;
    }

    public String getSex()
    {
        return this.sex.getDescription();
    }

    public void setSex(Sex sex)
    {
        this.sex = sex;
    }

    public Calendar getBirthDate()
    {
        return this.birthDate;
    }

    public void setBirthDate(Calendar birthDate)
    {
        this.birthDate = birthDate;
    }
}