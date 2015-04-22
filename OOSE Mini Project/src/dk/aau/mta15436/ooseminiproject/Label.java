package dk.aau.mta15436.ooseminiproject;

import processing.core.PFont;

public class Label implements GUIElement
{
	private static final int COLOR = 255;
	
	private int x;
	private int y;
	private String text;
	private int size;
	private Main master;
	private PFont font;
	
	@Override
	public void update()
	{
		master.fill(COLOR);
		master.textFont(font, size);
		master.text(text, x, y);
	}

	public Label(Main master, String text, PFont font, int size, int x, int y)
	{
		this.x = x;
		this.y = y;
		this.text = text;
		this.font = font;
		this.size = size;
		this.master = master;
	}
}
