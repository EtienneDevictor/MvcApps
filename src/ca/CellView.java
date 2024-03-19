package ca;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
    }

    public CellView() { this(null); }

    @Override
    public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
        myCell.nextState(); // changes the state of myCell
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText("" + myCell.getStatus());
=======
        myCell.nextState();

        // call update needed?
>>>>>>> 4e401a408b3094691a40ece8a255038093ab70d3
    }

    // called by notifySubscribers and GridView.update

    @Override
    public void update(String msg, Object oldState, Object newState) {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getStatus());
        update();
    }

    @Override
    public void update() {
        this.repaint();
    }
}


