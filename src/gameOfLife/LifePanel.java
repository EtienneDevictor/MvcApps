package gameOfLife;

import ca.Grid;
import ca.GridFactory;
import ca.GridPanel;
import mvc.AppFactory;
import mvc.AppPanel;
import stopLight.StoplightFactory;
import stopLight.StoplightPanel;

import javax.swing.*;
import java.awt.*;

public class LifePanel extends GridPanel {

    private JButton change;
    public LifePanel(GridFactory factory) {
        super(factory);
        this.setLayout((new GridLayout(1, 2)));
        //this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        change = new JButton("RUN1");
        change.addActionListener(this);
        ControlPanel.add(change);
        change = new JButton("RUN50");
        change.addActionListener(this);
        ControlPanel.add(change);
        change = new JButton("POPULATE");
        change.addActionListener(this);
        ControlPanel.add(change);
        change = new JButton("CLEAR");
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
