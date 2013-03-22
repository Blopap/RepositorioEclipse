package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class E13_210_JFrameUsandoContentPane extends JFrame{
	public E13_210_JFrameUsandoContentPane()
	{
		super("Ventana");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c =getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel p =new JPanel();
		JButton b = new JButton("Pulsa aqui");
		p.add(b);
		
		
		
		c.add(p);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new E13_210_JFrameUsandoContentPane();

	}
}
