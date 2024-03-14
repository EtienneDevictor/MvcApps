package gameOfLife;

import ca.GridFactory;
import ca.GridPanel;
import mvc.AppFactory;
import mvc.AppPanel;
import stopLight.StoplightFactory;
import stopLight.StoplightPanel;

import javax.swing.*;

public class LifePanel extends GridPanel {

    private JButton change;
    public LifePanel(GridFactory factory) {

        super(factory);
        change = new JButton("RUN1");
        change.addActionListener(this);
        ControlPanel.add(change);
        change = new JButton("RUN50");
        change.addActionListener(this);
        ControlPanel.add(change);
        this.display();
    }


    public static void main(String[] args) {
        GridFactory factory = new LifeFactory();
        GridPanel panel = new LifePanel((LifeFactory)factory);
        panel.display();
        System.out.println("panel");
    }
}
