// JFrame2 class for Etch-A-Sketch
// Cameron Nicholson
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // ACTIONLISTENER INTERFACE 

public class JFrame2 //	JFrame2.java	EVENT DRIVEN PROGRAMMING USING JBUTTON AND ACTIONLISTENER INTERFACE
{
	public static void main(String [] args)
	{
		JFrame window = new JFrame("Events");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // CLICKING THE X WILL KILL THE APP NOW 
		
		JButton button = new JButton("Click Me to change my color");
		button.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 60));
		
		ActionListener listener = new MyListener();
		button.addActionListener(listener);
	
		Container content = window.getContentPane();
		content.setLayout(new FlowLayout());
		content.add(button);

		window.setSize(640,480);
		window.setVisible(true);
	}
}

class MyListener implements ActionListener
{
	int index = 0;
	Color[] myColors = {Color.RED, Color.BLUE, Color.CYAN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.GREEN};
	
	public void actionPerformed(ActionEvent e)
	{
		Component refToJButtonThatWasClicked = (Component) e.getSource();
		refToJButtonThatWasClicked.setForeground(myColors[index]);
		index = (index + 1) % myColors.length;
		refToJButtonThatWasClicked.setBackground(myColors[index]);
	}
}
