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


import java.util.Observable;

abstract class ShapeGeom extends Observable {
    private Color color;
    private Color borderColor;
    private int thickness;
    private Point center; // hum ?
    private ArrayList<Point> pointMemo;
    private ArrayList<boolean> showedMemo;

    abstract void translate(int offset_x, int offest_y) {
        for (Point memo : pointMemo)
            memo.translate(offset_x, offest_y);
    }
    public void colorChange(Color);
    public void modifyShape();
    public ArrayList<Point> getpointMemo() {
        ArrayList<Point> tmp = new ArrayList<Point>;

        for (int i = 0; i < pointMemo.size(); i++)
            if (showedMemo.get(i))
                tmp.add(pointMemo.get(i));
        return (tmp);
    }
    public void draw(Graphic g);


}