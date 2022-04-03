package point;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void printCoordinates() {
        System.out.println("Point(" + x + ", " + y+")");
    }
}

