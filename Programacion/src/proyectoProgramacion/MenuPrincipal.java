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

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	
	
	//Gestion local de datos
	GestorDatos gd=new GestorDatos();
	
	private JTextField tfDniBusq;
	private JTextField tfNombreBusq;
	private JTextField tfApellidosBusq;
	
	

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
		GroupLayout gl_Vehiculos = new GroupLayout(Vehiculos);
		gl_Vehiculos.setHorizontalGroup(
			gl_Vehiculos.createParallelGroup(Alignment.LEADING)
				.addGap(0, 427, Short.MAX_VALUE)
		);
		gl_Vehiculos.setVerticalGroup(
			gl_Vehiculos.createParallelGroup(Alignment.LEADING)
				.addGap(0, 228, Short.MAX_VALUE)
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
		
		
	}
}
