package ClasesInterfazG;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

import javax.swing.JOptionPane;
import ClasesToNodo.*;

public class CreacionArchivos {

	public static boolean iniciarSesion(String nombreArchivo) {
		try (BufferedReader fileReader = new BufferedReader(new FileReader(nombreArchivo))) {
			String line = fileReader.readLine();
			while (line != null) {
					return true;
			}
		} catch (FileNotFoundException e) {
			int opcion = JOptionPane.showConfirmDialog(null,
					"No se pudo iniciar sesion correctamente. ¿Desea intentar nuevamente?", "Error",
					JOptionPane.YES_NO_OPTION);
			if (opcion == JOptionPane.YES_OPTION) {
				return iniciarSesion(nombreArchivo);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al leer el archivo de usuarios");
			iniciarSesion(nombreArchivo);
		}

		return false;
	}

	public static boolean registrarUsuario(String nombreArchivo, String id, String Contra, String nombreCompleto,
            String numCell) {
        Usuario usuario = new Usuario(id, nombreCompleto, numCell, Contra);
        File archivo = new File(nombreArchivo);
        boolean archivoCreado = false;

        try {
            if (!archivo.exists()) {
                archivoCreado = archivo.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (archivoCreado) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
                writer.println(usuario.toString());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
