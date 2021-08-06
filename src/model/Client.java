package model;

import java.util.Date;

/**
 * @author cassiano
 */
public class Client extends Person{
    private int ID;
    
    public Client(int ID, String nome, String cpf, Sex sexo, Date nascimento) {
        super(nome, cpf, sexo, nascimento);
        this.ID = ID;
    }
    
    @Override
    public String toString(){
        return "ID: " + this.ID +
               super.toString();
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public int getID(){
        return this.ID;
    }
}
