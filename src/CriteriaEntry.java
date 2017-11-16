package src;

import javax.swing.*;

public class CriteriaEntry extends JPanel
{
    public CriteriaEntry(String text)
    {
        JLabel label = new JLabel();
        label.setText(text);
        add(label);
    }
}
