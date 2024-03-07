package mvc;
import javax.swing.*;
import stopLight.Stoplight;

public class View extends JPanel implements Subscriber {

    protected Model model;

    public View(Model model){
        this.model = model;
    }

    @Override
    public void update() {
        model.changed();
        model.notifySubscribers();
    }
}
