package Shapes;

import java.awt.*;

public abstract class Point {
    protected int[] xCoord;
    protected int[] yCoord;
    protected Graphics brush;

    public int[] getxCoord() {
        return xCoord;
    }

    public void setxCoord(int[] xCoord) {
        this.xCoord = xCoord;
    }

    public int[] getyCoord() {
        return yCoord;
    }

    public void setyCoord(int[] yCoord) {
        this.yCoord = yCoord;
    }

    public int getLeftTopX() {
        return xCoord[0];
    }

}
