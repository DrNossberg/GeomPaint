import Controllers.CanvasController;
import Models.Mediator;
import Views.CanvasView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import java.awt.*;

public class GeomPain {
    public static void main(String[] args) {
        Mediator m = new Mediator();

        // Link model to controller
        CanvasController cc = new CanvasController(m);

        // Link controller to view
        CanvasView cv = new CanvasView(cc);

        // Add view observer to the model
        m.addObserver(cv);

        JFrame frame = new JFrame("Our super rectangle!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cv.addMouseListener(cc);
        cv.addMouseMotionListener(cc);

        cv.setPreferredSize(new Dimension(500, 500));
        cv.setBackground(Color.white);

        frame.setContentPane(cv);
        frame.setFocusable(true);
        frame.requestFocus();
        frame.setVisible(true);
        frame.pack();
    }
}
