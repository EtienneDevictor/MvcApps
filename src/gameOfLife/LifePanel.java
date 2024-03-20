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


    public LifePanel(GridFactory factory) {
        super(factory);
        this.display();
    }


    public static void main(String[] args) {
        GridFactory factory = new LifeFactory();
        GridPanel panel = new LifePanel(factory);
        panel.display();
        System.out.println("panel");
    }
}
