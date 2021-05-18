package Views;


import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import Controllers.CanvasController;

@SuppressWarnings("deprecation")
public class CanvasView extends JPanel implements Observer {
    CanvasController cc;

    public CanvasView(CanvasController cc) {
        this.cc = cc;
        this.addMouseListener(cc);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        this.cc.getMediator().draw(g);
    }
}