package optimal;

import java.util.HashMap;


public class Criteria
{
    private HashMap<String, Metric> criteria;

    public Criteria()
    {
        criteria = new HashMap<>();
    }

    public void add(String key, Metric metric)
    {
        criteria.put(key, metric);
    }

    public void score(RankedItem item)
    {
        Double amount = 0.0;
        for (String key : criteria.keySet())
        {
            Metric metric = criteria.get(key);
            amount += metric.factor(item.get_normalized(key));
        }
        item.setScore(amount);
    }

    public void sort(RankedSet set)
    {
        for (String key : criteria.keySet())
        {
            double valMax = set.maxOf(key);
            double valMin = set.minOf(key);

            for (RankedItem item: set.items)
            {
                double val = item.get(key);
                double valNormalized = (val - valMin) / (valMax - valMin);
                item.add_normalized(key, valNormalized);
            }
        }

        for (RankedItem item : set.items)
        {
            score(item);
        }
        set.sort();
    }

    public String toString()
    {
        return "Criteria: " + criteria.toString();
    }
}