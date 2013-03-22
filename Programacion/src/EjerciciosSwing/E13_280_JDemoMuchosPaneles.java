package EjerciciosSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class E13_280_JDemoMuchosPaneles extends JFrame {//No funciona
	public E13_280_JDemoMuchosPaneles()
	{
		super("JFrame con JPanels 2");
		
		Container c = getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridLayout g= new GridLayout(3,2);
		
		GridBagConstraints gbc= new GridBagConstraints();
		
		c.setLayout(g);
		
		JPanel p1= new JPanel();
		JPanel p2= new JPanel();
		JPanel p3= new JPanel();
		JPanel p4= new JPanel();
		
		p1.add(new JButton("Boton 1"));
		p1.add(new JButton("Boton 2"));
		p1.add(new JButton("Boton 3"));
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=2;
		
		c.add(p1,gbc);
		
		p2.add(new JButton("Boton 4"));
		p2.add(new JButton("Boton 5"));
		p2.add(new JButton("Boton 6"));
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		
		c.add(p2,gbc);
		
		p3.add(new JButton("Boton 7"));
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		c.add(p3,gbc);
		
		p4.add(new JButton("Boton 8"));
		p4.add(new JButton("Boton 9"));
		p4.add(new JButton("Boton 10"));
		p4.add(new JButton("Boton 11"));
		p4.add(new JButton("Boton 12"));
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=2;
		
		c.add(p4,gbc);
		
		
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new E13_280_JDemoMuchosPaneles();

	}
}
