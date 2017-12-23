package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import main.Main;

public class SierpinskiTriangle extends Shape {
	private int count;
	
	public SierpinskiTriangle(Main main) {
		super(main, "Sierpinski Triangle");
	}

	public void begin(Graphics g) {
		if(++count > 8)
			count--;
		this.g 	   = (Graphics2D) g;
		int width  = main.getFrame().getWidth();
		int height = main.getFrame().getHeight();
		
		fractal(new Point(width / 2, height / 5), 
				new Point(width / 2 - height / 3, height - height / 5), 
				new Point(width / 2 + height / 3, height - height / 5), 
				count - 1);
	}

	private void fractal(Point p1, Point p2, Point p3, int count) {
		if(count < 1) {
			g.drawPolygon(new int[] {p1.x, p2.x, p3.x}, new int[] {p1.y, p2.y, p3.y}, 3);
			return;
		}
		
		Point m1 = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
		Point m2 = new Point((p1.x + p3.x) / 2, (p1.y + p3.y) / 2);
		Point m3 = new Point((p3.x + p2.x) / 2, (p3.y + p2.y) / 2);
		fractal(p1, m1, m2, count - 1);
		fractal(m1, p2, m3, count - 1);
		fractal(m2, m3, p3, count - 1);
	}
}