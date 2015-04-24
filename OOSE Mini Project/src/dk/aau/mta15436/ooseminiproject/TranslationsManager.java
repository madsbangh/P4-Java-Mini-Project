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
	
	private Random rand;
	
	private void loadTransations()
	{
		String[] data = master.loadStrings(TRANSLATIONS_FILE);
		japaneseChars= data[0].split(",");
		japaneseWords = data[1].split(",");
		englishWords = data[2].split(",");
		danishWords = data[3].split(",");
	}
	
	public class JapaneseWordProvider implements TranslationsProvider
	{
		@Override
		public int getNextIndex()
		{
			return getNextJapaneseIndex();
		}

		@Override
		public String getWord(int index)
		{
			return getJapaneseWord(index);
		}
	}
	public JapaneseWordProvider japaneseWordProvider;
	
	public class JapaneseCharProvider implements TranslationsProvider
	{
		@Override
		public int getNextIndex()
		{
			return getNextJapaneseIndex();
		}

		@Override
		public String getWord(int index)
		{
			return getJapaneseChar(index);
		}
	}
	public JapaneseCharProvider japaneseCharProvider;
	
	public class DanishWordProvider implements TranslationsProvider
	{
		@Override
		public int getNextIndex()
		{
			return getNextDanishIndex();
		}

		@Override
		public String getWord(int index)
		{
			return getDanishWord(index);
		}
	}
	public DanishWordProvider danishWordProvider;
	
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
		return getRandomIndex();
	}
	
	public int getNextDanishIndex()
	{
		return getRandomIndex();
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
		japaneseWordProvider = new JapaneseWordProvider();
		japaneseCharProvider = new JapaneseCharProvider();
		danishWordProvider = new DanishWordProvider();
	}
}
