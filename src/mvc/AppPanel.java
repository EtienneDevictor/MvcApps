package mvc;
import stopLight.Stoplight;
import stopLight.StoplightView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppPanel extends JPanel implements ActionListener {
    private Model model;
    private View view;
    private AppFactory app;

    public AppPanel(AppFactory factory) {
        app = factory;
        model = app.makeModel();
        view = app.makeView(model);
        this.setLayout((new GridLayout(1, 2)));
        this.add(view);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setTitle(app.getTitle());
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", app.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", app.getHelp(), this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent ae) {
        String cmmd = ae.getActionCommand();
        try {
            switch (cmmd) {
                case "Change":
                    this.model.changed();
                    break;

                case "Save": {
                    String fName = Utilities.getFileName((String) null, false);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.model);
                    os.close();
                    break;
                }

                case "Open": {

                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        String fName = Utilities.getFileName((String) null, true);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        this.model = (Model) is.readObject();
                        view = new View(this.model);
                        is.close();
                    }

                    break;

                }

                case "New": {
                    this.model = app.makeModel();
                    view = new View(this.model);
                    break;
                }

                case "Quit": {
                    System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform(app.about());
                    break;
                }

                case "Help": {
                    String[] cmmds = app.getHelp();
                    Utilities.inform(cmmds);
                    break;

                }

                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    protected void handleException(Exception e) {
        Utilities.error(e);
    }

    public void display() {

    }

    protected class ControlPanel extends JPanel {

         static JPanel p = new JPanel();
        public ControlPanel() {
            setBackground(Color.PINK);
            JButton change = new JButton("Change");
            change.addActionListener(AppPanel.this);
            p.add(change);
            //  add(p);
        }

        public static void add(JButton button) {
            p.add(button);
        }
    }

   // public static void main(String[] args) {
    //    AppPanel app = new AppPanel();
    //}
}