// SimpleCalc class for Tokenize
// Cameron Nicholson
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.StringTokenizer;
import java.util.*;


public class SimpleCalc
{
	JFrame window;
	Container content ;
	JButton[] digits = new JButton[12];
	JButton[] ops = new JButton[4];
	JTextField expression;
	JButton equals;
	JTextField result;
	
	public SimpleCalc()
	{
		window = new JFrame( "Simple Calc");
		content = window.getContentPane();
		content.setLayout(new GridLayout(2,1));
		ButtonListener listener = new ButtonListener();
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,3));
		
		expression = new JTextField();
		expression.setFont(new Font("verdana", Font.BOLD, 16));
		expression.setText("");
		
		equals = new JButton("=");
		equals.setFont(new Font("verdana", Font.BOLD, 20 ));
		equals.addActionListener( listener );
		
		result = new JTextField();
		result.setFont(new Font("verdana", Font.BOLD, 16));
		result.setText("");
		
		topPanel.add(expression);
		topPanel.add(equals);	
		topPanel.add(result);
		
		JPanel bottomPanel = new JPanel();		
		bottomPanel.setLayout(new GridLayout(1,2)); 
		
		JPanel  digitsPanel = new JPanel();
		digitsPanel.setLayout(new GridLayout(4,3));
		
		for (int i=0 ; i<10 ; i++ )
		{
			digits[i] = new JButton( ""+i );
			digitsPanel.add( digits[i] );
			digits[i].addActionListener( listener );
		}
		digits[10] = new JButton( "C" );
		digitsPanel.add( digits[10] );
		digits[10].addActionListener( listener );
		
		digits[11] = new JButton( "CE" );
		digitsPanel.add( digits[11] );
		digits[11].addActionListener( listener );
		
		JPanel opsPanel = new JPanel();
		opsPanel.setLayout(new GridLayout(4,1));
		String[] opCodes = { "+", "-", "*", "/" };
		for (int i=0 ; i<4 ; i++ )
		{
			ops[i] = new JButton( opCodes[i] );
			opsPanel.add( ops[i] );
			ops[i].addActionListener( listener );
		}
		bottomPanel.add( digitsPanel );
		bottomPanel.add( opsPanel );
		
		content.add( topPanel );
		content.add( bottomPanel );
		
		window.setSize( 640,480);
		window.setVisible( true );
	}

	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Component whichButton = (Component) e.getSource();
			for (int i=0 ; i<10 ; i++ )
				if (whichButton == digits[i])
					expression.setText( expression.getText() + i );
			for(int i=0; i<4; i++)
				if (whichButton == ops[i])
					expression.setText( expression.getText() + ops[i].getText() );
			String evaluateExp = expression.getText();
			if(whichButton == equals)
			{
				boolean valid = validate(evaluateExp);
				if(valid == true)
				{
					result.setText(Double.toString(calculateText(evaluateExp)));
					result.setForeground(Color.BLACK);
				}
				else
				{
					result.setText("INVALID EXPRESSION");
					result.setForeground(Color.RED);
				}
			}
			if(whichButton == digits[10])
			{
				expression.setText("");
				result.setText("");
			}
			if(whichButton == digits[11])
			{
				expression.setText(expression.getText().substring(0, expression.getText().length()-1));
				result.setText("");
			}
		}
	}
	public double calculateText(String inputText)
	{
		String expr = inputText; 
		ArrayList<String> operatorList = new ArrayList<String>();
		ArrayList<Double> operandList = new ArrayList<Double>();
		StringTokenizer st = new StringTokenizer(expr,"+-*/", true);
		while (st.hasMoreTokens())
		{
			String token = st.nextToken();
			if ("+-/*".contains(token))
				operatorList.add(token);
			else
				operandList.add( Double.parseDouble(token) );
		}
		int checkmer = 0;
		int multDivLength = operatorList.size();
		for (int i = 0; i<multDivLength; i++)
		{
			if(operatorList.get(checkmer).equals("*"))
			{
				double result1 = operandList.get(checkmer) * operandList.get(checkmer+1);
				operandList.set(checkmer, result1);
				operatorList.remove(checkmer);
				operandList.remove(checkmer+1);
				if(operatorList.size() == 0)
					return result1;
			}
			else if(operatorList.get(checkmer).equals("/"))
			{
				double result2 = operandList.get(checkmer) / operandList.get(checkmer+1);
				operandList.set(checkmer, result2);
				operatorList.remove(checkmer);
				operandList.remove(checkmer+1);
				if(operatorList.size() == 0)
					return result2;
			}
			else
				checkmer++;
		}
		int checkmer2 = 0;
		int addSubLength = operatorList.size();
		for (int i = 0; i<addSubLength; i++)
		{
			if(operatorList.get(checkmer2).equals("+"))
			{
				double result3 = operandList.get(checkmer2) + operandList.get(checkmer2+1);
				operandList.set(checkmer2, result3);
				operatorList.remove(checkmer2);
				operandList.remove(checkmer2+1);
				if(operatorList.size() == 0)
					return result3;
			}
			else if(operatorList.get(checkmer2).equals("-"))
			{
				double result4 = operandList.get(checkmer2) - operandList.get(checkmer2+1);
				operandList.set(checkmer2, result4);
				operatorList.remove(checkmer2);
				operandList.remove(checkmer2+1);
				if(operatorList.size() == 0)
					return result4;
			}
			else
				checkmer2++;
		}
		return operandList.get(0);	
	}
	public boolean validate (String inputText)
	{
		
		String expr = inputText;
		ArrayList<String> operatorList = new ArrayList<String>();
		ArrayList<Double> operandList = new ArrayList<Double>();
		StringTokenizer st = new StringTokenizer(expr,"+-*/", true);
		
		while (st.hasMoreTokens())
		{
			String token = st.nextToken();
			if ("+-/*".contains(token))
				operatorList.add(token);
			else
			{
				try
				{	
					operandList.add( Double.parseDouble( token) );
				}
				catch(NumberFormatException e)
				{
					return false;
				}
			}
    	}
 		if (operatorList.size() == operandList.size()-1)
			return true;
		else
			return false;
	}
	public static void main(String [] args)
	{
		new SimpleCalc();
	}
}