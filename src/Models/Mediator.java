package Models;

import java.awt.*;
import java.util.*;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.List;

import Models.Shapes.Circle;
import Models.Shapes.Polygon;
import Models.Shapes.Square;

@SuppressWarnings("deprecation")
public class Mediator extends Observable {
    private final ArrayList<ShapeGeom> shapes;
    private ShapeGeom selectedShape;
    private AssetLoader loader;
    private Image image = null;
    private Point imageCoord = null;

    public Mediator(AssetLoader loader) {
        this.loader = loader;
        this.selectedShape = null;
        this.shapes = new ArrayList<>();
    }

    public void update() {
        setChanged();
        notifyObservers();
    }

    public void createShape(ShapeType shapetype, List<Point> points, Color color) {
        ShapeGeom shape = switch (shapetype) {
            case NONE       -> null;
            case POLYGON   -> new Polygon(this, points, color);
            case RECTANGLE  -> new Square(this, points, color);
            case SQUARE     -> new Square(this, points, color, true);
            case TRIANGLE   -> new Polygon(this, points, color);
            case CIRCLE     -> new Circle(this, points, color);
        };
        this.selectedShape = shape;
        update();
    }


    public void addShape(ShapeType shapetype, List<Point> points, Color c) {
        createShape(shapetype, points, c);
        if (this.selectedShape != null)
            addShape(this.selectedShape);
        update();
    }

    public ShapeGeom getSelectedShape() {
        return (this.selectedShape);
    }

    public void addShape(ShapeGeom shape) {
        this.shapes.add(0, shape);
        this.selectedShape = shape;
        update();
    }

    public void removeShape() {
        if (this.selectedShape != null) {
            this.shapes.remove(this.selectedShape);
            this.selectedShape = null;
            update();
        }
    }

    public void removeAll() {
        this.shapes.clear();
        this.selectedShape = null;
        update();
    }

    public void bringForward() {
        if (this.selectedShape != null && (this.shapes.indexOf(this.selectedShape) > 0)) {
            Collections.swap(
                    this.shapes,
                    this.shapes.indexOf(this.selectedShape),
                    this.shapes.indexOf(this.selectedShape) - 1);
            update();
        }
    }

    public void sendBackward() {
        if (this.selectedShape != null && (this.shapes.indexOf(this.selectedShape) < this.shapes.size() - 1)) {
            Collections.swap(
                    this.shapes,
                    this.shapes.indexOf(this.selectedShape),
                    this.shapes.indexOf(this.selectedShape) + 1);
            update();
        }
    }


    public boolean shapeIntersect(MouseEvent e) {
        Rectangle click = new Rectangle(e.getX() - 10, e.getY() - 10, 10, 10);

        for (ShapeGeom shape : this.shapes) {
            if (shape.intersects(click)) {
                this.selectedShape = shape;
                return (true);
            }
        }
        this.selectedShape = null;
        return (false);
    }

    public Point memoIntersect(MouseEvent e) {
        Rectangle click = new Rectangle(e.getX() - 10, e.getY() - 10, 10, 10);
        ArrayList<Point> mp;

        if (this.selectedShape == null)
            return (null);
        mp = this.selectedShape.getSaisiePoint();
        for (int i = 0; i < mp.size() ; i++)
            if (click.intersects(new Rectangle ((int) mp.get(i).getX() - 10, (int)  mp.get(i).getY() - 10, 10, 10))) {
                this.selectedShape.setSelectedMemo(i);
                return (mp.get(i));
            }
        return (null);
    }

    public void translate(int offset_x, int offset_y) {
        this.selectedShape.translate(offset_x, offset_y);
    }

    public void draw(Graphics g) {
        if (image != null && this.imageCoord != null)
            g.drawImage(this.image, (int) this.imageCoord.getX() + 10,
                (int) this.imageCoord.getY() + 10, null);
        for (int i = this.shapes.size()-1; i >= 0; i--)
            shapes.get(i).draw(g);

        if (this.selectedShape != null) {
            this.selectedShape.draw(g);
            this.selectedShape.drawMemo(g);
        }
    }

    public Object getResource(String resource) {
        return (this.loader.get(resource));
    }

    public void setImage(Image i) {
        this.image = i;
    }

    public void setImageCoord(Point coord) {
        this.imageCoord = coord;
    }
}
