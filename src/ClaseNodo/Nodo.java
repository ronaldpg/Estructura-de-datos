package ClaseNodo;
import ClasesInterfazG.*;

public class Nodo<T>{

	T dato;
	Nodo<T> enlaceSiguiente;
	
	//sin parametros
	public Nodo() {
		dato = null;
		enlaceSiguiente = null;
	}
	
	//con parametros
	public Nodo(T t) {
		dato = t;
		enlaceSiguiente = null;
	}

	//con dos parametros
	public Nodo(T t,Nodo<T> nodo) {
		dato = t;
		enlaceSiguiente = nodo;
	}
	
	public T obtenerValor() {
		return dato;
	}
	
	public void	enlazarSiguiente(Nodo<T> n){
		enlaceSiguiente = n;
	}
	
	public Nodo<T>	obtenerSiguiente() {
		return enlaceSiguiente;
	}

	//get and set
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Nodo<T> getEnlace() {
		return enlaceSiguiente;
	}

	public void setEnlace(Nodo<T> enlaceSiguiente) {
		this.enlaceSiguiente = enlaceSiguiente;
	}
	
}
