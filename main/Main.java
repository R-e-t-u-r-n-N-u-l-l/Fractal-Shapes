package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import shapes.ModifiedFractalTree;
import shapes.Shape;

public class Main {
	private Frame frame;
	private Shape currentShape;
	
	public Main() {
		//currentShape = new Rejected1(this);
		//currentShape = new SquareRotation(this);
		//currentShape = new KochSnowflake(this);
		//currentShape = new KochSnowflake2(this);
		//currentShape = new FractalTree(this);
		currentShape = new ModifiedFractalTree(this);
		//currentShape = new MengerSponge(this);
		//currentShape = new SierpinskiTriangle(this);
		frame 		 = new Frame(currentShape.getName());
		
		BufferStrategy bs = frame.getBufferStrategy();
			
		if(bs == null) {
			frame.createBufferStrategy(2);
			bs = frame.getBufferStrategy();
		}
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
		while(true) {
			Graphics g = bs.getDrawGraphics();
			
			g.setColor(Color.BLACK);
			g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
			g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
			
			g.setColor(Color.WHITE);
			currentShape.begin(g);
			
			g.dispose();	
			bs.show();
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	public Frame getFrame() {
		return frame;
	}
	
	public static void main(String[] args) {
		new Main();
	}
}