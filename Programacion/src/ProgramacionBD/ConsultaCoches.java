package ProgramacionBD;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.UIManager;

import rutinas.Rutinas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaCoches extends JFrame {

	private JPanel contentPane;
	private JTextField tfMatricula;
	private JTextField tfMarca;
	private JTextField tfModelo;
	private JTextField tfColor;
	private JTextField tfAnyo;
	private JTextField tfPrecio;
	private Connection con=null;
	private String driver="com.mysql.jdbc.Driver";
	private String bdnombre="bdcoches";
	private String url="jdbc:mysql://localhost:3306/"+bdnombre;
	private Vector<Coches> vCoches;
	private int posicion=0;
	
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private boolean isnuevo=false;
	
	private Vector<Boolean> bEstado=new Vector<Boolean>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());					
					ConsultaCoches frame = new ConsultaCoches();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaCoches() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Lista de Vehiculos");
		setBounds(100, 100, 450, 322);
		setMinimumSize(new Dimension(450,322));
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lbMatricula = new JLabel("Matricula");
		lbMatricula.setBounds(20, 8, 60, 14);
		panel.add(lbMatricula);
		
		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setBounds(20, 39, 60, 14);
		panel.add(lbMarca);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(10, 5, 212, 20);
		panel_1.add(tfMatricula);
		tfMatricula.setColumns(10);
		tfMatricula.setEnabled(false);
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
				.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(null);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(10, 18, 89, 23);
		panel_2.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(109, 18, 89, 23);
		panel_2.add(btnSiguiente);
		
		btnModificar = new JButton("Modificar");
		
		btnModificar.setBounds(208, 18, 89, 23);
		panel_2.add(btnModificar);
		
		btnNuevo = new JButton("Nuevo");
		
		btnNuevo.setBounds(208, 46, 89, 23);
		panel_2.add(btnNuevo);
		
		btnEliminar = new JButton("Eliminar");
		
		btnEliminar.setBounds(307, 18, 89, 23);
		panel_2.add(btnEliminar);
		
		tfMarca = new JTextField();
		tfMarca.setBounds(10, 36, 212, 20);
		panel_1.add(tfMarca);
		tfMarca.setColumns(10);
		
		tfModelo = new JTextField();
		tfModelo.setBounds(10, 67, 212, 20);
		panel_1.add(tfModelo);
		tfModelo.setColumns(10);
		
		tfColor = new JTextField();
		tfColor.setBounds(10, 98, 212, 20);
		panel_1.add(tfColor);
		tfColor.setColumns(10);
		
		tfAnyo = new JTextField();
		tfAnyo.setBounds(10, 129, 212, 20);
		panel_1.add(tfAnyo);
		tfAnyo.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(10, 160, 212, 20);
		panel_1.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(20, 70, 60, 14);
		panel.add(lblModelo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(20, 101, 60, 14);
		panel.add(lblColor);
		
		JLabel lblAnyo = new JLabel("A\u00F1o");
		lblAnyo.setBounds(20, 132, 60, 14);
		panel.add(lblAnyo);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(20, 163, 60, 14);
		panel.add(lblPrecio);
		contentPane.setLayout(gl_contentPane);
		
		
		cargaDatos();
		
		cargaPrimero();
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(posicion==vCoches.size()-2)
				{
					btnSiguiente.setEnabled(false);
				}
				
				if(posicion<vCoches.size()-1)
				{
					if(!btnAnterior.isEnabled())
					{
						btnAnterior.setEnabled(true);
					}
					posicion++;
					cargaPosicion();
					
				}
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(posicion==1)
				{
					btnAnterior.setEnabled(false);
				}
				
				if(posicion>0)
				{
					if(!btnSiguiente.isEnabled())
					{
						btnSiguiente.setEnabled(true);
					}
					posicion--;
					cargaPosicion();
				}
				
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comprobarDatos())
				{
					modificarDatos();
				}
				
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!isnuevo)
				{
					nuevoCoche();
					isnuevo=true;
				}
				else
				{
					if(insertarCoche())
					{
						btnNuevo.setText("Nuevo");
						btnEliminar.setText("Eliminar");
						cargarEstadosBotones();
						isnuevo=false;
						//posicion=0;
						cargaPosicion();
						compruebaEstado();
					}
					
				}
				
				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!isnuevo)
				{
					eliminarCoche();
					
				}
				else
				{
					cancelar();
				}
				
			}
		});
	}
	
	private boolean eliminarCoche()
	//Elimina el coche que se estra mostrando actualmente
	{
		boolean realizado=false;
		
		if(JOptionPane.showConfirmDialog(this, "Desea eliminar el vehiculo con matricula: "+tfMatricula.getText()+"?")==0)
		{
			if(JOptionPane.showConfirmDialog(this, "Esta seguro?")==0)
			{
				String sentenciaSQL = "Delete FROM "+bdnombre+".tcoches " +
									  "where tcoches.Matricula = '"+tfMatricula.getText()+"'";
				
				if(Rutinas.updateBD(sentenciaSQL, url, driver))
				{
					if(posicion!=0)
					{
//						if(posicion==1)
//						{
//							btnAnterior.setEnabled(false);
//						}
						posicion--;
					}
					else
					{
						
						posicion=0;
					}
					
					for (int i=0;i<vCoches.size();i++)
					{
						
						if(vCoches.get(i).getMatricula().equals(tfMatricula.getText()))
						{
							vCoches.remove(i);
						}
					}
					if(!vCoches.isEmpty())
					{
						cargaPosicion();
					}
					else
					{
						vaciarRegistros();
					}
					compruebaEstado();
					JOptionPane.showMessageDialog(this, "Vehiculo eliminado correctamente");
					realizado=true;
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Error al eliminar el vehiculo");
				}
			}
		}
		return realizado;
	}
	
	
	private boolean insertarCoche()
	//Comprueba si los datos de los TextField son correctos.
	//Si son correctos los introduce en la base de datos.
	//Despues los añade al vector de Coches
	{
		boolean realizado=false;
		
		if(comprobarDatos())
		{
			String sentenciaSQL="INSERT INTO `bdcoches`.`tcoches` (`Matricula`, `Marca`, `Modelo`, `Color`, `Anyo`, `Precio`) " +
					 "VALUES ('"+tfMatricula.getText()+"', '"+
					 			 tfMarca.getText()+"', '"+
					 			 tfModelo.getText()+"', ";
			if(tfColor.getText().equals(""))
			{
				sentenciaSQL+="NULL , ";
			}
			else
			{
				sentenciaSQL="'"+tfColor.getText()+"', "; 
			}
			if(tfAnyo.getText().equals(""))
			{
				sentenciaSQL+="NULL , ";
			}
			else
			{
				sentenciaSQL+="'"+tfAnyo.getText()+"', "; 
			}
			sentenciaSQL+="'"+tfPrecio.getText()+"');";			
			
			if(Rutinas.updateBD(sentenciaSQL, url, driver))
			{	
				JOptionPane.showMessageDialog(this, "Nuevo coche introducido correctamente");
				
				if(tfAnyo.getText().equals(""))
				{
					tfAnyo.setText("0");
				}
				
				//Añade el vehiculo al vector vCoches
				vCoches.add(new Coches(tfMatricula.getText(),
						tfMarca.getText(),
						tfModelo.getText(),
						tfColor.getText(),
						Integer.parseInt(tfAnyo.getText()),
						Float.parseFloat(tfPrecio.getText())));
				
				realizado=true;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Error al introducir vehiculo");
			}
			
		}
		
		
		return realizado;
	}
	
	private void nuevoCoche()
	//Prepara los cuadros de texto para insertar un nuevo vehiculo.
	{
		vaciarRegistros();
		
		btnNuevo.setText("Insertar"); //Cambia el texto del boton para permitir la insercion
		btnEliminar.setText("Cancelar");//Cambia el texto del boton para permitir la cancelacion
		guardarEstadosBotones(); //Guarda el estado de los botones.
	}
	
	private void vaciarRegistros()
	//Vacia los cuadros de texto
	{
		tfMatricula.setText("");
		tfMarca.setText("");
		tfModelo.setText("");
		tfColor.setText("");
		tfAnyo.setText("");
		tfPrecio.setText("");
	}
	
	
	private void cancelar()
	{		
		btnNuevo.setText("Nuevo");
		btnEliminar.setText("Eliminar");
		cargarEstadosBotones();
		//posicion=0;
		cargaPosicion();
		isnuevo=false;
	}
	
	private void guardarEstadosBotones()
	//Para crear un nuevo vehiculo, desactiva los botones que no se pueden pulsar.
	{
		bEstado.clear();
		bEstado.add(btnAnterior.isEnabled());
		bEstado.add(btnSiguiente.isEnabled());
		bEstado.add(btnModificar.isEnabled());
		
		tfMatricula.setEnabled(true);
		btnAnterior.setEnabled(false);
		btnSiguiente.setEnabled(false);
		btnModificar.setEnabled(false);
		
	}
	
	private void cargarEstadosBotones()
	//Carga los estados de los botones despues de crear un vehiculo nuevo.
	{
		tfMatricula.setEnabled(false);
		btnAnterior.setEnabled(bEstado.get(0));
		btnSiguiente.setEnabled(bEstado.get(1));
		btnModificar.setEnabled(bEstado.get(2));
	}
	
	private void cargaDatos()
	//Carga los datos en el vector de coches utilizando una consulta total
	//a la base de datos.
	{
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			vCoches=new Vector<Coches>();
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select * from tcoches";
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			while(rs.next())
			{
				vCoches.add(new Coches(rs.getString("Matricula"),
									   rs.getString("Marca"),
									   rs.getString("Modelo"),
									   rs.getString("Color"),
									   rs.getInt("Anyo"),
									   rs.getFloat("Precio")));

				
			}
			
			rs.close();
			stmt.close();
		
		}
		catch(ClassNotFoundException e){
			System.out.println("Controlador JDBC no encontrado: "+e.toString());
		}
		catch(SQLException e){
			System.out.println("Excepcion capturada de SQL: "+e.toString());
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println("No se puede cerrar la conexion: "+e.toString());
			}
		}
	}
	private boolean compruebaEstado()
	//Comprueba el estado del vector y dependiendo de los datos activa o desactiva los botones
	
	{
		boolean correcto=false;
		
		if(vCoches.isEmpty())
		{
			btnAnterior.setEnabled(false);
			btnSiguiente.setEnabled(false);
			btnModificar.setEnabled(false);
			btnEliminar.setEnabled(false);
		}
		else if(vCoches.size()==1)
		{
			btnAnterior.setEnabled(false);
			btnSiguiente.setEnabled(false);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
			correcto=true;
		}
//		else if(vCoches.size()==posicion+1)
//		{
//			btnAnterior.setEnabled(false);
//			btnSiguiente.setEnabled(false);
//		}
		else
		{
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
			if(posicion!=vCoches.size()-1)
			{
				btnSiguiente.setEnabled(true);
			}
			correcto=true;
		}
		return correcto;
	}
	
	private void cargaPrimero()
	//Carga los datos en los cuadros de texto del primer vehiculo.
	{
		btnAnterior.setEnabled(false);
		
		if(compruebaEstado())
		{
			cargaPosicion();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "No hay ningun vehiculo en la Base de Datos");
		}
			
	}
	
	private void cargaPosicion()
	//Carga en los cuadros de texto los datos de los vehiculos con la posicion "posicion".
	{
		tfMatricula.setText(vCoches.get(posicion).getMatricula());
		tfMarca.setText(vCoches.get(posicion).getMarca());
		tfModelo.setText(vCoches.get(posicion).getModelo());
		tfColor.setText(vCoches.get(posicion).getColor());
		tfAnyo.setText(""+vCoches.get(posicion).getAnyo());
		tfPrecio.setText(""+vCoches.get(posicion).getPrecio());
	}
	
	private boolean comprobarDatos()
	//Devuelve true si los datos son correctos y false en caso contrario	
	{
		boolean correcto=true;
		boolean error=false;
		
		if(isnuevo && existeMatricula(tfMatricula.getText()))
		{
			tfMatricula.setBackground(Color.red);
			error=true;			
		}
		else
		{
			tfMatricula.setBackground(Color.white);
		}
		
		if(!comprobarVacio(tfMarca))
		{
			error=true;
		}
		if(!comprobarVacio(tfModelo))
		{
			error=true;
		}
		/*
		if(!comprobarVacio(tfColor))
		{
			tfColor.setBackground(Color.white);
			tfColor.setText("");
			error=true;
		}
		if(!comprobarVacio(tfAnyo))
		{
			tfAnyo.setBackground(Color.white);
			tfAnyo.setText("");
			error=true;
		}
		*/
		if(!comprobarVacio(tfPrecio))
		{
			error=true;
		}
		
		if(error)
		{
			JOptionPane.showMessageDialog(this, "Algunos datos son erroneos, corregir aquellos en rojo.");
			
			correcto=false;
		}
		
		return correcto;
	}
	
	private boolean comprobarVacio(JTextField tf) 
	//Devuelve false si el texto esta vacio y true en caso contrario 
	{
		boolean correcto=true;
		if(tf.getText()=="")
		{
			tf.setBackground(Color.red);
			correcto=false;
		}
		else tf.setBackground(Color.white);
		return correcto;
	}
	
	private boolean existeMatricula(String matricula)
	//Comprueba si la matricula existe en el vector de coches.
	//Devuelve true si existe y false en caso contrario
	{
		boolean coincide=false;
		
		for(int i=0;i<vCoches.size();i++)
		{
			if(matricula.equals(vCoches.get(i).getMatricula()))
			{
				coincide=true;
			}
		}
		return coincide;
		
	}
	
	private void modificarVectorCoches(String matricula)
	//Modifica los datos del vehiculo con matricula "matricula"
	{
		for(int i=0;i<vCoches.size();i++)
		{
			if(matricula.equals(vCoches.get(i).getMatricula()))
			{
				vCoches.get(i).setMarca(tfMarca.getText());
				vCoches.get(i).setModelo(tfModelo.getText());
				vCoches.get(i).setColor(tfColor.getText());
				vCoches.get(i).setAnyo(Integer.parseInt(tfAnyo.getText()));
				vCoches.get(i).setPrecio(Float.parseFloat(tfPrecio.getText()));
			}
		}
	}
	
	private void modificarDatos()
	//Introduce los datos de los cuadros de texto en la base de datos.
	{
		String sentenciaSQL="UPDATE "+bdnombre+".tcoches SET Marca='"+tfMarca.getText()+
				"', Modelo='"+tfModelo.getText()+
				"', Color='"+tfColor.getText()+
				"', Anyo="+tfAnyo.getText()+
				", Precio="+tfPrecio.getText()+
				"where Matricula='"+tfMatricula.getText()+"'";
		
		if(Rutinas.updateBD(sentenciaSQL, url, driver))
		{
			modificarVectorCoches(tfMatricula.getText());
			JOptionPane.showMessageDialog(this, "Cambios realizados correctamente");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Error al realizar los cambios");
		}
		
		
	}
}
