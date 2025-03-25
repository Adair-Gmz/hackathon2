package com.devic.test;

import java.util.*;

// Clase Contacto
public class Contacto implements Comparable<Contacto> {
    // Encapsulamiento
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor principal
    public Contacto(String nombre, String apellido, String telefono) {
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
    }

    // Setters con validaciones
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        this.apellido = apellido.trim();
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }

    // Comparación de contactos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Contacto contacto = (Contacto) obj;
        return nombre.equalsIgnoreCase(contacto.nombre) &&
                apellido.equalsIgnoreCase(contacto.apellido);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    // Ordenamiento alfabético
    @Override
    public int compareTo(Contacto otro) {
        int comparacionNombre = this.nombre.compareToIgnoreCase(otro.nombre);
        if (comparacionNombre != 0) {
            return comparacionNombre;
        }
        return this.apellido.compareToIgnoreCase(otro.apellido);
    }

    // Impresión de datos
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}


