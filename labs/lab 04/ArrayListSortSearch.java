// ArrayListSortSearch class for Lab 4
// Cameron Nicholson
import java.util.*;
import java.io.*;

public class ArrayListSortSearch
{
	public static void main(String[] args) throws Exception
    {
		Random rand = new Random( 17 ); // any number will do to make program produce same numbers each execution 
		ArrayList<Integer> aList = new ArrayList<Integer>(); // Must use Integer instead of int. No primitives allowed  

		for ( int i=0 ; i<10; ++i ) 
			aList.add( rand.nextInt( 100 ) ); // append a number in 0..99 inclusive.
		printList( "aList .size() = " + aList.size() + " after .add() ing 10 random ints between 0..99", aList  );
		
		Collections.sort( aList ); // no start ind or count needed. list maintains internal count
		printList( "aList after Collections.sort()", aList  );
		
		int key = aList.get( 7 ); // grab the value at [7] just to guarantee a hit
		int index = Collections.binarySearch( aList, key );
		System.out.println( key + " found at index " + index );
		key = 200; // this number will NOT be found in the list
		index = Collections.binarySearch( aList, key );
		System.out.println( key + " found at index " + index ); // belongs at [.size()] thus return -(.size()+1)
	}
	static void printList( String caption, ArrayList<Integer> list )
	{
		System.out.println( caption );
		for (int n : list) 
			System.out.print( n + " ");
		System.out.println();
	}
}