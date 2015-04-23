package dk.aau.mta15436.ooseminiproject;

import java.util.Random;

public abstract class Challenge extends Room
{
	private static final int COLOR_BACKGROUND = 34;
	private static final int COLOR_CORRECT = 0x70AD37;
	private static final int COLOR_INCORRECT = 0xC42D3F;
	
	private int currentColor = COLOR_BACKGROUND;
	private int alarm = -1;
	private GUICallback alarmCallback;
	
	protected Random rand;
	protected TranslationsProvider translationsProvider;
	protected int[] indexes;
	protected GUICallback[] callbacks;
	
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
			currentColor = COLOR_BACKGROUND;
			master.mouseEnabled = true;
		}
	}
	
	// Flash green to show correct answer
	protected void correct(GUICallback callback)
	{
		currentColor = COLOR_CORRECT;
		master.mouseEnabled = false;
		alarm = 26;
		alarmCallback = callback;
	}
	
	// Flash red to show incorrect answer
	protected void incorrect()
	{
		currentColor = COLOR_INCORRECT;
		master.mouseEnabled = false;
		alarm = 26;
		alarmCallback = new Reset();
	}
	
	@Override
	protected void setup()
	{
		rand = new Random();
		indexes = new int[3];
		
		// Choose a random index for the incorrect answers (which is not equal to the correct answer's index)
		do
		{
			indexes[1] = master.translationsManager.getRandomIndex();
		} while (indexes[1] == indexes[0]);
		do
		{
			indexes[2] = master.translationsManager.getRandomIndex();
		} while (indexes[2] == indexes[0] || indexes[2] == indexes[1]);
	}
	
	@Override
	protected void construct()
	{
		// Add the "Back" button
		addElement(new Button(master, "Back", master.fontRegular, new GoToMenu(), 0, 0, 100, 50));
		
		// Add the 3 answer button
		int pos = rand.nextInt(3);
		for (int i=0; i<3; i++)
		{
			int index = (i + pos) % 3;
			String word = master.translationsManager.getEnglishWord(indexes[index]);
			float y = 225f + 125f*i;
			GUICallback cb = callbacks[index];
			addElement(new Button(master, word, master.fontRegular, cb, 25, y, 350, 100));
		}
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
