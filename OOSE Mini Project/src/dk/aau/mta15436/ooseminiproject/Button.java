package dk.aau.mta15436.ooseminiproject;

import processing.core.*;

public class Button implements GUIElement
{
	private float x, y, w, h;
	private String text;
	private Main master;
	
	public Button(Main master, String text, float x, float y, float w, float h)
	{
		this.master = master;
		this.text = text;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	@Override
	public void update()
	{
		// If the mouse is within our bounds
		int mx = master.mouseX;
		int my = master.mouseY;
		if (x < mx && mx < x+w && y < my && my < y+h)
		{
			master.fill(95);
			if (master.click)
			{
				PApplet.print("clicked " + text);
				
			}
		}
		else // Mouse is not hovering over the button
		{
			master.fill(63);
		}
		// Draw me!
		master.rect(x, y, w, h);
		master.fill(255);
		master.textSize(28);
		master.text(text, x, y, w, h);
	}
}
