 package com.devic.test;

import java.util.Scanner;


 // Clase principal para la interacción con el usuario
 public class Main {
     private static Scanner scanner = new Scanner(System.in);
     private static Agenda agenda;

     public static void main(String[] args) {
         inicializarAgenda();
         menuPrincipal();
     }

     // Inicializar la agenda con tamaño personalizado o por defecto
     private static void inicializarAgenda() {
         System.out.println("¿Desea especificar un tamaño personalizado para la agenda? (s/n)");
         String respuesta = scanner.nextLine();

         if (respuesta.equalsIgnoreCase("s")) {
             System.out.print("Ingrese el tamaño máximo de la agenda: ");
             int tamaño = scanner.nextInt();
             scanner.nextLine(); // Consumir salto de línea
             agenda = new Agenda(tamaño);
         } else {
             agenda = new Agenda(); // Tamaño por defecto
         }
     }

     // Menú principal de la aplicación
     private static void menuPrincipal() {
         while (true) {
             mostrarMenu();
             int opcion = scanner.nextInt();
             scanner.nextLine(); // Consumir salto de línea

             switch (opcion) {
                 case 1: añadirContacto(); break;
                 case 2: buscarContacto(); break;
                 case 3: eliminarContacto(); break;
                 case 4: modificarTelefono(); break;
                 case 5: agenda.listarContactos(); break;
                 case 6: verificarEspacioAgenda(); break;
                 case 7:
                     System.out.println("Saliendo del sistema...");
                     return;
                 default:
                     System.out.println("Opción inválida.");
             }
         }
     }

     // Mostrar menú de opciones
     private static void mostrarMenu() {
         System.out.println("*****************************");
         System.out.println("\n--- AGENDA TELEFÓNICA ---");
         System.out.println("*****************************");
         System.out.println("1. Añadir Contacto");
         System.out.println("*****************************");
         System.out.println("2. Buscar Contacto");
         System.out.println("*****************************");
         System.out.println("3. Eliminar Contacto");
         System.out.println("*****************************");
         System.out.println("4. Modificar Teléfono");
         System.out.println("*****************************");
         System.out.println("5. Listar Contactos");
         System.out.println("*****************************");
         System.out.println("6. Verificar Espacio en Agenda");
         System.out.println("*****************************");
         System.out.println("7. Salir");
         System.out.println("*****************************");
         System.out.print("Seleccione una opción: ");
         System.out.println("*****************************");
     }

     // Método para añadir un nuevo contacto
     private static void añadirContacto() {
         try {
             System.out.print("Ingrese nombre: ");
             String nombre = scanner.nextLine();

             System.out.print("Ingrese apellido: ");
             String apellido = scanner.nextLine();

             System.out.print("Ingrese teléfono: ");
             String telefono = scanner.nextLine();

             Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
             agenda.añadirContacto(nuevoContacto);
         } catch (IllegalArgumentException e) {
             System.out.println("Error: " + e.getMessage());
         }
     }

     // Buscar un contacto
     /// ssssssssssss
     private static void buscarContacto() {
         System.out.print("Ingrese nombre a buscar: ");
         String nombre = scanner.nextLine();

         System.out.print("Ingrese apellido a buscar: ");
         String apellido = scanner.nextLine();

         agenda.buscarContacto(nombre, apellido);
     }

     // Método para eliminar un contacto
     private static void eliminarContacto() {
         System.out.print("Ingrese nombre del contacto: ");
         String nombre = scanner.nextLine();

         System.out.print("Ingrese apellido del contacto: ");
         String apellido = scanner.nextLine();

         Contacto contactoEliminar = new Contacto(nombre, apellido, "");
         agenda.eliminarContacto(contactoEliminar);
     }

     // Método para modificar el teléfono de un contacto
     private static void modificarTelefono() {
         System.out.print("Ingrese nombre del contacto: ");
         String nombre = scanner.nextLine();

         System.out.print("Ingrese apellido del contacto: ");
         String apellido = scanner.nextLine();

         System.out.print("Ingrese nuevo teléfono: ");
         String nuevoTelefono = scanner.nextLine();

         agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
     }

     // Método para verificar el espacio en la agenda
     private static void verificarEspacioAgenda() {
         System.out.println("Espacios libres: " + agenda.espacioLibres());
         System.out.println("Agenda " + (agenda.agendaLlena() ? "está llena" : "tiene espacio disponible"));
     }
 }