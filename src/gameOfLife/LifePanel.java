package gameOfLife;

import ca.GridFactory;
import ca.GridPanel;
import mvc.AppFactory;
import mvc.AppPanel;
import stopLight.StoplightFactory;
import stopLight.StoplightPanel;

public class LifePanel extends GridPanel {
    public LifePanel(GridFactory factory) {
        super(factory);
    }
    public static void main(String[] args) {
        GridFactory factory = new LifeFactory();
        GridPanel panel = new LifePanel((LifeFactory)factory);
        panel.display();
        System.out.println("panel");
    }
}
