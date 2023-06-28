package Grafos;
import java.util.ArrayList;
import java.util.List;
public class Nodo {

	private Libro libro;
    private List<Nodo> adyacentes;

    public Nodo(Libro libro) {
        this.libro = libro;
        this.adyacentes = new ArrayList<>();
    }

    public Libro getLibro() {
        return libro;
    }

    public List<Nodo> getAdyacentes() {
        return adyacentes;
    }

    public void agregarAdyacente(Nodo nodo) {
        adyacentes.add(nodo);
    }
}
