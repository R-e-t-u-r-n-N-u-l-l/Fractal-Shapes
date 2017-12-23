package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Main;

public class SquareRotation extends Shape {
	private int count = 0;
	
	public SquareRotation(Main main) {
		super(main, "Square Rotation");
	}

	public void begin(Graphics g) {
		if(++count > 12)
			count--;
		this.g 	   = (Graphics2D) g;
		int width  = main.getFrame().getWidth();
		int height = main.getFrame().getHeight();
		int size   = width > height ? height / 3 : width / 3;
		
		fractal(new Rectangle(width / 2 - size / 2, height / 2 - size / 2, size, size), count - 1);
	}
	
	private void fractal(Rectangle r, int count) {
		g.drawRect(r.x, r.y, r.width, r.height);
		
		if(count < 1)
			return;

		int newSize = r.width / 2;
		
		fractal(new Rectangle(r.x - newSize / 2, r.y, newSize, newSize), count - 1);
		fractal(new Rectangle(r.x + r.width - newSize, r.y - newSize / 2, newSize, newSize), count - 1);
		fractal(new Rectangle(r.x + r.width - newSize / 2, r.y + r.height - newSize, newSize, newSize), count - 1);
		fractal(new Rectangle(r.x, r.y + r.height - newSize / 2, newSize, newSize), count - 1);
	}
}