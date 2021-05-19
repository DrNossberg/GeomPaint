package Controllers;

import Models.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class MenuController extends Observable implements ActionListener {
    private CanvasController cc;
    Color selectedColor = Color.BLACK;

    public MenuController(CanvasController cc) {
        this.cc = cc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnText = ((JButton) e.getSource()).getName();

        switch (btnText) {
            case "pick_color" -> {
                JColorChooser colorChooser = new JColorChooser();
                this.selectedColor = JColorChooser.showDialog(null, "Pick a color", Color.black); // color variable stocke la couleur sélectionnée avec "ok"

                setChanged();
                notifyObservers();

            }
            // Shapes buttons
            case "polygon_icon" ->  { cc.initiateShape(ShapeType.POLYGONE); }
            case "rectangle_icon"-> { cc.initiateShape(ShapeType.RECTANGLE);}
            case "triangle_icon"->  { cc.initiateShape(ShapeType.TRIANGLE); }
            case "circle_icon"  ->  { cc.initiateShape(ShapeType.CIRCLE);   }

            // Edit buttons
            case "fill_shape" ->{
            	if (this.selectedColor != null && this.cc.getMediator().getSelectedShape() != null) {
            	    this.cc.getMediator().getSelectedShape().setColor(this.selectedColor);
            	    setChanged();
                    notifyObservers();
                }
            }
            case "erase_shape" ->{
            	this.cc.getMediator().removeShape();
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

    public Color getSelectedColor() {
        return this.selectedColor;
    }
}

