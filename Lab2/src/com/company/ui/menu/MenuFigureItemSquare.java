package com.company.ui.menu;

import com.company.structures.FigureList;
import com.company.figures.Point;
import com.company.figures.Square;
import com.company.painting.ParallelogramPainter;

public class MenuFigureItemSquare extends MenuFigureItemListener{

    @Override
    public void buttonListener(){
        try {
            FigureList.add(new ParallelogramPainter(), new Square(new Point(Integer.parseInt(textFields.get(0).getText()), Integer.parseInt(textFields.get(1).getText())),
                    Integer.parseInt(textFields.get(2).getText())));
            f.setVisible(false);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            f.setVisible(false);
        }
    }
}
