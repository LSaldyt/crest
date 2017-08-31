package optimal;

import java.util.HashMap;

public class RankedItem
{
    private HashMap<String, Double> attributes;

    public RankedItem()
    {
        attributes = new HashMap<>();
    }

    public void add(String key, Double value)
    {
        attributes.put(key, value);
    }

    public Double get(String key)
    {
        return attributes.get(key);
    }
}