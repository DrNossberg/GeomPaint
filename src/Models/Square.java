package Models;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.lang.Math;

public class Square extends ShapeGeom {
    protected final Rectangle rect;

    public Square(ArrayList<Point> points) {
        this(points.get(0), points.get(1));
    }

    public Square(Point a, Point b) {
        super(new ArrayList<Point>());
        Point topLeft  = new Point( (int) Math.min(a.getX(), b.getX()),
                                    (int) Math.min(a.getY(), b.getY()));
        Point downRight = new Point((int) Math.max(a.getX(), b.getX()),
                                    (int) Math.max(a.getY(), b.getY()));
        super.pointMemo.add(topLeft);
        super.pointMemo.add(new Point(downRight.x, topLeft.y));
        super.pointMemo.add(downRight);
        super.pointMemo.add(new Point(topLeft.x, downRight.y));

        this.rect = new Rectangle (
                topLeft.x, topLeft.y,
                downRight.x - topLeft.x,
                downRight.y - topLeft.y);
        this.showedMemo = Arrays.asList(true, false, true, false);
    }

    @Override
    public void modifyShape() {

    }
    // public void fill(Color c){}

    @Override
    public void draw(Graphics g) {
        g.setColor(this.borderColor);
        g.drawRect((int) this.rect.getX(), (int) this.rect.getY(),
            (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    public boolean intersects(Rectangle r) {
        //possibility to overload contain here
        return (this.rect.intersects(r) && !this.rect.contains(r));
    }

    public String toString() {
        return("["+ this.rect.getX() + ", " + 
                    this.rect.getY() + "] w:" + 
                    this.rect.getWidth() + " h: " + 
                    this.rect.getHeight());
    }
}
