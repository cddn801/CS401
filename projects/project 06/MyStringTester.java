/** 
 * Project 6 - Writing the MyString Class
 * MyStringTester Driver class
 * Cameron Nicholson
 */
public class MyStringTester
{
	public static void main( String[] args )
	{
		MyString s1 = new MyString("Hello World");
		System.out.println( "s1=" + s1 );
		
		MyString s2 = new MyString(s1);
		System.out.println( "s2=" + s2 );
		
		if ( s1.equals( s2 ) )
			System.out.println( s1 + " identical to " + s2 );
		else
			System.out.println( s1 + " not identical to " + s2 );
		
		MyString s3 = new MyString( "GoodBye World" );
		System.out.println( "s3='" + s3 + "' and its length is: " + s3.length() );
		
		if ( s1.equals( s3 ) )
			System.out.println( s2 + " identical to " + s3 );
		else
			System.out.println( s1 + " not identical to " + s3 );
		
		s1=new MyString("albert"); s2=new MyString("alpha");
		System.out.println( "s1=" + s1 + "\ns2=" + s2 );
		System.out.println( "s1.compareTo(s2) ==> " + s1.compareTo(s2) ); // since "albert"  < "alpha" returns -1
		
		s1=new MyString("zebrano"); s2=new MyString("zebra");
		System.out.println( "s1=" + s1 + "\ns2=" + s2 );
		System.out.println( "s1.compareTo(s2) ==> " + s1.compareTo(s2) ); // since "zebrano"  > "zebra" returns 1		
		
		s1=new MyString("cattle"); s2=new MyString("catty");
		System.out.println( "s1=" + s1 + "\ns2=" + s2 );
		System.out.println( "s1.compareTo(s2) ==> " + s1.compareTo(s2) ); // since "cattle"  < "cattle" returns 1			
		
		s1=new MyString("pneumoencephalographically"); s2=new MyString("pneumoencephalographically");
		System.out.println( "s1=" + s1 + "\ns2=" + s2 );
		System.out.println( "s1.compareTo(s2) ==> " + s1.compareTo(s2) ); // returns 0 they are same string value
		
		System.out.println( "[4]'th letter of " + s3 + " is " + s3.charAt(4) );
			
		MyString key = new MyString("rld");
		System.out.println( key + " found in " + s3 + " at index: " + s3.indexOf( key ) );
		// SAME THING BUT WITHOUT USING A MyString VAR FOR THE KEY
		System.out.println( new MyString("Goo") + " found in " + s3 + " at index: " + s3.indexOf( new MyString("Goo") ) );
		System.out.println( new MyString("Bye") + " found in " + s3 + " at index: " + s3.indexOf( new MyString("Bye") ) );
		System.out.println( new MyString("zorp") + " found in " + s3 + " at index: " + s3.indexOf( new MyString("zorp") ) );
	}

}