package controll;

import model.dao.ComputadorDAO;
import view.*;
import model.*;
import java.sql.SQLException;
import model.interfaces.ControllStrategy;

/**
 * @author cassiano
 */
public class ComputadorStrategy implements ControllStrategy{
    private final ComputadorDAO computadorDao;
    private final View computadorView;
    
    public ComputadorStrategy(ComputadorDAO computadorDao){
        this.computadorDao  = computadorDao;
        this.computadorView = new ComputadorView();
    }
    
    @Override
    public void create() throws SQLException{
        String[] dados = this.computadorView.insert();
        if ( dados == null ) return;
        
        String marca        = dados[0];
        String modelo       = dados[1];
        String processador  = dados[2];
        String tipo         = dados[3];
        String cor          = dados[4];
        int ram             = Integer.parseInt(dados[5]);
        int armzmnto        = Integer.parseInt(dados[6]);
        float tamanhoTela   = Float.parseFloat(dados[7]);
       
        this.computadorDao.create(
            new Computer(
                0, ram, armzmnto, tamanhoTela, marca, modelo, processador, cor, tipo
            )
        );
        this.computadorView.show("Computador cadastrado.");
    }
    
    @Override
    public void read() throws SQLException{
        this.computadorView.show(
            this.computadorDao.read().toString()
        );
    }
    
    @Override
    public void update() throws SQLException{
        int ID = Integer.parseUnsignedInt(
            this.computadorView.getID()
        );
        if ( ! isValid(ID) ){
            this.computadorView.show("Computador não encontrado.");
            return;
        }
        
        Computer computador = this.computadorDao.findByID( ID );
        String[] dados = this.computadorView.update();
        switch ( dados[0] ){
            case "Marca":
                computador.setMarca(dados[1]);
                break;
            case "Modelo":
                computador.setModelo(dados[1]);
                break;
            case "Processador":
                computador.setProcessador(dados[1]);
                break;
            case "Tipo":
                computador.setTipo(dados[1]);
                break;
            case "Cor":
                computador.setCor(dados[1]);
                break;
            case "RAM":
                computador.setRam(Integer.parseInt(dados[1]));
                break;
            case "Armazenamento":
                computador.setArmazenamento(Integer.parseInt(dados[1]));
                break;
            default:
                computador.setTamanhoTela(Float.parseFloat(dados[1]));
        }
        this.computadorDao.update(computador);
        this.computadorView.show("Registro atualizado.");
    }
    
    @Override
    public void delete() throws SQLException{
        int ID = Integer.parseUnsignedInt(
            this.computadorView.getID()
        );
        if ( isValid(ID) ){
            this.computadorDao.delete( ID );
            this.computadorView.show("Computador excluído.");
            return;
        }
        this.computadorView.show("Computador não encontrado.");
    }
    
    @Override
    public void search() throws SQLException{
        int ID = Integer.parseUnsignedInt(
            this.computadorView.getID()
        );
        if ( isValid(ID) ){
            Computer computador = this.computadorDao.findByID( ID );
            this.computadorView.show(computador.toString());
            return;
        }
        this.computadorView.show("Computador não encontrado.");
    }
    
    @Override
    public boolean isValid(int ID) throws SQLException{
        return this.computadorDao.exists(ID);
    }
}
