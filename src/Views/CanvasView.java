package Views;


import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import Controllers.CanvasController;
import Controllers.MenuController;

@SuppressWarnings("deprecation")
public class CanvasView extends JPanel implements Observer {
    CanvasController cc;
    MenuController mc;

    public CanvasView(CanvasController cc, MenuController mc) {
        this.cc = cc;
        this.mc = mc;
        this.addMouseListener(cc);
        mc.addObserver(this);
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