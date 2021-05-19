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
import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.awt.Polygon;
import java.util.List;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;

import App.GeomPain;

import Models.Mediator;

@SuppressWarnings("deprecation")
public abstract class ShapeGeom extends Polygon {
    private Mediator m;
    protected Color borderColor = Color.black;
    protected Color color;
    protected int thickness;
    protected ArrayList<Point> pointMemo;
    protected List<Boolean> showedMemo;
    protected boolean displayMemo;
    protected Image memoImage;
    protected int maxMemoPoint;
    protected int selectedMemo;

    // ShapeGeom() {}

    public ShapeGeom(Mediator m, List<Point> points, Color c) {
        this.m = m;
        this.borderColor = c;
        this.pointMemo = new ArrayList<Point>(points);
        this.displayMemo = false;
        try {
            memoImage = (Image) m.getResource("memoPoint");
        } catch (Exception e) {
            System.out.println("error" + "memoPoint");
        }
        this.selectedMemo = -1;
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

    public void setSelectedMemo(int index) {
        this.selectedMemo = index;
    }

    // public void displayMemoPoints() {
        // getSaisiePoint()
    // }

    public abstract void updateShape();

    public void addMemoPoint(Point p) {
        this.pointMemo.add(p);
    }

    public ArrayList<Point> getSaisiePoint() {
        ArrayList<Point> tmp = new ArrayList<>();

        for (int i = 0; i < this.pointMemo.size(); i++) {
            if (this.showedMemo.get(i))
                tmp.add(this.pointMemo.get(i));
        }
        return (tmp);
    }

    public abstract void draw(Graphics g);

    public void drawMemo(Graphics g) {
        int w = this.memoImage.getWidth(null);
        int h = this.memoImage.getHeight(null);

        for (Point mp : getSaisiePoint()) {
            g.drawImage(this.memoImage,
                mp.x - (w / 2),
                mp.y - (h / 2), null);
        }
    }
    public abstract boolean intersects(Rectangle r);
}
