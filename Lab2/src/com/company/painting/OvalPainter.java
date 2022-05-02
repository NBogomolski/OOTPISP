package com.company.painting;

import com.company.figures.Figure;
import com.company.figures.Oval;

import java.awt.*;

//For oval & circle
public class OvalPainter extends FigurePainter{

    @Override
    public void draw(Graphics graphics, Figure figure) {
        Oval oval;
        try {
            oval = (Oval) figure;
        }
        catch (ClassCastException e){
            System.out.println("Error casting the shape into oval");
            return;
        }

        graphics.drawOval(oval.pos.x,oval.pos.y, oval.width, oval.height);
    }
}
