import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        ShapeGeom shape = new ShapeGeom();
        CanvaController cc = new CanvaController(shape);
        CanvaView cv = new CanvaView(cc);

        shape.addObserver(cv);

        JFrame frame = new JFrame("Our super rectangle!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cv.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().add(cv);

        frame.pack();
        frame.setVisible(true);
    }
}
