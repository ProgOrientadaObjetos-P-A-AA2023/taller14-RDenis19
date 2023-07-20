package paquete2;

public class Trabajador {

    //cédula, nombres, correo, sueldo, mes del sueldo
    private String cedula;
    private String nombres;
    private String correo;
    private double sueldo;
    private String mesSueldo;

    public Trabajador(String c, String n, String co,
            double s, String m) {
        cedula = c;
        nombres = n;
        correo = co;
        sueldo = s;
        mesSueldo = m;
    }

    public void establecerCedula(String c) {
        cedula = c;
    }

    public void establecerNombres(String n) {
        nombres = n;
    }

    public void establecerCorreo(String c) {
        correo = c;
    }

    public void establecerSueldo(double s) {
        sueldo = s;
    }

    public void establecerMesSueldo(String m) {
        mesSueldo = m;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public String obtenerNombres() {
        return nombres;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public String obtenerMesSueldo() {
        return mesSueldo;
    }

    @Override
    public String toString() {
        String cadena = String.format(""
                + "Cedula: %s\n"
                + "Nombres: %s\n"
                + "Correo: %s\n"
                + "Sueldo: %.2f\n"
                + "Mes sueldo: %s\n",
                cedula,
                nombres,
                correo,
                sueldo,
                mesSueldo
                );
         return cadena;
    }

}
