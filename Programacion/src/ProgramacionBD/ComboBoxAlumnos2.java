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
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		scrollPane.setBounds(0, 0, 427, 188);
		Datos.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"IdAlumno", "IdAsignatura", "Nota"
			}
		));
		scrollPane.setViewportView(table);
		Datos.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 189, 427, 39);
		Datos.add(panel);
		
		JButton btnVolver_1 = new JButton("Volver");
		panel.add(btnVolver_1);
		btnVolver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
				tabbedPane.remove(1);
			}
		});
		
		cargaDatos();
		
		tabbedPane.remove(1);
		
		
		btnVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null},
					},
					new String[] {
						"IdAlumno", "IdAsignatura", "Nota"
					}
				));
				scrollPane.setViewportView(table);
				Datos.setLayout(gl_Datos);
				
				JPanel panel = new JPanel();
				panel.setBounds(0, 189, 427, 39);
				Datos.add(panel);
				
				JButton btnVolver_1 = new JButton("Volver");
				panel.add(btnVolver_1);
				btnVolver_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						tabbedPane.setSelectedIndex(0);
						tabbedPane.remove(1);
					}
				});
				
				cargaNuevapestana((String) cbAlumnos.getSelectedItem());
				
				tabbedPane.setSelectedIndex(1);
			}
		});
	}
	
	public void cargaNuevapestana(String alumno)
	{
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select aa.IdAlumno, aa.IdAsignatura, aa.NotaFinal " +
								"from alumno_asignatura as aa inner join " +
								"alumno as a on aa.idAlumno=a.idAlumno " +
								"where a.Nombre = '"+alumno+"';";
			
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			int i=0;//Valor de filas.
			
			while(rs.next())
			{
				for(int j=1;j<=table.getColumnCount();j++)//Rellena la fila.
				{
					table.setValueAt(rs.getString(j), i, j-1);
				}
				i++;
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
