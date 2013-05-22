package proyectoProgramacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class TablaVehiculos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaVehiculos frame = new TablaVehiculos(new Vector<Vehiculo>());
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
	public TablaVehiculos(Vector<Vehiculo> v) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Listado Vehículos");
		setBounds(100, 100, 800, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnCancelar = new JButton("Cancelar");
		
		btnModificar = new JButton("Modificar");
		
		btnAceptar = new JButton("Aceptar");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(462, Short.MAX_VALUE)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModificar)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Identificador Vehículo", "Due\u00F1o", "Marca", "Modelo", "Color", "Fecha Fabricación"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		//Fin codigo autogenerado
		
		//Obtiene el modelo de la tabla
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		//Inicia el evento Table Data Changed
		model.fireTableDataChanged();
		
		//Vector que guardará los cambios realizados en la tabla.
		final Vector <Vehiculo> aux = new Vector<Vehiculo>();
		
		//Introduce los datos del vector "v" en la tabla
		for (int i=0;i<v.size();i++)
		{
			model.addRow(v.get(i).transformaVehiculo());
			aux.add(v.get(i));
		}
		
		
		//Controla las modificaciones en las tablas.
		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				// Por cada cambio realizado en la tabla, guarda dicho cambio en un vector analogo al introducido.
				
				int fila = e.getFirstRow();
				int columna = e.getColumn();
				
				aux.get(fila).insertarEnPosicion(columna, ""+table.getValueAt(fila, columna));
			}
		});
		
		//Cierra la ventana actual
		//Sin modificar nada
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//Actualiza los cambios realizados a los clientes en la base de datos
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Esta acción modificará la base de datos, desea continuar?")==0)
				{
					for(int i=0;i<aux.size();i++)
					{
						GestorBD.modificarVehiculo(aux.get(i));
					}
				}
			}
		});
		
		//Cierra la ventana actual
		//Sin modificar nada
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
