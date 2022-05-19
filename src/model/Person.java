package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
abstract public class Person
{

    private String nome, cpf;
    private Sex sexo;
    private Date nascimento;

    public Person(String nome, String cpf, Sex sexo, Date nascimento)
    {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    @Override
    public String toString()
    {
        return "\nNome: " + this.nome
            + "\nSexo: " + this.sexo.getDescricao()
            + "\nCPF: " + this.cpf
            + "\nData de "
            + "Nascimento: " + new SimpleDateFormat("dd/MM/yyyy")
                .format(this.nascimento);
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCpf()
    {
        return this.cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getSexo()
    {
        return this.sexo.getDescricao();
    }

    public void setSexo(Sex sexo)
    {
        this.sexo = sexo;
    }

    public Date getNascimento()
    {
        return this.nascimento;
    }

    public void setNascimento(Date data_nascimento)
    {
        this.nascimento = data_nascimento;
    }
}
