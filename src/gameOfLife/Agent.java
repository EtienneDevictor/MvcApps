package gameOfLife;

import ca.Cell;

import java.awt.*;

public class Agent extends Cell {

    private int status = 0;
    private int ambience = 8;
    public void Cell() {

    }


    @Override
    public void observe() {
        int count = 0;
        while(this.neighbors.iterator().hasNext())
        {
            Cell hi = this.neighbors.iterator().next();
            if (hi.getStatus() == 1) { count ++;}
        }
        this.ambience = count;
    }

    @Override
    public void interact() {


    }

    @Override
    public void update() {
        if (this.status == 0) {
            if(this.ambience == 3) {this.status = 1;}
        }
        else if (this.ambience != 2 && this.ambience != 3) {this.status = 0;}
        }


    @Override
    public void nextState() {
        if (this.status == 0) { this.status = 1; this.color = Color.GREEN;}
        else { this.status = 0; this.color = Color.RED;}
    }

    @Override
    public void reset(boolean randomly) {

        if (!randomly) {this.status = 0;}
        else {this.status = 1;}
    }
}
