// Lab 10 - Duplicate Detection
// Cameron Nicholson
import java.io.*;
import java.util.*;

public class Lab10
{
	public static void main(String[] args) throws Exception
	{
		HashSet<String> set = new HashSet<String>();
		boolean noDupe = true;
		Scanner infile = new Scanner( new File(args[0]) );
		while (infile.hasNext() && noDupe == true)
			noDupe = (set.add( infile.next() ));
		infile.close();
		if (noDupe == false)
			System.out.println("NOT UNIQUE");
		else
			System.out.println("UNIQUE");
	}
}