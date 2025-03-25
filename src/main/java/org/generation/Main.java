package org.generation;

import java.util.Scanner;
/*
 * Clase principal con el menú interactivo para gestionar la agenda.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = configurarAgenda(scanner);

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1": añadirContacto(scanner, agenda); break;
                case "2": existeContacto(scanner, agenda); break;
                case "3": agenda.listarContactos(); break;
                case "4": buscarContacto(scanner, agenda); break;
                case "5": eliminarContacto(scanner, agenda); break;
                case "6": modificarTelefono(scanner, agenda); break;
                case "7": System.out.println(agenda.agendaLlena() ? "Si" : "No"); break;
                case "8": System.out.println(agenda.espacioLibres()); break;
                case "9": salir = true; break;
                default: System.out.println("Opcion invalida.");
            }
        }
        scanner.close();
        System.out.println("Adios!");
    }

    private static Agenda configurarAgenda(Scanner scanner) {
        System.out.print("Tamano de la agenda (Enter para 10): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) return new Agenda();
        try {
            return new Agenda(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            System.out.println("Invalido. Usando tamaño 10.");
            return new Agenda();
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Verificar contacto");
        System.out.println("3. Listar contactos");
        System.out.println("4. Buscar contacto");
        System.out.println("5. Eliminar contacto");
        System.out.println("6. Modificar teléfono");
        System.out.println("7. Agenda llena?");
        System.out.println("8. Espacios libres");
        System.out.println("9. Salir");
        System.out.print("Opcion: ");
    }

    private static void añadirContacto(Scanner scanner, Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
    }

    private static void existeContacto(Scanner scanner, Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.println(agenda.existeContacto(new Contacto(nombre, apellido, "")) ?
                "Existe." : "No existe.");
    }

    private static void buscarContacto(Scanner scanner, Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        agenda.buscaContacto(nombre, apellido);
    }

    private static void eliminarContacto(Scanner scanner, Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        agenda.eliminarContacto(new Contacto(nombre, apellido, ""));
    }

    private static void modificarTelefono(Scanner scanner, Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Nuevo telefono: ");
        String telefono = scanner.nextLine();
        agenda.modificarTelefono(nombre, apellido, telefono);
    }
}