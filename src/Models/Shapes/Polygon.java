package Models.Shapes;

import Models.Mediator;
import Models.ShapeGeom;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Polygon extends ShapeGeom {

    public Polygon(Mediator m, List<Point> points) {
        super(m, points);
        this.showedMemo = new ArrayList<>();
        for (Point p: points)
            this.showedMemo.add(true);
        this.showedMemo.set(this.showedMemo.size() - 1, false);
        super.xpoints = new int[this.pointMemo.size()];
        super.ypoints = new int[this.pointMemo.size()];
    }

    @Override
    public void updateShape() {
        for (int i = 0; i < this.pointMemo.size(); i++) {
            super.xpoints[i] = (int) this.pointMemo.get(i).getX();
            super.ypoints[i] = (int) this.pointMemo.get(i).getY();
            super.addPoint(super.xpoints[i], super.ypoints[i]);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.borderColor);
        g.drawPolygon(super.xpoints, super.ypoints, this.pointMemo.size());

        if (this.color != null) {
            g.setColor(this.color);

            int[] xpointsInt = new int[super.xpoints.length];
            int[] ypointsInt = new int[super.ypoints.length];

            for (int i = 0; i < super.xpoints.length; i++) {
                xpointsInt[i] = super.xpoints[i] + 1;
                ypointsInt[i] = super.ypoints[i] + 1;
            }

            g.fillPolygon(xpointsInt, ypointsInt, this.pointMemo.size());
        }

    }

    @Override
    public boolean intersects(Rectangle r) {
        System.out.println(super.getBounds());
        return (super.intersects(r.getX(), r.getY(), r.getWidth(), r.getHeight()));
    }
}
