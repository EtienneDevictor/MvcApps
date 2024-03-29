package gameOfLife;

import ca.Cell;
import mvc.Subscriber;

import java.awt.Color;
import java.util.Iterator;

import java.awt.*;
import java.util.Random;

public class Agent extends Cell implements Subscriber {

    private int ambience;

    public Agent(Society society) {
        status = 1;
        observe();
    }

    @Override
    //The grid’s observe method calls the observe method of each cell,
    // then notifies subscribers. Similarly the interact method calls the interact
    // methods of each cell and the update method calls the update method of each cell.
    public void observe() {
        this.ambience = 0;
        for  (Cell c: neighbors) {
            if (c.getStatus() == 1)
                ambience++;
        }
    }

    @Override
    public int getValue() {
        observe();
        return ambience;
    }


    @Override //each cell interacts with a random neighbor through (bargaining, fighting, playing a game, etc)
    public void interact() {
        //none
    }

    @Override
    public void update(String msq, Object object1, Object object2) {
    }
    @Override
    public void update() {
        observe();
        // System.out.println("Agent update method called");
        System.out.printf("ambience: %d - status: %d", ambience, status);
        if (Society.death.contains(ambience)) {
            status = 0;
            color = Color.RED;
        } else if (Society.rebirth.contains(ambience)) {
            status = 1;
            color = Color.GREEN;
        }
        System.out.printf(" - new status: %d\n", status);
    }
    @Override
    public void nextState () {
        if (this.color == color.GREEN) {
            this.color = color.RED;
            status = 0;
        } else {
            this.color = color.GREEN;
            status = 1;
        }
    }

    public void reset(boolean randomly)
    {
        Random random = new Random();
        status =  randomly ? random.nextInt(2) : 1;
    }
    @Override
    public Color getColor()
    {
        // 0 = dead, 1 = alive
        if (this.status == 0)
        {
            return new Color(255, 0, 0);
        }
        else
        {
            return new Color(0, 255, 0);
        }
    }
}

