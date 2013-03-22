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

public class E13_100_DemoCheckBox extends JFrame {
	public E13_100_DemoCheckBox()
	{
		super("CheckBox Demostration");
		
		final JCheckBox cafe=new JCheckBox("cafe");
		final JCheckBox cola=new JCheckBox("cola");
		final JCheckBox leche=new JCheckBox("leche");
		final JCheckBox agua=new JCheckBox("agua");
		final JLabel l= new JLabel();
		
		class EventosRaton implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(cafe.getSelectedObjects() != null)
				{
					l.setText("Seleccionado cafe");
				}
				else if(cola.getSelectedObjects() != null)
				{
					l.setText("Seleccionado cola");
				}
				else if(leche.getSelectedObjects() != null)
				{
					l.setText("Seleccionado leche");
				}
				else if(agua.getSelectedObjects() != null)
				{
					l.setText("Seleccionado agua");
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
		
		JLabel l1 = new JLabel("Que deseas tomar?");
		
		l1.setFont(new Font("ARIAL", Font.PLAIN, 20));
		
		c.add(l1);
		
		JPanel p = new JPanel();
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(cafe);
		bg.add(cola);
		bg.add(leche);
		bg.add(agua);
		
		p.add(cafe);
		p.add(cola);
		p.add(leche);
		p.add(agua);
		
//		cafe.addMouseListener(new EventosRaton());
//		cola.addMouseListener(new EventosRaton());
//		leche.addMouseListener(new EventosRaton());
//		agua.addMouseListener(new EventosRaton());
		
		EventosRaton er = new EventosRaton();
		

		cafe.addMouseListener(er);
		cola.addMouseListener(er);
		leche.addMouseListener(er);
		agua.addMouseListener(er);
		
		c.add(p);
		
		c.add(l);
		
		this.setSize(300,300);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new E13_100_DemoCheckBox();


	}
}
