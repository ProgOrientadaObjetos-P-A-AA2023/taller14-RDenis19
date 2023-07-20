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
        int mesSueldo;
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

            System.out.println("Ingrese el mes de sueldo del trabajador: ");
            mesSueldo = entrada.nextInt();

            Trabajador trabajador = new Trabajador(
                    cedula,
                    nombres,
                    correo,
                    sueldo,
                    mesSueldo);
            c.insertarTrabajador(trabajador);
            c.establecerListaTrabajador();
            entrada.nextLine();

            System.out.println("Ingrese ´SALIR´ si desea terminar el proceso");
            String op = entrada.nextLine();

            if (op.equalsIgnoreCase("Salir")) {
                bandera = false;
                for (int i = 0; i < c.obtenerLista().size(); i++) {
                    System.out.println("-----------------------------------");
                    System.out.printf("%s",
                            c.obtenerLista());
                    

                }

            }

        }

    }

}
