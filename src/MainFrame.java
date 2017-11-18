package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame
{
    private Optimizer optimizer;
    private JList<String> items;

    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            //optimizer.show();
        }
    }

    public MainFrame(Optimizer optimizer)
    {
        setupLookAndFeel();
        this.optimizer = optimizer;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        items = new JList<>();
        JButton updateButton = new JButton("Update");

        updateButton.addActionListener(new ButtonListener());

        panel.add(new CriteriaFrame(optimizer.getCriteria()));
        panel.add(items);
        panel.add(updateButton);

        add(panel);

        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 400;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}