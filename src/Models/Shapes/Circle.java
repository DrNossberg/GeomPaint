package Models.Shapes;

import Models.Mediator;
import Models.ShapeGeom;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Circle extends ShapeGeom {
    private Ellipse2D.Double ellipse;

    public Circle(Mediator m, List<Point> points, Color c) {
        super(m, new ArrayList<>(), c);
        Point a = points.get(0);
        Point b = (points.size() > 1) ? points.get(1) : a;

        this.pointMemo.add(a);
        this.pointMemo.add(b);
        this.showedMemo = Arrays.asList(true, true);
        this.ellipse = new Ellipse2D.Double();
        updateShape();
    }

    @Override
    public void updateShape() {
        double radius = Math.sqrt(Math.pow(super.pointMemo.get(0).getX() - super.pointMemo.get(1).getX(), 2) +
                                     Math.pow(super.pointMemo.get(0).getY() - super.pointMemo.get(1).getY(), 2));
        this.ellipse.setFrame(super.pointMemo.get(0).getX() - radius,
            super.pointMemo.get(0).getY() - radius, radius * 2, radius * 2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.borderColor);
        g.drawOval((int) this.ellipse.getX(), (int) this.ellipse.getY(), (int) this.ellipse.getWidth(), (int) this.ellipse.getWidth());
        if (color != null) {
            g.setColor(this.color);
            g.fillOval((int) this.ellipse.getX() - 1, (int) this.ellipse.getY() - 1, (int) this.ellipse.getWidth() + 1, (int) this.ellipse.getHeight() + 1);
        }
    }

    @Override
    public boolean intersects(Rectangle r) {
        return (this.ellipse.intersects(r.getX(), r.getY(), r.getWidth(), r.getHeight()));
    }
}
