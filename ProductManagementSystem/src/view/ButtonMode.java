package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

public class ButtonMode extends JButton {

	private Color colorMenu = new Color(39,43,48);
	
	
	public ButtonMode() {
		setOpaque(false);
		setBorder(null);
		setFocusPainted(false);
		setFont(new Font("Roboto",Font.PLAIN,15));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(colorMenu);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(),40,40);
		super.paintComponent(g);
	}

	public Color getColorMenu() {
		return colorMenu;
	}

	public void setColorMenu(Color colorMenu) {
		this.colorMenu = colorMenu;
	}
	
	
}
