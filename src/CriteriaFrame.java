package src;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CriteriaFrame extends JPanel
{
    public CriteriaFrame()
    {
        setLayout(new GridLayout(1, 2));
        JPanel inner = new JPanel();
        inner.setLayout(new GridLayout(20, 1));
        for (int i = 0; i < 20; i++)
        {
            inner.add(new CriteriaEntry(String.valueOf(i)));
        }

        JScrollPane scrollPane = new JScrollPane(inner);
        scrollPane.createVerticalScrollBar();

        add(scrollPane);
        setBorder(new TitledBorder(new EtchedBorder(), "Criteria"));
    }
}
