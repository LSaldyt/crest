package src;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Set;

public class CriteriaFrame extends JPanel
{
    public CriteriaFrame(Criteria criteria)
    {
        setLayout(new GridLayout(1, 2));
        JPanel inner = new JPanel();

        HashMap<String, Metric> metrics = criteria.getMetrics();
        Set<String> keys = metrics.keySet();

        inner.setLayout(new GridLayout(keys.size(), 1));
        for (String key : keys)
        {
            Metric metric = metrics.get(key);
            inner.add(new CriteriaEntry(key, metric));
        }

        JScrollPane scrollPane = new JScrollPane(inner);
        scrollPane.createVerticalScrollBar();

        add(scrollPane);
        setBorder(new TitledBorder(new EtchedBorder(), "Criteria"));
    }
}
