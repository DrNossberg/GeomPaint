package Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String btnText = ((JButton) e.getSource()).getText();

        // switch (btnText) {
        //     case "Pick a color" -> {
        //         JColorChooser colorChooser = new JColorChooser();
        //         Color color = JColorChooser.showDialog(null, "Pick a color", Color.black); // color variable stocke la couleur sélectionnée avec "ok"

        //         System.out.println("Choosen color: " + color);
        //     }
        // }
    }
}

/*public void actionPerformed(ActionEvent e){
				switch (couleurs.getSelectedIndex()){
					case 0:
						setColor(Color.black);
						break;
					case 1:
						setColor(Color.grey);
						break;
					case 2:
						setColor(Color.red);
						break;
					case 3:
						setColor(Color.green);
						break;
					case 4:
						setColor(Color.blue);
						break;
					case 5:
						setColor(Color.violet);
						break;
					case 6:
						setColor(Color.yellow);
						break;
					case 7:
						setColor(Color.orange);
						break;
				}
				repaint();
			}*/