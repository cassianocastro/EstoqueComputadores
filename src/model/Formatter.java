package model;

import java.util.*;

/**
 *
 */
public class Clientes
{

    private final List<Client> clientes;

    public Clientes()
    {
        this.clientes = new LinkedList<>();
    }

    public void add(Client client)
    {
        this.clientes.add(client);
    }

    public CharSequence toSequence()
    {
        if ( !this.clientes.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();
            for ( Client cliente : this.clientes )
            {
                msg.append(cliente.toString());
                msg.append("\n***\n");
            }
            return msg;
        }
        return new StringBuilder("Sem registros");
    }

}
