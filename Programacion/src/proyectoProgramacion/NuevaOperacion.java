package proyectoProgramacion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import rutinas.Rutinas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevaOperacion extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdentificador;
	private JTextField tfFechaEntrada;
	private JComboBox<String> cbVehiculo;
	private JTextArea taDescripcion;
	
	private JCheckBox chckbxAceite;
	private JCheckBox chckbxFiltroAire;
	private JCheckBox chckbxFiltroCombustible;
	private JCheckBox chckbxFiltroAceite;
	private JCheckBox chckbxRuedas;
	private JCheckBox chckbxOtros;
	private JButton btnHoy;

	//Main para pruebas de la ventana
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NuevaOperacion frame = new NuevaOperacion();
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
	public NuevaOperacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Nueva operación");
		setBounds(100, 100, 530, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos de la Operaci\u00F3n");
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setEnabled(true);
		lblIntroduzcaLosDatos.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblIdentificadorDeLa = new JLabel("Identificador de la operaci\u00F3n");
		lblIdentificadorDeLa.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblRevCambio = new JLabel("Revisiones / cambios");
		lblRevCambio.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblFechaDeEntrada = new JLabel("Fecha de Entrada");
		lblFechaDeEntrada.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		
		tfIdentificador = new JTextField();
		tfIdentificador.setColumns(10);
		
		chckbxAceite = new JCheckBox("Aceite");
		
		chckbxFiltroAire = new JCheckBox("Filtro aire");
		
		chckbxFiltroCombustible = new JCheckBox("Filtro combustible");
		
		chckbxFiltroAceite = new JCheckBox("Filtro aceite");
		
		chckbxRuedas = new JCheckBox("Ruedas");
		
		chckbxOtros = new JCheckBox("Otros");
		
		tfFechaEntrada = new JTextField();
		tfFechaEntrada.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCancelar = new JButton("Cancelar");
		
		
		JButton btnIntroducir = new JButton("Introducir");
		
		
		cbVehiculo = new JComboBox<String>();
		
		btnHoy = new JButton("Hoy");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(lblDescripcion, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIntroduzcaLosDatos, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFechaDeEntrada, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
										.addComponent(lblRevCambio, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
										.addComponent(lblVehiculo, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
										.addComponent(lblIdentificadorDeLa, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(tfIdentificador, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
										.addComponent(cbVehiculo, 0, 300, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(chckbxAceite, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
												.addComponent(chckbxFiltroAceite, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(chckbxRuedas, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
												.addComponent(chckbxFiltroAire, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(chckbxOtros, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
												.addComponent(chckbxFiltroCombustible, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
											.addGap(18))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(tfFechaEntrada, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnHoy)))))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnIntroducir, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIntroduzcaLosDatos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificadorDeLa)
						.addComponent(tfIdentificador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVehiculo)
						.addComponent(cbVehiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxAceite)
						.addComponent(lblRevCambio)
						.addComponent(chckbxFiltroAire)
						.addComponent(chckbxFiltroCombustible))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxFiltroAceite)
						.addComponent(chckbxRuedas)
						.addComponent(chckbxOtros))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfFechaEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaDeEntrada)
						.addComponent(btnHoy))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDescripcion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnIntroducir)))
		);
		
		taDescripcion = new JTextArea();
		scrollPane.setViewportView(taDescripcion);
		contentPane.setLayout(gl_contentPane);
		
		//Fin codigo autogenerado
		
		//Añade los datos al ComboBox
		anyadirDatosCB();
		
		//Introduce el siguente identificador de operacion en el TextField y lo desactiva
		tfIdentificador.setText(""+GestorDatos.siguienteIdentificadorOperacion());
		tfIdentificador.setEditable(false);
		
		//Cierra la ventana
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//Comprueba si los campos necesarios estan rellenados
		//Si lo estan, inserta los datos en la base de datos y
		//lo inserta en el vector local de operaciones		
		btnIntroducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comprobarVacios())
				{
					//Introducir los datos de la operacion
					Operacion o = nuevaOperacion();
					
					if(GestorBD.insertarOperacion(o))
					{
						GestorDatos.anyadirOperacion(o);
						dispose();
						JOptionPane.showMessageDialog(null, "Operación introducida correctamente");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error de inserción");
					}
				}
			}
		});
		
		//Introduce el valor del dia actual al TextField Fecha Entrada
		btnHoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				tfFechaEntrada.setText(Rutinas.fechaActual());				
			}
		});
		
	}
	
	private Operacion nuevaOperacion()
	//Crea una nueva operacion.
	{
		int id = Integer.parseInt(tfIdentificador.getText());
		int vehiculo = GestorDatos.identificadorVehiculoDniMarcaModelo(""+cbVehiculo.getSelectedItem());
		boolean desc = taDescripcion.getText().equals("");
				
		if(desc)
		{
			return new Operacion(id, 
					vehiculo, 
					valorRevCambios(), 
					null, 
					tfFechaEntrada.getText(), 
					null);
		}
		else
		{
			return new Operacion(id, 
								vehiculo, 
								valorRevCambios(), 
								taDescripcion.getText(), 
								tfFechaEntrada.getText(), 
								null);
		}
	}
	
	private int valorRevCambios()
	//Obtiene el valor de las revisiones/cambios a partir de los CheckBox
	{
		return GestorDatos.valorRevCambios(chckbxAceite.isSelected(), 
											chckbxFiltroAire.isSelected(),
											chckbxFiltroCombustible.isSelected(), 
											chckbxFiltroAceite.isSelected(),
											chckbxRuedas.isSelected(), 
											chckbxRuedas.isSelected());
	}
	
	private void anyadirDatosCB()
	//Carga los datos de los vehiculos en el ComboBox.
	{
		Vector<String> aux = GestorDatos.dniMarcaModeloVehiculos();
		
		for(int i = 0; i<aux.size();i++)
		{
			cbVehiculo.addItem(aux.get(i));
		}
	}
	
	private boolean comprobarVacios()
	//Comprueba si los Textbox que no pueden estar vacios lo estan.
	//Si alguno esta vacio pone el fondo en rojo, si no lo pone en blanco.
	{
		boolean estado = true;
		
		if(tfFechaEntrada.getText().equals(""))
		{
			tfFechaEntrada.setBackground(Color.red);
			estado=false;
		}
		else tfFechaEntrada.setBackground(Color.white);
		
		if(!estado)
		{
			JOptionPane.showMessageDialog(this, "Algún componente esta vacío.");
		}	
		
		return estado;
	}
}
