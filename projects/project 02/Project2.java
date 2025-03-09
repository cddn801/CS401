// Project 2 - Dynamic Histogram
// Cameron Nicholson
import java.io.*;
import java.util.*;

public class Project2
{
	static final int INITIAL_CAPACITY = 10;
	public static void main (String[] args) throws Exception
	{
		
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Project2 <input filename>\n\n"); // i.e. C:\> java Project2 dictionary.txt
			System.exit(0);
		}
		int[] histogram = new int[0];
		String[] wordList = new String[INITIAL_CAPACITY];
		int wordCount = 0;
		BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
		while ( infile.ready() )
		{
			String word = infile.readLine();
			if (wordCount == wordList.length)
				wordList = upSizeArr(wordList);
			wordList[wordCount++] = word ;

			
			if (word.length() + 1 > histogram.length)
				histogram = upSizeHisto(histogram, word.length() + 1);
			
			++histogram[word.length()];
			
		}
		infile.close();

		wordList = trimArr( wordList, wordCount );
		System.out.println( "After final trim: wordList length: " + wordList.length + " wordCount: " + wordCount );

		for ( int i = 0; i < histogram.length ; i++ )
			System.out.format("words of length %2d  %d\n", i,histogram[i] );

	}

	static String[] upSizeArr(String[] fullArr)
	{	
		String[] newArr = new String[fullArr.length * 2];
		
		for (int origNum = 0; origNum < fullArr.length; origNum++)
		{
			newArr[origNum] = fullArr[origNum];
		}
		return newArr;
	}
	static String[] trimArr(String[] oldArr, int count)
	{
		String[] newArr = new String[count];
		
		for (int i = 0; i < count; i++)
		{
			newArr[i] = oldArr[i];
		}
		
		return newArr;
	}

	static int[] upSizeHisto( int[] oldArr, int newLength )
	{
		int[] newHisto = new int[newLength];
		for (int count = 0; count < oldArr.length; count++)
			newHisto[count] = oldArr[count];
		return newHisto;
	}
}