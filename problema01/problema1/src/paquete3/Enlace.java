package paquete3;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;   // METODO ESTATICO
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import paquete2.Trabajador;

public class Enlace {

    private Connection conn;
    private ArrayList<Trabajador> listaT;

    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:bd/base01.db";
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertarTrabajador(Trabajador trabajador) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(""
                    + "INSERT INTO Trabajador ("
                    + "cedula, "
                    + "nombres, "
                    + "correo,"
                    + "sueldo , "
                    + "mesSueldo) "
                    + "values ("
                    + "'%s', '%s', '%s', '%.2f', '%d')",
                    trabajador.obtenerCedula(),
                    trabajador.obtenerNombres(),
                    trabajador.obtenerCorreo(),
                    trabajador.obtenerSueldo(),
                    trabajador.obtenerMesSueldo());
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarTrabajador1");
            System.out.println(e.getMessage());

        }
    }

    public void establecerListaTrabajador() {
        listaT = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from Trabajador;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Trabajador trabajador = new Trabajador(
                        rs.getString("cedula"),
                        rs.getString("nombres"),
                        rs.getString("correo"),
                        rs.getDouble("sueldo"),
                        rs.getInt("mesSueldo")
                );
                listaT.add(trabajador);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarTrbajador2");
            System.out.println(e.getMessage());

        }

    }

    public ArrayList<Trabajador> obtenerLista() {
        return listaT;
    }

    public Connection obtenerConexion() {
        return conn;
    }
}
