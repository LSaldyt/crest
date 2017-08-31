package optimal;

import java.util.Collections;
import java.util.Vector;

public class RankedSet
{
    private Vector<RankedItem> items;

    public RankedSet()
    {
        items = new Vector<>();
    }

    public void add(RankedItem item)
    {
        items.add(item);
    }

    private Double maxOf(Vector<RankedItem> rankedItems, String key)
    {
        Vector<Double> values = new Vector<>();
        values.add(0.); // Case for empty list
        for (RankedItem item : rankedItems)
        {
            values.add(item.get(key));
        }
        return Collections.max(values);
    }

    public Vector<RankedItem> by(Criteria criteria)
    {
        for (RankedItem item: items)
        {
            System.out.println(criteria.score(item));
        }

        return new Vector<>();
    }
};

