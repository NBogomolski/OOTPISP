package com.company.figures;

import com.company.painting.ParallelogramPainter;

public class Parallelogram extends Figure{

    public Point pos;
    public int width;
    public int height;
    public double angle;

    public Parallelogram(Point pos, int width, int height, double angle) {
        this.pos = pos;
        this.width = width;
        this.height = height;
        this.angle = angle;
    }

}
