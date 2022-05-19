package model;

/**
 *
 */
public enum Sex
{
    m("m"),
    f("f");

    private final String descricao;

    private Sex(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return this.descricao;
    }
}
