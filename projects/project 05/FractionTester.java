/** 
 * Project 5 - Writing the Fraction
 * FractionTester Driver class
 * Cameron Nicholson
 */
public class FractionTester
{
	public static void main( String args[] )
	{
		Fraction f1 = new Fraction( 44,14 ); // reduces to 22/7
		System.out.println( "f1=" + f1 ); // should output 22/7

		Fraction f2 = new Fraction( 21,14 ); // reduces to 3/2
		System.out.println( "f2=" + f2 ); // should output 3/2

		System.out.println( f1.add( f2 ) ); // should output 65/14
		System.out.println( f1.subtract( f2 ) ); // should output 23/14
		System.out.println( f1.multiply( f2 ) ); // should output 33/7
		System.out.println( f1.divide( f2 ) ); // should output 44/21
		System.out.println( f1.reciprocal() ); // should output 7/22

	}
}