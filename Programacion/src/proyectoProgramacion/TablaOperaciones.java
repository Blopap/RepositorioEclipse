package proyectoProgramacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import rutinas.Rutinas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class TablaOperaciones extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaOperaciones frame = new TablaOperaciones(new Vector<Operacion>());
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
	public TablaOperaciones(Vector<Operacion> o) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Listado Operaciones");
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnModificar = new JButton("Operación finalizada");
		
		JButton btnAceptar = new JButton("Aceptar");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(325, Short.MAX_VALUE)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnModificar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar)
						.addComponent(btnModificar))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdOperación", "Vehículo", "Revisiones/Cambios", "Descripción", "Fecha de Entrada", "Fecha de Salida"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(116);
		table.getColumnModel().getColumn(3).setPreferredWidth(122);
		table.getColumnModel().getColumn(4).setPreferredWidth(103);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		//Fin codigo autogenerado
		
		//Obtiene el modelo de la tabla
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		//Vector que guardará los cambios realizados en la tabla.
		final Vector <Operacion> aux = o;
		
		//Introduce los datos del vector "v" en la tabla
		for (int i=0;i<o.size();i++)
		{
			model.addRow(o.get(i).transformaOperacion());
		}
		
		
		//Cierra la ventana actual
		//Sin modificar nada
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		//Actualiza los cambios realizados a los clientes en la base de datos
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Esta acción modificará la base de datos, desea continuar?")==0)
				{
					String fecha = JOptionPane.showInputDialog(null, "Fecha de fin, vacio para fecha actual.");
					
					if(fecha.equals(""))
					{
						fecha = Rutinas.fechaActual();
					}
					if(table.getSelectedRow() >= 0)
						//Si hay una fila seleccionada.
					{
						if(table.getValueAt(table.getSelectedRow(), table.getColumnCount()-1)==null)
							//Si el valor de la fila esta vacio.
						{
							aux.get(table.getSelectedRow()).setFechaSalida(fecha);
							table.setValueAt(fecha,table.getSelectedRow(), table.getColumnCount()-1);
							GestorBD.modificarOperacion(aux.get(table.getSelectedRow()));
						}
						else
						{
							JOptionPane.showMessageDialog(null, "La operacion al vehiculo ya ha sido realizada.");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
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
