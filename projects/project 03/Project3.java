// Project3 - InsertInOrder with bSearch
// Cameron Nicholson
import java.util.*;
import java.io.*;

public class Project3
{
	static final int INITIAL_CAPACITY = 5;

	public static void main( String args[] ) throws Exception
	{
		if (args.length < 1 )
		{
			System.out.println("ERROR: Must enter an int on cmd line (i.e. # of random ints to put in array)\n");
			System.exit(0);
		}

		int numInts2generate = Integer.parseInt( args[0] );

		// random number generator to fill our array
		Random randGen =  new Random( 17 ); // seed with 17
		int[] arr = new int[INITIAL_CAPACITY];
		int count= 0;
		for ( int i = 0 ; i<numInts2generate ; ++i)
		{
			if ( count==arr.length ) arr = upSizeArr(arr);
			insertInOrder( arr, count++, 1 + randGen.nextInt(1000) );
		}

		arr=trimArr(arr,count);
		printArray( arr );
	}

	static void printArray( int[] arr  )
    {
        for( int i=0 ; i<arr.length ;++i )
            System.out.print(arr[i] + " " );
        System.out.println();
    }
	
	static int[] upSizeArr( int[] fullArr )
	{
		int[] upSizedArr = new int[ fullArr.length * 2 ];
		for ( int i=0; i<fullArr.length ; ++i )
			upSizedArr[i] = fullArr[i];
		return upSizedArr;
	}

	static int[] trimArr( int[] oldArr, int count )
	{
		int[] trimmedArr = new int[ count ];
		for ( int i=0; i<count ; ++i )
			trimmedArr[i] = oldArr[i];
		return trimmedArr;
	}

	static void insertInOrder( int[] arr, int count, int newVal )
	{
		int index = bSearch( arr, count, newVal);
		if (index < 0)
			index = -(index + 1);	
		for (int i = count-1; i >= index; i--)
		{
			arr[i+1] = arr[i];
		}
		arr[index] = newVal;
	}

	static int bSearch(int[] a, int count, int key)
	{
		int LO = 0;
		int HI = count-1;
		int MID = 0;
		while ( LO <= HI )
		{
			MID = Math.abs((HI-LO)/2) + LO;
			if (a[MID] < key)
				LO = MID + 1;
			else if (a[MID] > key)
				HI = MID - 1;
			else if (a[MID] == key)
				return MID;
		}  
		   int encodedIndex = -(LO + 1);
		   return encodedIndex;
	}
}