package ca;

import mvc.*;
import stopLight.ChangeCommand;

public class GridFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new Grid() {
            @Override
            public Cell makeCell(boolean uniform) {
                return null;
            }
        };
    }

    @Override
    public View makeView(Model m) {
        return new GridView((Grid)m);
    }

    @Override
    public String getTitle() {
        return "CA Model";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Creates a grid of clickable cells which different states"};
    }

    @Override
    public String about() {
        return "CA Model Version 1.0 ";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"RUN1", "RUN50", "POPULATE", "CLEAR"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "RUN1")
            return new RunCommand(model);
        else if (type == "RUN50")
            return new RunCommand(model);
        else if (type == "POPULATE")
            return new PopulateCommand(model);
        else if (type == "CLEAR")
            return new ClearCommand(model);
        return null;
    }
}