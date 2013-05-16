package proyectoProgramacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfContrasenya;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Login Gestión");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		
		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfContrasenya = new JTextField();
		tfContrasenya.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		
		
		JButton btnCancelar = new JButton("Cancelar");
		
		
		JLabel lblBienvenidoAGestion = new JLabel("Bienvenido a Gesti\u00F3n de Veh\u00EDculos");
		lblBienvenidoAGestion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBienvenidoAGestion.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuario, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addComponent(btnLogin, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContrasenya, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfUsuario, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
								.addComponent(tfContrasenya, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnCancelar)
									.addGap(78))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBienvenidoAGestion, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBienvenidoAGestion, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasenya)
						.addComponent(tfContrasenya, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(31))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(GestorBD.comprobarContrasenya(tfUsuario.getText(),tfContrasenya.getText()))
				{
					MenuPrincipal p=new MenuPrincipal();
					p.setVisible(true);
					
					//Abrir ventana nueva, cerrar esta.
					dispose();
					
					
				}
				else
				{
					//Error en el login.
					tfContrasenya.setText("");
					muestraMensaje("Usuario o contraseña erroneo");
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//Cierra la ventana
				//System.exit(0); //Cierra el programa completamente.
			}
		});
		
	}
		
	private void muestraMensaje(String msg)
	//Muestra el mensaje msg en una ventana.
	{
		JOptionPane.showMessageDialog(this, msg);
	}
	
}
