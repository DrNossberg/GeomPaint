/*
* PROJET IHM - CLASSE MENU
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MenuView extends JPanel{
	private JComboBox couleurs;
	private JButton effacer;
	private JButton carre;
	private JButton rectangle;
	private JButton cercle;
	private JButton triangle;
	private JButton polygone;
	private JButton remplir;
	private MenuController mc;

	public MenuView(MenuController mc){
		this.mc = mc;
		couleurs = new JComboBox(new String[] {"noir", "gris", "rouge",
		"vert", "bleu", "violet", "jaune", "orange"});
		couleurs.addActionListener(mc);
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
		
		this.add(couleurs);

		effacer=new JButton("Effacer");
		effacer.addActionListener(mc);
		this.add(effacer);

		carre = new JButton("carré");
		carre = addActionListener(mc);
		this.add(carre);

		rectangle = new JButton("rectangle");
		rectangle = addActionListener(mc);
		this.add(rectangle);

		cercle = new JButton("cercle");
		cercle = addActionListener(mc);
		this.add(cercle);

		triangle = new JButton("triangle");
		triangle = addActionListener(mc);
		this.add(triangle);

		polygone = new JButton("polygone");
		polygone = addActionListener(mc);
		this.add(polygone);
		
		remplir = new JButton("remplir");
		remplir = addActionListener(mc);
		this.add(remplir);

		
	}
	public void paintComponent(Graphics g){
			super.paintComponent(g);
		}

}