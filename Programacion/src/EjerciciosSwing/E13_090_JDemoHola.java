package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class E13_090_JDemoHola extends JFrame{

	public E13_090_JDemoHola()
	{
		super("Demo Hola");
		
		final JTextField tf = new JTextField(20);
		final JLabel l = new JLabel();
		
		class EventosRaton implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				
				l.setText("Hola "+tf.getText());
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		
		c.add(new JLabel("Cual es su nombre?"));
		
		
		c.add(tf);
		
		JButton b = new JButton("Pulsa Aqui");
		
		b.addMouseListener(new EventosRaton() );
		c.add(b);
		
		
		c.add(l);
		
		
		
		
		this.setSize(300,300);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new E13_090_JDemoHola();


	}

}
