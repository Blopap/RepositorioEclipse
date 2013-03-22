package EjerciciosSwing;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class E13_290_Tablero extends JFrame {
	public E13_290_Tablero()
	{
		super("JFrame con JPanels 2");
		
		Container c = getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		int filas = 10;
		int columnas = 6;
		
		this.setSize(30*columnas,30*filas);
		
		Color c1=Color.blue;
		Color c2=Color.white;
		Color c3;
		
		c.setLayout(new GridLayout(filas, columnas));
		
		JLabel l;
		
		for(int i=0;i<filas;i++)
		{
			if(i%2==0)
			{
				c3=c1;
			}
			else c3=c2;
			
			for(int j=0;j<columnas;j++)
			{
				l=new JLabel();
				l.setSize(30,30);
				l.setOpaque(true);
				if(c3==c1)
				{
					c3=c2;
				}
				else c3=c1;
				l.setBackground(c3);
				c.add(l);
			}
		}
		
		
		
		
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new E13_290_Tablero();

	}
	
}
