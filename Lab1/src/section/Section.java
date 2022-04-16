package section;

import point.Point;

public class Section extends Point {
    private Point start;
    private Point end;

    public Section(int x, int y, int xEnd, int yEnd) {
        super(x, y);
    }
}
