package dk.aau.mta15436.ooseminiproject;

import java.util.Random;

// Loads translations from translations file and manages them
public class TranslationsManager
{
	private static final String TRANSLATIONS_FILE = "translations.csv";
	
	private Main master;
	
	private String[] englishWords;
	private String[] japaneseWords;
	private String[] japaneseChars;
	private String[] danishWords;
	
	private int currentIndex = 1;
	
	private Random rand;
	
	private void loadTransations()
	{
		String[] data = master.loadStrings(TRANSLATIONS_FILE);
		japaneseChars= data[0].split(",");
		japaneseWords = data[1].split(",");
		englishWords = data[2].split(",");
		danishWords = data[3].split(",");
	}
	
	public String getEnglishWord(int index)
	{
		return englishWords[index];
	}
	
	public String getJapaneseWord(int index)
	{
		return japaneseWords[index];
	}
	
	public String getJapaneseChar(int index)
	{
		return japaneseChars[index];
	}
	
	public String getDanishWord(int index)
	{
		return danishWords[index];
	}
	
	public int getNextJapaneseIndex()
	{
		currentIndex++;
		currentIndex %= japaneseWords.length;
		return currentIndex;
	}
	
	public int getNextDanishIndex()
	{
		currentIndex++;
		currentIndex %= danishWords.length;
		return currentIndex;
	}
	
	public int getRandomIndex()
	{
		return rand.nextInt(englishWords.length);
	}
	
	public TranslationsManager(Main master)
	{
		this.master = master;
		rand = new Random();
		loadTransations();
	}
}
