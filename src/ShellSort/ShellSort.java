package ShellSort;
import ClaseNodo.ProcesoNodo;
import ClasesToNodo.Libro;

public class ShellSort {

	public static void shellSort(ProcesoNodo lista) {
	    int n = lista.tamaño();
	    int gap = n / 2;

	    while (gap > 0) {
	        for (int i = gap; i < n; i++) {
	            Libro temp = (Libro) lista.obtener(i);
	            int j = i;

	            while (j >= gap && ((Libro) lista.obtener(j - gap)).compareTo(temp) > 0) {
	                lista.eliminar(j);
	                lista.insertar((Libro) lista.obtener(j - gap), j);
	                j -= gap;
	            }

	            lista.eliminar(j);
	            lista.insertar(temp, j);
	        }

	        gap /= 2;
	    }
	}
}
