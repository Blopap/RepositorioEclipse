package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class e13_040_JFrame4_font extends JFrame{

	public e13_040_JFrame4_font()
	{
		super("Cuarta Ventana");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c =getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel p =new JPanel();
		JLabel l =new JLabel("Buen dia");
		l.setFont(new Font("Arial",Font.PLAIN,60));
		
		p.add(l);
		
		
		
		c.add(p);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new e13_040_JFrame4_font();

	}

}
