package src;

import java.util.HashMap;

public class RankedItem
{
    private String name;
    private HashMap<String, Double> attributes;
    private HashMap<String, Double> attributesNormalized;

    Double score;

    public RankedItem(String name)
    {
        this.name = name;
        attributes = new HashMap<>();
        attributesNormalized = new HashMap<>();
        this.score = 0.0;
    }

    public void add(String key, Double value)
    {
        attributes.put(key, value);
    }

    public Double get(String key)
    {
        if (!attributes.containsKey(key))
        {
            System.err.println("criteria key: " + key + " not found in input data");
        }
        return attributes.get(key);
    }


    public void add_normalized(String key, Double value){ attributesNormalized.put(key, value); }

    public Double get_normalized(String key){ return attributesNormalized.get(key); }

    public void setScore(Double score)
    {
        this.score = score;
    }

    public Double getScore()
    {
        return this.score;
    }

    public String toString()
    {
        return name + ": " + attributes.toString();
    }
}