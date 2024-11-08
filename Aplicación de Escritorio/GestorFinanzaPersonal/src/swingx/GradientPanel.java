package swingx;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

public class GradientPanel extends JPanel {
	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		
		Color gradientStart = new Color(223, 93, 123);
		Color gradientEnd = new Color(227, 120, 145);
		
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint painter = new GradientPaint(0, 0, gradientStart,
				0, height, gradientEnd);
		Paint oldPainter = g2.getPaint();
		g2.setPaint(painter);
		g2.fill(g2.getClip());

		gradientStart = new Color(227, 120, 145);
		gradientEnd = new Color(223, 93, 123);

		painter = new GradientPaint(0, 0, gradientEnd,
				0, height / 2, gradientStart);
		g2.setPaint(painter);
		g2.fill(g2.getClip());

		painter = new GradientPaint(0, height / 2, gradientStart,
				0, height, gradientEnd);
		g2.setPaint(painter);
		g2.fill(g2.getClip());

		g2.setPaint(oldPainter);
	}
}
