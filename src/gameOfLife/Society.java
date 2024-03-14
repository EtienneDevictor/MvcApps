package gameOfLife;

import ca.Cell;
import ca.Grid;

import java.util.HashSet;
import java.util.Set;

public class Society extends Grid {

    public static Set<Integer> rebirth = new HashSet<Integer>();
    public static Set<Integer> death = new HashSet<Integer>();
    public static int percentAlive = 50;
    @Override
    public Cell makeCell(boolean uniform) {
        return new Agent();
    }

}
