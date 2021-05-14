package Controllers;

import Models.*;
import Models.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CanvasController extends MouseAdapter {
    private final Mediator m;
    private final ArrayList<Point> points = new ArrayList<>();

    public CanvasController(Mediator m) {
        super();
        this.m = m;
    }

    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            points.add(new Point(e.getX(), e.getY()));

            if (this.points.size() == 2) {
                this.m.addShape(new Rectangle(points.get(0), points.get(1)));
                this.points.clear();
            }
        }

    }

    public Mediator getMediator() {
        return this.m;
    }
}