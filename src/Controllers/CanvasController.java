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
import java.awt.*;
// import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import java.util.Arrays;


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

    public CanvasController(Mediator m) {
        super();
        this.m = m;
    }

    public void mouseMoved(MouseEvent e) {
        if (!this.finished) {
            ArrayList<Point> tmp = new ArrayList<>(points);
            tmp.add(e.getPoint());

            m.createShape(this.shapeType, tmp);
        }
        if (this.curr != null) {
            this.curr.setLocation(e.getPoint());
            this.m.getSelectedShape().updateShape();
            this.m.update();
        }
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
        if (finished && this.m.getSelectedShape() != null) { // Selection of a shape
            if (this.curr == null)
                this.curr = this.m.memoIntersect(e);
            else
                this.curr = null;
        }
        if (finished && this.m.shapeIntersect(e)) {
            this.m.update();
            return;
        }

        // Drawing of a shape
        this.points.add(new Point(e.getX(), e.getY()));
        this.finished = false;
        if (this.shapeType != this.shapeType.NONE && figureDone(e)) {
            // System.out.println("Points ! : " + points.get(0) + " , " + points.get(1));
            this.m.addShape(this.shapeType, points);
            this.points.clear();
            this.finished = true;
            this.shapeType = ShapeType.NONE;
        }
    }

    public boolean figureDone(MouseEvent e) {
        if (this.shapeType == ShapeType.POLYGONE) {
            int margin = 5;
            return (this.points.size() > 1 &&
                    e.getX() >= (this.points.get(0).getX() - margin)  &&
                    e.getX() <= (this.points.get(0).getX() + margin) &&
                    e.getY() >= (this.points.get(0).getY()) - margin &&
                    e.getY() <= (this.points.get(0).getY() + margin));
        }
        return (this.points.size() == this.shapeType.getMaxMemoPoint());
    }

    public Mediator getMediator() {
        return (this.m);
    }


    public void initiateShape(ShapeType type) {
        this.points.clear();
        this.shapeType = type;
    }


}