/*
** IUT Nancy-Charlemagne, 2021
** Projet :
**    GeomPaint
** Author :
**    Erin      Bernardoni
**    Antoine   Orion
**    Valentine INGARDIN
**    Maroua    MELKI
** File description :
**    Implementation of the Shape object
*/

package Models;


import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.awt.Polygon;
import java.util.List;


@SuppressWarnings("deprecation")
public abstract class ShapeGeom extends Polygon {
    protected Color borderColor = Color.black;
    protected Color color;
    protected int thickness;
    protected ArrayList<Point> pointMemo;
    protected List<Boolean> showedMemo;
    protected int maxMemoPoint;

    ShapeGeom() {}

    ShapeGeom(ArrayList<Point> points) {
        this.pointMemo = points;
    }

    public void translate(int offset_x, int offest_y) {
        for (Point memo : pointMemo)
            memo.translate(offset_x, offest_y);
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void setBorderColor(Color c) {
        this.borderColor = c;
    }


    public abstract void modifyShape();
    public void addMemoPoint(Point p) {
        this.pointMemo.add(p);
    }

    public ArrayList<Point> getSaisiePoint() {
        ArrayList<Point> tmp = new ArrayList<>();

        for (int i = 0; i < pointMemo.size(); i++)
            if (showedMemo.get(i))
                tmp.add(pointMemo.get(i));
        return (tmp);
    }
    
    public void modifyMemoPoint(int pointIndex, Point nw_coord) {
        if (this.pointMemo.size() < pointIndex)
            return;
        this.pointMemo.set(pointIndex, nw_coord);
    }

    public abstract void draw(Graphics g);
    public abstract boolean intersects(Rectangle r);
}
