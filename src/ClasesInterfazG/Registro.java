package ClasesInterfazG;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.*;
import static ClasesInterfazG.CreacionArchivos.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import ClasesToNodo.*;

public class Registro extends JFrame {
	
	private MenuPrincipal s = new MenuPrincipal();
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField txtCedula;
	private JTextField txtNumTelefono;
	public Usuario info = new Usuario();
	private JTextField txtContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 12));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  link= "C:\\Users\\PC\\Documents\\Proyecto eclipse\\ProyectoFinalGrupoLibro\\RegistroUsuarios\\";
				String nombre = textNombre.getText();
				String telefono = txtNumTelefono.getText();
				String cedula = txtCedula.getText();
				String contra = txtContra.getText();
				String subCadenaN = nombre.substring(0,2);
				String subCadenaC = cedula.substring(6);
				String cadenaD = subCadenaN + subCadenaC;
				String nombreArchivo = cadenaD + ".txt";
				info.setNombreCompleto(nombre);
				info.setID(cedula);
				info.setNumeroTelefono(telefono);
				info.setContra(contra);
				String archivo = link + nombreArchivo;
				if (registrarUsuario(archivo, cedula, contra, nombre, telefono)) {
		            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente" + "\nSu codigo para iniciar sesion: " + cadenaD);
				} else {
		            JOptionPane.showMessageDialog(null, "Error al registrar el usuario" + "\nEl usuario que intenta registra ya existe");
		        }
				textNombre.setText("");
				txtNumTelefono.setText("");
				txtCedula.setText("");
				txtContra.setText("");
			}
		});
		btnRegistrar.setBounds(23, 185, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.setVisible(true);
				setVisible(false);
			}
		});
		btnSalir.setBounds(196, 185, 89, 23);
		contentPane.add(btnSalir);
		
		textNombre = new JTextField();
		textNombre.setBounds(173, 45, 112, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtCedula.getText().length() >= 11) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		txtCedula.setBounds(173, 76, 112, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNumTelefono = new JTextField();
		txtNumTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNumTelefono.getText().length() >= 9) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		txtNumTelefono.setBounds(173, 107, 112, 20);
		contentPane.add(txtNumTelefono);
		txtNumTelefono.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre->");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(23, 48, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula->");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(20, 79, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número de Teléfono->");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(23, 110, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblContra = new JLabel("Contraseña->");
		lblContra.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 11));
		lblContra.setBounds(23, 141, 74, 14);
		contentPane.add(lblContra);
		
		txtContra = new JTextField();
		txtContra.setBounds(173, 138, 112, 20);
		contentPane.add(txtContra);
		txtContra.setColumns(10);
		
		JLabel lblTitulo = new JLabel("REGISTRO USUARIO");
		lblTitulo.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 17));
		lblTitulo.setBounds(72, 11, 157, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 325, 261);
		contentPane.add(lblFondo);
		this.setLocationRelativeTo(null);
		ImageIcon imagen = new ImageIcon("src/Imagenes/FondoRegistro.jpg");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(icono);
	}
}
