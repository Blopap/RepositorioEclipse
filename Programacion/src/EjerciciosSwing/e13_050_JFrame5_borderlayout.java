package EjerciciosSwing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class e13_050_JFrame5_borderlayout extends JFrame{
	public e13_050_JFrame5_borderlayout()
	{
		super("Quinta Ventana");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c =getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel p =new JPanel();
		JLabel l =new JLabel("Quien eres");
		
		p.add(l);
		
		
		
		c.add(p,BorderLayout.WEST);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new e13_050_JFrame5_borderlayout();

	}
}
