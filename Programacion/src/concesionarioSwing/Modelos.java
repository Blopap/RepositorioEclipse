package concesionarioSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modelos extends JFrame {

	private JPanel contentPane;
	private JTextField CTextField;
	private JTextField DTextField;
	private JTextField PBTextField;
	
	private ArrayList<Modelo> listadoModelos = new ArrayList<Modelo>();
	private int posicion=0;
	private JTextField MPTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modelos frame = new Modelos();
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
	public Modelos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Modelo = new JPanel();
		tabbedPane.addTab("Modelos", null, Modelo, null);
		GridBagLayout gbl_Modelo = new GridBagLayout();
		gbl_Modelo.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Modelo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Modelo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Modelo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Modelo.setLayout(gbl_Modelo);
		
		JLabel lblModelo = new JLabel("Modelos");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.gridwidth = 3;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 4;
		gbc_lblModelo.gridy = 0;
		Modelo.add(lblModelo, gbc_lblModelo);
		
		JLabel lblCodigoDeModelo = new JLabel("Codigo de Modelo");
		GridBagConstraints gbc_lblCodigoDeModelo = new GridBagConstraints();
		gbc_lblCodigoDeModelo.anchor = GridBagConstraints.WEST;
		gbc_lblCodigoDeModelo.gridwidth = 3;
		gbc_lblCodigoDeModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoDeModelo.gridx = 1;
		gbc_lblCodigoDeModelo.gridy = 1;
		Modelo.add(lblCodigoDeModelo, gbc_lblCodigoDeModelo);
		
		CTextField = new JTextField();
		GridBagConstraints gbc_CTextField = new GridBagConstraints();
		gbc_CTextField.gridwidth = 3;
		gbc_CTextField.insets = new Insets(0, 0, 5, 0);
		gbc_CTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CTextField.gridx = 5;
		gbc_CTextField.gridy = 1;
		Modelo.add(CTextField, gbc_CTextField);
		CTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		Modelo.add(lblNewLabel, gbc_lblNewLabel);
		
		DTextField = new JTextField();
		GridBagConstraints gbc_DTextField = new GridBagConstraints();
		gbc_DTextField.gridwidth = 3;
		gbc_DTextField.insets = new Insets(0, 0, 5, 0);
		gbc_DTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_DTextField.gridx = 5;
		gbc_DTextField.gridy = 3;
		Modelo.add(DTextField, gbc_DTextField);
		DTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Precio Base");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		Modelo.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		PBTextField = new JTextField();
		GridBagConstraints gbc_PBTextField = new GridBagConstraints();
		gbc_PBTextField.gridwidth = 3;
		gbc_PBTextField.insets = new Insets(0, 0, 5, 0);
		gbc_PBTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PBTextField.gridx = 5;
		gbc_PBTextField.gridy = 5;
		Modelo.add(PBTextField, gbc_PBTextField);
		PBTextField.setColumns(10);
		 
		 JLabel lblModeloPromocionado = new JLabel("Modelo Promocionado");
		 GridBagConstraints gbc_lblModeloPromocionado = new GridBagConstraints();
		 gbc_lblModeloPromocionado.gridwidth = 3;
		 gbc_lblModeloPromocionado.insets = new Insets(0, 0, 5, 5);
		 gbc_lblModeloPromocionado.gridx = 1;
		 gbc_lblModeloPromocionado.gridy = 7;
		 Modelo.add(lblModeloPromocionado, gbc_lblModeloPromocionado);
		 
		 MPTextField = new JTextField();
		 GridBagConstraints gbc_MPTextField = new GridBagConstraints();
		 gbc_MPTextField.gridwidth = 3;
		 gbc_MPTextField.insets = new Insets(0, 0, 5, 5);
		 gbc_MPTextField.fill = GridBagConstraints.HORIZONTAL;
		 gbc_MPTextField.gridx = 5;
		 gbc_MPTextField.gridy = 7;
		 Modelo.add(MPTextField, gbc_MPTextField);
		 MPTextField.setColumns(10);
		
		
		 final JLabel resultado = new JLabel(" ");
		GridBagConstraints gbc_resultado = new GridBagConstraints();
		gbc_resultado.gridwidth = 4;
		gbc_resultado.insets = new Insets(0, 0, 5, 5);
		gbc_resultado.gridx = 1;
		gbc_resultado.gridy = 8;
		Modelo.add(resultado, gbc_resultado);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!CTextField.getText().equals(
						"El codigo existe, introduzca otro")) {

					if (comprobarCodigoM(Integer.parseInt(CTextField.getText()))) 
					{
						CTextField.setText("El codigo existe, introduzca otro");
						CTextField.setBackground(Color.red);
					} else {
						
						CTextField.setBackground(Color.green);
						resultado.setText("El modelo no existe");

					}
				}
			}
		});
		
		GridBagConstraints gbc_btnComprobar = new GridBagConstraints();
		gbc_btnComprobar.insets = new Insets(0, 0, 5, 5);
		gbc_btnComprobar.gridx = 6;
		gbc_btnComprobar.gridy = 9;
		Modelo.add(btnComprobar, gbc_btnComprobar);
		
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CTextField.setBackground(Color.white);
				
				if (!CTextField.getText().equals(
						"El codigo existe, introduzca otro")) {

					if (!comprobarCodigoM(Integer.parseInt(CTextField.getText()))) 
					{
						if(!MPTextField.getText().equals(""))
						{
							float pb=Float.parseFloat(PBTextField.getText());
							float mp=Float.parseFloat(MPTextField.getText());
							
							listadoModelos.add(new ModeloPromocionado(Integer.parseInt(CTextField.getText()), 
																	  DTextField.getText(), 
																	  pb,
																	  mp));
							
						}
						else
						{
						listadoModelos.add(new Modelo(Integer.parseInt(CTextField.getText()),
													  DTextField.getText(), 
													  Float.parseFloat(PBTextField.getText())));
						}
					}
				}
				
			}
		});
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.insets = new Insets(0, 0, 5, 0);
		gbc_btnAadir.gridx = 7;
		gbc_btnAadir.gridy = 9;
		Modelo.add(btnAadir, gbc_btnAadir);
		
		JPanel Vista = new JPanel();
		
		tabbedPane.addTab("Mostrar", null, Vista, null);
		GridBagLayout gbl_Vista = new GridBagLayout();
		gbl_Vista.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_Vista.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Vista.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Vista.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Vista.setLayout(gbl_Vista);
		
		final JLabel info = new JLabel("");
		GridBagConstraints gbc_info = new GridBagConstraints();
		gbc_info.insets = new Insets(0, 0, 5, 5);
		gbc_info.gridx = 3;
		gbc_info.gridy = 1;
		Vista.add(info, gbc_info);
		
		
		final JButton btnAnterior = new JButton("Anterior");
		
		
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnterior.gridx = 2;
		gbc_btnAnterior.gridy = 6;
		Vista.add(btnAnterior, gbc_btnAnterior);
		
		
		final JButton btnSiguiente = new JButton("Siguiente");
		
		
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.gridx = 4;
		gbc_btnSiguiente.gridy = 6;
		Vista.add(btnSiguiente, gbc_btnSiguiente);
		
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tam=listadoModelos.size();
				
				if(tam > 1)
				{
					if(posicion==0)
					{
						btnAnterior.setEnabled(false);
					}
					else
					{
						btnAnterior.setEnabled(true);
					}
					info.setText(listadoModelos.get(posicion).toString());
				}else if(tam==1)
				{
					btnAnterior.setEnabled(false);
					btnSiguiente.setEnabled(false);
					info.setText(listadoModelos.get(posicion).toString());
				}else if(tam==0)
				{
					btnAnterior.setEnabled(false);
					btnSiguiente.setEnabled(false);
				}
			}
		});
		
		
		
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(posicion==1)
				{
					btnAnterior.setEnabled(false);
				}
				if(posicion<listadoModelos.size())
				{
					btnSiguiente.setEnabled(true);
				}
				posicion--;
				info.setText(listadoModelos.get(posicion).toString());
			}
		});
		
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(posicion==listadoModelos.size()-2)
				{
					btnSiguiente.setEnabled(false);
				}
				if(posicion>0)
				{
					btnAnterior.setEnabled(true);
				}
				posicion++;
				info.setText(listadoModelos.get(posicion).toString());
			}
		});
		
	}
	
	// comprobar si el codigo de modelo ya existe
		public boolean comprobarCodigoM(int codigo)// Dev true si existe, false en
													// caso contrario
		{
			boolean esta = false;

			int tam = this.listadoModelos.size();

			for (int i = 0; i < tam; i++) {
				if (listadoModelos.get(i).getCodigoModelo() == codigo) {
					esta = true;
				}
			}

			return esta;
		}

}
