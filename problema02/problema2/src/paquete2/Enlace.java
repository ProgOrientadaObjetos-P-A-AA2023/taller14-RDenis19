package paquete2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;   // METODO ESTATICO
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import paquete3.Estudiante;

public class Enlace {

    private Connection conn;
    private ArrayList<Estudiante> listaE;

    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:bd/base001.base";
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertarEstudiante(Estudiante estudiante) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "INSERT INTO estudiante ("
                    + "nombre, "
                    + "apellido,"
                    + "calificacion1, "
                    + "calificacion2, "
                    + "calificacion3) "
                    + "VALUES ('%s', '%s', %s, %s, %s)",
                    estudiante.obtenerNombre(),
                    estudiante.obtenerApellido(),
                    estudiante.obtenerCalificacion1(),
                    estudiante.obtenerCalificacion2(),
                    estudiante.obtenerCalificacion3());

            statement.executeUpdate(data);
            obtenerConexion().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void establecerLista() {
        listaE = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "SELECT * FROM estudiante;";
            ResultSet rs = statement.executeQuery(data);

            while (rs.next()) {
                Estudiante estudiante = new Estudiante(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDouble("calificacion1"),
                        rs.getDouble("calificacion2"),
                        rs.getDouble("calificacion3"));
                estudiante.establecerPromedio();
                listaE.add(estudiante);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    public ArrayList<Estudiante> obtenerLista() {
        return listaE;
    }

    public Connection obtenerConexion() {
        return conn;
    }
}
