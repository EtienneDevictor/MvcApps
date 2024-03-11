package stopLight;

import java.awt.*;
import javax.swing.*;

import mvc.*;


public class StoplightPanel extends AppPanel {
    private JButton change;
    public StoplightPanel(AppFactory factory) {
        super(factory);
        change = new JButton("Change");
        change.addActionListener(this);
        ControlPanel.add(change);
        System.out.println("inside StoplightPanel method");
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new StoplightPanel(factory);
        System.out.println("should have added change button");
        panel.display();
        System.out.println("display");
    }

}

