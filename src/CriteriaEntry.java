package src;

import javax.swing.*;
import java.awt.*;

public class CriteriaEntry extends JPanel
{
    public CriteriaEntry(String name, Metric metric)
    {
        setLayout(new GridLayout(1, 3));
        JLabel label = new JLabel();
        label.setText(name);
        JTextField valueField = new JTextField();
        JRadioButton button   = new JRadioButton();
        add(label);
        add(valueField);
        add(button);
    }
}
