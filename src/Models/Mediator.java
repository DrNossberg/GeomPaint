package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
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

    public void addShape() {
        this.addShape(this.selectedShape);
    }

    public void addShape(ShapeGeom shape) {
        this.shapes.add(0, shape);
        this.selectedShape = shape;
        setChanged();
        notifyObservers();
    }

    public void shapeSelect(MouseEvent e) {
        this.selectedShape = null;
        for (ShapeGeom shape : this.shapes)
            if (shape.contains(e.getX(), e.getY())) {
                System.out.println("contains ! ");
                this.selectedShape = shape;
                break;
            }
    }

    public void translate(int offset_x, int offset_y) {
        this.selectedShape.translate(offset_x, offset_y);
    }

    public void draw(Graphics g) {
        if (this.selectedShape != null) {
            System.out.println("printing ?");
            this.selectedShape.draw(g);
        }
        for (ShapeGeom shape : this.shapes)
            shape.draw(g);
    }
}
