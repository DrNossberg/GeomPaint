/*
** IUT Nancy-Charlemagne, 2021
** Projet :
**    Labythin
** Author :
**    Erin      Bernardoni
**    Antoine   Orion
**    Valentine INGARDIN
**    Maroua    MELKI
** File description :
**    Enumeration of differents possible shape,
**    eatch containing the number of point they need to hae to be drawable
*/

package Models;


public enum ShapeType {
    RECTANGLE(2),
    CIRCLE(2),
    POLYGONE(-1);

    private int memoPoint;

    ShapeType(int memoPoint) {
        this.memoPoint = memoPoint;
    }

    public int getMaxMemoPoint() {
        return (this.memoPoint);
    }
}