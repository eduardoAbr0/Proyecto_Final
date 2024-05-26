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

    /*
    //OPERACIONES ABCC
    public boolean ejecutarInstruccionDML(String instruccionSQL){
        System.out.println(instruccionSQL);
        boolean res = false;
        try {
            preparedStatement = conexion.prepareStatement(instruccionSQL);
            if( this.preparedStatement.executeUpdate() >= 1 )
                res = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en instruccion SQL");
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en instruccion SQL");
            }

        }
        return res;
    }
*/

    /*
    //CONSULTAS
    public ResultSet ejecutarConsultaSQL(String instruccionSQL){
        resultSet = null;
        try {
            preparedStatement = conexion.prepareStatement(instruccionSQL);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en instrucion SQL");
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error instruccion SQL");
            }
        }
        return resultSet;
    }
*/
    public static void main(String[] args) {
        new conexionBD();
    }

}
