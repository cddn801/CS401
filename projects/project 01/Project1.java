// Project 1 - CS0007 Review
// Cameron Nicholson
import java.io.*;
import java.util.Scanner;

public class Project1
{
	public static void main( String args[] ) throws Exception
	{
		final double MILES_PER_MARATHON = 26.21875;

		Scanner kbd = new Scanner (System.in);
		double aveMPH=0, aveMinsPerMile=0, aveSecsPerMile=0;
		System.out.print("Enter marathon time in hrs minutes seconds: ");
		
		// recorded time values //
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		
		hours = kbd.nextInt();
		minutes = kbd.nextInt();
		seconds = kbd.nextInt();
		
		double totalSecs = 0;
		double totalHours = 0;
		double totalSecsPerMile = 0;
		
		// Calculations for average mph output //
		totalSecs = hours * 3600 + minutes * 60 + seconds;
		totalHours = totalSecs / 3600;
		aveMPH = MILES_PER_MARATHON / totalHours;
		
		// Calculations for mph split output //
		totalSecsPerMile = totalSecs / MILES_PER_MARATHON;
		aveMinsPerMile = (totalSecsPerMile % 3600) / 60 - 1;
		aveSecsPerMile = (totalSecsPerMile % 3600) % 60;
		
		System.out.println();
		System.out.format("Average MPH was: %.2f mph\n", aveMPH  );
		System.out.format("Average mile split was %.0f mins %.1f seconds per mile", aveMinsPerMile, aveSecsPerMile );
		System.out.println();

	} 
}