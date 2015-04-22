package dk.aau.mta15436.ooseminiproject;

import processing.core.*;

public class Main extends PApplet
{
	private static final long serialVersionUID = 3286085431838033816L;
	public boolean click = false;
	Button b = new Button(this, "Testing!", 100, 100, 200, 100);
	
	public void setup()
	{
		size(400, 600);
		textAlign(CENTER, CENTER);
		noStroke();
	}
	
	public void draw()
	{
		background(32);
		b.update();
		// Reset click to false every frame
		click = false;
	}
	
	public void mousePressed()
	{
		// Click is true for this frame
		click = true;
	}

	public static void main(String[] args)
	{
		PApplet.main(new String[] { "dk.aau.mta15436.ooseminiproject.Main" });
	}
}
