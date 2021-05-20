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
    NONE(0),
    RECTANGLE(2),
    SQUARE(2),
    TRIANGLE(3),
    CIRCLE(2),
    POLYGON(-1);

    private int memoPoint;

    ShapeType(int memoPoint) {
        this.memoPoint = memoPoint;
    }

    public int getMaxMemoPoint() {
        return (this.memoPoint);
    }
}
