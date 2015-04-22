package dk.aau.mta15436.ooseminiproject;

import processing.core.*;

public class Main extends PApplet
{
	// Whether the mouse has been pressed this frame
	public boolean click = false;
	// We can disable mouse clicking if we want
	public boolean mouseEnabled = true;
	
	// Just because PApplet
	private static final long serialVersionUID = 3286085431838033816L;
	// The currently active room. We start in the menu
	private Room currentRoom = new Menu(this);
	
	// Change the current room for the provided Room object
	public void goToRoom(Room room)
	{
		currentRoom = room;
		// Set click to false to avoid automatically pressing eventual elements in the next room
		click = false;
		// Re-enable mouse if it has been disabled
		mouseEnabled = true;
	}

	public void setup()
	{
		size(400, 600);
		textAlign(CENTER, CENTER);
		noStroke();
	}
	
	public void draw()
	{
		// Update the current room so it can draw its elements and do its logic
		currentRoom.update();
		// Reset click to false every frame
		click = false;
	}
	
	public void mousePressed()
	{
		// Click is true for this frame
		if (mouseEnabled)
		{
			click = true;			
		}
	}

	public static void main(String[] args)
	{
		PApplet.main(new String[] { "dk.aau.mta15436.ooseminiproject.Main" });
	}
}
