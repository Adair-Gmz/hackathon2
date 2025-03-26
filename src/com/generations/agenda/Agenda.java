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
        if (contactos.size() >= LIMITE_CONTACTOS) {
            System.out.println("¡Error! Agenda llena. No puede añadir más contactos.");
        }
        else
        {
            if (existeContacto(nombre, apellido)) {
                System.out.println("¡Error! El contacto con nombre " + nombre + " y apellido " + apellido + " ya existe.");
            } else {
                contactos.put(nombre + " " + apellido, new Contacto(nombre, apellido, telefono));
                System.out.println("Contacto añadido exitosamente");
            }
        }
    }

    public boolean existeContacto(String nombre, String apellido) {
        String clave = nombre + " " + apellido;
        return contactos.containsKey(clave); // Retorna true si el contacto existe
    }
}
