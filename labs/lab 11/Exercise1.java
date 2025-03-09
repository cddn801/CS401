/** 
 * Lab 11 - Exceptions
 * Exercise 1
 * Cameron Nicholson
 */
import java.io.*;
import java.util.*;
public class Exercise1
{
	public static void main( String args[] ) 
	{
		if (args.length < 1)
		{
			System.out.println("\nYou must enter an input filename on cmd line!\n");
			System.exit(0);
		}
		boolean loop;
		boolean end = false;
		Scanner infile = null;
		String filename = args[0];
		do
		{
			loop = false;
            try 
			{
				infile = new Scanner (new File( filename) );
			}
			catch (FileNotFoundException fnfe )
			{
				System.out.print(filename + " not found. Enter a valid filename: ");
				Scanner reader = new Scanner(System.in);
				filename = reader.nextLine();
				loop = true;
			}
			catch (Exception e )
			{
				System.out.print(filename + " not found. Enter a valid filename: ");
				Scanner reader = new Scanner(System.in);
				filename = reader.nextLine();
				loop = true;
			}
			finally
			{
				if(loop == false)
					end = true;
			}
        } while (end == false);
		while (infile.hasNext())
		{
			String token = infile.next();
			System.out.printf("%s\n", token);
		}
	}
}