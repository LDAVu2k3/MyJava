package view;

import java.awt.*;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchStudent extends JTextField {
	public SearchStudent() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setSelectionColor(new Color(220, 204, 182));
	}

	private final String hint = "Find here ...";

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (getText().length() == 0) {
			int h = getHeight();
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Insets ins = getInsets();
			FontMetrics fm = g2.getFontMetrics();
			int c0 = getBackground().getRGB();
			int c1 = getForeground().getRGB();
			int m = 0xfefefefe;
			int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
			g2.setColor(new Color(c2, true));
			g2.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
		}
	}
}
