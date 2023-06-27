package ClasesInterfazG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import static ClasesInterfazG.CreacionArchivos.*;
import ClasesToNodo.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	public Usuario info = new Usuario();
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("INICIO DE SESEION USUARIO");
		lblTitulo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblTitulo.setBounds(77, 11, 265, 27);
		contentPane.add(lblTitulo);
		
		JLabel lblCod = new JLabel("INGRESE EL CODIGO: ");
		lblCod.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 12));
		lblCod.setBounds(41, 106, 122, 14);
		contentPane.add(lblCod);
		
		txtCod = new JTextField();
		txtCod.setBounds(213, 104, 138, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		JButton btnLogin = new JButton("INICIAR SESION");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcesosBiblioteca login = new ProcesosBiblioteca();
				String  link= "C:\\Users\\PC\\Documents\\Proyecto eclipse\\ProyectoFinalGrupoLibro\\RegistroUsuarios\\";
				String Codigo = txtCod.getText();
				String nombreArchivo = link + Codigo + ".txt";
				if(iniciarSesion(nombreArchivo)) {
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
					login.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "ID de usuario o contraseña incorrectos");
				}
			}
		});
		btnLogin.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 16));
		btnLogin.setBounds(41, 214, 163, 23);
		contentPane.add(btnLogin);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal ju = new MenuPrincipal();
				ju.setVisible(true);
				setVisible(false);
			}
		});
		btnSalir.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 16));
		btnSalir.setBounds(260, 217, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 434, 261);
		contentPane.add(lblFondo);
		ImageIcon imagen = new ImageIcon("src/Imagenes/FondoLogin.jpg");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(icono);
	}
}
