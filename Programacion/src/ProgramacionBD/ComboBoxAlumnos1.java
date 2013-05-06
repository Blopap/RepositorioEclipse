package ProgramacionBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ComboBoxAlumnos1 extends JFrame {

	private JPanel contentPane;
	
	
	private String driver="com.mysql.jdbc.Driver";
	private String bdnombre="bduniversidad1";
	private String url="jdbc:mysql://localhost:3306/"+bdnombre;
	
	private JComboBox <String> cbAlumnos;
	private boolean bandera=false;
	
	Connection con = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBoxAlumnos1 frame = new ComboBoxAlumnos1();
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
	public ComboBoxAlumnos1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		cbAlumnos = new JComboBox<String>();
		
		cbAlumnos.setBounds(168, 102, 186, 20);
		panel.add(cbAlumnos);
		
		JLabel lblDatosAlumnos = new JLabel("Datos alumnos");
		lblDatosAlumnos.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDatosAlumnos.setBounds(35, 105, 123, 14);
		panel.add(lblDatosAlumnos);
		
		cargaDatos();
		
		cbAlumnos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(bandera)
				{	
					muestraDatos((String) e.getItem());
					bandera = !bandera;
				}
				else bandera= !bandera;
			}
		});
		
	}
	
	public void cargaDatos()
	{
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select Nombre from alumno";
			
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			while(rs.next())
			{
				cbAlumnos.addItem(rs.getString(1));
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
	
	public void muestraDatos(String nombreAlumno)
	{
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select Dni,apellido1,apellido2 from alumno where Nombre = '"+nombreAlumno+"'";
			
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			while(rs.next())
			{
				
				String mensaje = "Dni: "+rs.getString(1);
				mensaje += " Nombre: "+nombreAlumno;
				mensaje += " Apellido1: "+rs.getString(2);
				mensaje += " Apellido2: "+rs.getString(3);
				
				
				JOptionPane.showMessageDialog(this, mensaje);
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
}
