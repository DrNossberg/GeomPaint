package App;

import Controllers.CanvasController;
import Controllers.MenuController;
import Models.AssetLoader;
import Models.Mediator;
import Views.CanvasView;
import Views.MenuView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import java.awt.*;

public class GeomPain {

    public static void main(String[] args) {

        AssetLoader loader = new AssetLoader("./src/resources");
        Mediator mediator = new Mediator(loader);

        // Link model to controller
        CanvasController cc = new CanvasController(mediator);
        MenuController mc = new MenuController(cc);

        // Link controller to view
        CanvasView cv = new CanvasView(cc, mc);
        MenuView mv = new MenuView(mediator, mc);

        // Add view observer to the model
        mediator.addObserver(cv);

        JFrame frame = new JFrame("Our super rectangle!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        cv.addMouseMotionListener(cc);

        cv.setPreferredSize(new Dimension(1000, 600));
        cv.setBackground(Color.white);

        mv.setPreferredSize(new Dimension(200, 100));

        frame.getContentPane().add(mv, BorderLayout.WEST);
        frame.getContentPane().add(cv, BorderLayout.CENTER);
        frame.setMinimumSize(new Dimension(500, 500));

        frame.setFocusable(true);
        frame.requestFocus();
        frame.setVisible(true);
        frame.pack();
    }
}
