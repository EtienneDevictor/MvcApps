package simstation;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;

public class SimulationPanel extends AppPanel {

    private JButton start;
    private JButton suspend;
    private JButton resume;
    private JButton stop;
    private JButton stats;
    public SimulationPanel(AppFactory factory) {
        super(factory);

        start = new JButton("Change");
        start.addActionListener(this);
        ControlPanel.add(start);
        suspend = new JButton("Change");
        suspend.addActionListener(this);
        ControlPanel.add(suspend);
        resume = new JButton("Change");
        resume.addActionListener(this);
        ControlPanel.add(resume);
        stop = new JButton("Change");
        stop.addActionListener(this);
        ControlPanel.add(stop);
        stats = new JButton("Change");
        stats.addActionListener(this);
        ControlPanel.add(stats);
        this.display();
    }
}
