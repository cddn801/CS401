/** 
 * Project 7 - GUI Calculator
 * Tokenize Driver class
 * Cameron Nicholson
 */
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Double;

public class Tokenize
{
	public static void main( String[] args)
	{
		String expr="4+5-12/3.5-5.4*3.14";
		System.out.println( "expr: " + expr );
		ArrayList<String> operatorList = new ArrayList<String>();
		ArrayList<Double> operandList = new ArrayList<Double>();
		StringTokenizer st = new StringTokenizer( expr,"+-*/", true );
		while (st.hasMoreTokens())
		{
			String token = st.nextToken();
			if ("+-/*".contains(token))
				operatorList.add(token);
			else
				operandList.add( Double.parseDouble( token) );
    		}
 		System.out.println("Operators:" + operatorList);
		System.out.println("Operands:" + operandList);
	}
}

