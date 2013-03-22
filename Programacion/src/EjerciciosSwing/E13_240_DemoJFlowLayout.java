package EjerciciosSwing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class E13_240_DemoJFlowLayout extends JFrame{
	public E13_240_DemoJFlowLayout()
	{
		super("Ventana");
		
		final JButton izq= new JButton("Boton izq");
		final JButton der= new JButton("Boton der");
		final Container c =getContentPane();
		
		class EventosRaton implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				FlowLayout l=new FlowLayout();
				
				if(e.getSource().equals(izq))
				{
					l.setAlignment(FlowLayout.LEFT);
					c.setLayout(l);
					
					c.revalidate();
					
				}
				else if(e.getSource().equals(der))
				{
					l.setAlignment(FlowLayout.RIGHT);
					c.setLayout(l);

					c.revalidate();
				}
				
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
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		
		EventosRaton er = new EventosRaton();
		
		izq.addMouseListener(er);
		der.addMouseListener(er);
		
		
		c.add(izq);
		c.add(der);
		
		
		this.setSize(700,100);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new E13_240_DemoJFlowLayout();

	}
}
