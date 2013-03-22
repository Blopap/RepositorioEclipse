package EjerciciosSwing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class E13_270_JFrameConJPanels extends JFrame{
	public E13_270_JFrameConJPanels()
	{
		super("JFrame con JPanels");
		
		Container c = getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		
		JPanel p1= new JPanel();
		JPanel p2= new JPanel();
		
		p1.add(new JButton("Boton 1"));
		
		p1.setBackground(Color.blue);
		
		p2.add(new JButton("Boton 2"));
		p2.add(new JButton("Boton 3"));
		
		p2.setBackground(Color.red);
		
		c.add(p1);
		c.add(p2);
		
		
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new E13_270_JFrameConJPanels();

	}
}
