package Models.Shapes;

import Models.Mediator;
import Models.ShapeGeom;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Triangle extends Polygon {
    public Triangle(Mediator m, List<Point> points, Color c) {
        super(m, points, c);
        this.showedMemo = new ArrayList<>();
        for (Point p: points)
            this.showedMemo.add(true);
        super.xpoints = new int[this.pointMemo.size()];
        super.ypoints = new int[this.pointMemo.size()];
        for (int i = 0; i < this.pointMemo.size(); i++) {
            super.xpoints[i] = (int) this.pointMemo.get(i).getX();
            super.ypoints[i] = (int) this.pointMemo.get(i).getY();
        }
    }
}
