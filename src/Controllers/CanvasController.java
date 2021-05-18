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
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


import Models.*;
import Models.Square;
import Models.ShapeGeom;
import Models.ShapeType;

public class CanvasController extends MouseAdapter implements MouseListener, MouseMotionListener {
    private final Mediator m;
    private ArrayList<Point> points = new ArrayList<>();
    private ShapeGeom shape;
    private ShapeType shapeType = ShapeType.RECTANGLE;
    private boolean finished = true;

    public CanvasController(Mediator m) {
        super();
        this.m = m;
    }

    public void mouseMoved(MouseEvent e) {
        if (!this.finished && shapeType == ShapeType.RECTANGLE) {
            m.setSelectedShape(new Square(points.get(0), e.getPoint()));
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
        // if (finished && )
        if (finished && this.m.shapeIntersect(e)) {
            this.m.update();
            return;
        }
        this.points.add(new Point(e.getX(), e.getY()));
        this.finished = false;
        if (this.points.size() == this.shapeType.getMaxMemoPoint()) {
            if (this.shapeType == ShapeType.RECTANGLE)
                this.m.addShape(new Square(points.get(0), points.get(1)));
            this.points.clear();
            this.finished = true;
            this.shape = null;
            this.shapeType = ShapeType.NONE;
        }
    }

    public Mediator getMediator() {
        return (this.m);
    }
}