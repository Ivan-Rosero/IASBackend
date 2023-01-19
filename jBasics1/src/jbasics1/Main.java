package jbasics1;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner intro = new Scanner(System.in);

        Cliente[] listaClientes = new Cliente[4];

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
                    
                    try {
                    if (listaClientes.length > 10) {
                        throw new Exception();
                    }
                    System.out.println("Ingrese nombre del cliente: ");

                    intro.nextLine();
                    String nombre = intro.nextLine();

                    System.out.println("Ingrese cédula del cliente: ");
                    int cedula = intro.nextInt();

                    //Creo nuevo objeto
                    listaClientes = Arrays.copyOf(listaClientes, listaClientes.length + 1);
                    listaClientes[listaClientes.length - 1] = new Cliente(nombre, cedula);
                    System.out.println("Cliente agregado correctamente");
                } catch (Exception e) {
                    System.out.println("El número de clientes excede la capacidad de la lista.");
                }

                break;

                case 2:
                    try {
                    System.out.println("Lista de Clientes");

                    for (int i = 0; i < listaClientes.length; i++) {
                        if (listaClientes[i] != null) {
                            System.out.println(listaClientes[i].toString());
                        }
                    }

                        System.out.println("Ingrese la posición del cliente a borrar: ");
                        int value = intro.nextInt();
                                                                
                                if(value >=0 && value <= listaClientes.length -1){
                                    for (int i = value; i < listaClientes.length; i++){
                                        listaClientes[i] = listaClientes[i+1];
                                    }
                                    if(listaClientes.length > 4){
                                        listaClientes = Arrays.copyOf(listaClientes, listaClientes.length - 1);
                                    } else {
                                        listaClientes[listaClientes.length - 1] = null;
                                    }
                                    System.out.println("Hay " + listaClientes.length + " clientes");
                                }else {
                                    throw new Exception();
                                }
                                }catch(Exception e){
                                        System.out.println("Opción no valida");
                                        }
                                break;
                    
                    

                    //for(int i = 0; i == location; i++){
                    // listaClientes[i] ;
                    //}
                    //listaClientes = ArrayUtils.remove(listaClientes, location);
                }
                System.out.println("Lista de clientes actual: ");
                for (int i = 0; i < listaClientes.length; i++) {
                    if (listaClientes[i] != null) {
                        System.out.println(listaClientes[i].toString());
                    }
                }

            }

        }

    }
