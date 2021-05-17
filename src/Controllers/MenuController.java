package Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String btnText = ((JButton) e.getSource()).getText();

        switch (btnText) {
            case "Pick a color" -> {
                JColorChooser colorChooser = new JColorChooser();
                Color color = JColorChooser.showDialog(null, "Pick a color", Color.black); // color variable stocke la couleur sélectionnée avec "ok"

                System.out.println("Choosen color: " + color);
            	break;
            }
            case "Fill shape" ->{
            	clearFigure();
            	break;
            }
            case "Erase shape" ->{
            	clearFigure();
            	break;
            }
            case "Bring forward" ->{
            	forwardFigure();
            	break;
            }
           case "Send backward" ->{
            	backwardFigure();
            	break;
            }
            case "Erase all" ->{
            	getGraphics().clearReact(0, 0, getWidht(), getHeight());
            	clear();
            	break;
            }
            
        }
    }
}

