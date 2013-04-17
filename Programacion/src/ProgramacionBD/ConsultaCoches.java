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
	
	private JButton bAnterior;
	private JButton bSiguiente;
	private JButton bModificar;
	private JButton btnNuevo;
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
		setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(450,300));
		
		
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
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
				.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(null);
		
		bAnterior = new JButton("Anterior");
		bAnterior.setBounds(10, 18, 71, 23);
		panel_2.add(bAnterior);
		
		bSiguiente = new JButton("Siguiente");
		bSiguiente.setBounds(91, 18, 89, 23);
		panel_2.add(bSiguiente);
		
		bModificar = new JButton("Modificar");
		
		bModificar.setBounds(190, 18, 89, 23);
		panel_2.add(bModificar);
		
		btnNuevo = new JButton("Nuevo");
		
		btnNuevo.setBounds(289, 18, 89, 23);
		panel_2.add(btnNuevo);
		
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
		
		bSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(posicion==vCoches.size()-2)
				{
					bSiguiente.setEnabled(false);
				}
				
				if(posicion<vCoches.size()-1)
				{
					if(!bAnterior.isEnabled())
					{
						bAnterior.setEnabled(true);
					}
					posicion++;
					cargaPosicion();
					
				}
			}
		});
		
		bAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(posicion==1)
				{
					bAnterior.setEnabled(false);
				}
				
				if(posicion>0)
				{
					if(!bSiguiente.isEnabled())
					{
						bSiguiente.setEnabled(true);
					}
					posicion--;
					cargaPosicion();
				}
				
			}
		});
		
		bModificar.addActionListener(new ActionListener() {
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
						cargarEstadosBotones();
						isnuevo=false;						
					}
					
				}
				
				
			}
		});
		
		
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
							 			 tfModelo.getText()+"', '"+
							 			 tfColor.getText()+"', '"+
							 			 tfAnyo.getText()+"', '"+
							 			 tfPrecio.getText()+"');";
			
			
			if(Rutinas.updateBD(sentenciaSQL, url, driver))
			{	
				JOptionPane.showMessageDialog(this, "Nuevo coche introducido correctamente");
				
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
	{
		tfMatricula.setText("");
		tfMarca.setText("");
		tfModelo.setText("");
		tfColor.setText("");
		tfAnyo.setText("");
		tfPrecio.setText("");
		
		btnNuevo.setText("Insertar"); //Cambia el texto del boton para permitir la insercion
		guardarEstadosBotones(); //Guarda el estado de los botones.
		
		
	}
	
	private void guardarEstadosBotones()
	//Para crear un nuevo vehiculo, desactiva los botones que no se pueden pulsar.
	{
		bEstado.clear();
		bEstado.add(bAnterior.isEnabled());
		bEstado.add(bSiguiente.isEnabled());
		bEstado.add(bModificar.isEnabled());
		
		tfMatricula.setEnabled(true);
		bAnterior.setEnabled(false);
		bSiguiente.setEnabled(false);
		bModificar.setEnabled(false);
		
	}
	
	private void cargarEstadosBotones()
	//Carga los estados de los botones despues de crear un vehiculo nuevo.
	{
		tfMatricula.setEnabled(false);
		bAnterior.setEnabled(bEstado.get(0));
		bSiguiente.setEnabled(bEstado.get(1));
		bModificar.setEnabled(bEstado.get(2));
	}
	
	private void cargaDatos()
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
	private void cargaPrimero()
	{
		bAnterior.setEnabled(false);
		
		if(vCoches.isEmpty())
		{
			bSiguiente.setEnabled(false);
			tfMatricula.setForeground(Color.red);
			tfMatricula.setText("No hay ningun vehiculo");
			tfMarca.setForeground(Color.red);
			tfMarca.setText("en la Base de Datos");
			
		}
		else
		{
			cargaPosicion();
		}
			
	}
	
	private void cargaPosicion()
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
		if(!comprobarVacio(tfColor))
		{
			tfColor.setBackground(Color.white);
			tfColor.setText("null");
			error=true;
		}
		if(!comprobarVacio(tfAnyo))
		{
			tfAnyo.setBackground(Color.white);
			tfAnyo.setText("null");
			error=true;
		}
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
	{
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			con.setAutoCommit(false);
			
			String sentenciaSQL;
			
			Statement stmt=con.createStatement();
			
//			if(!comprobarMatricula(tfMatricula.getText()))
//			{
//				System.out.println("entra");
//				
//				if(existeMatricula(tfMatricula.getText()))
//				{
//					sentenciaSQL="DELETE FROM "+bdnombre+".tcoches where MATRICULA="+tfMatricula.getText();
//					
//					stmt.executeUpdate(sentenciaSQL);
//				}
//				
//				sentenciaSQL="INSERT INTO `bdcoches`.`tcoches` (`Matricula`, `Marca`, `Modelo`, `Color`, `Anyo`, `Precio`) " +
//							 "VALUES ('"+tfMatricula.getText()+"', '"+
//							 			 tfMarca.getText()+"', '"+
//							 			 tfModelo.getText()+"', '"+
//							 			 tfColor.getText()+"', "+
//							 			 tfAnyo.getText()+", "+
//							 			 tfPrecio.getText()+")";
//				stmt.executeUpdate(sentenciaSQL);
//				
//				cargaMatriculas();
//				
//			}
//			else
//			{
				sentenciaSQL="UPDATE "+bdnombre+".tcoches SET Marca='"+tfMarca.getText()+
																	"', Modelo='"+tfModelo.getText()+
																	"', Color='"+tfColor.getText()+
																	"', Anyo="+tfAnyo.getText()+
																	", Precio="+tfPrecio.getText()+
																	"where Matricula='"+tfMatricula.getText()+"'";
				
				stmt.executeUpdate(sentenciaSQL);
				modificarVectorCoches(tfMatricula.getText());
				
				JOptionPane.showMessageDialog(this, "Cambios realizados correctamente");
//			}
			
			//con.rollback();
			con.commit();
			stmt.close();
		
		}
		catch(ClassNotFoundException e){
			System.out.println("Controlador JDBC no encontrado: "+e.toString());
		}
		catch(SQLException e){
			if(con!=null)
			{
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
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
}
