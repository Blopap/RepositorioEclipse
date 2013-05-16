package proyectoProgramacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TablaClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaClientes frame = new TablaClientes(new Vector<Cliente>());
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
	public TablaClientes(Vector <Cliente> c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Listado Cliente");
		setBounds(100, 100, 800, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAceptar = new JButton("Aceptar");
		
		JButton btnModificar = new JButton("Modificar");
		
		
		btnCancelar = new JButton("Cancelar");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(436, Short.MAX_VALUE)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnModificar)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
		);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Dni", "Nombre", "Apellidos", "Varon?", "Direccion", "Codigo Postal", "Ciudad", "Telefono", "Fecha de Nacimiento"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Boolean.class, String.class, Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(81);
		table.getColumnModel().getColumn(3).setPreferredWidth(46);
		table.getColumnModel().getColumn(4).setPreferredWidth(87);
		table.getColumnModel().getColumn(5).setPreferredWidth(78);
		table.getColumnModel().getColumn(6).setPreferredWidth(54);
		table.getColumnModel().getColumn(7).setPreferredWidth(59);
		table.getColumnModel().getColumn(8).setPreferredWidth(112);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.fireTableDataChanged();
		
		final Vector <Cliente> aux = new Vector<Cliente>();
		//Vector que guardará los cambios realizados en la tabla.
		
		for (int i=0;i<c.size();i++)
		{
			model.addRow(c.get(i).trasformaCliente());
			aux.add(c.get(i));
		}
		
		
		
		model.addTableModelListener(new TableModelListener() {
			//Controla las modificaciones en las tablas.
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// Por cada cambio realizado en la tabla, guarda dicho cambio en un vector analogo al introducido.
				
				int fila = e.getFirstRow();
				int columna = e.getColumn();
				
				aux.get(fila).insertarEnPosicion(columna, ""+table.getCellEditor(fila, columna).getCellEditorValue());
								
//				System.out.println("FILA: "+fila+" Columna: "+columna);
//				
//				System.out.println("datos cambiado");
				
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Esta acción modificará la base de datos, desea continuar?")==0)
				{
					for(int i=0;i<aux.size();i++)
					{
						GestorBD.modificarCliente(aux.get(i));
					}
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	
	private Vector<Object> test(int i)
	{
		Vector<Object> test=new Vector<Object>();
		test.add(""+i);
		test.add(""+i);
		test.add(""+i);
		test.add(true);
		test.add(""+i);
		test.add(i);
		test.add(""+i);
		test.add(i);
		test.add(""+i);
		
		return test;
	}
}
