package com.generations.agenda;
//Esta clase servirá para definir los atributos de un Contacto
public class Contacto {
    //Un contacto tendra nombre, apellido y teléfono
    protected String nombre;
    protected String apellido;
    protected String telefono;

    //Constructor de Contacto
    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Usar toString para dar un formato de como se mostrará la información en pantalla
    @Override
    public String toString() {
        return "\nContacto: " + nombre + " " + apellido + "\nTeléfono: " + telefono;
    }
}
