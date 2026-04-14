package agenda.app;

/**
 * Clase de la capa de aplicación que gestiona el menú de opciones de la
 * aplicación de agenda.
 */
public class Menu {

	private Consola consola;

	/**
	 * Crea un objeto Menu que utilizará una consola para mostrar opciones y leer la
	 * selección del usuario.
	 *
	 * @param consola Consola utilizada para la interacción con el usuario.
	 */
	public Menu(Consola consola) {
		this.consola = consola;
	}

	/**
	 * Muestra el menú principal con todas las opciones disponibles.
	 */
	public void mostrarMenu() {
		consola.escribirLinea("");
		consola.escribirLinea("        AGENDA DE CONTACTOS          ");
		consola.escribirLinea("");
		consola.escribirLinea("1. Crear nuevo contacto");
		consola.escribirLinea("2. Listar todos los contactos");
		consola.escribirLinea("3. Buscar contactos");
		consola.escribirLinea("4. Eliminar contacto");
		consola.escribirLinea("5. Añadir teléfono a contacto");
		consola.escribirLinea("0. Salir");
		consola.escribirLinea("────────────────────────────────────");
	}

	/**
	 * Solicita al usuario que elija una opción del menú y devuelve el número
	 * seleccionado.
	 *
	 * @return Opción elegida por el usuario (0-5).
	 */
	public int leerOpcion() {
		return consola.leerEnteroRango("Selecciona una opción: ", 0, 5);
	}
}