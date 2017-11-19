package src;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class CriteriaFrame extends JPanel
{
    Criteria parent;
    Vector<CriteriaEntry> entries;

    public CriteriaFrame(Criteria criteria)
    {
        entries = new Vector<>();
        this.parent = criteria;

        setLayout(new GridLayout(1, 2));
        JPanel inner = new JPanel();

        HashMap<String, Metric> metrics = criteria.getMetrics();
        Set<String> keys = metrics.keySet();

        inner.setLayout(new GridLayout(keys.size(), 1));
        for (String key : keys)
        {
            Metric metric = metrics.get(key);
            CriteriaEntry entry = new CriteriaEntry(key, metric);
            entries.add(entry);
            inner.add(entry);
        }

        //JScrollPane scrollPane = new JScrollPane(inner);
        //scrollPane.createVerticalScrollBar();

        //add(scrollPane);
        add(inner);
        setBorder(new TitledBorder(new EtchedBorder(), "Criteria"));
    }

    public void updateEntries()
    {
        for (CriteriaEntry entry : entries)
        {
            entry.updateValue(parent);
        }
    }
}
