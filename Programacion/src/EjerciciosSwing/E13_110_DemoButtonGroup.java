package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class E13_110_DemoButtonGroup extends JFrame{
	public E13_110_DemoButtonGroup()
	{
		super("Demostracion ButtonGroup");
		
		final JCheckBox ife=new JCheckBox("IFE");
		final JCheckBox cartilla=new JCheckBox("Cartilla");
		final JCheckBox pasaporte=new JCheckBox("Pasaporte");
		final JCheckBox licencia=new JCheckBox("Licencia");
		final JLabel l= new JLabel();
		
		class EventosRaton implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(ife.getSelectedObjects() != null)
				{
					l.setText("Revisar credencial del IFE");
				}
				else if(cartilla.getSelectedObjects() != null)
				{
					l.setText("Revisar cartilla");
				}
				else if(pasaporte.getSelectedObjects() != null)
				{
					l.setText("Revisar pasaporte");
				}
				else if(licencia.getSelectedObjects() != null)
				{
					l.setText("Revisar licencia de conducir");
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {

				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("Que documento oficial presenta?");
		
		l1.setFont(new Font("ARIAL", Font.PLAIN, 20));
		
		c.add(l1);
		
		JPanel p = new JPanel();
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(ife);
		bg.add(cartilla);
		bg.add(pasaporte);
		bg.add(licencia);
		
		p.add(ife);
		p.add(cartilla);
		p.add(pasaporte);
		p.add(licencia);
		
//		cafe.addMouseListener(new EventosRaton());
//		cola.addMouseListener(new EventosRaton());
//		leche.addMouseListener(new EventosRaton());
//		agua.addMouseListener(new EventosRaton());
		
		EventosRaton er = new EventosRaton();
		

		ife.addMouseListener(er);
		cartilla.addMouseListener(er);
		pasaporte.addMouseListener(er);
		licencia.addMouseListener(er);
		
		c.add(p);
		
		c.add(l);
		
		this.setSize(300,300);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new E13_110_DemoButtonGroup();


	}
}
