/** 
 * Lab 11 - Exceptions
 * Exercise 2
 * Cameron Nicholson
 */
import java.io.*;
import java.util.*;

public class Exercise2
{
	public static void main( String args[] )
	{
		boolean loop;
		boolean end = false;
		int num;
		do 
		{
			loop = false;
			try
			{
				Scanner kbd = new Scanner(System.in);
				System.out.print("Enter int in range 1..100 inclusive: ");
				num = kbd.nextInt();
				if(num < 1 || num > 100)
				{
					System.out.println("Number out of range. Must be in 1..100");
					loop = true;
				}
				else
				{
					System.out.format("\nThank you. You entered %d\n", num );
				}
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Input was not an integer");
				loop = true;
			}
			finally
			{
				if(loop == false)
					end = true;
			}
        } while (end == false);
	}
}