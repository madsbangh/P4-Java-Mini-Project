package dk.aau.mta15436.ooseminiproject;

import java.util.ArrayList;

public abstract class Room
{
	// Container for all the GUI elements in the room
	protected ArrayList<GUIElement> guiElements = new ArrayList<GUIElement>();
	// Reference to the PApplet so we can pass it on to Buttons etc.
	protected Main master;
	
	protected class GoToNextRoom implements GUICallback
	{
		private Room nextRoom;
		
		@Override
		public void call()
		{
			master.goToRoom(nextRoom);
		}
		
		public GoToNextRoom(Room nextRoom)
		{
			this.nextRoom = nextRoom;
		}
	}
	
	// Create and set up all the GUI elements
	protected abstract void setup();
	protected abstract void draw();
	
	// Add a new GUI element to the GUIElement list of this room
	protected void addElement(GUIElement element)
	{
		guiElements.add(element);
	}
	
	public void update()
	{
		draw();
		for (GUIElement element : guiElements)
		{
			element.update();
		}
	}
	
	public Room(Main master)
	{
		this.master = master;
		setup();
	}
}