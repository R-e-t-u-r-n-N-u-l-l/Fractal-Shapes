package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import main.Main;

public class KochSnowflake2 extends Shape {
	private int width, height, count;
	
	public KochSnowflake2(Main main) {
		super(main, "Koch Snowflake");
	}

	public void begin(Graphics g) {
		if(++count > 7)
			count--;
		this.g 	  = (Graphics2D) g;
		width     = main.getFrame().getWidth();
		height 	  = main.getFrame().getHeight();
		
		Point p1 = new Point(width / 2 - height / 3, (int) (height / 2.5));
		Point p2 = new Point(width / 2 + height / 3, (int) (height / 2.5));
		Point p3 = new Point(width / 2, height - height / 12);
		
		fractal(p1, p2, count - 1);
		fractal(p2, p3, count - 1);
		fractal(p3, p1, count - 1);
	}

	private void fractal(Point p1, Point p2, int count) {
		if(count < 1) {
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			return;
		}
		
		float dx    = p2.x - p1.x;
		float dy    = p2.y - p1.y;
		float dist  = (float) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		float angle = (float) Math.atan2(dy, dx);
		
		Point m1 = new Point((int) (p1.x + dx / 3), (int) (p1.y + dy / 3));
		Point m2 = new Point((int) (p2.x - dx / 3), (int) (p2.y - dy / 3));
		Point m3 = new Point((int) (m1.x + Math.cos(angle - Math.PI / 2) * (dist / 3)), (int) (m1.y + Math.sin(angle - Math.PI / 2) * (dist / 3)));
		Point m4 = new Point((int) (m2.x + Math.cos(angle - Math.PI / 2) * (dist / 3)), (int) (m2.y + Math.sin(angle - Math.PI / 2) * (dist / 3)));
		
		fractal(p1, m1, count - 1);
		fractal(m2, p2, count - 1);
		fractal(m1, m3, count - 1);
		fractal(m3, m4, count - 1);
		fractal(m4, m2, count - 1);
	}
}