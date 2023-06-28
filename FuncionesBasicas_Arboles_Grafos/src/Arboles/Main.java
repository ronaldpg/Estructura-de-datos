package Arboles;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Arbol arbol = new Arbol();
		int opcion = 0;
        while (opcion != 5) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "1. Insertar libro\n" +
                    "2. Buscar libro\n" +
                    "3. Eliminar libro\n" +
                    "4. Ordenar libros\n" +
                    "5. Salir\n\n" +
                    "Ingrese una opción:"));

            switch (opcion) {
                case 1:
                    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
                    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
                    Libros libro = new Libros(titulo, autor);
                    arbol.insertar(libro);
                    break;
                case 2:
                    titulo = JOptionPane.showInputDialog("Ingrese el título del libro a buscar:");
                    boolean encontrado = arbol.buscar(new Libros(titulo, ""));
                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, "El libro fue encontrado en el árbol.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El libro no fue encontrado en el árbol.");
                    }
                    break;
                case 3:
                    titulo = JOptionPane.showInputDialog("Ingrese el título del libro a eliminar:");
                    Libros libroEliminado = arbol.eliminar(titulo);
                    if (libroEliminado != null) {
                        JOptionPane.showMessageDialog(null, "El libro \"" + libroEliminado.getNombreLibro() + "\" fue eliminado del árbol.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El libro no fue encontrado en el árbol.");
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Ordenando los libros:");
                    arbol.imprimirInOrden();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }
}
