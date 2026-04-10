
//TODO: Crea todos los atributos y métodos de la clase en base al UML, la documentación y el código que ya tenéis.
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
	 * @param consola Consola utilizada para leer y escribir información.
	 * @param agenda  Agenda sobre la que se realizan las operaciones.
	 */

	public GestorAgenda(Agenda agenda, Consola consola) {
		this.agenda = agenda;
		consola = Consola.getInstance();
	}

	/**
	 * Solicita al usuario los datos de un nuevo contacto, lo crea en la agenda y
	 * permite definir su dirección y sus teléfonos.
	 */

	public void asignarDireccion(Contacto contacto) {
		consola.leerTexto("");
	}
	/**
	 * Pide al usuario los datos de una dirección y la asigna al contacto indicado.
	 *
	 * @param contacto Contacto al que se le asignará la dirección.
	 */

	/**
	 * Pregunta cuántos teléfonos se desean añadir y solicita sus datos uno a uno,
	 * agregándolos al contacto indicado.
	 *
	 * @param contacto Contacto al que se le añadirán los teléfonos.
	 */

	/**
	 * Muestra por consola todos los contactos de la agenda. Si la agenda está
	 * vacía, muestra un mensaje informativo.
	 */

	/**
	 * Solicita un texto de búsqueda y muestra los contactos cuyo nombre o apellidos
	 * coincidan con el texto indicado.
	 */

	/**
	 * Solicita el ID de un contacto y, si existe, lo elimina de la agenda. Muestra
	 * por consola si la operación ha tenido éxito o no.
	 */

	/**
	 * Solicita el ID de un contacto y añade un nuevo teléfono si el contacto
	 * existe. Si no existe, muestra un mensaje informativo.
	 */

	/**
	 * Muestra por consola las opciones disponibles de {@link TipoVia} y devuelve el
	 * tipo elegido.
	 *
	 * @return Tipo de vía seleccionado por el usuario.
	 */

	/**
	 * Muestra por consola las opciones disponibles de {@link TipoTelefono} y
	 * devuelve el tipo elegido.
	 *
	 * @return Tipo de teléfono seleccionado por el usuario.
	 */

}
