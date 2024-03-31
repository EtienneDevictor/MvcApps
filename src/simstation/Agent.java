package simstation;

import mvc.Model;
import mvc.Utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.awt.*;
import java.util.Iterator;

public class Agent implements Serializable, Runnable {

    private String name;
    protected Header heading;
    private int xc;
    private int yx;
    private boolean suspended = false;
    private boolean stopped = false;
    protected transient Thread thread;
    @Override
    public void run() {

    }

    public void start() {

    }

    public void suspend() {

    }

    public void resume() {

    }

    public void stop() {

    }

    public void update() {

    }

    public void move(int steps) {

    }

    protected static class Header {

        int direction;
        public Header() {
            int direction = 0;
        }

        public void random() {
            direction = Utilities.rng.nextInt(4);
        }
    }
}
