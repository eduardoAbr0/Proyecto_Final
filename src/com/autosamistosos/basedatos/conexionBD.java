package com.autosamistosos.basedatos;
import java.sql.*;

public class conexionBD {
    private static conexionBD instancia;
    protected Connection conexion;

    private conexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/proyectobd";
            conexion = DriverManager.getConnection(URL, "root", "pizza");
            //System.out.println("Conexion exitosa con BD");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en el DRIVER");
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Error en la URL");
        }
    }
    public static conexionBD getInstancia(){
        if(instancia == null){
            instancia = new conexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void desconectar(){
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión.");
            }
        }

    }


}
