import java.awt.Color;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Setup EZ graphics system
		EZ.initialize(800, 400);
		
		//Set background color to black
		EZ.setBackgroundColor(new Color(200,200,200)); 
		
		//Play sound throughout program
		EZSound sound = EZ.addSound("BackgroundMusic.WAV");
		sound.play();
		
		
		boolean exit = false; //will continue until exit is true
		
		while (exit!=true){ 
			
			//Set first background - The Home Planet
			Background HomePlanet = new Background("HomePlanet.png", 400, 200, "BackgroundMovement.txt");
			Background Ship0 = new Background("Ship3.png", 900, 250, "Ship.txt");
			Background Asteroid = new Background("Asteroid2.png",400,-400,"Asteroid.txt");
			Asteroid.FileRead();
			Reader People1 = new Reader(0, 1, 2, "Person1.png","Person2.png","Person3.png", "Left");
			People1.Execute();
			
			//Set second background - Space
			Background Space1 = new Background("Space.png", 440, 200, "BackgroundMovement.txt");
			//Ship that travelers are on
			Background Ship1 = new Background("Ship.png", 400, 200, "Ship.txt");
			//Make space background move - looks like ship is moving through space
			Space1.FileRead();
			Ship1.FileRead();
			
			//Set third background - The Ice Planet
			Background IcePlanet = new Background("IcePlanet.png", 400, 200, "Planet.txt");
			Background Ship2 = new Background("Ship3.png", 400, -200, "ShipLanding.txt");
			Ship2.FileRead();
			Reader Mei = new Reader(3, 4, 5, "Mei2.png","Mei1.png","Mei1.png", "Left");
			Mei.Execute();
			Reader People2 = new Reader(6, 7, 8, "Person1.png","Person2.png","Person3.png", "Right");
			People2.Execute();
			
			Background Space2 = new Background("Space.png", 900, 200, "BackgroundMovement.txt");
			Background Ship3 = new Background("Ship.png", 400, 200, "Ship.txt");
			Space2.FileRead();
			Ship3.FileRead();
			
			Background InvaderZim = new Background("InvaderZim.png", 400, 200, "Planet.txt");
			Background Ship4 = new Background("Ship3.png", -200, -200, "ShipLanding2.txt");
			Ship4.FileRead();
			Reader Gir = new Reader(9, 10, 11, "Gir1.png","Gir2.png","Gir2.png", "Right");
			Gir.Execute();
			Reader People3 = new Reader(12, 13, 14, "Person1.png","Person2.png","Person3.png", "Left");
			People3.Execute();
			
			Background Space3 = new Background("Space.png", 900, 200, "BackgroundMovement.txt");
			Background Ship5 = new Background("Ship.png", 400, 200, "Ship.txt");
			Space3.FileRead();
			Ship5.FileRead();
			
			Background KingdomHearts = new Background("KingdomHearts.png", 400, 200, "Planet.txt");
			Reader Heartless = new Reader(15, 16, 17, "Heartless1.png","Ship2.png","Heartless2.png", "Center");
			Heartless.Execute();
			
			Background Space4 = new Background("Space.png", 900, 200, "BackgroundMovement.txt");
			Background Ship7 = new Background("Ship.png", 400, 200, "Ship.txt");
			Space4.FileRead();
			Ship7.FileRead();
			
			Background GreenPlanet = new Background("GreenPlanet.png", 400, 200, "Planet.txt");
			Background Ship8 = new Background("Ship3.png", 400, -200, "ShipLanding.txt");
			Ship8.FileRead();
			Reader People4 = new Reader(18, 19, 20, "Person1.png","Person2.png","Person3.png", "Right");
			People4.Execute();
			
			Background Space5 = new Background("Space.png", -160, 170, "BackgroundMovement.txt");
			Background Explosion = new Background("Explosion.png", 500, 200, "Explosion.txt");
			Explosion.FileRead();
			
			Background Ending = new Background("Ending.png", 400, 200, "BackgroundMovement.txt");
			Background TheEnd = new Background("TheEnd.png", 400, 200, "TheEnd.txt");
			TheEnd.FileRead();
			
			exit = true;
		}

	}

}
