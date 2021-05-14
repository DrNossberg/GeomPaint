package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Mediator extends Observable {
    private final ArrayList<ShapeGeom> figures;

    public Mediator() {
        this.figures = new ArrayList<>();
    }

    public void addShape(ShapeGeom rect) {
        this.figures.add(rect);

        setChanged();
        notifyObservers();
    }

    public void draw(Graphics g) {
        for (ShapeGeom shape : figures)
            shape.draw(g);
    }
}
