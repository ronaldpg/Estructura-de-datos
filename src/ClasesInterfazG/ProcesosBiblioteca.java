package ClasesInterfazG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ClaseNodo.*;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.*;
import ClasesToNodo.*;
import static ShellSort.ShellSort.*;

public class ProcesosBiblioteca extends JFrame {
	private JPanel contentPane;
	public ProcesoNodo<Libro> lista = new ProcesoNodo<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		
				try {
					ProcesosBiblioteca frame = new ProcesosBiblioteca();
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
	public ProcesosBiblioteca() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Eliminar mediante el nombre del libro");
				String nombreLibro = JOptionPane.showInputDialog("Ingrese el nombre del libro");
				lista.eliminarL(nombreLibro);
			}
		});
		
		JButton btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Ordenando la lista de libros");
				shellSort(lista);
				JOptionPane.showMessageDialog(null,"Libros ordenados:");
				    for (int i = 0; i < lista.tamaño(); i++) {
				        Libro libro = lista.obtener(i);
				        JOptionPane.showMessageDialog(null,libro.toString());
				    }
			}
		});
		btnOrdenar.setBounds(44, 166, 99, 31);
		contentPane.add(btnOrdenar);
		btnEliminar.setBounds(44, 124, 99, 31);
		contentPane.add(btnEliminar);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreAutor = JOptionPane.showInputDialog("Ingrese el nombre del autor");
				String nombreLibro = JOptionPane.showInputDialog("Ingrese el nombre del libro");
				String fechaP = JOptionPane.showInputDialog("Ingrese la fecha de publicacion del libro");
				String generoLibro = JOptionPane.showInputDialog("Ingrese el genero del libro");
				int numeroPaginas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de paginas del libro", "Ingrensando el numero de paginas", JOptionPane.INFORMATION_MESSAGE));
				Libro libroNuevo = new Libro(nombreAutor, nombreLibro, fechaP, generoLibro, numeroPaginas);
				lista.insertar(libroNuevo);
			}
		});
		btnInsertar.setBounds(44, 82, 102, 31);
		contentPane.add(btnInsertar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Busqueda por el nombre del autor");
				String nombreAutor = JOptionPane.showInputDialog("Ingrese el nombre del autor");
				lista.buscarP(nombreAutor);
			}
		});
		btnBuscar.setBounds(190, 83, 89, 29);
		contentPane.add(btnBuscar);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.mostrarDatos();
			}
		});
		btnVisualizar.setBounds(190, 124, 89, 31);
		contentPane.add(btnVisualizar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal ji = new MenuPrincipal();
				ji.setVisible(true);
				setVisible(false);
			}
		});
		btnSalir.setBounds(190, 166, 89, 31);
		contentPane.add(btnSalir);
		
		JLabel lblTitulo = new JLabel("MENU BIBLIOTECA");
		lblTitulo.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 18));
		lblTitulo.setBounds(87, 11, 165, 31);
		contentPane.add(lblTitulo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 345, 261);
		contentPane.add(lblFondo);
		this.setLocationRelativeTo(null);
		ImageIcon imagen = new ImageIcon("src/Imagenes/FondoBiblioteca (1).jpg");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
		lblFondo.setIcon(icono);
	}
}
