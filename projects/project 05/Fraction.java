// Fraction Class for FractionTester
// Cameron Nicholson
public class Fraction
{
	private int numer;
	private int denom;
	
	public int getNumer()
	{
		return numer;
	}
	public int getDenom()
	{
		return denom;
	}
	public String toString()
	{
		return numer + "/" + denom;
	}
	
	public void setNumer( int n )
	{
		numer = n;
	}
	public void setDenom( int d )
	{
		if (d!=0)
			denom=d;
		else
		{
			System.exit(0);
		}
	}

	public Fraction()
	{
		this( 0, 1 ); 
	}

	public Fraction( int n )
	{
		this( n, 1 ); 
	}
	
	public Fraction( int n, int d )
	{
		int gcd = gcd(n,d); 
		setNumer(n/gcd);		
		setDenom(d/gcd);
	}
	
	public Fraction( Fraction other )
	{
		this( other.numer, other.denom ); 
	}

	public Fraction add( Fraction other )
	{
		return new Fraction(((numer*other.denom) + (other.numer*denom)),(denom*other.denom));        
	} 
	
	public Fraction subtract( Fraction other )
	{
		return new Fraction(((numer*other.denom) - (other.numer*denom)),(denom*other.denom));
	}
	
	public Fraction multiply( Fraction other )
	{
		return new Fraction((numer*other.numer),(denom*other.denom));
	}
	
	public Fraction divide( Fraction other )
	{
		return new Fraction((numer*other.denom),(denom*other.numer));
	}
	
	public Fraction reciprocal()
	{
		return new Fraction( denom , numer );
	}

	private int gcd( int n, int d)
	{
		int gcd;
		if (d > n)
			gcd=n;
		else 
			gcd=d;
		while( gcd > 0 )
		{
			if ((n % gcd == 0) && (d % gcd == 0)) 
				return gcd; 
			else 
				--gcd;
		}
		return 1;
	}
}
