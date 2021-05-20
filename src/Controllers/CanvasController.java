/*
** IUT Nancy-Charlemagne, 2021
** Projet :
**    Labythin
** Author :
**    Erin      Bernardoni
**    Antoine   Orion
**    Valentine INGARDIN
**    Maroua    MELKI
** File description :
**    
**    
*/

package Controllers;

import javax.swing.*;
import java.awt.Image;
import java.awt.Color;
import java.awt.Point;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.ArrayList;

import Models.*;
import Models.Shapes.Square;
import Models.ShapeGeom;
import Models.ShapeType;

public class CanvasController extends MouseAdapter implements MouseListener, MouseMotionListener {
    private final ArrayList<Point> points = new ArrayList<>();
    private final Mediator m;
    private ShapeType shapeType = ShapeType.NONE;
    private boolean finished = true;
    private Point curr = null;
    private Point prev_pos = null;
    private Color color;

    public CanvasController(Mediator m) {
        super();
        this.m = m;
    }

    public void mouseMoved(MouseEvent e) {
        if (!this.finished) {
            ArrayList<Point> tmp = new ArrayList<>(points);
            tmp.add(e.getPoint());
            if (e.isShiftDown() && this.shapeType == ShapeType.RECTANGLE)
                this.shapeType = ShapeType.SQUARE;
            m.createShape(this.shapeType, tmp, this.color);
        }
        if (this.curr != null) {
            this.curr.setLocation(e.getPoint());
            this.m.getSelectedShape().updateShape();
            this.m.update();
        }
        if (this.shapeType != ShapeType.NONE)
            this.m.setImageCoord(e.getPoint());
    }

    public void mouseReleased(MouseEvent e) {
        // System.out.println("fezfs");
    }

    public void mouseDragged(MouseEvent e) {
        if (this.prev_pos != null && this.curr == null && finished && this.m.shapeIntersect(e)) {
            this.m.translate(e.getX() - (int) prev_pos.getX(),
                e.getY() - (int) prev_pos.getY());
            this.m.getSelectedShape().updateShape();
            this.m.update();
        }
        this.prev_pos = e.getPoint();
    }

    public void mousePressed(MouseEvent e) {
        if (!SwingUtilities.isLeftMouseButton(e))
            return;
        prev_pos = e.getPoint();
        if (finished) { // Selection of a shape
            if (this.m.shapeIntersect(e)) {
                this.curr = (this.curr == null) ? this.m.memoIntersect(e) : null;
            } else
                this.curr = null;
            this.m.update();
        }

        // Drawing of a shape
        if (!this.finished)
            this.points.add(new Point(e.getX(), e.getY()));
        if (this.shapeType != this.shapeType.NONE && figureDone(e)) {
            if (e.isShiftDown() && this.shapeType == ShapeType.RECTANGLE)
                this.shapeType = ShapeType.SQUARE;
            this.m.addShape(this.shapeType, points, this.color);
            this.shapeType = ShapeType.NONE;
            this.finished = true;
            this.points.clear();
            this.m.setImage(null);
        }
    }

    public boolean figureDone(MouseEvent e) {
        if (this.shapeType == ShapeType.POLYGON) {
            int margin = 5;
            boolean ret = this.points.size() > 1 &&
                    e.getX() >= (this.points.get(0).getX() - margin)  &&
                    e.getX() <= (this.points.get(0).getX() + margin) &&
                    e.getY() >= (this.points.get(0).getY()) - margin &&
                    e.getY() <= (this.points.get(0).getY() + margin);
            if (ret)
                this.points.remove(this.points.size() - 1);
            return (ret);
        }
        return (this.points.size() == this.shapeType.getMaxMemoPoint());
    }
// 
    public Mediator getMediator() {
        return (this.m);
    }

    public void initiateShape(ShapeType type, Color c) {
        this.shapeType = type;
        this.points.clear();
        this.finished = false;
        this.color = c;
        try {
            m.setImage((Image) m.getResource(type.toString().toLowerCase() + "_icon"));
            System.out.println(type.toString().toLowerCase() + "_icon");
        } catch (Exception e) {
            System.out.println("error" + "memoPoint");
        }
    }
}