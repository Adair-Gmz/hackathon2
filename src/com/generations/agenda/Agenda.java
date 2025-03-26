package com.generations.agenda;
import java.util.HashMap;
import java.util.Map;

//Esta clase Agenda.java contendra los métodos que se usarán para el menú de Main.java
public class Agenda {
    //String será la key y Contacto corresponde a Contacto.java
    protected Map<String, Contacto> contactos;
    protected int LIMITE_CONTACTOS = 10;

    public Agenda() {
        //Usar HashMap evitará que existan datos duplicados en la agenda
        contactos = new HashMap<>();
    }

    public void anadirContacto(String nombre, String apellido, String telefono) {
        if (agendaLlena()) {
            System.out.println("\n✖ Error ✖ | Agenda llena. No se pueden añadir más contactos.");
        }
        else
        {
            String contacto = nombre + " " + apellido;
            if (existeContacto(contacto)) {
                System.out.println("\n✖ Error ✖ | El contacto " + nombre + " " + apellido + " ya existe.");
            } else {
                contactos.put(nombre + " " + apellido, new Contacto(nombre, apellido, telefono));
                System.out.println("\nContacto añadido exitosamente");
            }
        }
    }

    public boolean existeContacto(String contacto) {
        return contactos.containsKey(contacto); // Retorna un booleano True si el contacto existe
    }

    public void listarContactos(){
        if (contactos.isEmpty()) { //Si la agenda esta vacia, mostrará ese mensaje
            System.out.println("\nSu agenda esta vacía");
        } else { //En caso contrario, mostrará todos los contactos de la agenda
            for (Map.Entry<String, Contacto> contacto : contactos.entrySet()) {
                System.out.println(contacto.getValue());
            }
        }
    }

    public void buscarContacto(String nombre, String apellido) {
        String contacto = nombre + " " + apellido;
        if (existeContacto(contacto)) {//Si el contacto existe, se muestra el contacto
            System.out.println("\nContacto encontrado");
            System.out.println(contactos.get(contacto));
        } else {//En caso contrario, mostrar que no existe
            System.out.println("\n✖ Error ✖ | El contacto " + nombre + " " + apellido + " no existe");
        }
    }

    public void eliminarContacto(String nombre, String apellido) {
        String contacto = nombre + " " + apellido;
        if (existeContacto(contacto)) {//Si el contacto existe, eliminarlo
            contactos.remove(contacto);
            System.out.println("\nContacto eliminado exitosamente");
        } else {
            System.out.println("\n✖ Error ✖ | El contacto " + nombre + " " + apellido + " no existe");
        }
    }

    public void modificarTelefono(String nombre, String apellido, String telefonoNuevo) {
        String contacto = nombre + " " + apellido;
        if (existeContacto(contacto)) { //Si el contacto existe, modificarlo
            Contacto cambio = contactos.get(contacto);
            cambio.setTelefono(telefonoNuevo);
            System.out.println("\nTeléfono modificado exitosamente");
        } else { //En caso contrario, mostrar que no existe
            System.out.println("\n✖ Error ✖ | El contacto " + nombre + " " + apellido + " no existe");
        }
    }

    public boolean agendaLlena() {
        //Si la agenda esta llena, retornarlo como True
        return contactos.size() >= LIMITE_CONTACTOS;
    }

    public void espaciosLibres() {
        if (agendaLlena()) {//Si la agenda esta llena, mostrarlo
            System.out.println("\nAgenda llena. No se pueden añadir más contactos.");
        }else {//En caso contrario, mostrar cuantos espacios quedan libres
            int espacios = LIMITE_CONTACTOS - contactos.size();
            System.out.println("\nLa agenda aún tiene " + espacios + " espacios libres");
        }
    }
}
