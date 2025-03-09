// Coin class for CoinTester
// Cameron Nicholson
import java.util.Random;
public class Coin
{
	private final int heads = 1;
	private final int tails = 0;
	private Random random;
  	private int numHeads, numTails;

	public Coin( int seed )
  	{
		random = new Random(seed);
		reset();
	}
	
	public String flip()
	{
		int option = random.nextInt(2); 
		if (option == heads)
		{
			numHeads++;
			return "H";
		}
		else
		{
			numTails++;
			return "T";
		}
	}

	public int getNumHeads()
	{
		return numHeads;
	}

	public int getNumTails()
	{
		return numTails;
	}
	
	public void reset()
	{
		numHeads = 0;
		numTails = 0;
	}
}