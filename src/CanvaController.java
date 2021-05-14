
public class CanvaController extends MouseAdapter {
    private ShapeGeom shape;
    
    public CanvaController(ShapeGeom shape) {
        this.shape = shape;
    }

    @Override
    public void mousePressed() {
        shape.createFigure();
    }

    public ShapeGeom getShape() {
        return this.shape;
    }
}