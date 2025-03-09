// Fraction Class for FractionTester
// Cameron Nicholson
public class Fraction implements Comparable<Fraction>
{
	private int numer;
	private int denom;

	public int getNumer()
	{	return numer;
	}
	public int getDenom()
	{	return denom;
	}
	
	public void setNumer( int n )
	{	numer = n;
	}
	public void setDenom( int d )
	{
		if (d==0) { System.out.println("Can't have 0 in denom"); System.exit(0); }
		else denom=d;
	}
	
	public Fraction( int n, int d )
	{	int gcd = gcd( n, d );
		setNumer(n/gcd);
		setDenom(d/gcd);
	}
	private int gcd( int n, int d )
	{	int gcd = n<d ? n : d; 
		while( gcd > 0 ) 
			if (n%gcd==0 && d%gcd==0) return gcd; else --gcd;
		return 1; 
	}
	
	public Fraction( Fraction other )
	{
		this( other.getNumer(), other.getDenom() );
	}
	
	public int compareTo( Fraction other )
	{
		Fraction myFraction = new Fraction(((numer*other.denom) - (other.numer*denom)),(denom*other.denom));
		if ((myFraction.numer > 0 && myFraction.denom > 0) || (myFraction.numer < 0 && myFraction.denom < 0))
			return 1;
		else if ((myFraction.numer < 0 && myFraction.denom > 0) || (myFraction.numer > 0 && myFraction.denom < 0))
			return -1;
		else
			return 0;
	}
	
	public String toString()
	{
		return getNumer() +  "/" + getDenom() + "\t=" +  + ((double)getNumer()/(double)getDenom()); 
	}
}
