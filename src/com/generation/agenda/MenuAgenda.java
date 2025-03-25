package com.generation.agenda;

import java.util.Scanner;

public class MenuAgenda {
    private static Agenda agenda;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarAgenda();
        mostrarMenu();
    }

    private static void inicializarAgenda() {
        System.out.println("¿Desea crear la agenda con un tamaño específico? (s/n)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Introduzca el tamaño de la agenda: ");
            int tamano = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            agenda = new Agenda(tamano);
        } else {
            agenda = new Agenda(); // Tamaño por defecto
        }
    }

    private static void mostrarMenu() {
        while (true) {
            System.out.println("\n--- AGENDA TELEFÓNICA ---");
            System.out.println("1. Añadir Contacto");
            System.out.println("2. Listar Contactos");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Eliminar Contacto");
            System.out.println("5. Modificar Teléfono");
            System.out.println("6. Espacios Libres");
            System.out.println("7. Verificar Agenda Llena");
            System.out.println("8. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    añadirContacto();
                    break;
                case 2:
                    agenda.listarContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    eliminarContacto();
                    break;
                case 5:
                    modificarTelefono();
                    break;
                case 6:
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;
                case 7:
                    System.out.println(agenda.agendaLlena() ?
                            "La agenda está llena" : "La agenda no está llena");
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void añadirContacto() {
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
            agenda.añadirContacto(nuevoContacto);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void buscarContacto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        agenda.buscaContacto(nombre, apellido);
    }

    private static void eliminarContacto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        Contacto contactoAEliminar = new Contacto(nombre, apellido, "");
        agenda.eliminarContacto(contactoAEliminar);
    }

    private static void modificarTelefono() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Nuevo Teléfono: ");
        String nuevoTelefono = scanner.nextLine();

        agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
    }
}