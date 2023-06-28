package Arboles;

public class Nodo {

	private Libros libro;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    public Nodo(Libros libro) {
        this.libro = libro;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public Libros getLibro() {
        return libro;
    }
    
    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo nodo) {
        hijoIzquierdo = nodo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo nodo) {
        hijoDerecho = nodo;
    }
    
}
