package agenda.dominio;

import java.util.List;

import agenda.app.Consola;

/**
 * Clase de la capa de aplicación que gestiona las acciones de la Agenda desde
 * consola.
 */
public class GestorAgenda {

	private Agenda agenda;
	private Consola consola;

	/**
	 * Crea un gestor de agenda que utilizará una consola para interactuar con el
	 * usuario y una agenda para realizar las operaciones del dominio.
	 *
	 * @param agenda  Agenda sobre la que se realizan las operaciones.
	 * @param consola Consola utilizada para leer y escribir información.
	 */
	public GestorAgenda(Agenda agenda, Consola consola) {
		this.agenda = agenda;
		this.consola = consola;
	}

	/**
	 * Solicita al usuario los datos de un nuevo contacto, lo crea en la agenda y
	 * permite definir su dirección y sus teléfonos.
	 */
	public void crearContacto() {
		consola.escribirLinea("\n=== CREAR NUEVO CONTACTO ===");

		String nombre = consola.leerTextoNoVacio("Introduce el nombre: ");
		String apellidos = consola.leerTextoNoVacio("Introduce los apellidos: ");
		String email = consola.leerTexto("Introduce el email (opcional): ");

		Contacto nuevoContacto = agenda.crearContacto(nombre, apellidos, email);

		consola.escribirLinea("\nContacto creado con ID: " + nuevoContacto.getId());

		// Asignar dirección
		asignarDireccion(nuevoContacto);

		// Añadir teléfonos
		anadirTelefonos(nuevoContacto);

		consola.escribirLinea("\n¡Contacto creado exitosamente!");
	}

	/**
	 * Pide al usuario los datos de una dirección y la asigna al contacto indicado.
	 *
	 * @param contacto Contacto al que se le asignará la dirección.
	 */
	public void asignarDireccion(Contacto contacto) {
		consola.escribirLinea("\n--- Asignar Dirección ---");

		TipoVia tipoVia = elegirTipoVia();
		int numero = consola.leerEntero("Introduce el número: ");
		consola.leerTexto(""); // Limpiar buffer

		String bloque = consola.leerTexto("Introduce el bloque (opcional): ");
		String escalera = consola.leerTexto("Introduce la escalera (opcional): ");
		String portal = consola.leerTexto("Introduce el portal (opcional): ");
		String letra = consola.leerTexto("Introduce la letra (opcional): ");

		contacto.definirDireccion(tipoVia, numero, bloque, escalera, portal, letra);
	}

	/**
	 * Pregunta cuántos teléfonos se desean añadir y solicita sus datos uno a uno,
	 * agregándolos al contacto indicado.
	 *
	 * @param contacto Contacto al que se le añadirán los teléfonos.
	 */
	public void anadirTelefonos(Contacto contacto) {
		consola.escribirLinea("\n--- Añadir Teléfonos ---");

		int cantidad = consola.leerEnteroRango("¿Cuántos teléfonos deseas añadir? ", 0, 10);

		for (int i = 0; i < cantidad; i++) {
			consola.escribirLinea("\nTeléfono " + (i + 1) + ":");
			String numero = consola.leerTextoNoVacio("Introduce el número: ");
			TipoTelefono tipo = elegirTipoTelefono();

			contacto.agregarTelefono(numero, tipo);
		}
	}

	/**
	 * Muestra por consola todos los contactos de la agenda. Si la agenda está
	 * vacía, muestra un mensaje informativo.
	 */
	public void listarContactos() {
		consola.escribirLinea("\n=== LISTA DE CONTACTOS ===");

		List<Contacto> contactos = agenda.listarContactos();

		if (contactos.isEmpty()) {
			consola.escribirLinea("La agenda está vacía. No hay contactos para mostrar.");
		} else {
			consola.escribirLinea("Total de contactos: " + contactos.size() + "\n");
			for (Contacto c : contactos) {
				consola.escribirLinea(c.toString());
				consola.escribirLinea("-----------------------------------");
			}
		}
	}

	/**
	 * Solicita un texto de búsqueda y muestra los contactos cuyo nombre o apellidos
	 * coincidan con el texto indicado.
	 */
	public void buscarContactos() {
		consola.escribirLinea("\n=== BUSCAR CONTACTOS ===");

		String textoBusqueda = consola.leerTextoNoVacio("Introduce el texto de búsqueda: ");

		List<Contacto> resultados = agenda.buscarPorNombre(textoBusqueda);

		if (resultados.isEmpty()) {
			consola.escribirLinea("No se encontraron contactos que coincidan con: " + textoBusqueda);
		} else {
			consola.escribirLinea("\nSe encontraron " + resultados.size() + " contacto(s):\n");
			for (Contacto c : resultados) {
				consola.escribirLinea(c.toString());
				consola.escribirLinea("-----------------------------------");
			}
		}
	}

	/**
	 * Solicita el ID de un contacto y, si existe, lo elimina de la agenda. Muestra
	 * por consola si la operación ha tenido éxito o no.
	 */
	public void eliminarContacto() {
		consola.escribirLinea("\n=== ELIMINAR CONTACTO ===");

		int id = consola.leerEntero("Introduce el ID del contacto a eliminar: ");

		boolean eliminado = agenda.eliminarContactoPorId(id);

		if (eliminado) {
			consola.escribirLinea("✓ Contacto con ID " + id + " eliminado correctamente.");
		} else {
			consola.escribirLinea("✗ No se encontró ningún contacto con ID " + id + ".");
		}
	}

	/**
	 * Solicita el ID de un contacto y añade un nuevo teléfono si el contacto
	 * existe. Si no existe, muestra un mensaje informativo.
	 */
	public void anadirTelefonoAContacto() {
		consola.escribirLinea("\n=== AÑADIR TELÉFONO A CONTACTO ===");

		int id = consola.leerEntero("Introduce el ID del contacto: ");

		Contacto contacto = agenda.obtenerPorId(id);

		if (contacto == null) {
			consola.escribirLinea("✗ No existe ningún contacto con ID " + id + ".");
		} else {
			consola.escribirLinea("Contacto encontrado: " + contacto.getNombre() + " " + contacto.getApellidos());
			consola.leerTexto(""); // Limpiar buffer

			String numero = consola.leerTextoNoVacio("Introduce el número de teléfono: ");
			TipoTelefono tipo = elegirTipoTelefono();

			contacto.agregarTelefono(numero, tipo);
			consola.escribirLinea("✓ Teléfono añadido correctamente.");
		}
	}

	/**
	 * Muestra por consola las opciones disponibles de {@link TipoVia} y devuelve el
	 * tipo elegido.
	 *
	 * @return Tipo de vía seleccionado por el usuario.
	 */
	public TipoVia elegirTipoVia() {
		consola.escribirLinea("\nSelecciona el tipo de vía:");

		TipoVia[] tipos = TipoVia.values();
		for (int i = 0; i < tipos.length; i++) {
			consola.escribirLinea((i + 1) + ". " + tipos[i]);
		}

		int opcion = consola.leerEnteroRango("Elige una opción (1-" + tipos.length + "): ", 1, tipos.length);

		return tipos[opcion - 1];
	}

	/**
	 * Muestra por consola las opciones disponibles de {@link TipoTelefono} y
	 * devuelve el tipo elegido.
	 *
	 * @return Tipo de teléfono seleccionado por el usuario.
	 */
	public TipoTelefono elegirTipoTelefono() {
		consola.escribirLinea("\nSelecciona el tipo de teléfono:");

		TipoTelefono[] tipos = TipoTelefono.values();
		for (int i = 0; i < tipos.length; i++) {
			consola.escribirLinea((i + 1) + ". " + tipos[i]);
		}

		int opcion = consola.leerEnteroRango("Elige una opción (1-" + tipos.length + "): ", 1, tipos.length);

		return tipos[opcion - 1];
	}
}