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

                    //Verifico que no hayan números en el nombre
                    if (nombre.matches(".*\\d+.*")) {
                        System.out.println("El dato contiene números");
                        break;
                    }
                    //Verifico que no hayan letras en la cedula
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
                    String cd = intro.next();
                    boolean eliminado = false;

                    for (int i = 0; i < listaClientes.size(); i++) {

                        if (listaClientes.get(i).getCedula() == cd) {
                            listaClientes.remove(i);
                            eliminado = true;
                        }
                    }
                    if (eliminado = true) {
                        System.out.println("Cliente eliminado, quedan " + listaClientes.size() + " clientes");
                    } else {
                        System.out.println("Error al eliminar usuario");
                    }

                    break;

                case 3:
                    System.out.println("Ingrese la cedula del cliente a buscar: ");

                    boolean encontrado = false;
                    cd = intro.next();
                    for (Cliente listaCliente : listaClientes) {
                        if (listaCliente.getCedula().equals(cd)) {
                            System.out.println("El cliente es " + listaCliente.getNombre() + " con cédula " + listaCliente.getCedula());
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("El usuario no fue encontrado.");
                    }

                    break;
                case 4:
                    System.out.println("Hasta pronto!");
                    break;

                default:
                    System.out.println("Ingrese número valido");

            }
            System.out.println("###############################");
            System.out.println("Lista de clientes actual: ");
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i) == null) {
                    System.out.println("No hay clientes");
                } else {
                    System.out.println(listaClientes.get(i).getNombre() + " con cédula " + listaClientes.get(i).getCedula());
                }
            }
            System.out.println("###############################");
        }

    }

}
