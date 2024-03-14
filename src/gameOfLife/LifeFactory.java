package gameOfLife;

import ca.*;
import mvc.Model;

public class LifeFactory extends GridFactory {

    @Override
    public Model makeModel() {
        return new LifeGrid();
    }

    @Override
    public String getTitle() {
        return "Game of Life";
    }
}
