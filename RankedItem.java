package optimal;

import java.util.HashMap;

public class RankedItem
{
    private HashMap<String, Double> attributes;
    private HashMap<String, Double> attributesNormalized;

    Double score;

    public RankedItem()
    {
        attributes = new HashMap<>();
        attributesNormalized = new HashMap<>();
    }

    public void add(String key, Double value)
    {
        attributes.put(key, value);
    }

    public Double get(String key)
    {
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
        return "RankedItem: " + attributes.toString();
    }
}