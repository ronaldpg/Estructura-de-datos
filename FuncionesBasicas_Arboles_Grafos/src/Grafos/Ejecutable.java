package Grafos;

import javax.swing.JOptionPane;

public class Ejecutable {

	public static void main(String[] args) {
	
		Grafo grafo = new Grafo();
		int opcion = 0;
        while (opcion != 3) {
            	opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:\n"
                    + "1. Agregar libro\n"
                    + "2. Imprimir grafo\n"
                    + "3. Salir"));

            switch (opcion) {
                case 1:
                    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro");
                    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro");
                    Libro libro = new Libro(titulo, autor);
                    grafo.agregarNodo(libro);
                    JOptionPane.showMessageDialog(null, "Libro agregado correctamente");
                    break;
                case 2:
                    grafo.imprimirGrafo();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
        }
    }
}
