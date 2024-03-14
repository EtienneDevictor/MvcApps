package ca;

import javax.swing.*;

import mvc.*;
import java.awt.*;

public class GridView  extends View {

    private CellView cellViews[][];


    public GridView(Model model) {
        super(model);

        this.setLayout((new GridLayout(((Grid)model).dim, ((Grid)model).dim)));

        for (int row = 0; row < ((Grid)model).dim; row++) {
            for (int col = 0; col < ((Grid)model).dim; col++) {
                CellView cell = new CellView(((Grid)model).getCell(row, col));
                cellViews[row][col] = cell;
                add(cell);
            }
        }
    }

    //shu
    public void update(String msg, Object oldState, Object newState) {
        for (int row = 0; row < ((Grid)model).getDim(); row++) {
            for (int col = 0; col < ((Grid)model).getDim(); col++) {
                CellView cellView = cellViews[row][col];
                Cell cell = ((Grid)model).getCell(row, col);
                //apparences
                cellView.setBackground(cell.getColor());
                cellView.setText(Integer.toString(cell.getStatus()));

            }
    }

    public void paintComponent() {

    }

}