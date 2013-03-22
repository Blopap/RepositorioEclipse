package EjerciciosSwing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class E13_120_DemoComboBox extends JFrame {
	public E13_120_DemoComboBox()
	{
		super("Demostracion ComboBox");
		
		final JComboBox<String> doc=new JComboBox<String>();
		final JLabel l= new JLabel();
		
		class EventosRaton implements ItemListener{

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(doc.getSelectedItem().equals("IFE"))
				{
					l.setText("Revisar credencial del IFE");
				}
				else if(doc.getSelectedItem().equals("cartilla"))
				{
					l.setText("Revisar cartilla");
				}
				else if(doc.getSelectedItem().equals("pasaporte"))
				{
					l.setText("Revisar pasaporte");
				}
				else if(doc.getSelectedItem().equals("licencia"))
				{
					l.setText("Revisar licencia de conducir");
				}
				
			}

			
			
		}
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("Que documento oficial presenta?");
		
		l1.setFont(new Font("ARIAL", Font.PLAIN, 20));
		
		c.add(l1);
		
		doc.addItem("IFE");
		doc.addItem("cartilla");
		doc.addItem("pasaporte");
		doc.addItem("licencia");
		
		c.add(doc);		

		EventosRaton er = new EventosRaton();
		
		doc.addItemListener(er);
		
		c.add(l);
		
		this.setSize(300,300);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new E13_120_DemoComboBox();


	}

}
