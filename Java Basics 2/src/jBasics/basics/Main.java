package jBasics.basics;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Scanner intro = new Scanner(System.in);

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        int option = 0;

        while (option != 4) {

            System.out.println("\n1. Agregar cliente");
            System.out.println("2. Borrar cliente");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Salir");
            System.out.println("\n Ingrese el número de la opción");
            option = intro.nextInt();

            switch (option) {
                case 1:

                    System.out.println("Ingrese nombre del cliente: ");

                    intro.nextLine();
                    String nombre = intro.nextLine();

                    if (nombre.matches(".*\\d+.*")) {
                        System.out.println("El dato contiene números");
                        break;
                    }

                    System.out.println("Ingrese cédula del cliente: ");
                    String cedula = intro.next();
                    if (!cedula.matches(".*\\d+.*")) {
                        System.out.println("El dato contiene letras");
                        break;
                    }
                    //Creo nuevo objeto
                    listaClientes.add(new Cliente(nombre, cedula));
                    System.out.println("Cliente agregado correctamente");

                    break;

                case 2:
                    System.out.println("Ingrese la cedula del cliente a borrar: ");
                    String location = intro.nextLine();
                    for(Cliente q : listaClientes){
                        if (q.getCedula() == location){
                            listaClientes.remove(q);
                            break;
                        }
                    }
//                    if (listaClientes.remove(location)){
//                        System.out.println("Cliente eliminado, quedan " + listaClientes.size() + " clientes");
//                    }else{
//                        System.out.println("Error al eliminar usuario");
//                    }
                    
                    

                    break;

                case 3:
                    System.out.println("Ingrese la cedula del cliente a buscar: ");

                    boolean encontrado = false;
                    location = intro.next();
                    for (Cliente listaCliente : listaClientes) {
                        if (listaCliente.getCedula().equals(location) ) {
                            System.out.println("El cliente es " + listaCliente.getNombre() + " con cédula " + listaCliente.getCedula());
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("El usuario no fue encontrado.");
                    }

            }

        }

    }

}
