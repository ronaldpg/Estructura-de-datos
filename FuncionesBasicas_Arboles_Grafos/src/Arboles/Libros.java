package Arboles;

public class Libros implements Comparable<Libros> {

	private String nombreLibro;
    private String autor;

    public Libros(String nombreLibro, String autor) {
        this.nombreLibro = nombreLibro;
        this.autor = autor;
    }


	public String getNombreLibro() {
        return nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public int compareTo(Libros otroLibro) {
        return this.nombreLibro.compareToIgnoreCase(otroLibro.getNombreLibro());
    }
}
