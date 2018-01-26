import java.util.*;
import java.io.*;

public class Reader {
	int i;
	Scanner test[] = new Scanner[3];
	Actor testActor[] = new Actor[3];
	
	//Reads different commands.txt for each actor depending on the int variables and uses different pictures for the actors depending on
	//on the different String variables chosen. Then draws the characters on either the right side, left side, or center of the screen.
	Reader(int x, int y, int z, String A, String B, String C, String D) throws FileNotFoundException {
		FileReader reader0 = new FileReader("cmds"+x+".txt");
		FileReader reader1 = new FileReader("cmds"+y+".txt");
		FileReader reader2 = new FileReader("cmds"+z+".txt");
		test[0] = new Scanner(reader0);
		test[1] = new Scanner(reader1);
		test[2] = new Scanner(reader2);
		if(D == "Left"){
			testActor[0] = new Actor(A, -150, 200);
			testActor[1] = new Actor(B, -150, 200);
			testActor[2] = new Actor(C, -150, 200);
		}else if(D == "Right"){
			testActor[0] = new Actor(A, 950, 200);
			testActor[1] = new Actor(B, 950, 200);
			testActor[2] = new Actor(C, 950, 200);
		}else if(D == "Center"){
			testActor[0] = new Actor(A, 175, -200);
			testActor[1] = new Actor(B, 400, -200);
			testActor[2] = new Actor(C, 725, -200);
		}
		
	}
	//executes the cmds
	public void Execute() {
		while (test[i].hasNextLine()) {
		String Commands;
		Commands = test[i].next();
		if(Commands.contains("Switch0")) {
		//test[i] = test[0];

		//testActor[i] = testActor[0];
			i = 0;
		}
		if (Commands.contains("Switch1")) {
			//test[i] = test[1];

			//testActor[i] = testActor[1];
			i = 1;
		}
		if (Commands.contains("Switch2")) {
			//test[i] = test[2];

			//testActor[i] = testActor[2];
			i = 2;
		}
		if(Commands.contains("moveto")) {
			int x = test[i].nextInt();
			int y = test[i].nextInt();
			int dur = test[i].nextInt();
		boolean run = true;
		do {
				testActor[i].setDestination(x, y, dur);
				// While the actor should be moving...
				while(testActor[i].moving()) {	
				// Call the go member function of the bug to make it move.
					testActor[i].moveto();
				// Refresh the screen
				EZ.refreshScreen();
				run = false;
				}
				// If run is true then keep looping.
				} while(run == true);	
				}
		if(Commands.contains("turnto")){
		int angle = test[i].nextInt();
		int time = test[i].nextInt();
		boolean rotation = true;
		do {
				testActor[i].setAngle(angle, time);
				// While the actor should be turning...
				while(testActor[i].turning()) {	
				// Call the go member function of the actor to make it turn.
					testActor[i].turnto();
				// Refresh the screen
				EZ.refreshScreen();
				rotation = false;
				}
			
			// If rotation is true then keep looping.
			} while(rotation == true);
			}	
		//if commands contains PLAY then the playsound method is used
		if(Commands.contains("PLAY")){
		String sound = test[i].next();
		testActor[i].playsound(sound);
		}
		
		}
	

}
}

