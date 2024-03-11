package mvc;

public class Command {

    protected Model model;
    public Command(Model model) {
        this.model = model;
    }
    public void execute() {
        System.out.println("reached");
        model.changed();
    }
}
