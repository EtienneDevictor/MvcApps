package gameOfLife;

import ca.Cell;
import java.awt.Color;
import java.util.Iterator;

import java.awt.*;

public class Agent extends Cell {

    private int status;
    private int ambience = 8;

    public Agent() {
        this(true);
    }

    public Agent(boolean unalive) //not sure
    {
        if (unalive) {
            status = 0;
        } else {
            status = 1;
        }
        ambience = 0;
    }


    @Override
    //The grid’s observe method calls the observe method of each cell,
    // then notifies subscribers. Similarly the interact method calls the interact
    // methods of each cell and the update method calls the update method of each cell.
    public void observe() {
        int sum = 0;
        Iterator<Cell> it = super.neighbors.iterator();
        while (it.hasNext()) {
            Cell c = it.next();
            if (c.getStatus() == 1)
                sum++;
        }
        ambience = sum;

    }

    @Override //each cell interacts with a random neighbor through (bargaining, fighting, playing a game, etc)
    public void interact() {
        //none
    }

    @Override
    public void update() {
        if (status == 1) {
            if (Society.death.contains(ambience))
                status = 0;
        } else {
            if (Society.rebirth.contains(ambience))
                status = 1;
        }
    }

    @Override
    public void nextState() {
        if (status == 0) {
            status = 1;
        } else {
            status = 0;
        }

        public void observe() {
            int count = 0;
            while (this.neighbors.iterator().hasNext()) {
                Cell hi = this.neighbors.iterator().next();
                if (hi.getStatus() == 1) {
                    count++;
                }
            }
            this.ambience = count;
        }

        @Override
        public void interact ()
        {
            //none

        }

        @Override
        public void update () {
            if (this.status == 0) {
                if (this.ambience == 3) {
                    this.status = 1;
                }
            } else if (this.ambience != 2 && this.ambience != 3) {
                this.status = 0;
            }
        }


        @Override
        public void nextState () {
            if (this.status == 0) {
                this.status = 1;
                this.color = Color.GREEN;
            } else {
                this.status = 0;
                this.color = Color.RED;
            }
        }

        public void reset(boolean randomly)
        {
            if (!randomly) {
                this.status = 0;
                this.ambience = 0;
            } else
                this.status = 1;
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
        @Override
        public int getAmbience()
            {
            return ambience;
            }

    }

}
