package proyectoProgramacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
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

public class TablaClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnAceptar;

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
		setBounds(100, 100, 800, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAceptar = new JButton("Aceptar");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAceptar)
					.addContainerGap(701, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAceptar)
					.addContainerGap(18, Short.MAX_VALUE))
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
		
		for (int i=0;i<c.size();i++)
		{
			model.addRow(c.get(i).trasformaCliente());
		}
		
		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				
				int fila = e.getFirstRow();
				int columna = e.getColumn();
				
				System.out.println("FILA: "+fila+" Columna: "+columna);
				
				System.out.println("datos cambiado");
				
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
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
