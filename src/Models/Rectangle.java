package Models;

import java.awt.*;
import java.util.ArrayList;

public class Rectangle extends ShapeGeom{

    public Rectangle(Point a, Point b) {
        super.pointMemo = new ArrayList<>();
        this.pointMemo.add(a);
        this.pointMemo.add(b);
    }

    @Override
    public void colorChange(Color c) {

    }

    @Override
    public void modifyShape() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        int x = this.pointMemo.get(0).x;
        int y = this.pointMemo.get(0).y;
        g.drawRect(x, y,
                this.pointMemo.get(1).x - x,
                this.pointMemo.get(1).y - y);
    }
}
