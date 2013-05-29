package proyectoProgramacion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import rutinas.Rutinas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class NuevoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfDni;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfDireccion;
	private JTextField tfCodigoPostal;
	private JTextField tfCiudad;
	private JTextField tfTelefono;
	private JTextField tfFechaNacimiento;

	//Main para pruebas de la ventana
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NuevoCliente frame = new NuevoCliente();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public NuevoCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		setTitle("Nuevo Cliente");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNuevoCliente = new JLabel("Introduzca los datos del nuevo cliente");
		lblNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tfApellidos = new JTextField();
		tfApellidos.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblCodigoPostal = new JLabel("Código Postal");
		lblCodigoPostal.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblFechanacimiento = new JLabel("Fecha de Nacimiento");
		lblFechanacimiento.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		buttonGroup.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		buttonGroup.add(rdbtnMujer);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		
		tfCodigoPostal = new JTextField();
		tfCodigoPostal.setColumns(10);
		
		tfCiudad = new JTextField();
		tfCiudad.setColumns(10);
		
		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		
		tfFechaNacimiento = new JTextField();
		tfFechaNacimiento.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		
		JButton btnIntroducir = new JButton("Introducir");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNuevoCliente, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFechanacimiento, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addComponent(lblTelefono, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addComponent(lblCiudad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addComponent(lblCodigoPostal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addComponent(lblDireccion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addComponent(lblSexo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addComponent(lblApellidos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addComponent(lblNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addComponent(lblDni, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfNombre, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
								.addComponent(tfDni, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
								.addComponent(tfApellidos, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnHombre, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnMujer, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
								.addComponent(tfDireccion, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
								.addComponent(tfCodigoPostal, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
								.addComponent(tfCiudad, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
								.addComponent(tfTelefono, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
								.addComponent(tfFechaNacimiento, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
							.addComponent(btnIntroducir, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNuevoCliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(tfDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(tfApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexo)
						.addComponent(rdbtnHombre)
						.addComponent(rdbtnMujer))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(tfDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoPostal)
						.addComponent(tfCodigoPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCiudad)
						.addComponent(tfCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(tfTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechanacimiento)
						.addComponent(tfFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnIntroducir))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//Comprueba si los campos necesarios estan rellenados
		//Si lo estan, inserta los datos en la base de datos y
		//lo inserta en el vector local de clientes		
		btnIntroducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comprobarVacios())
				{
					//introducir datos
					Cliente c=nuevoCliente();
					
					if(GestorBD.insertarCliente(c))
					{
						GestorDatos.anyadirCliente(c);
						dispose();
						JOptionPane.showMessageDialog(null, "Cliente introducido correctamente");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error de inserción");
					}
				}
			}
		});
		
		//Cierra la ventana
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	private boolean comprobarVacios()
	//Comprueba si los Textbox que no pueden estar vacios lo estan.
	//Si alguno esta vacio pone el fondo en rojo, sino lo pone en blanco.
	//Si todos los componentes necesarios estan rellenados, comprueba si el dni no se repite.
	{
		boolean estado=true;
		
		
		
		if(tfNombre.getText().equals(""))
		{
			tfNombre.setBackground(Color.red);
			estado=false;
		}
		else tfNombre.setBackground(Color.white);
		if(tfApellidos.getText().equals(""))
		{
			tfApellidos.setBackground(Color.red);
			estado=false;
		}
		else tfApellidos.setBackground(Color.white);
		Enumeration<AbstractButton> en= buttonGroup.getElements();
		
		if(!en.nextElement().isSelected() && !en.nextElement().isSelected())
		{
			estado=false;
		}
		
		if(tfDireccion.getText().equals(""))
		{
			tfDireccion.setBackground(Color.red);
			estado=false;
		}
		else tfDireccion.setBackground(Color.white);
		if(tfCodigoPostal.getText().equals("") || !Rutinas.isNumeros(tfCodigoPostal.getText()))
		{
			tfCodigoPostal.setBackground(Color.red);
			estado=false;
		}
		else tfCodigoPostal.setBackground(Color.white);
		if(tfCiudad.getText().equals(""))
		{
			tfCiudad.setBackground(Color.red);
			estado=false;
		}
		else tfCiudad.setBackground(Color.white);
		
		if(tfDni.getText().equals(""))
		{			
			tfDni.setBackground(Color.red);
			estado=false;
		}
		else tfDni.setBackground(Color.white);
		
		if(!tfTelefono.getText().equals("") && !Rutinas.isNumeros(tfTelefono.getText()))
		{
			tfTelefono.setBackground(Color.red);
			estado=false;
		}
		else tfTelefono.setBackground(Color.white);
		
		if(!estado)
		{
			JOptionPane.showMessageDialog(this, "Algunos componentes requeridos están vacios o son incorrectos.");
		}
		else if (GestorDatos.existeDniCliente(tfDni.getText()))
			//Si es true, el dni esta repetido.
		{
			tfDni.setBackground(Color.red);
			JOptionPane.showMessageDialog(this, "Dni repetido.");
			estado=false;
		}
		
		return estado;
	}
	
	private Cliente nuevoCliente()
	//Crea un cliente a partir de los datos del formulario.
	{
		boolean tel=tfTelefono.getText().equals("");
		boolean fech=tfFechaNacimiento.getText().equals("");
		
		if(tel && fech)
		{
			return new Cliente(tfDni.getText(), tfNombre.getText(), tfApellidos.getText(),
					sexoCliente(), tfDireccion.getText(), Integer.parseInt(tfCodigoPostal.getText()),
					tfCiudad.getText(),
					null,null);
		}
		else if(tel)
		{
			return new Cliente(tfDni.getText(), tfNombre.getText(), tfApellidos.getText(),
					sexoCliente(), tfDireccion.getText(), Integer.parseInt(tfCodigoPostal.getText()),
					tfCiudad.getText(),
					null,tfFechaNacimiento.getText());
		}
		else if(fech)
		{
			return new Cliente(tfDni.getText(), tfNombre.getText(), tfApellidos.getText(),
					sexoCliente(), tfDireccion.getText(), Integer.parseInt(tfCodigoPostal.getText()),
					tfCiudad.getText(),
					Integer.parseInt(tfTelefono.getText()),null);
		}
		return new Cliente(tfDni.getText(), tfNombre.getText(), tfApellidos.getText(),
				sexoCliente(), tfDireccion.getText(), Integer.parseInt(tfCodigoPostal.getText()),
				tfCiudad.getText(),
				Integer.parseInt(tfTelefono.getText()),tfFechaNacimiento.getText());
	}
	
	private boolean sexoCliente()
	// Obtiene el sexo del cliente.
	// True si es un hombre y false si es una mujer.
	{
		boolean sexo;
		
		Enumeration<AbstractButton> en= buttonGroup.getElements();
		
		if(en.nextElement().isSelected())
		{
			sexo=true;
		}
		else sexo=false;
		
		return sexo;
		
	}
	
}
