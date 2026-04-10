package agenda.dominio;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private int id;
    private String nombre;
    private String apellidos;
    private String email;

    // DCS: Composición - Contacto "posee" Direccion y Telefonos
    private Direccion direccion;
    private List<Telefono> telefonos;

    // DCS: Sin public, solo Agenda (mismo paquete dominio) puede crear Contacto
    Contacto(int id, String nombre, String apellidos, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefonos = new ArrayList<>();
    }

    // DCS: Contacto CREA su direccion (composición)
    public void definirDireccion(TipoVia tipoVia, int numero, String bloque, String escalera, String portal, String letra) {
        this.direccion = new Direccion(tipoVia, numero, bloque, escalera, portal, letra);
    }

    // DCS: Contacto CREA sus teléfonos (composición)
    public void agregarTelefono(String numero, TipoTelefono tipo) {
        this.telefonos.add(new Telefono(numero, tipo));
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void agregarTelefono(Telefono t) {
        this.telefonos.add(t);
    }

    public List<Telefono> getTelefonos() {
        return new ArrayList<>(this.telefonos);
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ID: ").append(this.id).append("\n");
        sb.append("Nombre: ").append(this.nombre).append(" ").append(this.apellidos).append("\n");

        if (!this.email.isBlank()) {
            sb.append("Email: ").append(this.email).append("\n");
        }

        sb.append("Dirección: ").append(this.direccion).append("\n");

        sb.append("Teléfonos:\n");
        if (this.telefonos.isEmpty()) {
            sb.append("  (sin teléfonos)\n");
        } else {
            for (Telefono t : this.telefonos) {
                sb.append("  - ").append(t).append("\n");
            }
        }

        return sb.toString();
    }
}
