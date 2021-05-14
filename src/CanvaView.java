
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class CanvaView extends JPanel implements Observer {
    CanvaController cc;

    public CanvaView(CanvaController cc) {
        this.cc = cc;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.cc.getShape().draw(g);
    }
}