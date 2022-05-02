package com.company.painting;

import com.company.figures.Figure;
import com.company.figures.Oval;
import com.company.figures.Parallelogram;

import java.awt.*;

//Common class for all shapes
public abstract class FigurePainter {

    public abstract void draw(Graphics graphics, Figure figure);

}
