package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;

import main.Main;

public abstract class Shape {
	protected Main main;
	protected Graphics2D g;
	private String name;
	
	public Shape(Main main, String name) {
		this.main = main;
		this.name = name;
	}
	
	public abstract void begin(Graphics g);
	
	public String getName() {
		return name;
	}
}