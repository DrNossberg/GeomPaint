package Models.Shapes;

import Models.Mediator;
import Models.ShapeGeom;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Circle extends ShapeGeom {
    public Circle(Mediator m, List<Point> points, Color c) {
        super(m, new ArrayList<>(), c);
        this.pointMemo.add(points.get(0));
        if (points.size() > 1)
            this.pointMemo.add(points.get(1));
        else
            this.pointMemo.add(points.get(0));
        this.showedMemo = Arrays.asList(true, true);

        updateShape();
    }

    @Override
    public void updateShape() {
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.borderColor);
        int radius = (int) Math.sqrt(Math.pow(super.pointMemo.get(0).getX() - super.pointMemo.get(1).getX(),2) +
                                     Math.pow(super.pointMemo.get(0).getY() - super.pointMemo.get(1).getY(),2));
        Point topLeft = new Point(
                (int) (super.pointMemo.get(0).getX() - radius),
                (int) (super.pointMemo.get(0).getY() - radius));

        g.drawOval((int) topLeft.getX(), (int) topLeft.getY(), 2 * radius,  2 * radius);

        if (color != null) {
            g.setColor(this.color);
            g.fillOval((int) topLeft.getX() + 1, (int) topLeft.getY() + 1, 2 * (radius - 1), 2 * (radius - 1));
        }
    }

    @Override
    public boolean intersects(Rectangle r) {
        return (super.intersects((Rectangle2D) r) && super.contains(r));
    }
}
