package paquete1;

import java.util.ArrayList;
import paquete2.Enlace;
import paquete3.Estudiante;

public class Principal {

    public static void main(String[] args) {
        Enlace e = new Enlace();
        ArrayList<Estudiante> list;

        e.establecerLista();

        System.out.println("-------------------------------------------");
        for (Estudiante estudiantes : e.obtenerLista()) {
            System.out.println(estudiantes);
            System.out.println("-------------------------------------------");

        }
    }

}
