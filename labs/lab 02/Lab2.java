// Lab 2 - Min Max Perfect and Prime
// Cameron Nicholson
import java.io.*;
import java.util.*;
 
public class Lab2
{
    public static void main (String args[]) throws Exception // we NEED this 'throws' clause
    {
      
        if (args.length < 3)
        {
            System.out.println("\nusage: C:\\> java Lab2 <input file name> <lo>  <hi>\n\n");
            // i.e. C:\> java Lab2 L2input.txt 1 30
            System.exit(0);
        }

        String infileName = args[0];
        int lo = Integer.parseInt(args[1]);
        int hi = Integer.parseInt(args[2]);
 
        Scanner infile = new Scanner( new File(infileName) );
        int min,max;
        min=max=infile.nextInt();
		
		// Tracks the total number of tokens in the file. For use in calculating the initial max and min of the file. //
		int fileTotal = 0;
        while ( infile.hasNextInt() )
        {
			// takes the next number in the file and assigns it to num. //
			int num = infile.nextInt();
			
			if (fileTotal == 0){
				max = num;
				min = num;
			}
			else 
            {
				if (num > max){ // Compares num to the current max value. //
					max = num;
				}
				else if (num < min){ // Compares num to the current min value. //
					min = num;
				}
			}
			
			fileTotal ++;
        }
		
        System.out.format("min: %d max: %d\n",min,max);
        for ( int i = lo ; i <= hi ; ++i)
        {
            System.out.print( i );
            if ( isPrime(i) ) System.out.print( " prime ");
            if ( isPerfect(i) ) System.out.print( " perfect ");
            System.out.println();
        }
    }
   
    // RETURNs true if and only if the number passed in is perfect
    static boolean isPerfect( int n )
    {  
		// Returns false all numbers less than the first perfect number, 6. //
        if(n < 6){ return false; }
		
		int halfNum = n / 2;
		int origSumNum = 0;
		
		// This loop adds up all of the integers that factor evenly into the number given. //
        for (int i = 1; i <= halfNum; i++) 
        {
            // If the factor divides evenly, the factor is added to the sum of the factors: origSumNum //
            if(n % i == 0) {
                    origSumNum = origSumNum + i; // adds the factor to the sum of factors
            }
               
        }
		
		// If the factors that divide evenly add up to the original number, returns true. //
        if (n == origSumNum){ return true; }
		
		// If the factors don't add up to the original number, the method returns false. Number is not perfect. //
        else{ return false; }
    }
	
    // RETURNs true if and only if the number passed in is prime
    static boolean isPrime( int n )
    {  
		// Returns false every number before the first prime number, 2. //
        if(n < 2){ return false; }
		
		int rootNum = (int)Math.sqrt(n); // takes the square root of n and limits the for loop 
		
		// Checks any number > 2 for being prime //
		for (int i = 2; i <= rootNum; i++)
		{
			// If the number has a factor other equal to i, it is not prime. Returns false. //
			if(n % i == 0){ return false; }
 
		}
		// If the number doesn't meet the criteria above, it is prime. //
		return true;
	}		
}