package agenda;

public class Agenda {

    private Contacto contactos[];

    public Agenda() {
        contactos = new Contacto[10];   //establecemos un tamaño de 10 contactos
    }
    public Agenda(int tamaño){
        contactos = new Contacto[tamaño];
    }
    //metodo para añadir contactos a la agenda
    public void añadirContacto(Contacto contacto){
        if(comprobarSiExisteContacto(contacto)){
            System.out.println("\nYa existe un contacto con ese nombre, porfavor digite otro nombre");

        }
        else if(comprobarSiLaAgendaEstaLlena()){
            System.out.println("\nLa agenda esta llena");
        }
        else{
            boolean registrado = false;
            for (int i = 0; i < contactos.length && !registrado; i++) {
                if(contactos[i] == null){
                    contactos[i] = contacto;
                    registrado = true;
                }

            }
            if(registrado == true){
                System.out.println("\nEl contacto se ha registrado con exito !!");
            }else{
                System.out.println("\nLa agenda esta llena lo siento");
            }
        }

    }
    //comprobar si existe un contacto con el mismo nombre
    public boolean comprobarSiExisteContacto(Contacto contacto){
        for(int i = 0;i < contactos.length; i++){
            if(contactos[i] != null && contactos[i].equals(contacto)){
                return true;
            }

        }
        return false;
    }
    //metodo para comprobar si la agenda esta llena
    public boolean comprobarSiLaAgendaEstaLlena(){
        for(int i = 0;i < contactos.length; i++){
            if(contactos[i] == null){
                return false;
            }
        }
        return true;
    }
    //Metodo para listar los contactos
    public  void listarContactos(){
        if(comprobarSiHayHuecosLibres()== contactos.length){
            System.out.println("\nNo hay contactos para listar");

        }
        else{
            for (int i = 0; i < contactos.length; i++) {
                if (contactos [i] != null){
                    System.out.println("Nombre : " + contactos[i].getNombre());
                    System.out.println("Numero : " + contactos[i].getNumero());
                    System.out.println("Apellido : " + contactos[i].getApellido());
                    System.out.println("");
                }

            }

        }

    }
    //Creamos el metodo para comprobar si hay espacios libres en el arreglo
    public int comprobarSiHayHuecosLibres(){
        int contadorVacios = 0;
        for(int i = 0;i < contactos.length; i++){
            if(contactos[i] == null){
                contadorVacios ++;

            }
        }
        return contadorVacios;
    }
    public void buscarContacto(String nombre){
        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].getNombre() != null &&
                    contactos[i].getNombre().trim().equalsIgnoreCase(nombre.trim())){
                System.out.println("\nContacto encontrado, su telefono es: " + contactos[i].getNumero());
                encontrado = true;
            }

        }
        if(!encontrado){
            System.out.println("\nNo se ah encontrado el contacto");
        }
    }
    //Creamos un metodo para eliminar contacto
    public void eliminarContacto(Contacto contacto){
        boolean eliminado = false;
        for (int i = 0; i < contactos.length && !eliminado; i++) {
            if(contactos[i] != null && contactos[i].equals(contacto)){
                contactos[i] = null;
                eliminado = true;
            }
        }
        if(eliminado == true){
            System.out.println("\nEl contacto se ah eliminado");
        }else{
            System.out.println("\nEl contacto no se ah eliminado");
        }
    }
}