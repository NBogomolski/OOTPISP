package com.company.ui.menu;

import com.company.structures.FigureList;
import com.company.figures.Line;
import com.company.figures.Point;
import com.company.painting.LinePainter;

public class MenuFigureItemLine extends MenuFigureItemListener {

    @Override
    public void buttonListener() {
        try {
            FigureList.add(new LinePainter(), new Line(new Point(Integer.parseInt(textFields.get(0).getText()), Integer.parseInt(textFields.get(1).getText())),
                    new Point(Integer.parseInt(textFields.get(2).getText()), Integer.parseInt(textFields.get(3).getText()))));
            f.setVisible(false);
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
            f.setVisible(false);
        }
    }
}

