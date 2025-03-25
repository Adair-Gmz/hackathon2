package com.devic.test;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

// Gestion de la agenda
public class Agenda {
    // Conjunto ordenado para almacenar contactos únicos
    private Set<Contacto> contactos;
    private int tamañoMaximo;

    // Tamaño por defecto
    public Agenda() {
        this(10); // Tamaño por defecto de 10 contactos
    }

    // Tamaño personalizado
    public Agenda(int tamañoMaximo) {
        if (tamañoMaximo <= 0) {
            throw new IllegalArgumentException("El tamaño de la agenda debe ser positivo");
        }
        this.tamañoMaximo = tamañoMaximo;
        this.contactos = new TreeSet<>();
    }

    // Añadir un contacto
    public boolean añadirContacto(Contacto contacto) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena. No se pueden agregar más contactos.");
            return false;
        }

        if (existeContacto(contacto)) {
            System.out.println("El contacto ya existe en la agenda.");
            return false;
        }

        return contactos.add(contacto);
    }

    // Verificar si existe
    public boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }

    // Listar contactos
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.println("Contactos en la agenda:");
        contactos.forEach(System.out::println);
    }

    // Buscar
    public void buscarContacto(String nombre, String apellido) {
        Optional<Contacto> contactoEncontrado = contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre) &&
                        c.getApellido().equalsIgnoreCase(apellido))
                .findFirst();

        if (contactoEncontrado.isPresent()) {
            System.out.println("Teléfono: " + contactoEncontrado.get().getTelefono());
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    // Eliminar
    public boolean eliminarContacto(Contacto contacto) {
        boolean eliminado = contactos.remove(contacto);
        if (eliminado) {
            System.out.println("Contacto eliminado exitosamente.");
        } else {
            System.out.println("El contacto no existe en la agenda.");
        }
        return eliminado;
    }

    // Modificar teléfono
    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        Optional<Contacto> contactoEncontrado = contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre) &&
                        c.getApellido().equalsIgnoreCase(apellido))
                .findFirst();

        if (contactoEncontrado.isPresent()) {
            Contacto contacto = contactoEncontrado.get();
            contactos.remove(contacto);
            contacto.setTelefono(nuevoTelefono);
            contactos.add(contacto);
            System.out.println("Teléfono modificado exitosamente.");
            return true;
        }

        System.out.println("Contacto no encontrado.");
        return false;
    }

    // Verificar si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() >= tamañoMaximo;
    }

    // Calcular espacios libres
    public int espacioLibres() {
        return tamañoMaximo - contactos.size();
    }
}