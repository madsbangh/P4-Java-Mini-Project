package dk.aau.mta15436.ooseminiproject;

// The menu the user is presented with when starting the application
public class Menu extends Room
{
	private static final int colorBackground = 48;
	
	// Callback for going to Japanese training Room
	private class GoToJapaneseChallenge implements GUICallback
	{
		@Override
		public void call()
		{
			master.goToRoom(new JapaneseChallenge(master));
		}
	};
	
	// Callback for going to Danish training Room
	private class GoToDanishChallenge implements GUICallback
	{
		@SuppressWarnings("static-access") // Debug (temporary)
		@Override
		public void call()
		{
			//master.goToRoom(new DanishChallenge(master));
			master.println("-> Danish Challenge"); // Debug (temporary)
		}
	}

	@Override
	protected void setup()
	{
		addElement(new Button(master, "Train Japanese", new GoToJapaneseChallenge(), 80, 150, 240, 100));
		addElement(new Button(master, "Train Danish", new GoToDanishChallenge(),     80, 350, 240, 100));
	}
	
	@Override
	protected void draw()
	{
		master.background(colorBackground);
	}
	
	public Menu(Main master)
	{
		super(master);
	}
}
