package com.company.painting;

import com.company.figures.Figure;
import com.company.figures.Parallelogram;
import com.company.figures.Point;

import java.awt.*;

//For Square, Rectangle, Rhombus & Parallelogram
public class ParallelogramPainter extends FigurePainter{

    @Override
    public void draw(Graphics graphics, Figure figure) {
        Parallelogram paral;
        try{
            paral = (Parallelogram) figure;
        }
        catch (ClassCastException e){
            System.out.println("Can't cast the shape in parallelogram");
            return;
        }
        Point point1 = paral.pos;
        Point point2 = new Point((paral.pos.x + paral.width), point1.y);
        Point point3 = new Point((int) (paral.pos.x + paral.height*Math.cos(paral.angle)),
                (int)(paral.pos.y + paral.height*Math.sin(paral.angle)));
        Point point4 = new Point(point3.x + paral.width, point3.y);

        graphics.drawPolygon(new int[]{point1.x, point2.x, point4.x, point3.x},
                             new int[]{point1.y, point2.y, point4.y, point3.y},
                            4);
    }
}
