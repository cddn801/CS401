// Lab 3 - Insert in Order
// Cameron Nicholson
import java.util.*;
import java.io.*;

public class Lab3
{
	static final int INITIAL_CAPACITY = 5;

	public static void main( String args[] ) throws Exception
	{
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Lab3 L3input.txt\n");
			System.exit(0);
		}

		Scanner infile =  new Scanner( new File( args[0] ) );
		int[] arr = new int[INITIAL_CAPACITY];
		int count= 0;
		while (infile.hasNextInt())
		{
			if ( count == arr.length ) arr = upSize( arr );
			insertInOrder( arr, count, infile.nextInt() );
			++count;
		}
		infile.close();
		printArray( "SORTED ARRAY: ", arr, count );

	}

	static void printArray( String caption, int[] arr, int count  )
	{
		System.out.print( caption );
		for( int i=0 ; i<count ;++i )
			System.out.print(arr[i] + " " );
		System.out.println();
	}

	static void insertInOrder( int[] arr, int count, int key   )
	{
		if (count == 0)
			arr[0] = key;
		else
		{
			for (int i = count; i > 0; i--)
			{
				int temp = arr[i-1];
				if (key < arr[i-1])
				{
					arr[i] = temp;
					arr[i-1] = key;
				}
				else if ((key > arr[i-1]) && (arr[i] != key))
				{
					arr[i] = key;
					break;
				}
				else
					break;
			}
		}
	}
	static int[] upSize( int[] fullArr )
	{
		int[] newArr = new int[fullArr.length * 2];
		
		for (int origNum = 0; origNum < fullArr.length; origNum++)
		{
			newArr[origNum] = fullArr[origNum];
		}
		return newArr;
	}
}