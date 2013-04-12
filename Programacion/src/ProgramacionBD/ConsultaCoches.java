package ProgramacionBD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

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
	private String url="jdbc:mysql://localhost:3306/bdcoches";
	private Vector<Coches> vCoches;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(100, 100, 450, 300);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
					.addContainerGap())
		);
		
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
		
		JButton bSiguiente = new JButton("Siguiente");
		bSiguiente.setBounds(83, 222, 89, 23);
		panel_1.add(bSiguiente);
		
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
		
		JButton bAnterior = new JButton("Anterior");
		bAnterior.setBounds(47, 222, 89, 23);
		panel.add(bAnterior);
		contentPane.setLayout(gl_contentPane);
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
	
	
	
	
	
}
