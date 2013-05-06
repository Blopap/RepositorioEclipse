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
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ComboBoxAlumnos2 extends JFrame {

	private JPanel contentPane;
	
	private String driver="com.mysql.jdbc.Driver";
	private String bdnombre="bduniversidad1";
	private String url="jdbc:mysql://localhost:3306/"+bdnombre;
	
	Connection con=null;
	
	private JComboBox <String> cbAlumnos;
	private JPanel Datos;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBoxAlumnos2 frame = new ComboBoxAlumnos2();
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
	public ComboBoxAlumnos2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Alumno = new JPanel();
		tabbedPane.addTab("Alumno", null, Alumno, null);
		Alumno.setLayout(null);
		
		cbAlumnos = new JComboBox<String>();
		cbAlumnos.setBounds(161, 79, 144, 20);
		Alumno.add(cbAlumnos);
		
		JLabel label = new JLabel("Datos alumnos");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(28, 82, 123, 14);
		Alumno.add(label);
		
		JButton btnVerDatos = new JButton("Ver Datos");
		
		btnVerDatos.setBounds(161, 163, 89, 23);
		Alumno.add(btnVerDatos);
		
		JPanel Datos = new JPanel();
		tabbedPane.addTab("Datos Alumno", null, Datos, null);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_Datos = new GroupLayout(Datos);
		gl_Datos.setHorizontalGroup(
			gl_Datos.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
		);
		gl_Datos.setVerticalGroup(
			gl_Datos.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Datos.setLayout(gl_Datos);
		
		cargaDatos();
		
		btnVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				JPanel Datos = new JPanel();
//				tabbedPane.addTab("Datos Alumno", null, Datos, null);
				
				tabbedPane.setSelectedIndex(1);
			}
		});
	}
	
	public void cargaNuevapestana()
	{
		
		
		
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
}
