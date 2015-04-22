package dk.aau.mta15436.ooseminiproject;

public abstract class Room
{
	// Container for all the GUI elements in the room
	protected GUIElement[] guiElements;
	
	// Create and set up all the GUI elements
	protected abstract void setup();
	
	public void update()
	{
		for (GUIElement element : guiElements)
		{
			element.update();
		}
	}
	
	public Room()
	{
		setup();
	}
}