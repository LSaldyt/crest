package optimal;

import java.util.HashMap;

public class Criteria
{
    private HashMap<String, Double> criteria;

    public Criteria()
    {
        criteria = new HashMap<>();
    }

    public void add(String key, Double weight)
    {
        criteria.put(key, weight);
    }

    public Double score(RankedItem item)
    {
        Double amount = 0.0;
        for (String key : criteria.keySet())
        {
            Double weight = criteria.get(key);
            amount += item.get(key) * weight;
        }
        return amount;
    }
}