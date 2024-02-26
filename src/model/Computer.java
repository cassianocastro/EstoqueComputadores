package model;

/**
 *
 */
public class Computer
{

    private Long id;
    private int ram;
    private int storage;
    private String mark;
    private String model;
    private String processor;
    private String color;
    private String type;
    private float screenSize;

    public Computer(Long id, int ram, int storage, float screenSize,
                    String mark, String model, String processor, String color, String type)
    {
        this.id         = id;
        this.ram        = ram;
        this.storage    = storage;
        this.mark       = mark;
        this.model      = model;
        this.processor  = processor;
        this.color      = color;
        this.type       = type;
        this.screenSize = screenSize;
    }

    public Long getID()
    {
        return this.id;
    }

    public void setID(Long id)
    {
        this.id = id;
    }

    public int getRAM()
    {
        return this.ram;
    }

    public void setRAM(int ram)
    {
        this.ram = ram;
    }

    public int getStorage()
    {
        return this.storage;
    }

    public void setStorage(int storage)
    {
        this.storage = storage;
    }

    public String getMark()
    {
        return this.mark;
    }

    public void setMark(String mark)
    {
        this.mark = mark;
    }

    public String getModel()
    {
        return this.model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getProcessor()
    {
        return this.processor;
    }

    public void setProcessor(String processor)
    {
        this.processor = processor;
    }

    public String getColor()
    {
        return this.color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public float getScreenSize()
    {
        return this.screenSize;
    }

    public void setScreenSize(float screenSize)
    {
        this.screenSize = screenSize;
    }
}