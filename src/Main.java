package src;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        Optimizer optimizer = new Optimizer("cars", "items.csv", "criteria.csv");
        optimizer.show();

        JFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}
