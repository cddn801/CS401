// Lab 8 - Tracing Recursion
// Cameron Nicholson
import java.io.*;
public class Recursion
{	public static void main( String[] args )
	{
		mystery1( 314159 );
		System.out.println();
		System.out.println( mystery2( 314159 ) );
		int[] arr = { 3,1,4,1,5,9 };
		System.out.println( mystery3( arr, arr.length-1 ) );
		if ( mystery4( arr, 0) )
			System.out.println( "RETURNED TRUE");
		else 
			System.out.println( "RETURNED FALSE");
		mystery5( 5 ); System.out.println();
		mystery6( 5 ); System.out.println();
		mystery7( 5 ); System.out.println();
	}
	static void mystery1 ( int n )
	{	if ( n==0 ) return;
		System.out.print( n % 10 );
		mystery1( n/10 );
	}
	static int mystery2( int n )
	{
		if ( n==0) return 0;
		return (n%10) + mystery2( n/10);
	}
	static int mystery3( int arr[], int i )
	{	if ( i == -1) return 0;
		return arr[i] + mystery3( arr, i-1);
	}
	static boolean mystery4( int arr[], int i )
	{	if ( i==arr.length-1) return true;
		if ( arr[i]>arr[i+1]) return false;
		return (mystery4( arr, i+1) );
	}
	static void mystery5 ( int n )
	{	if (n==0) return;
		System.out.print(n + " ");
		mystery5(n-1);
	}
	static void mystery6 ( int n )
	{	if (n==0) return;
		mystery6(n-1);
		System.out.print(n + " ");
	}
	static void mystery7 ( int n )
	{	if (n==0) return;
		System.out.print(n + " ");
		mystery7(n-1);
		System.out.print(n + " ");
	}
}