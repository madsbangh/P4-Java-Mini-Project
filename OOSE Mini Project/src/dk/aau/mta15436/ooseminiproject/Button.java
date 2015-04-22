package dk.aau.mta15436.ooseminiproject;

import processing.core.PFont;

public class Button implements GUIElement
{
	private static final int COLOR_DEFAULT = 0;
	private static final int COLOR_HOVER = 16;
	private static final int COLOR_PRESSED = 32;
	private static final int COLOR_TEXT = 255;
	
	private PFont font;
	
	protected Main master;
	protected float x, y, w, h;
	protected String text;
	protected GUICallback callback;
	
	@Override
	public void update()
	{
		// If the mouse is within our bounds and the mouse is enabled
		int mx = master.mouseX;
		int my = master.mouseY;
		if (master.mouseEnabled && x < mx && mx < x+w && y < my && my < y+h)
		{
			master.fill(COLOR_HOVER);
			if (master.click)
			{
				// Call the callback given in the constructor
				callback.call();
			}
			else if (master.mousePressed)
			{
				master.fill(COLOR_PRESSED);
			}
		}
		else // Mouse is not hovering over the button
		{
			master.fill(COLOR_DEFAULT);
		}
		// Draw me!
		master.rect(x, y, w, h);
		master.fill(COLOR_TEXT);
		master.textFont(font, 28);
		master.text(text, x, y, w, h);
	}
	
	public Button(Main master, String text, PFont font, GUICallback callback, float x, float y, float w, float h)
	{
		this.master = master;
		this.text = text;
		this.font = font;
		this.callback = callback;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
}
