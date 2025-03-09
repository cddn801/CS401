// Project4 - ArrayList & Jumbled Words
// Cameron Nicholson
import java.util.*;
import java.io.*;

public class Project4
{
	public static void main(String[] args) throws Exception
    {	
		if (args.length < 2 )
		{
			System.out.println("\nusage: C:\\> java Project4 dictionary.txt jumbles.txt\n");
			System.exit(0);
		}
		
		ArrayList<String> pairs = new ArrayList<String>();
		BufferedReader dfile = new BufferedReader( new FileReader(args[0]) );
		while ( dfile.ready() )
		{
			String newWord = dfile.readLine();
			String newWordSort = toCanonical(newWord);
			String bigWord = newWordSort + " " + newWord;
			pairs.add(bigWord);
		}
			Collections.sort(pairs);
		
		ArrayList<String> dCanons = new ArrayList<String>();
		ArrayList<String> dWords = new ArrayList<String>();
		for (String line: pairs)
		{
			String[] pair = line.split( "\\s+");  
			dCanons.add(pair[0]);
			dWords.add(pair[1]);
		}
		
		ArrayList<String> jWords = new ArrayList<String>();
		BufferedReader jfile = new BufferedReader( new FileReader(args[1]) );
		while ( jfile.ready() )
		{
			String newWord = jfile.readLine();
			jWords.add(newWord);
		}
			Collections.sort(jWords);


		for (String jWord: jWords)
		{
			System.out.print(jWord + " ");
			String jCanon = toCanonical(jWord);
			int index = Collections.binarySearch( dCanons, jCanon );
			if (index < 0)
				System.out.print('\n');
		
			else
			{
				int low = index;
				while(low >= 0)
				{
					if ((dCanons.get(low).compareTo(jCanon) != 0))
					{
						break;
					}
					low--;
				}
				low++;
				
				while((low <= dCanons.size()-1) && (dCanons.get(low).equals(jCanon)))
				{
					System.out.print(dWords.get(low) + " ");
					low++;
				}
				System.out.print('\n');
			}
		}
	}		
	
	static String toCanonical( String word )
	{
		char[] letters = word.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}
}