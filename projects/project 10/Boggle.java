// Boggle class for Project 10
// Cameron Nicholson
import java.io.*;
import java.util.*;

public class Boggle
{
	static int numWordsFormed = 0;
	static HashSet<String> set = new HashSet<String>();
	static TreeSet<String> tree = new TreeSet<String>();
	
	public static void main(String[] args) throws Exception
	{
		Scanner reader = new Scanner( new File(args[0]) );
		while (reader.hasNext())
			set.add( reader.next() );
		reader.close();
		
		Scanner infile = new Scanner( new File(args[1]) );
        int rows = infile.nextInt();
        int cols = rows;
        String[][] board = new String[rows][cols];
        for(int r = 0; r < rows ; r++)
           for(int c = 0; c < cols; c++)
                 board[r][c] = infile.next();
        infile.close();
			 
		for(int r = 0; r < rows ; r++)
           for(int c = 0; c < cols; c++)
			   depthFirstSearch( board, r, c, "");
		
		int treeSize = tree.size();
		for(int i = 0; i<treeSize; i++)
		{
			System.out.println(tree.first());
			tree.remove(tree.first());
		}
	}
	
	static void depthFirstSearch( String[][] board, int r, int c, String word )
	{
		word += board[r][c];
		if(set.contains(word) == true && word.length()>2)
			tree.add(word);
		
		if((r-1>=0)&&(board[r-1][c] != "0"))
		{
			String tempN = board[r][c];
			board[r][c] = "0";
			depthFirstSearch(board, r-1, c, word);
			board[r][c] = tempN;
		}
		if (((r-1>=0)&&(c+1<board.length))&&(board[r-1][c+1] != "0"))
		{
			String tempNE = board[r][c];
			board[r][c] = "0";
			depthFirstSearch( board, r-1, c+1, word );
			board[r][c] = tempNE;
		}
		if ((c+1<board.length)&&(board[r][c+1] != "0"))
		{
			String tempE = board[r][c];
			board[r][c] = "0";
			depthFirstSearch( board, r, c+1, word );
			board[r][c] = tempE;
		}
		if (((r+1<board.length)&&(c+1<board.length))&&(board[r+1][c+1] != "0"))
		{
			String tempSE = board[r][c];
			board[r][c] = "0";
			depthFirstSearch( board, r+1, c+1, word );
			board[r][c] = tempSE;
		}
		if ((r+1<board.length)&&(board[r+1][c] != "0"))
		{
			String tempS = board[r][c];
			board[r][c] = "0";
			depthFirstSearch( board, r+1, c, word );
			board[r][c] = tempS;
		}
		if (((r+1<board.length)&&(c-1>=0))&&(board[r+1][c-1] != "0"))
		{
			String tempSW = board[r][c];
			board[r][c] = "0";
			depthFirstSearch( board, r+1, c-1, word );
			board[r][c] = tempSW;
		}
		if ((c-1>=0)&&(board[r][c-1] != "0"))
		{
			String tempW = board[r][c];
			board[r][c] = "0";
			depthFirstSearch( board, r, c-1, word );
			board[r][c] = tempW;
		}
		if (((r-1>=0)&&(c-1>=0))&&(board[r-1][c-1] != "0"))
		{
			String tempNW = board[r][c];
			board[r][c] = "0";
			depthFirstSearch( board, r-1, c-1, word );
			board[r][c] = tempNW;
		}
	}
}