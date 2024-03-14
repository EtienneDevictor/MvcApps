package gameOfLife;

import ca.*;
import mvc.Model;

public class LifeFactory extends GridFactory {

    @Override
    public Model makeModel() {
        return new Society();
    }

    @Override
    public String getTitle() {
        return "Game of Life";
    }
}
