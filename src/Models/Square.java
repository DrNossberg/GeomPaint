package Models;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.lang.Math;

public class Square extends ShapeGeom {
    protected final List<Boolean> showedMemo = Arrays.asList(true, false, true, false);
     // ArrayList<Boolean>  = new ArrayList<>(Arrays.asList());

    public Square(ArrayList<Point> points) {
        this(points.get(0), points.get(1));
    }

    public Square(Point a, Point b) {
        super.pointMemo = new ArrayList<>();
        Point topLeft  = new Point( (int) Math.min(a.getX(), b.getX()),
                                    (int) Math.min(a.getY(), b.getY()));
        Point downRight = new Point((int) Math.max(a.getX(), b.getX()),
                                    (int) Math.max(a.getY(), b.getY()));
        System.out.println("TL : " + topLeft.getX() + ", " + topLeft.getY() +
            "DR : " + downRight.getX() + ", " + downRight.getY());
        super.pointMemo.add(topLeft);
        super.pointMemo.add(downRight);
    }

    @Override
    public void modifyShape() {

    }
    // public void fill(Color c){}

    @Override
    public void draw(Graphics g) {
        int x = this.pointMemo.get(0).x;
        int y = this.pointMemo.get(0).y;

        g.setColor(this.borderColor);
        g.drawRect(x, y,
                this.pointMemo.get(1).x - x,
                this.pointMemo.get(1).y - y);
    }
}
