package model;

/**
 *
 *
 */
public class Computer
{

    private int ID, ram, armazenamento;
    private String marca, modelo, processador, cor, tipo;
    private float tamanhoTela;

    public Computer(int ID, int ram, int armazenamento, float tamanhoTela,
                    String marca, String modelo, String processador, String cor, String tipo)
    {
        this.ID = ID;
        this.ram = ram;
        this.armazenamento = armazenamento;
        this.marca = marca;
        this.modelo = modelo;
        this.processador = processador;
        this.cor = cor;
        this.tipo = tipo;
        this.tamanhoTela = tamanhoTela;
    }

    @Override
    public String toString()
    {
        return "\nID: " + this.ID
            + "\nMarca: " + this.marca
            + "\nModelo: " + this.modelo
            + "\nMemória RAM: " + this.ram + " GB"
            + "\nArmazenamento: " + this.armazenamento + " GB"
            + "\nProcessador: " + this.processador
            + "\nTipo: " + this.tipo
            + "\nTamanho da Tela: " + this.tamanhoTela + "\""
            + "\nCor: " + this.cor;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getRam()
    {
        return ram;
    }

    public void setRam(int ram)
    {
        this.ram = ram;
    }

    public int getArmazenamento()
    {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento)
    {
        this.armazenamento = armazenamento;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getProcessador()
    {
        return processador;
    }

    public void setProcessador(String processador)
    {
        this.processador = processador;
    }

    public String getCor()
    {
        return cor;
    }

    public void setCor(String cor)
    {
        this.cor = cor;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public float getTamanhoTela()
    {
        return tamanhoTela;
    }

    public void setTamanhoTela(float tamanhoTela)
    {
        this.tamanhoTela = tamanhoTela;
    }

}
