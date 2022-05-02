package com.company.figures;

import com.company.painting.OvalPainter;

public class Oval extends Figure{

    public int width;
    public int height;
    public Point pos;


    public Oval(Point pos, int width, int height){
        this.pos = pos;
        this.width = width;
        this.height = height;
    }
}
