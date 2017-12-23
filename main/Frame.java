package main;

import java.awt.Canvas;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Frame extends Canvas {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public Frame(String title) {
		GraphicsDevice[] ged = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		
		frame = new JFrame(title);
		if(ged.length > 1)
			frame.setLocation(ged[1].getDefaultConfiguration().getBounds().getLocation());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		this.setSize(frame.getSize());
		
		frame.add(this);
	}
}