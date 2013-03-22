package EjerciciosSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class E13_230_DemoJBorderLayout extends JFrame {
	public E13_230_DemoJBorderLayout()
	{
		super("Ventana");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c =getContentPane();
		c.setLayout(new BorderLayout(5, 5));
		
		JButton b1 = new JButton("norte");
		JButton b2 = new JButton("sur");
		JButton b3 = new JButton("este");
		JButton b4 = new JButton("oeste");
		JButton b5 = new JButton("centro");
		
		
		c.add(b1,BorderLayout.PAGE_START);
		c.add(b2,BorderLayout.PAGE_END);
		c.add(b3,BorderLayout.LINE_START);
		c.add(b4,BorderLayout.LINE_END);
		c.add(b5,BorderLayout.CENTER);
		
//		c.add(b1,BorderLayout.NORTH);
//		c.add(b2,BorderLayout.SOUTH);
//		c.add(b3,BorderLayout.EAST);
//		c.add(b4,BorderLayout.WEST);
//		c.add(b5,BorderLayout.CENTER);
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new E13_230_DemoJBorderLayout();

	}
}
