package com.company.ui.menu;

import com.company.structures.FigureList;
import com.company.figures.Parallelogram;
import com.company.figures.Point;
import com.company.painting.ParallelogramPainter;

public class MenuFigureItemParallelogram extends MenuFigureItemListener {

    @Override
    public void buttonListener(){
        try {
            FigureList.add(new ParallelogramPainter(), new Parallelogram(new Point(Integer.parseInt(textFields.get(0).getText())
                    , Integer.parseInt(textFields.get(1).getText())),
                    Integer.parseInt(textFields.get(2).getText()), Integer.parseInt(textFields.get(3).getText()), Double.parseDouble(textFields.get(4).getText())));
            f.setVisible(false);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            f.setVisible(false);
        }
    }
}
