package ClasesInterfazG;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import static ClasesInterfazG.CreacionArchivos.*;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.Icon;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * 


	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		
		setForeground(Color.RED);
		setTitle("Libreria Municipal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro w = new Registro();
				MenuPrincipal l = new MenuPrincipal();
				w.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistro.setBounds(77, 54, 112, 36);
		contentPane.add(btnRegistro);
		
		JButton btnInicio = new JButton("Inicia Sesión");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login s = new Login();
				s.setVisible(true);
				setVisible(false);
			}
		});
		btnInicio.setBounds(77, 101, 112, 36);
		contentPane.add(btnInicio);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(87, 148, 99, 36);
		contentPane.add(btnSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 282, 237);
		contentPane.add(lblFondo);
		this.setLocationRelativeTo(null);
		ImageIcon imagen = new ImageIcon("src/Imagenes/Añadir un título (3).png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(icono);
	}
}
