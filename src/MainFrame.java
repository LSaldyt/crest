package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame
{
    private Optimizer optimizer;
    private JTextArea output;
    private CriteriaFrame criteriaFrame;

    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            criteriaFrame.updateEntries();
            optimizer.sort();
            String outputText = "";
            for (RankedItem item : optimizer.getRankedSet().items)
            {
                outputText += item.toString() + "\n";
            }
            output.setText(outputText);
        }
    }

    public MainFrame(Optimizer optimizer)
    {
        setupLookAndFeel();
        this.optimizer = optimizer;

        output = new JTextArea();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ButtonListener());

        criteriaFrame = new CriteriaFrame(optimizer.getCriteria());

        panel.add(criteriaFrame);
        panel.add(output);
        panel.add(updateButton);

        add(panel);

        final int FRAME_WIDTH = 1200;
        final int FRAME_HEIGHT = 800;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        updateButton.doClick();
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