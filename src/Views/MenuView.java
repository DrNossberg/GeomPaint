package Views;

import Controllers.MenuController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class MenuView extends JPanel{
	private MenuController mc;

	public MenuView(MenuController mc){
		this.mc = mc;

		Border panelBorder = BorderFactory.createLineBorder(Color.black);
		this.setBorder(panelBorder);

		Border subMenuBorder = BorderFactory.createLineBorder(new Color(157, 157, 157));

		JLabel title = new JLabel("ToolBox", JLabel.CENTER);
		title.setPreferredSize(new Dimension(198, 30));
		title.setFont(new Font("Helvetica", Font.BOLD, 25));
		this.add(title);

		JPanel shapesPanel = createShapesPanel();
		shapesPanel.setPreferredSize(new Dimension(198, 70));
		shapesPanel.setBorder(subMenuBorder);
		this.add(shapesPanel);

		JPanel toolsPanel = createToolsPanel();
		toolsPanel.setPreferredSize(new Dimension(198, 210));
		toolsPanel.setBorder(subMenuBorder);
		this.add(toolsPanel);

		JPanel colorsPanel = createColorPanel();
		colorsPanel.setPreferredSize(new Dimension(198, 70));
		colorsPanel.setBorder(subMenuBorder);
		this.add(colorsPanel);

	}
	public void paintComponent(Graphics g){
			super.paintComponent(g);
	}


	public JPanel createShapesPanel() {
		JPanel shapesPanel = new JPanel();

		shapesPanel.add(createSubMenuLabel("Shapes"));

		JButton[] shapeButtons = new JButton[4];
		shapeButtons[0] = new JButton();
		shapeButtons[0].setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/Ressources/polygon_icon.png"))));
		shapeButtons[0].setName("draw_polygon");
		shapeButtons[1] = new JButton();
		shapeButtons[1].setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/Ressources/rectangle_icon.png"))));
		shapeButtons[1].setName("draw_rectangle");
		shapeButtons[2] = new JButton();
		shapeButtons[2].setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/Ressources/triangle_icon.png"))));
		shapeButtons[2].setName("draw_triangle");
		shapeButtons[3] = new JButton();
		shapeButtons[3].setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/Ressources/circle_icon.png"))));
		shapeButtons[3].setName("draw_circle");

		for (JButton btn : shapeButtons) {
			btn.setBackground(Color.white);
			btn.setPreferredSize(new Dimension(20,20));
			btn.addActionListener(mc);
			shapesPanel.add(btn);
		}

		return shapesPanel;
	}

	public JPanel createToolsPanel() {
		JPanel toolsPanel = new JPanel();

		toolsPanel.add(createSubMenuLabel("Edit"));
		JButton[] toolButtons = new JButton[5];
		toolButtons[0] = new JButton("Fill shape");
		toolButtons[0].setName("fill_shape");
		toolButtons[1] = new JButton("Erase shape");
		toolButtons[1].setName("erase_shape");
		toolButtons[2] = new JButton("Bring forward");
		toolButtons[2].setName("bring_forward");
		toolButtons[3] = new JButton("Send backward");
		toolButtons[3].setName("send_backward");
		toolButtons[4] = new JButton("Erase all");
		toolButtons[4].setName("erase_all");


		for (JButton btn : toolButtons) {
			buttonFormat(btn);
			toolsPanel.add(btn);
		}

		return toolsPanel;
	}

	public JPanel createColorPanel() {
		JPanel colorPanel = new JPanel();

		colorPanel.add(createSubMenuLabel("Color"));
		JButton btn = new JButton("Pick a color");
		btn.setName("pick_color");
		btn.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/Ressources/palette-de-couleurs.png"))));
		buttonFormat(btn);
		colorPanel.add(btn);

		return colorPanel;
	}

	public JLabel createSubMenuLabel(String txt) {
		JLabel lbl = new JLabel(txt, JLabel.CENTER);
		lbl.setPreferredSize(new Dimension(198, 20));
		lbl.setFont(new Font("Helvetica", Font.BOLD, 15));

		return lbl;
	}

	public void buttonFormat(JButton btn) {
		btn.setBackground(Color.white);
		btn.setPreferredSize(new Dimension(190, 30));
		btn.setFont(new Font("Helvetica", Font.PLAIN, 15));
		btn.setBorder(new EtchedBorder());
		btn.addActionListener(mc);
	}
}