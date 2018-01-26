
public class Actor {

	private EZImage actorPicture;
	
	//moveto
	private int x, y, startx, starty;
	private int destx, desty;
	private long starttime;
	private long duration;
	private boolean interpolation;
	//turnto
	private float startangle, endangle;
	private float currentangle;
	private boolean rotation;
	
	//Constructor
	//actor with the filename to load an image and the pos of the image
	Actor(String filename, int posx, int posy) {
		actorPicture = EZ.addImage(filename, posx, posy);
		x = posx;
		y = posy;
		startx = x;
		starty = y;
		//sets the interpolation and rotation booleans to false
		interpolation = false;
		rotation = false;

	}
	
	// Set the destination by giving it 3 variables
	// Dur means duration and is measured in seconds
	public void setDestination(int posx, int posy, long dur){
		
		// Set destination position and duration
		// Convert seconds to miliseconds
		destx = posx; desty = posy; duration = dur*1000;
		
		// Get the starting time (i.e. time according to your computer)
		starttime = System.currentTimeMillis();
		
		// Set the starting position of your bug
		startx=x; starty=y;
		
		// Set interpolation mode to true
		interpolation = true;
		
		
	}
	
	// This moves the bug based on the current time and elapsed time according to the interpolation equation
	public void moveto(){
		
		// If interpolation mode is true then do interpolation
		if (interpolation == true) {
			
			// Normalize the time (i.e. make it a number from 0 to 1)
			float normTime = (float) (System.currentTimeMillis() - starttime)/ (float) duration;
			
			// Calculate the interpolated position of the bug
			x = (int) (startx + ((float) (destx - startx) *  normTime));
			y = (int) (starty + ((float) (desty - starty) *  normTime));
			
			// If the difference between current time and start time has exceeded the duration
			// then the animation/interpolation is over.
			if ((System.currentTimeMillis() - starttime) >= duration) {
				
				// Set interpolation to false
				interpolation = false;
				
				// Move the bug all the way to the destination
				x = destx; y = desty;
			}
			//to move the image itself.
			actorPicture.translateTo(x,y);	
		}
		
	}
	

	public boolean moving() {
		return interpolation;
	}
	
	// ********* SCALE
	public void setAngle(float angle, float dur){
		endangle = angle;
		starttime = System.currentTimeMillis();
		startangle = currentangle;
		rotation = true;
	}
	
	public void turnto() {
	if (rotation == true){
	// Normalize the time (i.e. make it a number from 0 to 1)
	float normTime = (float) (System.currentTimeMillis() - starttime)/ (float) duration;
	
	// Calculate the interpolated position of the bug
	currentangle =  (startangle + ((float) (endangle - startangle) *  normTime));

	
	// If the difference between current time and start time has exceeded the duration
	// then the animation/interpolation is over.
	if ((System.currentTimeMillis() - starttime) >= duration) {
		
		// Set interpolation to false
		rotation = false;
		
		// Scale the bug all the way to the destination
		currentangle = endangle;
	}
	// to rotate the image itself.
	actorPicture.rotateTo(currentangle);	
	}
	}

	public boolean turning() {
		return rotation;
	}
	//loads a sound and then plays the sound
	public void playsound(String filename2) {
	EZSound Sound = EZ.addSound(filename2);
	Sound.play();
	}
}
