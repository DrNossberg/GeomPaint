package Models;

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


import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
abstract class ShapeGeom extends Observable {
    protected Color color;
    protected Color borderColor;
    protected int thickness;
    protected Point center; // hum ?
    protected ArrayList<Point> pointMemo;
    protected ArrayList<Boolean> showedMemo;

    void translate(int offset_x, int offest_y) {
        for (Point memo : pointMemo)
            memo.translate(offset_x, offest_y);
    }

    public abstract void colorChange(Color c);
    public abstract void modifyShape();

    public ArrayList<Point> getpointMemo() {
        ArrayList<Point> tmp = new ArrayList<>();

        for (int i = 0; i < pointMemo.size(); i++)
            if (showedMemo.get(i))
                tmp.add(pointMemo.get(i));
        return (tmp);
    }
    public abstract void draw(Graphics g);


}