package EjemplosSwing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class EjemplosSwing {
	public static void main(String[] args) {
//		new Ventana1();
//		new Ventana2();
//		new Ventana3();
//		new Ventana4("img.jpg");
//		new Ventana5();
//		new Ventana6();
//		new Ventana7();
//		new Ventana8();
//		new Ventana9();
		new Ventana10();
//		new Ventana11();
//		new Ventana12();
//		new Ventana13();
//		new Ventana14();
//		new Ventana15();
//		new Ventana16();
//		new Ventana17();
//		new Ventana18();
		
	}
}
class Ventana1 extends JFrame{
	public Ventana1()//JFrame, crea una ventana vacia.
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
}
class Ventana2 extends JFrame{
	public Ventana2()//JPanel, crea una figura en la ventana.
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new MiPanel());
		setSize(300,200);
		setVisible(true);
	}
}
class MiPanel extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect(20, 20, 80, 80);
	}
}
class Ventana3 extends JFrame{
	public Ventana3(){//JPanel, crea una frase en la ventana.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel p = new JPanel();
		p.add(new JLabel("Ejemplo 3"));
		
		c.add(p);
		
		setSize(200,200);
		setVisible(true);
	}
	
}
class Ventana4 extends JFrame{
	public Ventana4(String fich){//JLabel - ImageIcon, carga una imagen y la visualiza en la ventana.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon ii= new ImageIcon(fich);
		
		c.add(new JLabel("",ii,JLabel.CENTER));
		
		setSize(650,500);
		setVisible(true);
	}
	
}
class Ventana5 extends JFrame{
	public Ventana5()//JTextField, crea una campo para introducir texto.
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JTextField jtf = new JTextField(20);
		
		c.add(new Label("Nombre"));
		c.add(jtf);
		
		setSize(350,200);
		setVisible(true);
		
	}
	
}

class Ventana6 extends JFrame{
	public Ventana6()// JTextArea, crea una zona para introducir texto
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JTextArea jta = new JTextArea(8,20);
		
		c.add(new JLabel("Observaciones"));
		c.add(jta);
		
		setSize(350,200);
		setVisible(true);
		
	}
	
}
class Ventana7 extends JFrame{
	public Ventana7()//JButton, crea botones en la ventana.
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("Aceptar");
		JButton b2 = new JButton("Cancelar");
		
		
		c.add(b1);
		c.add(b2);
		
		setSize(350,200);
		setVisible(true);
		
	}
	
}
class Ventana8 extends JFrame{
	public Ventana8()//JCheckBox, crea botones rectangulares en la pantalla
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox cb = new JCheckBox("Pizarra");
		cb.setFont(new Font("Arial",Font.PLAIN,20));
		
		c.add(cb);
		
		setSize(350,200);
		setVisible(true);
		
	}
	
}
class Ventana9 extends JFrame{
	public Ventana9()//JRadioButton, crea botones circulares en la ventana.
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JRadioButton rb = new JRadioButton("Pizarra");
		
		rb.setFont(new Font("Arial",Font.PLAIN,20));
		
		c.add(rb);
		
		setSize(350,200);
		setVisible(true);
		
	}
	
}
class Ventana10 extends JFrame{
	public Ventana10()//ButtonGroup, unifica un grupo de botones.
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("Selecciona el tipo de Combustible"));
		
		Font fuente = new Font("Arial",Font.PLAIN,18);
		
		JRadioButton gas = new JRadioButton("Gasolina");
		gas.setFont(fuente);
		
		JRadioButton die = new JRadioButton("Diesel");
		die.setFont(fuente);
		
		//Agrupando botones
		ButtonGroup grupo = new ButtonGroup();
		
		grupo.add(gas);
		grupo.add(die);
		
		JPanel radioPanel = new JPanel();
		
		radioPanel.setLayout(new GridLayout(0,1));
		radioPanel.add(gas);
		radioPanel.add(die);
		
		c.add(radioPanel);	
		
		setSize(350,300);
		setVisible(true);
		
	}
}

class Ventana11 extends JFrame{
	public Ventana11()//JComboBox, crea una lista en la ventana.
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JComboBox cb = new JComboBox();
		cb.setFont(new Font("Arial",Font.PLAIN,20));
		cb.addItem("Pizarra");
		cb.addItem("Pantalla");
		cb.addItem("Proyector");
		
		c.add(cb);
		
		setSize(350,200);
		setVisible(true);
		
	}
}

class Ventana12 extends JFrame{
	public Ventana12()//JList, crea una lista plana en la ventana.
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		String [] datos = {"Pizzarra","Pantalla","Proyector"};
		
		JList lista = new JList(datos);
		
		c.add(lista);
		
		setSize(200,200);
		setVisible(true);
		
	}
}

class Ventana13 extends JFrame{
	public Ventana13()//JTable, crea una tabla con datos en la ventana.
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		//Nombres de las columnas
		final String[] nomcol = {"Sesion","Tema","Fecha","Aula"};
		
		//Datos
		Object[][] datos = {
				{"1","MySQL","12-07-04","5"},
				{"2","MySQL","13-07-04","5"},
				{"3","JDBC","14-07-04","5"},
				{"4","GUI","15-07-04","5"},
				{"5","Proyecto","16-07-04","5"}};
		JTable tabla = new JTable(datos,nomcol);
		
		tabla.setFont(new Font("Arial",Font.BOLD,18));
		tabla.setRowHeight(24);
		
		JScrollPane jsp = new JScrollPane(tabla);
		
		cp.add(jsp,BorderLayout.CENTER);
		
		setSize(500,300);
		setVisible(true);
	}
}

class Ventana14 extends JFrame{
	
	public Ventana14()//JTree & DefaultMutableTreeNode, crea un arbol en la ventana. 
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//Contruccion del arbol
		
		DefaultMutableTreeNode asig = new DefaultMutableTreeNode("Enlaces");
		
		DefaultMutableTreeNode tema;
		DefaultMutableTreeNode seccion;
		
		tema= new DefaultMutableTreeNode("Buscadores");
		asig.add(tema);
		
		seccion = new DefaultMutableTreeNode("Google");
		
		tema.add(seccion);
		
		seccion = new DefaultMutableTreeNode("Yahoo");
		tema.add(seccion);
		
		tema = new DefaultMutableTreeNode("Java");
		asig.add(tema);
		
		seccion= new DefaultMutableTreeNode("Sun");
		tema.add(seccion);
		
		seccion= new DefaultMutableTreeNode("IBM");
		tema.add(seccion);
		
		seccion= new DefaultMutableTreeNode("JavaWorld");
		tema.add(seccion);
		
		JTree arbol = new JTree(asig);
		
		arbol.setFont(new Font("Arial",Font.BOLD,20));
		
		c.add(arbol,BorderLayout.CENTER);
		
		setSize(400,600);
		setVisible(true);
	}
}
class Ventana15 extends JFrame{
	private JMenuBar mb;
	public Ventana15()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Se crea una barra de menus
		mb = new JMenuBar();
		
		// Creamos un elemento del menu
		JMenu archivo = new JMenu("Archivo");
		archivo.setFont(new Font("Arial",Font.PLAIN,20));
		
		// Creamos y añadimos submenus
		
		JMenuItem nuevo = new JMenuItem("Nuevo");
		nuevo.setFont(new Font("Arial",Font.PLAIN,16));
		archivo.add(nuevo);		
		
		JMenuItem abrir = new JMenuItem("Abrir");
		abrir.setFont(new Font("Arial",Font.PLAIN,16));
		archivo.add(abrir);
		
		JMenuItem ver = new JMenuItem("Ver todos");
		ver.setFont(new Font("Arial",Font.PLAIN,16));
		archivo.add(ver);
		
		// Ahora añadimos otro archivo a la barra de menus
		mb.add(archivo);
		
		// Creamos otro elemento del menu
		
		JMenu editar = new JMenu("Editar");
		editar.setFont(new Font("Arial",Font.PLAIN,20));
		
		// Creamos y añadimos submenus
		
		JMenuItem copiar = new JMenuItem("Copiar");
		copiar.setFont(new Font("Arial",Font.PLAIN,16));
		editar.add(copiar);
		
		JMenuItem pegar = new JMenuItem("Pegar");
		pegar.setFont(new Font("Arial",Font.PLAIN,16));
		editar.add(pegar);
		
		JMenuItem cortar = new JMenuItem("Cortar");
		cortar.setFont(new Font("Arial",Font.PLAIN,16));
		editar.add(cortar);
		
		//Añadimos editar a la barra de herramientas
		mb.add(editar);
		
		setJMenuBar(mb);
		
		setSize(500,300);
		setVisible(true);
	}
}
class Ventana16 extends JFrame{
	public Ventana16()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JButton b1= new JButton("A");
		JButton b2= new JButton("B");
		JButton b3= new JButton("C");
		JButton b4= new JButton("D");
		JButton b5= new JButton("E");
		c.setLayout(new BorderLayout());
		
		c.add(b1,BorderLayout.NORTH);
		c.add(b2,BorderLayout.SOUTH);
		c.add(b3,BorderLayout.WEST);
		c.add(b4,BorderLayout.EAST);
		c.add(b5,BorderLayout.CENTER);
		
		setSize(350,200);
		setVisible(true);
		
	}
}
class Ventana17 extends JFrame{
	public Ventana17()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JButton b1= new JButton("A");
		JButton b2= new JButton("B");
		JButton b3= new JButton("Boton mas largo");
		JButton b4= new JButton("D");
		JButton b5= new JButton("E");
		c.setLayout(new FlowLayout());
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b5);
		
		setSize(350,200);
		setVisible(true);
		
	}
}
class Ventana18 extends JFrame{
	public Ventana18()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JButton b1= new JButton("A");
		JButton b2= new JButton("B");
		JButton b3= new JButton("C");
		JButton b4= new JButton("D");
		JButton b5= new JButton("E");
		c.setLayout(new GridLayout(2,3));
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b5);
		
		setSize(350,200);
		setVisible(true);
	}
}







