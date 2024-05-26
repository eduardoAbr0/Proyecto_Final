package com.autosamistosos.basedatos;
import java.sql.*;

public class conexionBD {

    static String x;
    protected Connection conexion;
    private ResultSet resultSet;

    public conexionBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/autosamistososp";
            conexion = DriverManager.getConnection(URL, "root", "pizza");
            System.out.println("Conexion exitosa con BD");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en el DRIVER");
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en la URL");
        }
    }
    public static void main(String[] args) {
        new conexionBD();
    }

}
