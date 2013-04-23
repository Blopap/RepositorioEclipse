package ProgramacionBD;

import java.awt.BorderLayout;
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
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 603, 512);
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
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Alumno", null, panel_2, null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		tfDni = new JTextField();
		tfDni.setBounds(80, 8, 495, 20);
		panel.add(tfDni);
		tfDni.setColumns(10);
		
		tfIdAlumno = new JTextField();
		tfIdAlumno.setBounds(80, 39, 495, 20);
		panel.add(tfIdAlumno);
		tfIdAlumno.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(80, 70, 495, 20);
		panel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido1 = new JTextField();
		tfApellido1.setBounds(80, 101, 200, 20);
		panel.add(tfApellido1);
		tfApellido1.setColumns(10);
		
		tfCiudad = new JTextField();
		tfCiudad.setBounds(80, 132, 495, 20);
		panel.add(tfCiudad);
		tfCiudad.setColumns(10);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(80, 163, 230, 20);
		panel.add(tfCalle);
		tfCalle.setColumns(10);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(80, 194, 495, 20);
		panel.add(tfTelefono);
		tfTelefono.setColumns(10);
		
		tfNacimiento_1 = new JTextField();
		tfNacimiento_1.setHorizontalAlignment(SwingConstants.CENTER);
		tfNacimiento_1.setBounds(80, 225, 24, 20);
		panel.add(tfNacimiento_1);
		tfNacimiento_1.setColumns(10);
		
		tfNacimiento_2 = new JTextField();
		tfNacimiento_2.setHorizontalAlignment(SwingConstants.CENTER);
		tfNacimiento_2.setBounds(112, 225, 24, 20);
		panel.add(tfNacimiento_2);
		tfNacimiento_2.setColumns(10);
		
		tfNacimiento_3 = new JTextField();
		tfNacimiento_3.setHorizontalAlignment(SwingConstants.CENTER);
		tfNacimiento_3.setBounds(146, 225, 40, 20);
		panel.add(tfNacimiento_3);
		tfNacimiento_3.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDni.setBounds(0, 11, 70, 14);
		panel.add(lblDni);
		
		JLabel lblIdAlumno = new JLabel("IdAlumno");
		lblIdAlumno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdAlumno.setBounds(0, 42, 70, 14);
		panel.add(lblIdAlumno);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setBounds(0, 73, 70, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido1 = new JLabel("1\u00BAApellido:");
		lblApellido1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblApellido1.setBounds(0, 104, 70, 14);
		panel.add(lblApellido1);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCiudad.setBounds(0, 135, 70, 14);
		panel.add(lblCiudad);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCalle.setBounds(0, 166, 70, 14);
		panel.add(lblCalle);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelefono.setBounds(0, 200, 70, 14);
		panel.add(lblTelefono);
		
		JLabel lblNacimiento = new JLabel("Nacimiento:");
		lblNacimiento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNacimiento.setBounds(0, 231, 70, 14);
		panel.add(lblNacimiento);
		
		JLabel label = new JLabel("/");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(102, 228, 14, 14);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(62)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("/");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(136, 228, 14, 14);
		panel.add(label_1);
		
		tfLetra = new JTextField();
		tfLetra.setHorizontalAlignment(SwingConstants.CENTER);
		tfLetra.setBounds(551, 163, 24, 20);
		panel.add(tfLetra);
		tfLetra.setColumns(10);
		
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLetra.setBounds(506, 166, 35, 14);
		panel.add(lblLetra);
		
		tfPiso = new JTextField();
		tfPiso.setHorizontalAlignment(SwingConstants.CENTER);
		tfPiso.setBounds(472, 163, 24, 20);
		panel.add(tfPiso);
		tfPiso.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPiso.setBounds(427, 166, 35, 14);
		panel.add(lblPiso);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(393, 163, 24, 20);
		panel.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumero.setBounds(320, 166, 63, 14);
		panel.add(lblNumero);
		
		tfApellido_2 = new JTextField();
		tfApellido_2.setBounds(375, 101, 200, 20);
		panel.add(tfApellido_2);
		tfApellido_2.setColumns(10);
		
		JLabel lblApellido_2 = new JLabel("2\u00BA Apellido");
		lblApellido_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblApellido_2.setBounds(290, 104, 75, 14);
		panel.add(lblApellido_2);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSexo.setBounds(196, 228, 46, 14);
		panel.add(lblSexo);
		
		textField = new JTextField();
		textField.setBounds(252, 225, 323, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 76, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 295, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 70, Short.MAX_VALUE)
		);
		panel_4.setLayout(gl_panel_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(215)
							.addComponent(btnBuscar)))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscar)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		JButton btnAnterior = new JButton("Anterior");
		
		JButton btnSiguiente = new JButton("Siguiente");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAnterior, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(btnSiguiente, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAnterior)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSiguiente)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		panel_1.setLayout(gl_panel_1);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
