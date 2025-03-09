// PlainArraySortSearch class for Lab 4
// Cameron Nicholson
import java.util.*;
import java.io.*;

public class PlainArraySortSearch
{
	public static void main(String[] args) throws Exception
    {
		Random rand = new Random( 17 ); // any number will do to make program produce same numbers each execution
		int[] plainArr = new int[ 15 ] ;
		int count;

		for ( count=0; count<10; ++count )
			plainArr[count] = rand.nextInt( 100 ); // append a number in 0..99 inclusive.
		printArr( "plainArr count = " + count  + " after appending " + count + " random ints between 0..99", plainArr, count  );

		Arrays.sort( plainArr, 0, count ); // must feed sort the start ind and count
		printArr( "plainArr after Arrays.sort()", plainArr, count  ); // must pass in count

		int key = plainArr[7]; // grab the value at [7] just to guarantee a hit
		int index = Arrays.binarySearch( plainArr, 0, count, key );
		System.out.println( key + " found at index " + index );
		key = 200; // this number will NOT be found in the array
		index = Arrays.binarySearch( plainArr, 0, count, key ); // again must supplpy start ind and count
		System.out.println( key + " found at index " + index ); // belongs at [count] thus return -(count+1)
	}

	static void printArr( String caption, int[] arr, int count  ) // must pass in count
	{
		System.out.println( caption );
		for (int i=0 ; i<count ; ++i)
			System.out.print( arr[i] + " ");
		System.out.println();
	}
}