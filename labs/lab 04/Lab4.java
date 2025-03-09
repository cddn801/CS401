// Lab 4 - Plain Arrays vs. ArrayList
// Lab 4 Driver class
// Cameron Nicholson
import java.util.*;
import java.io.*;

public class Lab4
{
	public static void main(String[] args) throws Exception
    {	
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Lab4 jumbles.txt\n");
			System.exit(0);
		}
		
		ArrayList<String> wordList = new ArrayList<String>();
		BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
		while ( infile.ready() )
		{
			String newWord = infile.readLine();
			wordList.add(newWord);
		}
			Collections.sort(wordList); 
			printList(wordList);
	}
	
	static String canonical( String word )
	{
		char[] letters = word.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}
	
	static void printList( ArrayList<String> list )
	{
		for (String n : list)
			System.out.println( n + " " + canonical( n ) );
	}
}