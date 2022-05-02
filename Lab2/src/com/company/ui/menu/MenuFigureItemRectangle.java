package com.company.ui.menu;

import com.company.structures.FigureList;
import com.company.figures.Point;
import com.company.figures.Rectangle;
import com.company.painting.ParallelogramPainter;

public class MenuFigureItemRectangle extends MenuFigureItemListener{

    @Override
    public void buttonListener(){
        try {
            FigureList.add(new ParallelogramPainter(), new Rectangle(new Point(Integer.parseInt(textFields.get(0).getText()), Integer.parseInt(textFields.get(1).getText())),
                    Integer.parseInt(textFields.get(2).getText()), Integer.parseInt(textFields.get(3).getText())));
            f.setVisible(false);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            f.setVisible(false);
        }
    }
}
