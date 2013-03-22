package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class E13_250_DemoJGridLayout extends JFrame {

	public E13_250_DemoJGridLayout()
	{
		super("Ventana");
		
		Container c = getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.setLayout(new GridLayout(3, 2,5,5));
		
		c.add(new JButton("Boton 1"));
		c.add(new JButton("Boton 2"));
		c.add(new JButton("Boton 3"));
		c.add(new JButton("Boton 4"));
		c.add(new JButton("Boton 5"));
		
		
		
		
		
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new E13_250_DemoJGridLayout();

	}

}
