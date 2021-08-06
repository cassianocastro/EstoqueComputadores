package model;

import java.util.*;

/**
 * @author cassiano
 */
public class Estoque {
    private final List<Computer> estoque;
    
    public Estoque(){
        this.estoque = new LinkedList<>();
    }
    
    public void add(Computer computer) {
        this.estoque.add( computer );
    }

    public CharSequence toSequence() {
        if ( ! this.estoque.isEmpty() ){
            StringBuilder msg = new StringBuilder();
            for (Computer computador : this.estoque) {
                msg.append(computador.toString());
                msg.append("\n***\n");
            }
            return msg;
        }
        return new StringBuilder("Sem registros");
    }
    
}
