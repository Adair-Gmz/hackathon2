package com.generation.agenda;

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor
    public Contacto(String nombre, String apellido, String telefono) {
        // Validar que nombre y apellido no estén vacíos
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }

        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.telefono = telefono;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    // Setter para teléfono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Equals basado en nombre y apellido (sin distinguir mayúsculas)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Contacto contacto = (Contacto) obj;
        return nombre.equalsIgnoreCase(contacto.nombre) &&
                apellido.equalsIgnoreCase(contacto.apellido);
    }

    // HashCode coherente con equals
    @Override
    public int hashCode() {
        return (nombre.toLowerCase() + apellido.toLowerCase()).hashCode();
    }

    // toString para impresión
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}