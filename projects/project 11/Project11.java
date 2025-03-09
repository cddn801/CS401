/** 
 * Project 11 - Extending the Exception Class
 * Project 11 Driver class
 * Cameron Nicholson
 */
import java.util.*;
public class Project11
{
	public static void main( String args[] )
	{
		int num = 0;
		Scanner kbd = new Scanner(System.in);
		do
		{
			System.out.print("Enter int in range 1..100 inclusive: ");
			try
			{
				num=kbd.nextInt();
				if(num<1 || num>100)
					throw new NumberOutOfRangeException("Number out of range. Must be in 1..100");
			}
			catch ( InputMismatchException e) 
			{
				System.out.println("Input was not an integer ");
				kbd.nextLine();
			}
			catch ( NumberOutOfRangeException e ) 
			{
				System.out.println(e.getMessage());
				kbd.nextLine();
			}
			catch ( Exception e ) 
			{
				System.out.println(e);
				System.exit(0);
			}
		} while(num<1 || num>100);
		
		System.out.format("\nThank you. You entered %d\n", num );
	}
}

// Exception class for Project 11
class NumberOutOfRangeException extends Exception
{
	public NumberOutOfRangeException(String msg) 
	{
		super(msg);
	}
}