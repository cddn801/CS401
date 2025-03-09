/** 
 * Lab 7 - Etch-A-Sketch
 * Etch-A-Sketch Driver class
 * Cameron Nicholson
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Etch_A_Sketch implements MouseListener, MouseMotionListener
{
	JFrame window;
	Container contentPane;
	int mouseX,mouseY,oldX,oldY;
	JLabel coords;
	JButton toggle;
	Color colors[] = {Color.RED, Color.BLUE, Color.GREEN, Color.CYAN};
	int colorIndex = 0;
	public Etch_A_Sketch()
	{
		JFrame window = new JFrame("Classic Etch a Sketch");
		contentPane = window.getContentPane();
		contentPane.setLayout( new FlowLayout());
		coords = new JLabel();
		toggle = new JButton("Change Color");
		coords.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 32));
		contentPane.add( coords);
		contentPane.add(toggle);
		contentPane.addMouseListener(this);
		contentPane.addMouseMotionListener(this); 
		window.setSize(640,480);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setForeground(colors[colorIndex]);
		toggle.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				window.setForeground(colors[colorIndex++]);
				if(colorIndex > 3)
					colorIndex = 0;
			}
        });
	}
	public void mouseClicked( MouseEvent me)
	{
       mouseX = me.getX();
	   mouseY = me.getY();
	}
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	}
	public void mouseReleased( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	}
	public void mouseExited( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	}
	public void mouseEntered( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	}
	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		
		if (oldX ==0 )
		{
			oldX=mouseX;
			oldY=mouseY;
			return;
		}
		Graphics g = contentPane.getGraphics();
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
	}
	public void mouseMoved( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
	}
	public static void main( String[] args)
	{
		new Etch_A_Sketch();
	}
}