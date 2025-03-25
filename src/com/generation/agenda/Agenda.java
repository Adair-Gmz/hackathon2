package com.generation.agenda;

import java.util.Arrays;
import java.util.Comparator;

public class Agenda {
    private Contacto[] contactos;
    private int numContactos;

    // Constructor con tamaño por defecto
    public Agenda() {
        this(10);
    }

    // Constructor con tamaño personalizado
    public Agenda(int tamano) {
        if (tamano <= 0) {
            throw new IllegalArgumentException("El tamaño de la agenda debe ser positivo");
        }
        contactos = new Contacto[tamano];
        numContactos = 0;
    }

    // Añadir contacto
    public void añadirContacto(Contacto c) {
        // Verificar si la agenda está llena
        if (agendaLlena()) {
            System.out.println("La agenda está llena. No se pueden añadir más contactos.");
            return;
        }

        // Verificar si el contacto ya existe
        if (existeContacto(c)) {
            System.out.println("El contacto ya existe en la agenda.");
            return;
        }

        // Añadir contacto
        contactos[numContactos] = c;
        numContactos++;
        System.out.println("Contacto añadido exitosamente.");
    }

    // Verificar si el contacto existe
    public boolean existeContacto(Contacto c) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    // Listar contactos
    public void listarContactos() {
        if (numContactos == 0) {
            System.out.println("La agenda está vacía.");
            return;
        }

        // Ordenar contactos alfabéticamente
        Contacto[] contactosOrdenados = Arrays.copyOf(contactos, numContactos);
        Arrays.sort(contactosOrdenados, new Comparator<Contacto>() {
            @Override
            public int compare(Contacto c1, Contacto c2) {
                int comparacionNombre = c1.getNombre().compareToIgnoreCase(c2.getNombre());
                if (comparacionNombre != 0) {
                    return comparacionNombre;
                }
                return c1.getApellido().compareToIgnoreCase(c2.getApellido());
            }
        });

        // Imprimir contactos ordenados
        for (Contacto c : contactosOrdenados) {
            System.out.println(c);
        }
    }

    // Buscar contacto por nombre y apellido
    public void buscaContacto(String nombre, String apellido) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre) &&
                    contactos[i].getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Teléfono: " + contactos[i].getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Eliminar contacto
    public void eliminarContacto(Contacto c) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].equals(c)) {
                // Desplazar elementos para llenar el hueco
                for (int j = i; j < numContactos - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                contactos[numContactos - 1] = null;
                numContactos--;
                System.out.println("Contacto eliminado exitosamente.");
                return;
            }
        }
        System.out.println("El contacto no existe en la agenda.");
    }

    // Modificar teléfono
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre) &&
                    contactos[i].getApellido().equalsIgnoreCase(apellido)) {
                contactos[i].setTelefono(nuevoTelefono);
                System.out.println("Teléfono modificado exitosamente.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Verificar si la agenda está llena
    public boolean agendaLlena() {
        return numContactos >= contactos.length;
    }

    // Espacios libres
    public int espacioLibres() {
        return contactos.length - numContactos;
    }
}