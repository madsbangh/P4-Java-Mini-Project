package dk.aau.mta15436.ooseminiproject;

public class JapaneseChallenge extends Challenge
{
	private TranslationsProvider charsProvider;
	
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
		// Japanese-specific things
		translationsProvider = master.translationsManager.japaneseWordProvider;
		charsProvider = master.translationsManager.japaneseCharProvider;
		
		super.setup();	
		
		callbacks = new GUICallback[] {new Correct(), new Incorrect(), new Incorrect()};
	}
	
	@Override
	protected void construct()
	{
		super.construct();
		
		// Create the label displaying the Japanese word to be guessed
		addElement(new Label(master, charsProvider.getWord(indexes[0]), master.fontJapanese, 40, 200, 100));
		addElement(new Label(master, translationsProvider.getWord(indexes[0]), master.fontRegular, 20, 200, 150));		
	}
	
	public JapaneseChallenge(Main master)
	{
		super(master);
	}
}
