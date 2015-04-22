package dk.aau.mta15436.ooseminiproject;

public abstract class Challenge extends Room
{
	private static final int colorBackground = 34;
	private static final int colorCorrect = 0x70AD37;
	private static final int colorIncorrect = 0xC42D3F;
	
	private int currentColor = colorBackground;
	private int alarm = -1;
	private GUICallback alarmCallback;
	
	// Callback for going to Danish training Room
	private class GoToMenu implements GUICallback
	{
		@Override
		public void call()
		{
			master.goToRoom(new Menu(master));
		}
	}
	
	// Callback for answering incorrectly
	protected class Incorrect implements GUICallback
	{
		@Override
		public void call()
		{
			incorrect();
		}
	}
	
	// Callback for resetting after incorrect answer state
	protected class Reset implements GUICallback
	{
		@Override
		public void call()
		{
			currentColor = colorBackground;
			master.mouseEnabled = true;
		}
	}
	
	// Flash green to show correct answer
	protected void correct(GUICallback callback)
	{
		currentColor = colorCorrect;
		master.mouseEnabled = false;
		alarm = 60;
		alarmCallback = callback;
	}
	
	// Flash red to show incorrect answer
	protected void incorrect()
	{
		currentColor = colorIncorrect;
		master.mouseEnabled = false;
		alarm = 60;
		alarmCallback = new Reset();
	}
	
	@Override
	protected void setup()
	{
		addElement(new Button(master, "Back", new GoToMenu(), 0, 0, 100, 50));
	}

	@Override
	protected void draw()
	{
		master.background(currentColor);
	}
	
	@Override
	public void update()
	{
		super.update();
		if (alarm > 0)
		{
			alarm--;
		}
		else if (alarm == 0) // BEEP, BEEP! alarm is going off
		{
			alarm = -1;
			alarmCallback.call();
		}
	}

	public Challenge(Main master)
	{
		super(master);
	}
}
