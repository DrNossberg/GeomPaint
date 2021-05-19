package Views;

import App.GeomPain;
import Controllers.MenuController;
import Models.Mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("deprecation")
public class MenuView extends JPanel implements Observer {
	private MenuController mc;
	private Mediator m;

	public MenuView(Mediator m, MenuController mc) {
		this.m = m;
		this.mc = mc;
		mc.addObserver(this);

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
		colorsPanel.setPreferredSize(new Dimension(198, 110));
		colorsPanel.setBorder(subMenuBorder);
		this.add(colorsPanel);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public JButton createShapeButton(String asset_name) {
		JButton tmp = new JButton();

		try {
			tmp.setName(asset_name);
			tmp.setIcon(new ImageIcon((Image) this.m.getResource(asset_name)));
		} catch (Exception e) {
			System.out.println("Error: " + asset_name + ": " + e.getStackTrace().toString());
		}
		return (tmp);
	}

	public JPanel createShapesPanel() {
		JPanel shapesPanel = new JPanel();
		JButton[] shapeButtons = new JButton[4];

		shapesPanel.add(createSubMenuLabel("Shapes"));
		shapeButtons[0] = createShapeButton("polygon_icon");
		shapeButtons[1] = createShapeButton("rectangle_icon");
		shapeButtons[2] = createShapeButton("triangle_icon");
		shapeButtons[3] = createShapeButton("circle_icon");

		for (JButton btn : shapeButtons) {
			btn.setBackground(Color.white);
			btn.setPreferredSize(new Dimension(20,20));
			btn.addActionListener(mc);
			shapesPanel.add(btn);
		}

		return (shapesPanel);
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
		btn.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../resources/palette-de-couleurs.png"))));
		buttonFormat(btn);
		colorPanel.add(btn);

		JLabel colorLbl = new JLabel("Selected color:", JLabel.LEFT);
		colorLbl.setPreferredSize(new Dimension(198, 15));
		colorLbl.setFont(new Font("Helvetica", Font.BOLD, 13));
		colorPanel.add(colorLbl);

		JPanel draw = new drawRect();
		draw.setPreferredSize(new Dimension(190, 15));
		colorPanel.add(draw);

		return colorPanel;
	}

	public JLabel createSubMenuLabel(String txt) {
		JLabel lbl = new JLabel(txt, JLabel.CENTER);
		lbl.setPreferredSize(new Dimension(190, 20));
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

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}