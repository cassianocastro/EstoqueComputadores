package model;

import java.util.*;

/**
 * @author User
 */
public class QuadroFuncionarios {
    private final List<Funcionario> quadro;
    
    public QuadroFuncionarios(){
        this.quadro = new LinkedList<>();
    }
    
    public void add(Funcionario f) {
        this.quadro.add( f );
    }
    
    public CharSequence toSequence(){
        if ( ! this.quadro.isEmpty() ){
            StringBuilder msg = new StringBuilder();
            for (Funcionario funcionario : this.quadro) {
                msg.append(funcionario.toString());
                msg.append("\n***\n");
            }
            return msg;
        }
        return new StringBuilder("Sem registros");
    }
}
