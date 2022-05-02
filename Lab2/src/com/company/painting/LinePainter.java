package com.company.painting;

import com.company.figures.Figure;
import com.company.figures.Line;

import java.awt.*;

public class LinePainter extends FigurePainter {

    @Override
    public void draw(Graphics graphics, Figure figure) {
        Line line;
        try{
            line = (Line) figure;
        }catch (ClassCastException e){
            System.out.println("Can't cast the shape to Line");
            return;
        }

        graphics.drawLine(line.point1.x,line.point1.y,line.point2.x,line.point2.y);
    }
}
