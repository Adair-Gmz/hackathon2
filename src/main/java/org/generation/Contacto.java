package org.generation;

import java.util.Objects;

/*
Representa un contacto en la agenda telefónica.
Un contacto está compuesto por nombre, apellido y teléfono.
Dos contactos se consideran iguales si tienen el mismo nombre y apellido (ignorando mayúsculas).
*/
public class Contacto {
    // Campos privados para encapsular los datos del contacto
    private String nombre;      // Almacena el nombre del contacto
    private String apellido;    // Almacena el apellido del contacto
    private String telefono;    // Almacena el número de teléfono del contacto

    /*
      Constructor: Crea una instancia de Contacto.
     @param nombre    Nombre del contacto (no puede estar vacío).
     @param apellido  Apellido del contacto (no puede estar vacío).
     @param telefono  Número de teléfono (no se valida el formato).
     */
    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;          // Asigna el nombre recibido al campo 'nombre'
        this.apellido = apellido;       // Asigna el apellido recibido al campo 'apellido'
        this.telefono = telefono;       // Asigna el teléfono recibido al campo 'telefono'
    }

    // Métodos Getters (para acceder a los campos privados)

    /*
      @return El nombre del contacto.
     */
    public String getNombre() { return nombre; }

    /*
      @return El apellido del contacto.
     */
    public String getApellido() { return apellido; }

    /*
     @return El teléfono del contacto.
     */
    public String getTelefono() { return telefono; }

    /*Método Setter (solo para teléfono, ya que nombre/apellido definen la identidad)*/

    /*
     Actualiza el número de teléfono del contacto.
     @param telefono Nuevo número de teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;  // Reemplaza el valor actual de 'telefono' con el nuevo valor
    }

    /*
     Compara si dos contactos son iguales.
     @param o Objeto a comparar (debe ser una instancia de Contacto).
     @return true si nombre y apellido coinciden (ignorando mayúsculas), false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        // Paso 1: Verifica si es el mismo objeto en memoria
        if (this == o) return true;
        // Paso 2: Verifica si el objeto es nulo o no es una instancia de Contacto
        if (o == null || getClass() != o.getClass()) return false;
        // Paso 3: Convierte el objeto a tipo Contacto para comparar campos
        Contacto contacto = (Contacto) o;
        // Paso 4: Compara nombre y apellido en minúsculas para ignorar diferencias de casing
        return nombre.equalsIgnoreCase(contacto.nombre) &&
                apellido.equalsIgnoreCase(contacto.apellido);
    }

    /*
     Genera un código hash único basado en nombre y apellido (en minúsculas).
     @return Código hash para usar en estructuras de datos como HashMap o HashSet.
     */
    @Override
    public int hashCode() {
        // Usa la clase Objects para generar un hash combinando nombre y apellido en minúsculas
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }
}