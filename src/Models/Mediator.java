package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Mediator extends Observable {
    private final ShapeGeom selectedFigure = null;
    private final ArrayList<ShapeGeom> figures;

    public Mediator() {
        this.figures = new ArrayList<>();
    }

    public void addShape(ShapeGeom rect) {
        this.figures.add(rect);
        setChanged();
        notifyObservers();
    }

    public void shapeSelect(MouseEvent e) {
        this.selectedFigure = null;
        for (ShapeGeom shape : this.figures) {
            if (shape.contains(e.getX(), e.getY())) {
                System.out.println("contains ! ");
                this.selectedFigure = shape;
                break;
            }
        }
    }

    public void translate(int offset_x, int offset_y) {
        this.selectedFigure.translate(offset_x, offset_y);
    }

    public void draw(Graphics g) {
        for (ShapeGeom shape : figures)
            shape.draw(g);
    }
}
