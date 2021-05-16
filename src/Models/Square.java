package Models;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.lang.Math;

public class Square extends ShapeGeom {
    protected final List<Boolean> showedMemo = Arrays.asList(true, false, true, false);
     // ArrayList<Boolean>  = new ArrayList<>(Arrays.asList());
    public int maxMemoPoint;

    public Square(Point a, Point b) {
        super.pointMemo = new ArrayList<>(); //(Point) a, (Point) b);
        super.pointMemo.add(a);
        super.pointMemo.add(b);
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
                Math.abs(this.pointMemo.get(1).x - x),
                Math.abs(this.pointMemo.get(1).y - y));
    }
}
