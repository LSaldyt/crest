package src;

import javax.swing.*;
import java.awt.*;

public class CriteriaEntry extends JPanel
{
    String name;
    JTextField valueField;
    JRadioButton maximizingButton;

    public CriteriaEntry(String name, Metric metric)
    {
        this.name = name;
        setLayout(new GridLayout(1, 4));
        JLabel nameLabel = new JLabel();
        nameLabel.setText(name);
        add(nameLabel);

        JLabel valueLabel = new JLabel("Weight: ");
        add(valueLabel);

        valueField = new JTextField();
        valueField.setText(String.valueOf(metric.weight));
        add(valueField);

        maximizingButton = new JRadioButton("Maximizing: ");
        maximizingButton.setSelected(metric.maximizing);
        add(maximizingButton);
    }

    public void updateValue(Criteria parent)
    {
        parent.addMetric(name, new Metric(Double.parseDouble(valueField.getText()), maximizingButton.isSelected()));
    }
}
