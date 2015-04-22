package dk.aau.mta15436.ooseminiproject;

public class Button implements GUIElement
{
	final static int colorDefault = 0;
	final static int colorHover = 16;
	final static int colorPressed = 32;
	final static int colorText = 255;
	
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
			master.fill(colorHover);
			if (master.click)
			{
				// Call the callback given in the constructor
				callback.call();
			}
			else if (master.mousePressed)
			{
				master.fill(colorPressed);
			}
		}
		else // Mouse is not hovering over the button
		{
			master.fill(colorDefault);
		}
		// Draw me!
		master.rect(x, y, w, h);
		master.fill(colorText);
		master.textSize(28);
		master.text(text, x, y, w, h);
	}
	
	public Button(Main master, String text, GUICallback callback, float x, float y, float w, float h)
	{
		this.master = master;
		this.text = text;
		this.callback = callback;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
}
