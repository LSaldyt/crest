package src;

import java.util.HashMap;


public class Criteria
{
    private HashMap<String, Metric> metrics;
    private HashMap<String, Filter> filters;

    public Criteria()
    {
        metrics = new HashMap<>();
        filters = new HashMap<>();
    }

    public void addMetric(String key, Metric metric)
    {
        metrics.put(key, metric);
    }

    public void addFilter(String key, Filter filter){ filters.put(key, filter); }

    public void score(RankedItem item)
    {
        Double amount = 0.0;
        for (String key : metrics.keySet())
        {
            Metric metric = metrics.get(key);
            amount += metric.factor(item.get_normalized(key));
        }
        item.setScore(amount);
    }

    public void sort(RankedSet set)
    {
        for (String key : metrics.keySet())
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

    public RankedSet filter(RankedSet set)
    {
        RankedSet filteredSet = new RankedSet();
        for (RankedItem item : set.items)
        {
            boolean valid = true;
            for (String key : filters.keySet())
            {
                Filter filter = filters.get(key);
                if (!filter.filter(item.get(key)))
                {
                    valid = false;
                    break;
                }
            }
            if (valid)
            {
                filteredSet.add(item);
            }
        }
        return filteredSet;
    }

    public String toString()
    {
        return "Criteria: \n" + metrics.toString() + "\n" + filters.toString();
    }
}
