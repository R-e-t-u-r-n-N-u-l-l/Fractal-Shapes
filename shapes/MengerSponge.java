package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Main;

public class MengerSponge extends Shape {
	private int count;
	
	public MengerSponge(Main main) {
		super(main, "Menger Sponge");
	}
	
	public void begin(Graphics g) {
		if(++count > 5)
			count--;
		this.g 	   = (Graphics2D) g;
		int width  = main.getFrame().getWidth();
		int height = main.getFrame().getHeight();
		int size   = width > height ? (int) (height * 0.8) : (int) (width * 0.8);
		
		fractal(new Rectangle(width / 2 - size / 2, height / 2 - size / 2, size, size), count);
	}
	
	private void fractal(Rectangle r, int count) {
		if(count < 1) {
			g.drawRect(r.x, r.y, r.width, r.height);
			return;
		}
		double width = r.getWidth() / 3;
		double height = r.getHeight() / 3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!(i == 1 && j == 1)) {
					fractal(new Rectangle(r.x + (int) (i * width), r.y + (int) (j * height), (int) width, (int) height), count - 1);
				}
			}
		}
	}
}