package Controllers;

import Models.*;
import Models.Square;
import Models.ShapeGeom;
import Models.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;



public class CanvasController extends MouseAdapter implements MouseListener, MouseMotionListener {
    private final ArrayList<Point> points = new ArrayList<>();
    private final Mediator m;
    private ShapeGeom shape;
    private ShapeType shapeType = ShapeType.RECTANGLE;
    private boolean finished = true;

    public CanvasController(Mediator m) {
        super();
        this.m = m;

    }

    public void mouseMoved(MouseEvent e) {
        if (!this.finished && shapeType == ShapeType.RECTANGLE) {
            System.out.println("here too");
            m.setSelectedShape(new Square(points.get(0), e.getPoint()));
        }
        // System.out.println("ladz!");

    //     // repaint();
    }

    public void mouseReleased(MouseEvent e) {
        // System.out.println("fezfs");
    }

    public void mouseDragged(MouseEvent e) {
        // System.out.println("hereqfefe");
    }

    public void mousePressed(MouseEvent e) {
        if (!SwingUtilities.isLeftMouseButton(e))
            return;
        this.points.add(new Point(e.getX(), e.getY()));
        this.finished = false;
        if (this.points.size() == this.shapeType.getMaxMemoPoint()) {
        System.out.println("Points ! : " + points.get(0) + " , " + points.get(1));
            this.m.addShape(new Square(points.get(0), points.get(1)));
            this.points.clear();
            this.finished = true;
        }
    }

    public Mediator getMediator() {
        return (this.m);
    }
}