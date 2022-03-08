public class Section extends Point {
    private Point start;
    private Point end;

    Section(int xStart, int yStart, int xEnd, int yEnd) {
//        this();
        this.start = new Point(xStart, xEnd);
    }

    Section(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
}
