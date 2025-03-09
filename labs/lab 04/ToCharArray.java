// ToCharArray class for Lab 4
// Cameron Nicholson
import java.util.*;
import java.io.*;

public class ToCharArray
{
	public static void main(String[] args) 
    {	
		for (String word : args ) // if you dont put words on the cmd line this loop skips over
			System.out.println( word + " => " + canonical( word ) );
	}

	// Extracts the letters from word into a char array and sorts that char array. 
	// Returns a new String consisting of those letters in sorted (canonical) form
	
	static String canonical( String word )
	{	// assume word is "zebra"
		char[] letters = word.toCharArray(); // letters: [z][e][b][r][a]
		Arrays.sort( letters ); // letters: [a][b][e][r][z]
		return new String( letters ); // String allows initialize with char arr
	}
}