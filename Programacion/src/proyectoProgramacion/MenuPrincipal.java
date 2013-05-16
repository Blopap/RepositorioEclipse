package proyectoProgramacion;

import java.awt.BorderLayout;
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
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
		);
		
		JPanel Clientes = new JPanel();
		tabbedPane.addTab("Gestion Clientes", null, Clientes, null);
		
		JButton btnNuevoCliente = new JButton("Nuevo Cliente");
		
		JLabel lblGestinDeClientes = new JLabel("Gesti\u00F3n de Clientes");
		lblGestinDeClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestinDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		
		
		GroupLayout gl_Clientes = new GroupLayout(Clientes);
		gl_Clientes.setHorizontalGroup(
			gl_Clientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Clientes.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGestinDeClientes, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
						.addGroup(gl_Clientes.createSequentialGroup()
							.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNuevoCliente)
								.addGroup(gl_Clientes.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDni, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(lblBuscarClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(lblApellidos, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfApellidosBusq)
								.addComponent(tfNombreBusq)
								.addComponent(tfDniBusq, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_Clientes.setVerticalGroup(
			gl_Clientes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Clientes.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGestinDeClientes)
					.addPreferredGap(ComponentPlacement.UNRELATED)
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
					.addComponent(btnNuevoCliente)
					.addContainerGap())
		);
		Clientes.setLayout(gl_Clientes);
		
		JPanel Vehiculos = new JPanel();
		
		tabbedPane.addTab("Gestion Vehiculos", null, Vehiculos, null);
		
		JButton btnNuevoVehiculo = new JButton("Nuevo Vehiculo");
		
		
		JLabel lblGestionDeVehiculos = new JLabel("Gesti\u00F3n de Vehiculos");
		lblGestionDeVehiculos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestionDeVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBuscarVehiculos = new JLabel("Buscar Vehiculos");
		
		JLabel lblIdvehiculo = new JLabel("Identificador Vehiculo");
		
		JLabel lblDueo = new JLabel("Due\u00F1o");
		
		JLabel lblMarca = new JLabel("Marca");
		
		JLabel lblModelo = new JLabel("Modelo");
		
		tfIdVehiculoBusq = new JTextField();
		tfIdVehiculoBusq.setColumns(10);
		
		cbDuenyoBusq = new JComboBox();
		
		tfMarcaBusq = new JTextField();
		tfMarcaBusq.setColumns(10);
		
		tfModeloBusq = new JTextField();
		tfModeloBusq.setColumns(10);
		GroupLayout gl_Vehiculos = new GroupLayout(Vehiculos);
		gl_Vehiculos.setHorizontalGroup(
			gl_Vehiculos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Vehiculos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Vehiculos.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGestionDeVehiculos, GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
						.addComponent(btnNuevoVehiculo)
						.addGroup(gl_Vehiculos.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_Vehiculos.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblBuscarVehiculos)
								.addComponent(lblIdvehiculo, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(lblDueo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMarca, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblModelo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Vehiculos.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfIdVehiculoBusq, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
								.addComponent(cbDuenyoBusq, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(tfMarcaBusq)
								.addComponent(tfModeloBusq))
							.addGap(164)))
					.addContainerGap())
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
					.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addComponent(btnNuevoVehiculo)
					.addContainerGap())
		);
		Vehiculos.setLayout(gl_Vehiculos);
		
		JPanel Operaciones = new JPanel();
		tabbedPane.addTab("Gestion Operaciones", null, Operaciones, null);
		GroupLayout gl_Operaciones = new GroupLayout(Operaciones);
		gl_Operaciones.setHorizontalGroup(
			gl_Operaciones.createParallelGroup(Alignment.LEADING)
				.addGap(0, 427, Short.MAX_VALUE)
		);
		gl_Operaciones.setVerticalGroup(
			gl_Operaciones.createParallelGroup(Alignment.LEADING)
				.addGap(0, 228, Short.MAX_VALUE)
		);
		Operaciones.setLayout(gl_Operaciones);
		contentPane.setLayout(gl_contentPane);
		
		//Fin codigo automatico.
		
		
		GestorBD.cargaClientes();
		
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
				if(GestorDatos.comprobarDatos(tfDniBusq.getText(), tfNombreBusq.getText(), tfApellidosBusq.getText()))
				{
					TablaClientes frame = new TablaClientes(GestorDatos.obtenerDatos(tfDniBusq.getText(), tfNombreBusq.getText(), tfApellidosBusq.getText()));
					frame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Datos no coincidentes.");
				}
			}
		});
		
		//Carga los datos en el ComboBox del vehiculo
		Vehiculos.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				Vector<String> aux = GestorDatos.DniNomApClientes(); 
				
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
		
		
		
	}
	
}
