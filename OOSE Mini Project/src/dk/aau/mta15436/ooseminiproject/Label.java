package dk.aau.mta15436.ooseminiproject;

public class Label implements GUIElement
{
	private static final int COLOR = 255;
	
	private int x;
	private int y;
	private String text;
	private Main master;
	
	@Override
	public void update()
	{
		master.fill(COLOR);
		master.text(text, x, y);
	}

	public Label(Main master, String text, int x, int y)
	{
		this.x = x;
		this.y = y;
		this.text = text;
		this.master = master;
	}
}
