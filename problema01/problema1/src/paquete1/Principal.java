package paquete1;

import java.util.Scanner;
import paquete2.Trabajador;
import paquete3.Enlace;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Enlace c = new Enlace();
        String cedula;
        String nombres;
        String correo;
        double sueldo;
        String mesSueldo;
        boolean bandera = true;

        while (bandera) {
            System.out.println("Ingrese la cedula del trabajador: ");
            cedula = entrada.nextLine();
            System.out.println("Ingrese el nombre del trabajador: ");
            nombres = entrada.nextLine();

            System.out.println("Ingrese el correo del trabajador: ");
            correo = entrada.nextLine();

            System.out.println("Ingrese el sueldo del trabajador: ");
            sueldo = entrada.nextDouble();
            entrada.nextLine();

            System.out.println("Ingrese el mes de sueldo del trabajador: ");
            mesSueldo = entrada.nextLine();

            Trabajador trabajador = new Trabajador(
                    cedula,
                    nombres,
                    correo,
                    sueldo,
                    mesSueldo);
            c.insertarTrabajador(trabajador);
            c.establecerListaTrabajador();

            System.out.println("Ingrese ´SALIR´ si desea terminar el proceso");
            String op = entrada.nextLine();

            if (op.equalsIgnoreCase("Salir")) {
                bandera = false;
                System.out.println("-----------------------------------");

                for (Trabajador tra : c.obtenerLista()) {
                    System.out.println(tra);
                    System.out.println("-----------------------------------");

                }
            }

        }

    }

}
