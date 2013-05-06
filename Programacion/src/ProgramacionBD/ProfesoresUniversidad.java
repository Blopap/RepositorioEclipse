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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProfesoresUniversidad extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private String driver="com.mysql.jdbc.Driver";
	private String bdnombre="bduniversidad1";
	private String url="jdbc:mysql://localhost:3306/"+bdnombre;
	
	Connection con = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfesoresUniversidad frame = new ProfesoresUniversidad();
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
	public ProfesoresUniversidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"DNI", "IdProfesor", "Nombre", "Apellido1", "Apellido2", "Ciudad", "Calle", "Numero", "Piso", "Letra", "Telefono", "DiaNacimiento", "MesNacimiento", "AnyoNacimiento", "Sexo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table.getColumnModel().getColumn(0).setMinWidth(75);
		table.getColumnModel().getColumn(1).setMinWidth(75);
		table.getColumnModel().getColumn(2).setMinWidth(75);
		table.getColumnModel().getColumn(3).setMinWidth(75);
		table.getColumnModel().getColumn(4).setMinWidth(75);
		table.getColumnModel().getColumn(5).setMinWidth(75);
		table.getColumnModel().getColumn(6).setMinWidth(75);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setMinWidth(50);
		table.getColumnModel().getColumn(8).setPreferredWidth(33);
		table.getColumnModel().getColumn(8).setMinWidth(33);
		table.getColumnModel().getColumn(9).setPreferredWidth(40);
		table.getColumnModel().getColumn(9).setMinWidth(40);
		table.getColumnModel().getColumn(10).setMinWidth(75);
		table.getColumnModel().getColumn(11).setPreferredWidth(80);
		table.getColumnModel().getColumn(11).setMinWidth(80);
		table.getColumnModel().getColumn(12).setPreferredWidth(85);
		table.getColumnModel().getColumn(12).setMinWidth(85);
		table.getColumnModel().getColumn(13).setPreferredWidth(90);
		table.getColumnModel().getColumn(13).setMinWidth(90);
		table.getColumnModel().getColumn(14).setPreferredWidth(38);
		table.getColumnModel().getColumn(14).setMinWidth(38);
		scrollPane.setViewportView(table);
		
		cargaDatos();
	}
	
	private void cargaDatos()
	//Carga los datos de una columna en la ventana.
	//Devuelve -1 si muestra la primera posicion y devuelve -2 si es la ultima
	{
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				     							ResultSet.CONCUR_READ_ONLY);
			
			String sentenciaSQL="Select * from profesor";
			
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

}
