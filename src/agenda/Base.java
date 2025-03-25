package agenda;
import javax.swing.*;
import java.util.Scanner;


public class Base {
    public static void main(String[] args) {
        int opcion;
        String nombre;
        String apellido;
        int numero;
        Contacto contacto;
        int tamañoAgenda;

        Scanner teclado = new Scanner(System.in);


        tamañoAgenda = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite la cantidad de contactos para su agenda : " ));
        Agenda agendaTelefonica = new Agenda(tamañoAgenda);
        do{



            System.out.println("\n\tLA AGENDA TE SALUDA.-.");
            System.out.println("1. Añadir contactoo");
            System.out.println("2. Listar contactos ");
            System.out.println("3. Buscar un contacto");
            System.out.println("4. Comprobar si existe un contacto");
            System.out.println("5. Eliminar un contacto");
            System.out.println("6. Verificar si hay espacio disponibles");
            System.out.println("7. Verifiacar si la agenda esta llena");
            System.out.println("8. Salir");
            System.out.print("Digite una opcion porfavor : ");
            opcion = teclado.nextInt();

            switch (opcion){
                //añadimos un contacto
                case 1 :
                    System.out.print("Digite su nombre: ");
                    nombre = teclado.next();
                    System.out.print("Digite su apellido: ");
                    apellido = teclado.next();
                    System.out.print("Digite su telefono : ");
                    numero = teclado.nextInt();
                    contacto = new Contacto(nombre,apellido,numero);
                    agendaTelefonica.añadirContacto(contacto);
                    System.out.println("");

                    break;

                //Mostramos lista de contactos
                case 2 :
                    agendaTelefonica.listarContactos();
                    System.out.println("");
                    break;

                //Buscamos un contacto
                case 3 :
                    System.out.println("\nDigite un nombre : ");
                    nombre = teclado.next();

                    agendaTelefonica.buscarContacto(nombre);
                    System.out.println("");
                    break;


                //comprobamos si un contacto existe
                case 4 :
                    System.out.print("\nDigite su nombre : ");
                    nombre = teclado.next();

                    contacto = new Contacto(nombre);
                    if(agendaTelefonica.comprobarSiExisteContacto(contacto)){
                        System.out.print("\nEl contacto existe");
                    }else{
                        System.out.println("\nEl contacto no existe");
                    }
                    break;

                // eliminar un contacto
                case 5 :
                    System.out.println("Digite su nombre : ");
                    nombre = teclado.next();
                    contacto = new Contacto(nombre);
                    agendaTelefonica.eliminarContacto(contacto);
                    System.out.println("");
                    break;

                //verificar si hay espacios disponibles
                case 6 :
                    System.out.println("\nHay " + agendaTelefonica.comprobarSiHayHuecosLibres() + " contactos");
                    System.out.println("");
                    break;

                //Verificar si la agenda esta llena
                case 7 :
                    if(agendaTelefonica.comprobarSiLaAgendaEstaLlena()){
                        System.out.println("\nLa agenda esta llena");
                    }else{
                        System.out.println("\nAun puedes registrar contactos");
                    }
                    System.out.println("");
                    break;

                case 8:
                    System.out.println("\nHasta pronto");
                    break;
                default:
                    System.out.println("\nOpcion no valida, porfavor vuelva a digitar");
                    System.out.println("");
                    break;


            }
        }while (opcion != 8);
    }
}
