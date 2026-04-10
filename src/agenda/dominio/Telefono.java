package agenda.dominio;

class Telefono { // DCS: Sin public solo accesible dentro del paquete dominio
    private String numero;
    private TipoTelefono tipo;

    // DCS: Sin public, solo Contacto (mismo paquete dominio) puede crear Telefono
    Telefono(String numero, TipoTelefono tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo + ": " + this.numero;
    }
}
