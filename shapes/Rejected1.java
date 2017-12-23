package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import main.Main;

public class Rejected1 extends Shape {
	private int count;
	
	public Rejected1(Main main) {
		super(main, "Null Hexagon");
	}

	public void begin(Graphics g) {
		if(++count > 10)
			count--;
		this.g 	   = (Graphics2D) g;
		int width  = main.getFrame().getWidth();
		int height = main.getFrame().getHeight();
		
		fractal(new Point(width / 2, height / 8),
				new Point(width / 2 - height / 3, height / 3),
				new Point(width / 2 - height / 3, height - height / 3),
				new Point(width / 2, height - height / 8),
				new Point(width / 2 + height / 3, height - height / 3),
				new Point(width / 2 + height / 3, height / 3),
				count - 1);
	}
	
	private void fractal(Point p1, Point p2, Point p3, Point p4, Point p5, Point p6, int count) {
		g.drawPolygon(new int[] {p1.x, p2.x, p3.x, p4.x, p5.x, p6.x}, new int[] {p1.y, p2.y, p3.y, p4.y, p5.y, p6.y}, 6);
		
		if(count < 1)
			return;
		
		int w  = p6.x - p2.x;
		int h  = p4.y - p1.y;
		int h1 = p3.y - p2.y;
		int w2 = w / 6;
		int h2 = h / 6;
		int h3 = p2.y - p1.y;
		
		Point np1 = new Point(p1.x, p1.y + h2);
		Point np2 = new Point(p2.x + w2, p2.y + h1 / 6);
		Point np3 = new Point(p3.x + w2, p3.y - h1 / 6);
		Point np4 = new Point(p4.x, p4.y - h2);
		Point np5 = new Point(p5.x - w2, p5.y - h1 / 6);
		Point np6 = new Point(p6.x - w2, p6.y + h1 / 6);
		
		fractal(np1, np2, np3, np4, np5, np6, count - 1);
		
		np1 = new Point(p1.x, p1.y);
		np2 = new Point(p1.x - w2 / 2, p1.y + h3 / 6);
		np3 = new Point(p1.x - w2 / 2, p1.y + h2 - h3 / 6);
		np4 = new Point(p1.x, p1.y + h2);
		np5 = new Point(p1.x + w2 / 2, p1.y + h2 - h3 / 6);
		np6 = new Point(p1.x + w2 / 2, p1.y + h3 / 6);
		
		fractal(np1, np2, np3, np4, np5, np6, count - 1);
		
		np1 = new Point(p4.x, p4.y - h2);
		np2 = new Point(np1.x - w2 / 2, np1.y + h3 / 6);
		np3 = new Point(np1.x - w2 / 2, np1.y + h2 - h3 / 6);
		np4 = new Point(np1.x, np1.y + h2);
		np5 = new Point(np1.x + w2 / 2, np1.y + h2 - h3 / 6);
		np6 = new Point(np1.x + w2 / 2, np1.y + h3 / 6);
		
		fractal(np1, np2, np3, np4, np5, np6, count - 1);
		
		np1 = new Point(p2.x + w2 / 2, p2.y + h3 / 2);
		np2 = new Point(np1.x - w2 / 2, np1.y + h3 / 6);
		np3 = new Point(np1.x - w2 / 2, np1.y + h2 - h3 / 6);
		np4 = new Point(np1.x, np1.y + h2);
		np5 = new Point(np1.x + w2 / 2, np1.y + h2 - h3 / 6);
		np6 = new Point(np1.x + w2 / 2, np1.y + h3 / 6);
		
		fractal(np1, np2, np3, np4, np5, np6, count - 1);
		
		np1 = new Point(p6.x - w2 / 2, p6.y + h3 / 2);
		np2 = new Point(np1.x - w2 / 2, np1.y + h3 / 6);
		np3 = new Point(np1.x - w2 / 2, np1.y + h2 - h3 / 6);
		np4 = new Point(np1.x, np1.y + h2);
		np5 = new Point(np1.x + w2 / 2, np1.y + h2 - h3 / 6);
		np6 = new Point(np1.x + w2 / 2, np1.y + h3 / 6);
		
		fractal(np1, np2, np3, np4, np5, np6, count - 1);
		
		np1 = new Point(p3.x + w2, p3.y - h1 / 6);
		np2 = new Point(np1.x - w2 / 2, np1.y + h3 / 6);
		np3 = new Point(np1.x - w2 / 2, np1.y + h2 - h3 / 6);
		np4 = new Point(np1.x, np1.y + h2);
		np5 = new Point(np1.x + w2 / 2, np1.y + h2 - h3 / 6);
		np6 = new Point(np1.x + w2 / 2, np1.y + h3 / 6);
		
		fractal(np1, np2, np3, np4, np5, np6, count - 1);
		
		np1 = new Point(p5.x - w2, p5.y - h1 / 6);
		np2 = new Point(np1.x - w2 / 2, np1.y + h3 / 6);
		np3 = new Point(np1.x - w2 / 2, np1.y + h2 - h3 / 6);
		np4 = new Point(np1.x, np1.y + h2);
		np5 = new Point(np1.x + w2 / 2, np1.y + h2 - h3 / 6);
		np6 = new Point(np1.x + w2 / 2, np1.y + h3 / 6);
		
		fractal(np1, np2, np3, np4, np5, np6, count - 1);
		
		np1 = new Point(p2.x + w2, p2.y + h1 / 6 - h2);
		np2 = new Point(np1.x - w2 / 2, np1.y + h3 / 6);
		np3 = new Point(np1.x - w2 / 2, np1.y + h2 - h3 / 6);
		np4 = new Point(np1.x, np1.y + h2);
		np5 = new Point(np1.x + w2 / 2, np1.y + h2 - h3 / 6);
		np6 = new Point(np1.x + w2 / 2, np1.y + h3 / 6);
		
		fractal(np1, np2, np3, np4, np5, np6, count - 1);
		
		np1 = new Point(p6.x - w2, p6.y + h1 / 6 - h2);
		np2 = new Point(np1.x - w2 / 2, np1.y + h3 / 6);
		np3 = new Point(np1.x - w2 / 2, np1.y + h2 - h3 / 6);
		np4 = new Point(np1.x, np1.y + h2);
		np5 = new Point(np1.x + w2 / 2, np1.y + h2 - h3 / 6);
		np6 = new Point(np1.x + w2 / 2, np1.y + h3 / 6);
		
		fractal(np1, np2, np3, np4, np5, np6, count - 1);
	}
}