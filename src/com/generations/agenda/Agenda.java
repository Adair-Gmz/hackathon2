package com.generations.agenda;
import java.util.HashMap;

//Esta clase Agenda.java contendra los métodos que se usarán para el menú de Main.java
public class Agenda {
    //Usar HashMap evitará que existan datos duplicados en la agenda
    //String será la key y Contacto corresponde a Contacto.java
    protected HashMap<String, Contacto> contactos = new HashMap<>();
    protected int limite_contactos = 10;

    public void anadirContacto(String nombre, String apellido, String telefono) {
        if (agendaLlena()) {//Si la agenda esta llena, mostrar ese mensaje
            System.out.println("\n✖ Error ✖ | Agenda llena. No se pueden añadir más contactos.");
        }
        else
        {
            String contacto = nombre + " " + apellido;
            //Volver minuscula para evitar datos duplicados por mayusculas y minusculas
            contacto = contacto.toLowerCase();
            if (existeContacto(contacto)) {//Si el contacto existe, mostrar ese mensaje
                System.out.println("\n✖ Error ✖ | El contacto " + nombre + " " + apellido + " ya existe.");
            } else {//En caso contrario, añadirlo en el HashMap
                //Volver nombre y apellido a minuscula
                nombre = nombre.toLowerCase();
                apellido = apellido.toLowerCase();
                //Volver la primer letra de nombre y apellido en mayuscula
                nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
                apellido = apellido.substring(0, 1).toUpperCase() + apellido.substring(1);
                //Añadir al HashMap
                contactos.put(contacto, new Contacto(nombre, apellido, telefono));
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
            for (String contacto : contactos.keySet()) {
                System.out.println(contactos.get(contacto));
            }
        }
    }

    public void buscarContacto(String nombre, String apellido) {
        String contacto = nombre + " " + apellido;
        contacto = contacto.toLowerCase();
        if (existeContacto(contacto)) {//Si el contacto existe, se muestra el contacto
            System.out.println("\nContacto encontrado");
            System.out.println(contactos.get(contacto));
        } else {//En caso contrario, mostrar que no existe
            System.out.println("\n✖ Error ✖ | El contacto " + nombre + " " + apellido + " no existe");
        }
    }

    public void eliminarContacto(String nombre, String apellido) {
        String contacto = nombre + " " + apellido;
        contacto = contacto.toLowerCase();
        if (existeContacto(contacto)) {//Si el contacto existe, eliminarlo
            contactos.remove(contacto);
            System.out.println("\nContacto eliminado exitosamente");
        } else {
            System.out.println("\n✖ Error ✖ | El contacto " + nombre + " " + apellido + " no existe");
        }
    }

    public void modificarTelefono(String nombre, String apellido, String telefonoNuevo) {
        String contacto = nombre + " " + apellido;
        contacto = contacto.toLowerCase();
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
        return contactos.size() >= limite_contactos;
    }

    public void espaciosLibres() {
        if (agendaLlena()) {//Si la agenda esta llena, mostrar ese mensaje
            System.out.println("\nAgenda llena. No se pueden añadir más contactos.");
        }else {//En caso contrario, mostrar cuantos espacios quedan libres
            int espacios = limite_contactos - contactos.size();
            System.out.println("\nLa agenda aún tiene " + espacios + " espacios libres");
        }
    }

    public void nuevoLimite(int limite){
       limite_contactos = limite; //Establecer nuevo límite de contactos
       System.out.println("\nEl nuevo límite de contactos es: " + limite_contactos);
    }
}
