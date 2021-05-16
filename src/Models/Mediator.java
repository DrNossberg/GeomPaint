package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;


@SuppressWarnings("deprecation")
public class Mediator extends Observable { 
    /* DEV : 
        le role du Mediator n'est pas de créer des shapes !
        on verra pour une Factory, cas échéant une classe dédiée
    */

    private ShapeGeom selectedShape;
    private final ArrayList<ShapeGeom> shapes;

    public Mediator() {
        this.selectedShape = null;
        this.shapes = new ArrayList<>();
    }

    public void setSelectedShape(ShapeGeom shape) {
        this.selectedShape = shape;
        setChanged();
        notifyObservers();
    }

    public ShapeGeom getSelectedShape() {
        return (this.selectedShape);
    }

    public void addShape() {
        this.addShape(this.selectedShape);
    }

    public void addShape(ShapeGeom shape) {
        this.shapes.add(0, shape);
        this.selectedShape = shape;
        setChanged();
        notifyObservers();
    }

    public boolean shapeIntersect(MouseEvent e) {
        Rectangle click = new Rectangle(e.getX() - 1, e.getY() - 1, 30, 30);

        for (ShapeGeom shape : this.shapes) {
            if (shape.intersects(click)) {
                this.selectedShape = shape;
                return (true);
            }
        }
        return (false);
    }


    public void translate(int offset_x, int offset_y) {
        this.selectedShape.translate(offset_x, offset_y);
    }

    public void draw(Graphics g) {
        if (this.selectedShape != null)
            this.selectedShape.draw(g);
        for (ShapeGeom shape : this.shapes)
            shape.draw(g);
    }
}
