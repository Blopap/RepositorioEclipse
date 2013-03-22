package EjerciciosSwing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class E13_220_JFrameConColor extends JFrame{
	public E13_220_JFrameConColor()
	{
		super("Ventana");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c =getContentPane();
		c.setLayout(new FlowLayout());
		
		c.setBackground(Color.blue);
		
		JButton b = new JButton("Pulsa aqui");
		b.setBackground(Color.red);
		c.add(b);
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new E13_220_JFrameConColor();

	}
}
