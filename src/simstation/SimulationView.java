package simstation;

import ca.CellView;
import ca.Grid;
import mvc.Model;
import mvc.View;
import stopLight.StopLightShape;
import stopLight.Stoplight;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;



public class SimulationView extends View {
    int dotSize = 5;
    public SimulationView(Model model) {

        super(model);
        setSize(500, 500);
        setBackground(Color.LIGHT_GRAY);
        repaint();
    }

    public void paintComponent(Graphics gc) {


        System.out.println("hits");
        super.paintComponent(gc);
        for (int count = 0; count < ((Simulation)model).agents.size(); count ++) {
            Agent temp = ((Simulation)model).agents.get(count);
            gc.fillOval(temp.xc - dotSize / 2, temp.yx - dotSize / 2, dotSize, dotSize);
        }

    }

}
