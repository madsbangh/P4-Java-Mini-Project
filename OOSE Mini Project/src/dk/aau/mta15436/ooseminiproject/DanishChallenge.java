package dk.aau.mta15436.ooseminiproject;

public class DanishChallenge extends Challenge
{	
	// Callback for answering correctly. Takes a room to go to next
	protected class Correct implements GUICallback
	{
		@Override
		public void call()
		{
			correct(new GoToNextRoom(new DanishChallenge(master)));
		}
	}
	
	@Override
	protected void setup()
	{
		super.setup();
		
		// Japanese-specific things
		translationsProvider = master.translationsManager.danishWordProvider;
		
		callbacks = new GUICallback[] {new Correct(), new Incorrect(), new Incorrect()};
		
		// indexes is an array with the 3 possible answers. The first one is always the correct answer
		indexes[0] = translationsProvider.getNextIndex();
	}
	
	@Override
	protected void construct()
	{
		super.construct();
		
		// Create the label displaying the Danish word to be guessed
		addElement(new Label(master, translationsProvider.getWord(indexes[0]), master.fontRegular, 40, 200, 120));
	}
	
	public DanishChallenge(Main master)
	{
		super(master);
	}
}
