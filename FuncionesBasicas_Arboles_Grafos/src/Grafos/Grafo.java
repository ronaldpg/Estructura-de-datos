package Grafos;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
public class Grafo {

	private List<Nodo> nodos;

    public Grafo() {
        nodos = new ArrayList<>();
    }

    public void agregarNodo(Libro libro) {
        Nodo nodo = new Nodo(libro);
        nodos.add(nodo);
    }

    public void agregarArista(int indiceOrigen, int indiceDestino) {
        Nodo nodoOrigen = nodos.get(indiceOrigen);
        Nodo nodoDestino = nodos.get(indiceDestino);
        nodoOrigen.agregarAdyacente(nodoDestino);
    }

    public void imprimirGrafo() {
        for (int i = 0; i < nodos.size(); i++) {
            Nodo nodo = nodos.get(i);
            JOptionPane.showMessageDialog(null,"Libro: " + nodo.getLibro().getTitulo() + " (" + nodo.getLibro().getAutor() + ")");
            List<Nodo> adyacentes = nodo.getAdyacentes();
            for (int j = 0; j < adyacentes.size(); j++) {
                Nodo adyacente = adyacentes.get(j);
                JOptionPane.showMessageDialog(null,adyacente.getLibro().getTitulo());
                if (j != adyacentes.size() - 1) {
                	JOptionPane.showMessageDialog(null,", ");
                }
            }
        }
    }
}
