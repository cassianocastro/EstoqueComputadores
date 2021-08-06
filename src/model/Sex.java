package model;

/**
 *
 * @author User
 */
public enum Sex {
    m("m"),
    f("f");
    
    private String descricao;
    
    private Sex(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
}
