package concesionarioSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ModelosOld extends JFrame {

	private JPanel contentPane;
	private JTextField DescripcionModelo;
	private JTextField PrecioModelo;
	private JTextField CodigoModelo;
	private JButton btnAñadir;
	
	private ArrayList<Modelo> listadoModelos= new ArrayList<Modelo>();
	private JLabel lblModeloIntroducido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModelosOld frame = new ModelosOld();
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
	public ModelosOld() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNuevoModelo = new JLabel("Nuevo modelo");
		GridBagConstraints gbc_lblNuevoModelo = new GridBagConstraints();
		gbc_lblNuevoModelo.gridwidth = 2;
		gbc_lblNuevoModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevoModelo.gridx = 2;
		gbc_lblNuevoModelo.gridy = 0;
		contentPane.add(lblNuevoModelo, gbc_lblNuevoModelo);
		
		JLabel lblNewLabel = new JLabel("Introduzca el codigo del modelo");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		CodigoModelo = new JTextField();
		CodigoModelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(CodigoModelo.getText().equals("El codigo existe, introduzca otro"))
				{
					CodigoModelo.setText("");
				}
				CodigoModelo.setBackground(Color.white);
				lblModeloIntroducido.setVisible(false);
			}
		});
		CodigoModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(CodigoModelo.getText().equals("El codigo existe, introduzca otro"))
				{
					CodigoModelo.setText("");
				}
				CodigoModelo.setBackground(Color.white);
				lblModeloIntroducido.setVisible(false);
			}
		});
		
		CodigoModelo.setText("");
		GridBagConstraints gbc_CodigoModelo = new GridBagConstraints();
		gbc_CodigoModelo.gridwidth = 3;
		gbc_CodigoModelo.insets = new Insets(0, 0, 5, 0);
		gbc_CodigoModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_CodigoModelo.gridx = 3;
		gbc_CodigoModelo.gridy = 1;
		contentPane.add(CodigoModelo, gbc_CodigoModelo);
		CodigoModelo.setColumns(10);
		
		JLabel lblIntroduzcaLaDescripcion = new JLabel("Introduzca la descripcion del modelo");
		GridBagConstraints gbc_lblIntroduzcaLaDescripcion = new GridBagConstraints();
		gbc_lblIntroduzcaLaDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblIntroduzcaLaDescripcion.gridwidth = 2;
		gbc_lblIntroduzcaLaDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroduzcaLaDescripcion.gridx = 0;
		gbc_lblIntroduzcaLaDescripcion.gridy = 3;
		contentPane.add(lblIntroduzcaLaDescripcion, gbc_lblIntroduzcaLaDescripcion);
		
		DescripcionModelo = new JTextField();
		GridBagConstraints gbc_DescripcionModelo = new GridBagConstraints();
		gbc_DescripcionModelo.gridwidth = 3;
		gbc_DescripcionModelo.insets = new Insets(0, 0, 5, 0);
		gbc_DescripcionModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_DescripcionModelo.gridx = 3;
		gbc_DescripcionModelo.gridy = 3;
		contentPane.add(DescripcionModelo, gbc_DescripcionModelo);
		DescripcionModelo.setColumns(10);
		
		JLabel lblIntroduzcaElPrecio = new JLabel("Introduzca el precio Base");
		GridBagConstraints gbc_lblIntroduzcaElPrecio = new GridBagConstraints();
		gbc_lblIntroduzcaElPrecio.anchor = GridBagConstraints.WEST;
		gbc_lblIntroduzcaElPrecio.gridwidth = 2;
		gbc_lblIntroduzcaElPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroduzcaElPrecio.gridx = 0;
		gbc_lblIntroduzcaElPrecio.gridy = 5;
		contentPane.add(lblIntroduzcaElPrecio, gbc_lblIntroduzcaElPrecio);
		
		PrecioModelo = new JTextField();
		GridBagConstraints gbc_PrecioModelo = new GridBagConstraints();
		gbc_PrecioModelo.insets = new Insets(0, 0, 5, 0);
		gbc_PrecioModelo.gridwidth = 3;
		gbc_PrecioModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_PrecioModelo.gridx = 3;
		gbc_PrecioModelo.gridy = 5;
		contentPane.add(PrecioModelo, gbc_PrecioModelo);
		PrecioModelo.setColumns(10);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(!CodigoModelo.getText().equals("El codigo existe, introduzca otro"))
				{
				
					if(comprobarCodigoM(Integer.parseInt(CodigoModelo.getText())))
					{
						CodigoModelo.setText("El codigo existe, introduzca otro");
						CodigoModelo.setBackground(Color.red);
					}
					else
					{
						listadoModelos.add(new Modelo(Integer.parseInt(CodigoModelo.getText()),
																	   DescripcionModelo.getText(),
																	   Float.parseFloat(PrecioModelo.getText())));
						lblModeloIntroducido.setVisible(true);
						
						listadoModelos.toString();
					}
				}
				
			}
		});
		
		lblModeloIntroducido = new JLabel("Modelo Introducido");
		lblModeloIntroducido.setVisible(false);
		GridBagConstraints gbc_lblModeloIntroducido = new GridBagConstraints();
		gbc_lblModeloIntroducido.insets = new Insets(0, 0, 0, 5);
		gbc_lblModeloIntroducido.gridx = 1;
		gbc_lblModeloIntroducido.gridy = 8;
		contentPane.add(lblModeloIntroducido, gbc_lblModeloIntroducido);
		GridBagConstraints gbc_btnAñadir = new GridBagConstraints();
		gbc_btnAñadir.gridx = 5;
		gbc_btnAñadir.gridy = 8;
		contentPane.add(btnAñadir, gbc_btnAñadir);
	}
	
	//comprobar si el codigo de modelo ya existe
	public boolean comprobarCodigoM(int codigo)//Dev true si existe, false en caso contrario
	{
		boolean esta=false;
		
		int tam=this.listadoModelos.size();
		
		for(int i=0;i<tam;i++)
		{
			if(listadoModelos.get(i).getCodigoModelo() == codigo)
			{				
				esta=true;
			}
		}
		
		return esta;
	}

}
