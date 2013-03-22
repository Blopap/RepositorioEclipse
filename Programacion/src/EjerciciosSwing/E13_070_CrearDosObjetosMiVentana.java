package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class E13_070_CrearDosObjetosMiVentana extends JFrame {

	public E13_070_CrearDosObjetosMiVentana()
	{
		super("Mi Ventana");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new E13_070_CrearDosObjetosMiVentana();
		new E13_070_CrearDosObjetosMiVentana();

	}

}
