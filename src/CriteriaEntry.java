package src;

import javax.swing.*;
import java.awt.*;

public class CriteriaEntry extends JPanel
{
    public CriteriaEntry(String name, Metric metric)
    {
        setLayout(new GridLayout(1, 3));
        JLabel nameLabel = new JLabel();
        nameLabel.setText(name);
        add(nameLabel);
        JLabel valueLabel = new JLabel();
        valueLabel.setText("Weight: " + String.valueOf(metric.weight));
        add(valueLabel);
        JLabel maxLabel = new JLabel();
        maxLabel.setText("Maximizing: " + String.valueOf(metric.maximizing));
        add(maxLabel);
    }
}
