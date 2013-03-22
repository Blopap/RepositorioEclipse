package EjemplosSwing;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class EventosTeclado extends JFrame {

	private JTextArea a;
	private int contadorLetras=0;
	private int contadorOtros=0;
	private long t1;
	private long t2;
	
	EventosTeclado(){
		a= new JTextArea();
		
		class ManipulaKeyEvent implements KeyListener{
			public void keyPressed(KeyEvent e) {
				char car;
				car = e.getKeyChar();
				
				if(!(Character.isLetter(car)) & !(Character.isDigit(car))){
					String tecla = e.getKeyText(e.getKeyCode());
					if(tecla.compareTo("Retroceso")==0)
						contadorLetras--;
					System.out.println(tecla);
					contadorOtros++;
				}
			}
			
			public void keyReleased (KeyEvent e){}
			
			public void keyTyped (KeyEvent e){
				char car;
				
				car= e.getKeyChar();
				
				if((Character.isLetter(car)) | (Character.isDigit(car))){
					System.out.println(car);
					contadorLetras++;
				}
			}
		}
		
		class ManipulaMouseEventInicio implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				contadorLetras=0;
				contadorOtros=0;
				
				t1=Calendar.getInstance().getTimeInMillis();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		}
		
		class ManipulaMouseEventFin implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				
				a.setText("");
				
				t2=Calendar.getInstance().getTimeInMillis();
				
				long tiempo = t2-t1;
				
				System.out.println("\nLetras y numeros: "+ contadorLetras);
				System.out.println("Otras teclas: " + contadorOtros);
				System.out.println("Tiempo (milisegundos): "+tiempo);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		ManipulaKeyEvent mce= new ManipulaKeyEvent();
		a.addKeyListener(mce);
		
		getContentPane().add(a,BorderLayout.CENTER);
		
		JButton botonInicio = new JButton("Inicio");
		getContentPane().add(a,BorderLayout.NORTH);
		botonInicio.addMouseListener( new ManipulaMouseEventInicio());
		
		JButton botonFin = new JButton("Resultado");
		botonFin.addMouseListener(new ManipulaMouseEventFin());
		getContentPane().add(botonFin,BorderLayout.SOUTH);
		
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new EventosTeclado();
	}

}


