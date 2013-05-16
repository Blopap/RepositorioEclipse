package proyectoProgramacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class NuevoVehiculo extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdVehiculo;
	private JTextField tfMarca;
	private JTextField tfModelo;
	private JTextField tfColor;
	private JTextField tfFechaFabricacion;
	private JComboBox<String> cbDuenyo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoVehiculo frame = new NuevoVehiculo();
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
	public NuevoVehiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Nuevo vehiculo");
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos del nuevo vehiculo");
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblIdentificadorDelVehiculo = new JLabel("Identificador del Vehiculo");
		lblIdentificadorDelVehiculo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblDueoDelVehiculo = new JLabel("Due\u00F1o del Vehiculo");
		lblDueoDelVehiculo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblFechaDeFabricacin = new JLabel("Fecha de fabricaci\u00F3n");
		lblFechaDeFabricacin.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tfIdVehiculo = new JTextField();
		tfIdVehiculo.setColumns(10);
		
		cbDuenyo = new JComboBox();
		
		
		
		tfMarca = new JTextField();
		tfMarca.setColumns(10);
		
		tfModelo = new JTextField();
		tfModelo.setColumns(10);
		
		tfColor = new JTextField();
		tfColor.setColumns(10);
		
		tfFechaFabricacion = new JTextField();
		tfFechaFabricacion.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnIntroducir = new JButton("Introducir");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIntroduzcaLosDatos, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFechaDeFabricacin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblModelo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMarca, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDueoDelVehiculo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblIdentificadorDelVehiculo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cbDuenyo, 0, 235, Short.MAX_VALUE)
								.addComponent(tfIdVehiculo, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
								.addComponent(tfMarca, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
								.addComponent(tfModelo, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
								.addComponent(tfColor, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
								.addComponent(tfFechaFabricacion, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnIntroducir, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIntroduzcaLosDatos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificadorDelVehiculo)
						.addComponent(tfIdVehiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDueoDelVehiculo)
						.addComponent(cbDuenyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarca)
						.addComponent(tfMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo)
						.addComponent(tfModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColor)
						.addComponent(tfColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeFabricacin)
						.addComponent(tfFechaFabricacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnIntroducir))
					.addGap(0, 0, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		anyadirDatosCB();
		
		btnIntroducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
	}
	
	private void anyadirDatosCB()
	{
		Vector<String> aux = GestorDatos.DniNomApClientes(); 
		
		for (int i=0;i<aux.size();i++)
		{
			cbDuenyo.addItem(aux.get(i));
		}
	}
	
	private boolean comprobarVacios()
	//Comprueba si los Textbox que no pueden estar vacios lo estan.
	//Si alguno esta vacio pone el fondo en rojo, sino lo pone en blanco.
	//Si todos los componentes necesarios estan rellenados, comprueba si el identificador de vehiculo no se repite.
	//
	{
		boolean estado=false;
		
		
		
		return estado;
	}

}
