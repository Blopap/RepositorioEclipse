package EjemplosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventosRaton {
	public static void main(String[] args) {
		new EventosRaton1();
	}
}
class EventosRaton1 extends JFrame{
	private JButton boton;
	private JTextField campoTexto;
	
	public EventosRaton1()
	{
		class ManipulaMouseEvent implements MouseListener
		{
			
			public void mouseClicked( MouseEvent e){
			}
			public void mouseReleased( MouseEvent e){
			}
			public void mouseEntered( MouseEvent e){
			}
			public void mouseExited( MouseEvent e){
			}
			public void mousePressed( MouseEvent e){
				System.out.println(campoTexto.getText());
			}
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("Introduce precio: "));
		
		campoTexto= new JTextField(20);
		
		c.add(campoTexto);
		
		boton = new JButton("Aceptar");
		
		c.add(boton);
		
		boton.addMouseListener( new ManipulaMouseEvent());
		setSize(350,200);
		setVisible(true);
	}
}
