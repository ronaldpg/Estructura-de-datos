package ClasesToNodo;

public class Usuario {

	String ID, nombreCompleto, numeroTelefono, contra;
	
	//================= CONSTRUCTOR ===============================================
	public Usuario(String iD, String nombreCompleto, String numeroTelefono,String contra) {
		ID = iD;
		this.contra = contra;
		this.nombreCompleto = nombreCompleto;
		this.numeroTelefono = numeroTelefono;
	}
	
	public Usuario(String iD, String contra) {
		ID = iD;
		this.contra = contra;
	}

	public Usuario() {
	}

	//==================== GET AND SET =============================================
	public String getID() {
		return ID;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	//======== TO STRING ============================================
	@Override
	public String toString() {
		return "Usuario \nID: " + getID() + "\nNombre: " + getNombreCompleto() + "\nNumero de telefono: " + getNumeroTelefono() + "\nContraseña: " + getContra() + "";
	}
	
}
