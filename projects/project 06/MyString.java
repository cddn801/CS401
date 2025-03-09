// MyString Class for MyStringTester
// Cameron Nicholson
public class MyString
{
	final int NOT_FOUND = -1;
	private char[] letters;
	
	public MyString( String other )
	{	
		int letterNum = other.length();
		letters = new char[letterNum];
		for (int i = 0; i < letterNum; i++)
		{
			letters[i]=other.charAt(i);
		}
	}
	public MyString( MyString other )
	{	
		int letterNum = other.length();
		letters = new char[letterNum];
		for(int i = 0; i < letterNum; i++)
		{
			letters[i]=other.charAt(i);
		}
	}	
	public int length()
	{
		return letters.length;
	}
	public char charAt(int index)
	{
		return letters[index];
	}
	int compareTo(MyString other)
	{
		int x = 0, y = 0;
		while (x < this.length() && y < other.length())
		{
			if ((letters[x] - other.charAt(y)) < 0)
			{
				if ((letters[x] - other.charAt(y)) < 0)
					return -1;
				else
					return 1;
			}	
			x++;
			y++;
		}
		if (x < letters.length)
			return 1;
		else if (y < other.length())
			return -1;
		return 0;
	}	
	public boolean equals(MyString other)
	{
		if (compareTo(other) == 0)
			return true;
		else 
			return false;
	}
	public int indexOf(int startIndex, char ch)	
	{
		for (int i = startIndex; i < letters.length; i++)
		{
			if(ch == letters[i])
				return i;
		}
		return -1;
	}
	public int indexOf(MyString key) 
	{	
		int indexOfFirst = indexOf( 0, key.charAt(0) );
		if (indexOfFirst == NOT_FOUND )
			return NOT_FOUND;
		while ( indexOfFirst != NOT_FOUND )
		{
			int indexOfNext = partSearch( indexOfFirst, key );
			if (indexOfNext != NOT_FOUND)
				return indexOfNext;
			else
				indexOfFirst = indexOf( indexOfFirst + 1, key.charAt(0) );
		}
		return -1;
	}
	
	private int partSearch (int startNum, MyString key)
	{
		int x = startNum, y = 0;
		int keyLength = key.length();
		while (x < letters.length && y < keyLength)
		{
			if (letters[x] == key.charAt(y))
			{
				x++;
				y++;
			}
			else
				break;
		}
		if (y == keyLength)
			return startNum;
		else 
			return -1;
	}
	
	public String toString()
	{
		String temp = new String(letters);
		return temp;
	}
}