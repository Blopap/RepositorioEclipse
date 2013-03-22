package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import juegoCartas.Baraja;
import juegoCartas.Carta;

public class E13_260_DemoJCardLayout extends JFrame{
	
	public E13_260_DemoJCardLayout()
	{
		super("Ventana");
		
		final Baraja bar=new Baraja();
		final JButton b = new JButton();
		
		class EventosRaton implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Carta car = bar.sacarCarta();
				
				b.setText(car.toString());
				
				bar.meterCarta(car);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		
		Container c = getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		
		b.addMouseListener(new EventosRaton());
		
		Carta car = bar.sacarCarta();
		
		b.setText(car.muestra());
		
		bar.meterCarta(car);
		
		
		c.add(b);
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new E13_260_DemoJCardLayout();

	}

}
