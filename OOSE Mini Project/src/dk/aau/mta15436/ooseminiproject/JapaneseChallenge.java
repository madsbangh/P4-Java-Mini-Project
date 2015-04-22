package dk.aau.mta15436.ooseminiproject;

public class JapaneseChallenge extends Challenge
{
	// Callback for answering correctly. Takes a room to go to next
	protected class Correct implements GUICallback
	{
		@Override
		public void call()
		{
			correct(new GoToNextRoom(new JapaneseChallenge(master)));
		}
	}
	
	@Override
	protected void setup()
	{
		super.setup();
		addElement(new Label(master, "Question", 200, 125));
		addElement(new Button(master, "Correct Answer", new Correct(), 25, 225, 350, 100));
		addElement(new Button(master, "Incorrect Answer 1", new Incorrect(), 25, 350, 350, 100));
		addElement(new Button(master, "Incorrect Answer 2", new Incorrect(), 25, 475, 350, 100));
	}
	
	public JapaneseChallenge(Main master)
	{
		super(master);
	}
}
