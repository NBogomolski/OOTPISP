package com.company.ui.menu;

import com.company.structures.FigureList;
import com.company.figures.Point;
import com.company.figures.Rhombus;
import com.company.painting.ParallelogramPainter;

public class MenuFigureItemRhombus extends MenuFigureItemListener {

    @Override
    public void buttonListener() {
        FigureList.add(new ParallelogramPainter(), new Rhombus(new Point(Integer.parseInt(textFields.get(0).getText()),
                Integer.parseInt(textFields.get(1).getText())),
                Integer.parseInt(textFields.get(2).getText()),
                Double.parseDouble(textFields.get(3).getText())));
        f.setVisible(false);
    }
}
