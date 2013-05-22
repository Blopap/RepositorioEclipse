package proyectoProgramacion;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import rutinas.Rutinas;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	
	
	//Gestion local de datos
	GestorDatos gd=new GestorDatos();
	
	private JTextField tfDniBusq;
	private JTextField tfNombreBusq;
	private JTextField tfApellidosBusq;
	private JTextField tfIdVehiculoBusq;
	private JTextField tfMarcaBusq;
	private JTextField tfModeloBusq;
	
	private JComboBox<String> cbDuenyoBusq;
	private JTextField tfOperacionesFecha;
	private JComboBox<String> cbOperacionesVehiculos;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 370);
		setTitle("Menu Principal");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 542, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING)
		);
		
		JPanel Clientes = new JPanel();
		tabbedPane.addTab("Gestión Clientes", null, Clientes, null);
		
		JButton btnNuevoCliente = new JButton("Nuevo Cliente");
		
		JLabel lblBuscarClientes = new JLabel("Buscar Clientes");
		
		JLabel lblDni = new JLabel("Dni");
		
		tfDniBusq = new JTextField();
		tfDniBusq.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		tfNombreBusq = new JTextField();
		tfNombreBusq.setColumns(10);
		
		tfApellidosBusq = new JTextField();
		tfApellidosBusq.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		
		JButton btnCerrar = new JButton("Cerrar");
		
		JLabel lblGestionDeClientes = new JLabel("Gesti\u00F3n de Clientes");
		lblGestionDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDeClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		GroupLayout gl_Clientes = new GroupLayout(Clientes);
		gl_Clientes.setHorizontalGroup(
			gl_Clientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Clientes.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Clientes.createSequentialGroup()
							.addComponent(lblGestionDeClientes, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_Clientes.createSequentialGroup()
							.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNuevoCliente, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Clientes.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDni, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(lblBuscarClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(lblApellidos, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
							.addGroup(gl_Clientes.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_Clientes.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING, false)
										.addComponent(tfApellidosBusq)
										.addComponent(tfNombreBusq)
										.addComponent(tfDniBusq, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
									.addContainerGap(306, Short.MAX_VALUE))
								.addGroup(gl_Clientes.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCerrar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
		);
		gl_Clientes.setVerticalGroup(
			gl_Clientes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Clientes.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGestionDeClientes)
					.addGap(19)
					.addComponent(lblBuscarClientes)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Clientes.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(tfDniBusq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Clientes.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(tfNombreBusq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Clientes.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(tfApellidosBusq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscar)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(gl_Clientes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNuevoCliente)
						.addComponent(btnCerrar))
					.addContainerGap())
		);
		Clientes.setLayout(gl_Clientes);
		
		JPanel Vehiculos = new JPanel();
		
		tabbedPane.addTab("Gestión Vehículos", null, Vehiculos, null);
		
		JButton btnNuevoVehiculo = new JButton("Nuevo Vehículo");
		
		
		JLabel lblGestionDeVehiculos = new JLabel("Gesti\u00F3n de Vehículos");
		lblGestionDeVehiculos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestionDeVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBuscarVehiculos = new JLabel("Buscar Vehículos");
		
		JLabel lblIdvehiculo = new JLabel("Identificador Vehículo");
		
		JLabel lblDueo = new JLabel("Due\u00F1o");
		
		JLabel lblMarca = new JLabel("Marca");
		
		JLabel lblModelo = new JLabel("Modelo");
		
		tfIdVehiculoBusq = new JTextField();
		tfIdVehiculoBusq.setColumns(10);
		
		cbDuenyoBusq = new JComboBox<String>();
		
		tfMarcaBusq = new JTextField();
		tfMarcaBusq.setColumns(10);
		
		tfModeloBusq = new JTextField();
		tfModeloBusq.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		
		JButton btnCerrar_1 = new JButton("Cerrar");
				
		GroupLayout gl_Vehiculos = new GroupLayout(Vehiculos);
		gl_Vehiculos.setHorizontalGroup(
			gl_Vehiculos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Vehiculos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Vehiculos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Vehiculos.createSequentialGroup()
							.addComponent(lblGestionDeVehiculos, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_Vehiculos.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_Vehiculos.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblBuscarVehiculos)
								.addComponent(lblIdvehiculo, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(lblDueo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMarca, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblModelo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBuscar_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Vehiculos.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfIdVehiculoBusq, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
								.addComponent(cbDuenyoBusq, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tfMarcaBusq)
								.addComponent(tfModeloBusq))
							.addGap(164))
						.addGroup(gl_Vehiculos.createSequentialGroup()
							.addComponent(btnNuevoVehiculo, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
							.addComponent(btnCerrar_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_Vehiculos.setVerticalGroup(
			gl_Vehiculos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Vehiculos.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGestionDeVehiculos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBuscarVehiculos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Vehiculos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdvehiculo)
						.addComponent(tfIdVehiculoBusq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Vehiculos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDueo)
						.addComponent(cbDuenyoBusq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Vehiculos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarca)
						.addComponent(tfMarcaBusq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Vehiculos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo)
						.addComponent(tfModeloBusq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscar_1)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_Vehiculos.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNuevoVehiculo)
						.addComponent(btnCerrar_1))
					.addContainerGap())
		);
		Vehiculos.setLayout(gl_Vehiculos);
		
		JPanel Operaciones = new JPanel();
		
		tabbedPane.addTab("Gestión Operaciones", null, Operaciones, null);
		
		JButton btnNuevaOperacin = new JButton("Nueva Operaci\u00F3n");
		
		
		JButton btnCerrar_2 = new JButton("Cerrar");
		
		JLabel lblGestinDeOperaciones = new JLabel("Gesti\u00F3n de Operaciones");
		lblGestinDeOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDeOperaciones.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblOperacionesDelVehiculo = new JLabel("Operaciones del vehículo:");
		
		cbOperacionesVehiculos = new JComboBox<String>();
		
		JButton btnBuscar_2 = new JButton("Buscar");
		
		JLabel lblOperacionesSinAcabar = new JLabel("Operaciones sin acabar/Fecha");
		
		tfOperacionesFecha = new JTextField();
		tfOperacionesFecha.setColumns(10);
		
		JButton btnHoy = new JButton("Hoy");
		
		
		GroupLayout gl_Operaciones = new GroupLayout(Operaciones);
		gl_Operaciones.setHorizontalGroup(
			gl_Operaciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Operaciones.createSequentialGroup()
					.addGroup(gl_Operaciones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Operaciones.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_Operaciones.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGestinDeOperaciones, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
								.addGroup(gl_Operaciones.createSequentialGroup()
									.addComponent(btnNuevaOperacin, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
									.addComponent(btnCerrar_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_Operaciones.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_Operaciones.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblOperacionesSinAcabar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblOperacionesDelVehiculo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
								.addComponent(btnBuscar_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_Operaciones.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_Operaciones.createSequentialGroup()
									.addComponent(tfOperacionesFecha)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnHoy))
								.addComponent(cbOperacionesVehiculos, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_Operaciones.setVerticalGroup(
			gl_Operaciones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Operaciones.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGestinDeOperaciones)
					.addGap(18)
					.addGroup(gl_Operaciones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOperacionesDelVehiculo)
						.addComponent(cbOperacionesVehiculos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Operaciones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOperacionesSinAcabar)
						.addComponent(tfOperacionesFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHoy))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscar_2)
					.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
					.addGroup(gl_Operaciones.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNuevaOperacin)
						.addComponent(btnCerrar_2))
					.addContainerGap())
		);
		Operaciones.setLayout(gl_Operaciones);
		contentPane.setLayout(gl_contentPane);
		
		//Fin codigo autogenerado.
		
		//Carga de datos desde la Base de Datos
		GestorBD.cargaClientes();
		GestorBD.cargaVehiculos();
		GestorBD.cargaOperaciones();
		
		//TRATAMIENTO CLIENTES
		
		//Inicia la agregacion de un nuevo cliente
		btnNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				setVisible(false);
				NuevoCliente frame = new NuevoCliente();
				frame.setVisible(true);
			}
		});
		
		//Busca clientes utilizando los datos de los textBox
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(GestorDatos.comprobarDatosCliente(tfDniBusq.getText(), tfNombreBusq.getText(), tfApellidosBusq.getText()))
				{
					TablaClientes frame = new TablaClientes(GestorDatos.obtenerDatosCliente(tfDniBusq.getText(), tfNombreBusq.getText(), tfApellidosBusq.getText()));
					frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Datos no coincidentes.");
				}
			}
		});
		
		//TRATAMIENTO VEHICULOS
		
		//Carga los datos en el ComboBox del vehiculo
		Vehiculos.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				Vector<String> aux = GestorDatos.DniNomApClientes(); 
				
				cbDuenyoBusq.removeAllItems();
				
				cbDuenyoBusq.addItem("");
				
				for (int i=0;i<aux.size();i++)
				{
					cbDuenyoBusq.addItem(aux.get(i));
				}
			}
		});
		
		//Inicia la agregacion de un nuevo vehiculo
		btnNuevoVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevoVehiculo frame = new NuevoVehiculo();
				frame.setVisible(true);
			}
		});
		
		//Busca vehiculos utilizando los datos de los textBox
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GestorDatos.comprobarDatosVehiculo(tfIdVehiculoBusq.getText(), tfMarcaBusq.getText(), tfModeloBusq.getText()))
				{
					String duenyo = ""+cbDuenyoBusq.getSelectedItem();
					
					if(GestorDatos.existeDuenyoVehiculo(duenyo))
					{
						if(!duenyo.equals(""))
						{							
							duenyo = GestorDatos.ComboBoxDuenyo(duenyo);
						}
						TablaVehiculos frame = new TablaVehiculos(GestorDatos.obtenerDatosVehiculo(tfIdVehiculoBusq.getText(),duenyo ,tfMarcaBusq.getText(), tfModeloBusq.getText()));
						frame.setVisible(true);
					}
					else JOptionPane.showMessageDialog(null, "El cliente seleccionado no tiene vehículos en la Base de Datos");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Datos no coincidentes.");
				}
			}
		});
		
		//TRATAMIENTO OPERACIONES
		
		//Inicia la agregacion de un nuevo vehiculo
		btnNuevaOperacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaOperacion frame = new NuevaOperacion();
				frame.setVisible(true);
			}
		});
		
		//Obtiene la fecha actual y la introduce en el TextField OperacionesFecha
		btnHoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfOperacionesFecha.setText(Rutinas.fechaActual());
			}
		});
		
		//Busca operaciones utilizando los datos del ComboBox y el TextField
		btnBuscar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idVehiculo = GestorDatos.identificadorVehiculoDniMarcaModelo(""+cbOperacionesVehiculos.getSelectedItem());
				String fecha = tfOperacionesFecha.getText();
				
				if(GestorDatos.comprobarDatosOperacion(idVehiculo,fecha))
				{
					TablaOperaciones frame = new TablaOperaciones(GestorDatos.obtenerDatosOperacion(idVehiculo, fecha)); 
					frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Datos no coincidentes.");
				}
				
			}
		});
		
		//Carga los datos de los Vehiculos en el ComboBox
		Operaciones.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				Vector<String> aux =  GestorDatos.dniMarcaModeloVehiculos();
				
				cbOperacionesVehiculos.removeAllItems();
				
				cbOperacionesVehiculos.addItem("");
				
				for (int i=0;i<aux.size();i++)
				{
					cbOperacionesVehiculos.addItem(aux.get(i));
				}
				
			}
		});
		
		
		
		//Cierra la aplicacion completamente
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		//Cierra la aplicacion completamente
		btnCerrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Cierra la aplicacion completamente
		btnCerrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
