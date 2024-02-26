package model;

/**
 *
 */
public enum Sex
{

    M("M"), F("F");

    private final String description;

    private Sex(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return this.description;
    }
}