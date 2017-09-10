package optimal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class RankedSet
{
    public Vector<RankedItem> items;

    public RankedSet()
    {
        items = new Vector<>();
    }

    public void add(RankedItem item)
    {
        items.add(item);
    }

    public Double maxOf(String key)
    {
        Vector<Double> values = new Vector<>();
        values.add(0.); // Case for empty list
        for (RankedItem item : items)
        {
            values.add(item.get(key));
        }
        return Collections.max(values);
    }

    public void sort()
    {
        items.sort(Comparator.comparing(RankedItem::getScore));
    }

    public String toString()
    {
        String repr = "Ranked Set: " + items.toString() + "\n";
        for (RankedItem item : items)
        {
            repr += item.getScore() + ", ";
        }
        return repr;
    }
};

