package Controllers;

import Models.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    private CanvasController cc;

    public MenuController(CanvasController cc) {
        this.cc = cc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnText = ((JButton) e.getSource()).getName();

        switch (btnText) {
            case "pick_color" -> {
                JColorChooser colorChooser = new JColorChooser();
                Color color = JColorChooser.showDialog(null, "Pick a color", Color.black); // color variable stocke la couleur sélectionnée avec "ok"

                System.out.println("Choosen color: " + color);
            }
            // Shapes buttons
            case "draw_polygon" -> {
                cc.initiateShape(ShapeType.POLYGONE);
            }
            case "draw_rectangle" -> {
                cc.initiateShape(ShapeType.RECTANGLE);
            }
            case "draw_triangle" -> {
                cc.initiateShape(ShapeType.TRIANGLE);
            }
            case "draw_circle" -> {
                cc.initiateShape(ShapeType.CIRCLE);
            }

            // Edit buttons
            case "fill_shape" ->{
//            	clearFigure();
            }
            case "erase_shape" ->{
//            	clearFigure();
            }
            case "bring_forward" ->{
//            	forwardFigure();
            }
           case "send_backward" ->{
//            	backwardFigure();
            }
            case "erase_all" ->{
//            	getGraphics().clearReact(0, 0, getWidht(), getHeight());
//            	clear();
            }
            
        }
    }
}

