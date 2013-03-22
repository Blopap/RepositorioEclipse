package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class e13_030_JFrame3_label extends JFrame{
	
	public e13_030_JFrame3_label()
	{
		super("Tercera Ventana");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c =getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel p =new JPanel();
		
		p.add(new JLabel("Buen dia"));
		
		c.add(p);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new e13_030_JFrame3_label();

	}
}
