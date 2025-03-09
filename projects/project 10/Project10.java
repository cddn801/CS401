/** 
 * Project 10 - The Game of Boggle
 * Project 10 Driver class
 * Cameron Nicholson
 */
import java.io.*;
import java.util.*;

public class Project10
{
	static int numWordsFormed = 0;
	
	public static void main(String[] args) throws Exception
	{	
		Scanner infile = new Scanner( new File(args[0]) );
        int rows = infile.nextInt();
        int cols = rows;
		int boardSize = 0;
        String[][] board = new String[rows][cols];
        for(int r = 0; r < rows ; r++)
           for(int c = 0; c < cols; c++)
                 board[r][c] = infile.next();
        infile.close();
		
		String[][] controlBoard = new String[rows][cols];
		for(int r = 0; r < rows ; r++)
           for(int c = 0; c < cols; c++)
                 controlBoard[r][c] = board[r][c];
			 
		for(int r = 0; r < rows ; r++)
           for(int c = 0; c < cols; c++)
                 depthFirstSearch( board, r, c, "");
		System.out.println("numWordsFormed: " + numWordsFormed);
	}
	
	static void depthFirstSearch( String[][] board, int r, int c, String word )
	{
		word += board[r][c];
		System.out.println( word );
		++numWordsFormed;
		
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