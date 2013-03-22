package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class E13_080_DemoComponentes extends JFrame{
	
	public E13_080_DemoComponentes()
	{
		super("Mostrando muchos componentes");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel();
		
		l1.setText("Esta ventana tiene muchos componentes");
		l1.setFont(new Font("ARIAL",Font.BOLD,20));
		c.add(l1);
		
		JLabel l2 = new JLabel();
		l2.setText("Ingresar su nombre: ");
		l2.setFont(new Font("ARIAL",Font.PLAIN,12));
		c.add(l2);
		
		JTextField tf = new JTextField(20);
		c.add(tf);
		JButton b = new JButton("Pulsar para continuar");
		c.add(b);
		
		
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new E13_080_DemoComponentes();


	}

}
