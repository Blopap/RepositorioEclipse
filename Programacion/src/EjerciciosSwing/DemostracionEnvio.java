package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DemostracionEnvio extends JFrame{
	public DemostracionEnvio()
	{
		super("Demostracion Envio");
		
		final Container c = getContentPane();
		
		final int e1=10;
		final int e2=5;
		final int e3=8;
		
		final JCheckBox env =new JCheckBox("Envalaje "+e1+"€");
		final JCheckBox laz = new JCheckBox("Lazo "+e2+"€");
		final JCheckBox tar = new JCheckBox("Tarjeta "+e3+"€");
		
		
		final JLabel tot=new JLabel();
		
		class EventosRaton implements MouseListener{

			private int total;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("env "+e.getSource().equals(env));
				System.out.println("laz "+e.getSource().equals(laz));
				System.out.println("tar "+e.getSource().equals(tar));
				System.out.println();
				
				if (e.getSource().equals(env))
				{
					if(!env.isSelected())
					{
						total=total-e1;
					}
					else 
					{
						total=total+e1;
					}
				}
				if (e.getSource().equals(laz))
				{
					
					if(!laz.isSelected())
					{
						total=total-e2;
					}
					else 
					{
						total=total+e2;
					}
				}
				if (e.getSource().equals(tar))
				{
					
					if(!tar.isSelected())
					{
						total=total-e3;
					}
					else 
					{
						total=total+e3;
					}
				}
				tot.setText("Total: "+total);
				c.add(tot);
				
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
		c.setLayout(new FlowLayout());

		JPanel p1=new JPanel();
		
		p1.add(new JLabel("Que elige?"));
		
		c.add(p1);
		
		
		EventosRaton er= new EventosRaton();
		
		env.addMouseListener(er);
		laz.addMouseListener(er);
		tar.addMouseListener(er);
		
		JPanel p2=new JPanel();
		
		
		
		p2.add(env);
		p2.add(laz);
		p2.add(tar);
		
		c.add(p2);
		
		JPanel p3= new JPanel();
		
		p3.add(tot);
		
		c.add(p3);
		
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DemostracionEnvio();

	}
}
