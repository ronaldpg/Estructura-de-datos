package Arboles;
import javax.swing.JOptionPane;
public class Arbol {

	private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(Libros libro) {
        raiz = insertarNodo(raiz, libro);
    }

    private Nodo insertarNodo(Nodo nodo, Libros libro) {
        if (nodo == null) {
            return new Nodo(libro);
        }

        if (libro.compareTo(nodo.getLibro()) < 0) {
            nodo.setHijoIzquierdo(insertarNodo(nodo.getHijoIzquierdo(), libro));
        } else if (libro.compareTo(nodo.getLibro()) > 0) {
            nodo.setHijoDerecho(insertarNodo(nodo.getHijoDerecho(), libro));
        }

        return nodo;
    }

    public boolean buscar(Libros libro) {
        return buscarNodo(raiz, libro);
    }

    private boolean buscarNodo(Nodo nodo, Libros libro) {
        if (nodo == null) {
            return false;
        }

        if (libro.compareTo(nodo.getLibro()) == 0) {
            return true;
        } else if (libro.compareTo(nodo.getLibro()) < 0) {
            return buscarNodo(nodo.getHijoIzquierdo(), libro);
        } else {
            return buscarNodo(nodo.getHijoDerecho(), libro);
        }
    }

    public Libros eliminar(String titulo) {
        Nodo nodoEliminado = eliminarNodo(raiz, titulo);
        return (nodoEliminado != null) ? nodoEliminado.getLibro() : null;
    }

    private Nodo eliminarNodo(Nodo nodo, String titulo) {
        if (nodo == null) {
            return null;
        }

        if (titulo.compareToIgnoreCase(nodo.getLibro().getNombreLibro()) < 0) {
            nodo.setHijoIzquierdo(eliminarNodo(nodo.getHijoIzquierdo(), titulo));
        } else if (titulo.compareToIgnoreCase(nodo.getLibro().getNombreLibro()) > 0) {
            nodo.setHijoDerecho(eliminarNodo(nodo.getHijoDerecho(), titulo));
        } else {
            if (nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null) {
                return null;
            } else if (nodo.getHijoIzquierdo() == null) {
                return nodo.getHijoDerecho();
            } else if (nodo.getHijoDerecho() == null) {
                return nodo.getHijoIzquierdo();
            } else {
                Nodo sucesor = obtenerSucesor(nodo.getHijoDerecho());
                nodo.setLibro(sucesor.getLibro());
                nodo.setHijoDerecho(eliminarNodo(nodo.getHijoDerecho(), sucesor.getLibro().getNombreLibro()));
            }
        }

        return nodo;
    }

    private Nodo obtenerSucesor(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.getHijoIzquierdo() != null) {
            actual = actual.getHijoIzquierdo();
        }
        return actual;
    }

    public void imprimirInOrden() {
        imprimirInOrdenRecursivo(raiz);
    }

    private void imprimirInOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirInOrdenRecursivo(nodo.getHijoIzquierdo());
            JOptionPane.showMessageDialog(null,"Título: " + nodo.getLibro().getNombreLibro() + ", Autor: " + nodo.getLibro().getAutor());
            imprimirInOrdenRecursivo(nodo.getHijoDerecho());
        }
    }
}