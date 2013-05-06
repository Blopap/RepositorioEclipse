package ProgramacionBD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaUniversidad extends JFrame {

	private JPanel contentPane;
	private JTextField tfDni;
	private JTextField tfIdAlumno;
	private JTextField tfNombre;
	private JTextField tfApellido1;
	private JTextField tfCiudad;
	private JTextField tfCalle;
	private JTextField tfTelefono;
	private JTextField tfNacimiento_1;
	private JTextField tfNacimiento_2;
	private JTextField tfNacimiento_3;
	private JTextField tfLetra;
	private JTextField tfPiso;
	private JTextField tfNumero;
	private JTextField tfApellido_2;
	private JTextField tfSexo;
	private JTextField textField_1;
	

	private String driver="com.mysql.jdbc.Driver";
	private String bdnombre="bduniversidad1";
	private String url="jdbc:mysql://localhost:3306/"+bdnombre;
	
	Connection con = null;
	int fila=1;
	boolean nuevo=false;
	
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnNuevo;	
	private JButton btnModificar;	
	private JButton btnBorrar;	
	private JButton btnVolver;	
	private JButton btnCargar;	
	private JButton btnCancelar;
	private JLabel lblNumAlumnos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUniversidad frame = new ConsultaUniversidad();
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
	public ConsultaUniversidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
		);
		
		JPanel AlumnoPrincipal = new JPanel();
		tabbedPane.addTab("Alumno", null, AlumnoPrincipal, null);
		
		JPanel AlumnoDatos = new JPanel();
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		
		tfIdAlumno = new JTextField();
		tfIdAlumno.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		
		tfApellido1 = new JTextField();
		tfApellido1.setColumns(10);
		
		tfCiudad = new JTextField();
		tfCiudad.setColumns(10);
		
		tfCalle = new JTextField();
		tfCalle.setColumns(10);
		
		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		
		tfNacimiento_1 = new JTextField();
		tfNacimiento_1.setHorizontalAlignment(SwingConstants.CENTER);
		tfNacimiento_1.setColumns(10);
		
		tfNacimiento_2 = new JTextField();
		tfNacimiento_2.setHorizontalAlignment(SwingConstants.CENTER);
		tfNacimiento_2.setColumns(10);
		
		tfNacimiento_3 = new JTextField();
		tfNacimiento_3.setHorizontalAlignment(SwingConstants.CENTER);
		tfNacimiento_3.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblIdAlumno = new JLabel("IdAlumno");
		lblIdAlumno.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblApellido1 = new JLabel("1\u00BAApellido:");
		lblApellido1.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNacimiento = new JLabel("Nacimiento:");
		lblNacimiento.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel label = new JLabel("/");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel AlumnosBoton = new JPanel();
		
		JPanel AlumnoNumero = new JPanel();
		GroupLayout gl_AlumnoPrincipal = new GroupLayout(AlumnoPrincipal);
		gl_AlumnoPrincipal.setHorizontalGroup(
			gl_AlumnoPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoPrincipal.createSequentialGroup()
					.addGroup(gl_AlumnoPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(AlumnoDatos, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_AlumnoPrincipal.createSequentialGroup()
							.addGap(62)
							.addGroup(gl_AlumnoPrincipal.createParallelGroup(Alignment.LEADING)
								.addComponent(AlumnosBoton, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)
								.addComponent(AlumnoNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_AlumnoPrincipal.setVerticalGroup(
			gl_AlumnoPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoPrincipal.createSequentialGroup()
					.addComponent(AlumnoDatos, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AlumnosBoton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AlumnoNumero, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel AlumnoNumeroDato = new JPanel();
		AlumnoNumeroDato.setForeground(Color.BLACK);
		AlumnoNumeroDato.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JLabel lblAlumnosReg = new JLabel("Alumnos Registrados en el Sistema");
		lblAlumnosReg.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblAlumnosReg.setForeground(Color.RED);
		GroupLayout gl_AlumnoNumero = new GroupLayout(AlumnoNumero);
		gl_AlumnoNumero.setHorizontalGroup(
			gl_AlumnoNumero.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoNumero.createSequentialGroup()
					.addContainerGap()
					.addComponent(AlumnoNumeroDato, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAlumnosReg, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_AlumnoNumero.setVerticalGroup(
			gl_AlumnoNumero.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_AlumnoNumero.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AlumnoNumero.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAlumnosReg, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(AlumnoNumeroDato, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		lblNumAlumnos = new JLabel("0");
		lblNumAlumnos.setForeground(Color.RED);
		lblNumAlumnos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNumAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_AlumnoNumeroDato = new GroupLayout(AlumnoNumeroDato);
		gl_AlumnoNumeroDato.setHorizontalGroup(
			gl_AlumnoNumeroDato.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_AlumnoNumeroDato.createSequentialGroup()
					.addComponent(lblNumAlumnos, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_AlumnoNumeroDato.setVerticalGroup(
			gl_AlumnoNumeroDato.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNumAlumnos, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
		);
		AlumnoNumeroDato.setLayout(gl_AlumnoNumeroDato);
		AlumnoNumero.setLayout(gl_AlumnoNumero);
		
		JLabel label_1 = new JLabel("/");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfLetra = new JTextField();
		tfLetra.setHorizontalAlignment(SwingConstants.CENTER);
		tfLetra.setColumns(10);
		
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tfPiso = new JTextField();
		tfPiso.setHorizontalAlignment(SwingConstants.CENTER);
		tfPiso.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tfApellido_2 = new JTextField();
		tfApellido_2.setColumns(10);
		
		JLabel lblApellido_2 = new JLabel("2\u00BA Apellido");
		lblApellido_2.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tfSexo = new JTextField();
		tfSexo.setColumns(10);
		GroupLayout gl_AlumnoDatos = new GroupLayout(AlumnoDatos);
		gl_AlumnoDatos.setHorizontalGroup(
			gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoDatos.createSequentialGroup()
					.addComponent(lblDni, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfDni, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_AlumnoDatos.createSequentialGroup()
					.addComponent(lblIdAlumno, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfIdAlumno, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_AlumnoDatos.createSequentialGroup()
					.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfNombre, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_AlumnoDatos.createSequentialGroup()
					.addComponent(lblApellido1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfApellido1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblApellido_2, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfApellido_2, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_AlumnoDatos.createSequentialGroup()
					.addComponent(lblCiudad, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfCiudad, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_AlumnoDatos.createSequentialGroup()
					.addComponent(lblCalle, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfCalle, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblNumero, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfNumero, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblPiso, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfPiso, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblLetra, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfLetra, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_AlumnoDatos.createSequentialGroup()
					.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tfTelefono, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_AlumnoDatos.createSequentialGroup()
					.addComponent(lblNacimiento, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(32)
							.addComponent(tfNacimiento_2, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addComponent(tfNacimiento_1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
							.addGap(32))
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(22)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
							.addGap(20)))
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
							.addGap(36))
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(10)
							.addComponent(tfNacimiento_3, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
					.addGap(10)
					.addComponent(lblSexo, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(tfSexo, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_AlumnoDatos.setVerticalGroup(
			gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoDatos.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDni, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(tfDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblIdAlumno, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(tfIdAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNombre))
						.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblApellido1))
						.addComponent(tfApellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblApellido_2))
						.addComponent(tfApellido_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCiudad))
						.addComponent(tfCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCalle))
						.addComponent(tfCalle)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNumero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(tfNumero)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPiso, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(tfPiso)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblLetra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(tfLetra))
					.addGap(11)
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(6)
							.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(tfTelefono))
					.addGap(11)
					.addGroup(gl_AlumnoDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNacimiento))
						.addComponent(tfNacimiento_2)
						.addComponent(tfNacimiento_1)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3))
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(tfNacimiento_3)
						.addGroup(gl_AlumnoDatos.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSexo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(tfSexo))
					.addGap(5))
		);
		AlumnoDatos.setLayout(gl_AlumnoDatos);
		
		JPanel AlumnoBotonSigAnt = new JPanel();
		AlumnoBotonSigAnt.setBounds(0, 0, 180, 76);
		AlumnoBotonSigAnt.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		JPanel AlumnoBotonMod = new JPanel();
		AlumnoBotonMod.setBounds(190, 0, 328, 76);
		AlumnoBotonMod.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		JPanel AlumnoBotonBusqueda = new JPanel();
		AlumnoBotonBusqueda.setBounds(0, 82, 518, 69);
		AlumnoBotonBusqueda.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		btnNuevo = new JButton("Nuevo");
		
		btnModificar = new JButton("Modificar");
		
		btnBorrar = new JButton("Borrar");
		
		btnVolver = new JButton("Volver");
		
		btnCargar = new JButton("Cargar");
		
		btnCancelar = new JButton("Cancelar");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GroupLayout gl_AlumnoBotonBusqueda = new GroupLayout(AlumnoBotonBusqueda);
		gl_AlumnoBotonBusqueda.setHorizontalGroup(
			gl_AlumnoBotonBusqueda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoBotonBusqueda.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_AlumnoBotonBusqueda.createSequentialGroup()
					.addGap(216)
					.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(231))
		);
		gl_AlumnoBotonBusqueda.setVerticalGroup(
			gl_AlumnoBotonBusqueda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoBotonBusqueda.createSequentialGroup()
					.addGap(6)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		AlumnoBotonBusqueda.setLayout(gl_AlumnoBotonBusqueda);
		AlumnosBoton.setLayout(null);
		
		btnAnterior = new JButton("Anterior");
				
		btnSiguiente = new JButton("Siguiente");
		
		AlumnosBoton.add(AlumnoBotonSigAnt);
		GroupLayout gl_AlumnoBotonSigAnt = new GroupLayout(AlumnoBotonSigAnt);
		gl_AlumnoBotonSigAnt.setHorizontalGroup(
			gl_AlumnoBotonSigAnt.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoBotonSigAnt.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_AlumnoBotonSigAnt.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSiguiente, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
		);
		gl_AlumnoBotonSigAnt.setVerticalGroup(
			gl_AlumnoBotonSigAnt.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoBotonSigAnt.createSequentialGroup()
					.addGap(6)
					.addComponent(btnAnterior)
					.addGap(6)
					.addComponent(btnSiguiente))
		);
		AlumnoBotonSigAnt.setLayout(gl_AlumnoBotonSigAnt);
		AlumnosBoton.add(AlumnoBotonMod);
		GroupLayout gl_AlumnoBotonMod = new GroupLayout(AlumnoBotonMod);
		gl_AlumnoBotonMod.setHorizontalGroup(
			gl_AlumnoBotonMod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoBotonMod.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_AlumnoBotonMod.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AlumnoBotonMod.createSequentialGroup()
							.addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnCargar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AlumnoBotonMod.createSequentialGroup()
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))))
		);
		gl_AlumnoBotonMod.setVerticalGroup(
			gl_AlumnoBotonMod.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AlumnoBotonMod.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_AlumnoBotonMod.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNuevo)
						.addComponent(btnBorrar)
						.addComponent(btnCargar))
					.addGap(6)
					.addGroup(gl_AlumnoBotonMod.createParallelGroup(Alignment.LEADING)
						.addComponent(btnModificar)
						.addComponent(btnVolver)
						.addComponent(btnCancelar)))
		);
		AlumnoBotonMod.setLayout(gl_AlumnoBotonMod);
		AlumnosBoton.add(AlumnoBotonBusqueda);
		AlumnoPrincipal.setLayout(gl_AlumnoPrincipal);
		contentPane.setLayout(gl_contentPane);
		
		//Comprueba el numero de filas y realiza las modificaciones necesarias.
		if(comprobarBotones())
		{
			//Carga los datos de la primera fila.
			cargaDatos(fila);
			btnAnterior.setEnabled(false);
			tfDni.setEnabled(false);
		}
		
		
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fila++;
				if(cargaDatos(fila)==-2)
				{
					btnSiguiente.setEnabled(false);
				}
				else if(!btnAnterior.isEnabled())
				{
					btnAnterior.setEnabled(true);
				}
					
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fila--;
				if(cargaDatos(fila)==-1)
				{
					btnAnterior.setEnabled(false);
				}
				else if(!btnSiguiente.isEnabled())
				{
					btnSiguiente.setEnabled(true);
				}
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!nuevo)
				{
					tfDni.setEnabled(true);
					limpiarCampos();
					nuevo=true;
				}
				else
				{
					
				}
				
				
			}
		});
		
		
	}
	
	private int cargaDatos(int posicion)
	//Carga los datos de una columna en la ventana.
	//Devuelve -1 si muestra la primera posicion y devuelve -2 si es la ultima
	{
		int tieneSigAnt=0;
		
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				     							ResultSet.CONCUR_READ_ONLY);
			
			String sentenciaSQL="Select * from alumno";
			
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			if(rs.absolute(posicion))
			{
				tfDni.setText(rs.getString(1));
				tfIdAlumno.setText(rs.getString(2));
				tfNombre.setText(rs.getString(3));
				tfApellido1.setText(rs.getString(4));
				tfApellido_2.setText(rs.getString(5));
				tfCiudad.setText(rs.getString(6));
				tfCalle.setText(rs.getString(7));
				tfNumero.setText(rs.getString(8));
				tfPiso.setText(rs.getString(9));
				tfLetra.setText(rs.getString(10));
				tfTelefono.setText(rs.getString(11));
				tfNacimiento_1.setText(rs.getString(12));
				tfNacimiento_2.setText(rs.getString(13));
				tfNacimiento_3.setText(rs.getString(14));
				tfSexo.setText(rs.getString(15));
				
				
			}
			if(rs.isFirst())
			{
				tieneSigAnt=-1;
			}
			else if(rs.isLast())
			{
				tieneSigAnt=-2;
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
		return tieneSigAnt;
	}
	
	private int numeroAlumnos()
	//Devuelve el numero de alumnos que tiene la base de datos.
	{
		int totalAlumnos=0;
		
		try{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,"root","");
			
			Statement stmt=con.createStatement();
			
			String sentenciaSQL="Select * from alumno";
			
			ResultSet rs=stmt.executeQuery(sentenciaSQL);
			
			while(rs.next())
			{
				totalAlumnos++;
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
		return totalAlumnos;
	}
	
	private boolean comprobarBotones()
	{
		int numAlumn=numeroAlumnos();
		if(numAlumn == 0)
		{
			btnAnterior.setEnabled(false);
			btnSiguiente.setEnabled(false);
			btnModificar.setEnabled(false);
			btnBorrar.setEnabled(false);
			btnVolver.setEnabled(false);
			btnCargar.setEnabled(false);
			btnCancelar.setEnabled(false);
			return false;
		}
		else if (numAlumn == 1)
		{
			btnAnterior.setEnabled(false);
			btnSiguiente.setEnabled(false);
			btnModificar.setEnabled(true);
			btnBorrar.setEnabled(true);
			btnVolver.setEnabled(true);
			btnCargar.setEnabled(true);
			btnCancelar.setEnabled(true);
		}
		
		lblNumAlumnos.setText(""+numAlumn);
		return true;
	}
	
	private void limpiarCampos()
	{
		tfDni.setText("");
		tfIdAlumno.setText("");
		tfNombre.setText("");
		tfApellido1.setText("");
		tfApellido_2.setText("");
		tfCiudad.setText("");
		tfCalle.setText("");
		tfNumero.setText("");
		tfPiso.setText("");
		tfLetra.setText("");
		tfTelefono.setText("");
		tfNacimiento_1.setText("");
		tfNacimiento_2.setText("");
		tfNacimiento_3.setText("");
		tfSexo.setText("");
	}
	
	
	
	
	
	
	
}
