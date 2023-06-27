package ClaseNodo;

import javax.swing.JOptionPane;

import ClasesToNodo.Libro;


public class ProcesoNodo<T> {

	private Nodo<T> cabeza;

	public ProcesoNodo() {
		cabeza = null;

	}

	public ProcesoNodo(Nodo<T> ini) {
		cabeza = ini;

	}

	// ==================== INSERTAR =======================================
	public void insertar(T elemento) {
		Nodo<T> nuevoNodo = new Nodo<>(elemento);
		if (cabeza == null) {
			cabeza = nuevoNodo;
		} else {
			Nodo<T> nodoActual = cabeza;
			while (nodoActual.enlaceSiguiente != null) {
				nodoActual = nodoActual.enlaceSiguiente;
			}
			nodoActual.enlaceSiguiente = nuevoNodo;
		}
	}

	// ==================== BUSCAR ==============================================
	public void buscarP(String autor) {
	    Nodo<T> actual = cabeza;
	    boolean encontrado = false;

	    while (actual != null) {
	        if (((Libro) actual.dato).getNombreAutor().equals(autor)) {
	        	JOptionPane.showMessageDialog(null,"Libro encontrado:");
	        	JOptionPane.showMessageDialog(null,actual.dato.toString());
	            encontrado = true;
	        }
	        actual = actual.enlaceSiguiente;
	    }

	    if (!encontrado) {
	    	JOptionPane.showMessageDialog(null,"No se encontró ningún libro del autor " + autor);
	    }
	}

	// =========================== BOLEAAN
	// ===========================================
	public boolean estaVacia() {
		if (cabeza == null) {
			JOptionPane.showMessageDialog(null, "La lista esta vacia");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "La lista esta llena");
			return false;
		}
	}

	// ============================= MOSTAR DATOS
	// =========================================
	public void mostrarDatos() {
		Nodo<T> actual = cabeza;
		if (cabeza == null) {
			JOptionPane.showMessageDialog(null, "La lista esta Empty");
			return;
		} else {
			while (actual != null) {
				JOptionPane.showMessageDialog(null, "DATOS ENCONTRADOS");
				JOptionPane.showMessageDialog(null, actual.getDato().toString());
				actual = actual.getEnlace();
			}
		}
	}
	// ====================================== ELIMNAR ===========================================

	public void eliminarL(String nombreLibro) {
	    Nodo<T> anterior = null;
	    Nodo<T> actual = cabeza;

	    while (actual != null) {
	        if (actual.dato instanceof Libro && ((Libro) actual.dato).nombreLibro.equals(nombreLibro)) {
	            if (anterior == null) {
	                cabeza = actual.enlaceSiguiente;
	            } else {
	                anterior.enlaceSiguiente = actual.enlaceSiguiente;
	            }
	            JOptionPane.showMessageDialog(null,"Se ha eliminado de manera exitosa el libro");
	            return; 
	        }

	        anterior = actual;
	        actual = actual.enlaceSiguiente;
	    }

	    JOptionPane.showMessageDialog(null,"El libro '" + nombreLibro + "' no se encontró en la lista.");
	}
	// =========================================== Metodos para el ordenamiento shellshort ==========================================

	//===================== Metodo que retorna el tamaño de la lista =====================
	 public int tamaño() {
	        int tamaño = 0;
	        Nodo<T> actual = cabeza;
	        while (actual != null) {
	            tamaño++;
	            actual = actual.enlaceSiguiente;
	        }
	        return tamaño;
	    }

	 	//================================== Metodo que retorna el nodo si se encontro en el indice indicado ============================0
	    public T obtener(int indice) {
	        if (indice < 0 || indice >= tamaño()) {
	            throw new IndexOutOfBoundsException("Índice fuera de rango");
	        }
	        Nodo<T> actual = cabeza;
	        for (int i = 0; i < indice; i++) {
	            actual = actual.enlaceSiguiente;
	        }
	        return actual.dato;
	    }
	    
	    //=============================== Metodo que insertar un nodo nuevo en el indice indicado ==================================
	    public void insertar(Object elemento, int indice) {
	        if (indice < 0 || indice > tamaño()) {
	            throw new IndexOutOfBoundsException("Índice fuera de rango");
	        }
	        Nodo<T> nuevoNodo = new Nodo(elemento);
	        if (indice == 0) {
	            nuevoNodo.enlaceSiguiente = cabeza;
	            cabeza = nuevoNodo;
	        } else {
	            Nodo<T> actual = cabeza;
	            for (int i = 0; i < indice - 1; i++) {
	                actual = actual.enlaceSiguiente;
	            }
	            nuevoNodo.enlaceSiguiente = actual.enlaceSiguiente;
	            actual.enlaceSiguiente = nuevoNodo;
	        }
	    }
	    
	    //====================== Metodo que obtiene el nodo segun el indice mandado por parametro =====================
	    private Nodo obtenerNodo(int indice) {
	        if (indice < 0 || indice >= tamaño()) {
	            throw new IndexOutOfBoundsException("Índice fuera de rango");
	        }

	        Nodo actual = cabeza;
	        for (int i = 0; i < indice; i++) {
	            actual = actual.enlaceSiguiente;
	        }
	        return actual;
	    }
	    
	    //================= Metodo que elimina el nodo segun el indice mandado por parametros ===========================
	    public void eliminar(int indice) {
	        if (indice < 0 || indice >= tamaño()) {
	            throw new IndexOutOfBoundsException("Índice fuera de rango");
	        }

	        if (indice == 0) {
	            cabeza = cabeza.enlaceSiguiente;
	        } else {
	            Nodo anterior = obtenerNodo(indice - 1);
	            Nodo actual = anterior.enlaceSiguiente;
	            anterior.enlaceSiguiente = actual.enlaceSiguiente;
	        }
	    }
}
