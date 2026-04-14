package agenda.app;

import agenda.dominio.Agenda;
import agenda.dominio.GestorAgenda;

/**
 * Clase principal que ejecuta la aplicación de gestión de agenda.
 */
public class Main {

	public static void main(String[] args) {

		// Crear una instancia de la clase Consola (Singleton)
		Consola consola = Consola.getInstance();

		// Crear una instancia de la clase Menu
		Menu menu = new Menu(consola);

		// Crear una instancia de la clase Agenda
		Agenda agenda = new Agenda();

		// Crear una instancia de la clase GestorAgenda
		GestorAgenda gestor = new GestorAgenda(agenda, consola);

		// Declarar una variable opcion
		int opcion;

		// Bucle do-while para gestionar el menú de la aplicación
		do {
			menu.mostrarMenu();
			opcion = menu.leerOpcion();

			switch (opcion) {
			case 1:
				gestor.crearContacto();

			case 2:
				gestor.listarContactos();

			case 3:
				gestor.buscarContactos();
			case 4:
				gestor.eliminarContacto();

			case 5:
				gestor.anadirTelefonoAContacto();

			case 0:
				consola.escribirLinea("\n¡Hasta pronto! Cerrando la agenda...");

			default:
				consola.escribirLinea("Opción no válida.");
			}

		} while (opcion != 0);

		// Cerrar el recurso Scanner asociado a la entrada estándar
		consola.cerrar();
	}

}
