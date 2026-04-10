package agenda.dominio;

public class ContactoFactory {
	public static Contacto crearContacto(int id, String nombre, String apellidos, String email) {
		return new Contacto(id, nombre, apellidos, email);
	}
}
