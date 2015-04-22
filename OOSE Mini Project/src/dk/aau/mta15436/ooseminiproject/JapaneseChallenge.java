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
		
		// Create an array with the 3 possible answers. The first one is always the correct answer
		int[] indexes = new int[3];
		
		indexes[0] = master.translationsManager.getNextJapaneseIndex();
		
		// Create the label displaying the Japanese word to be guessed
		addElement(new Label(master, master.translationsManager.getJapaneseChar(indexes[0]), master.fontJapanese, 40, 200, 100));
		addElement(new Label(master, master.translationsManager.getJapaneseWord(indexes[0]), master.fontRegular, 20, 200, 150));
		
		// Choose a random index for the incorrect answers (which is not equal to the correct answer's index)
		do
		{
			indexes[1] = master.translationsManager.getRandomIndex();
		} while (indexes[1] == indexes[0]);
		do
		{
			indexes[2] = master.translationsManager.getRandomIndex();
		} while (indexes[2] == indexes[0] || indexes[2] == indexes[1]);
		GUICallback[] callbacks = {new Correct(), new Incorrect(), new Incorrect()};
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
	
	public JapaneseChallenge(Main master)
	{
		super(master);
	}
}
