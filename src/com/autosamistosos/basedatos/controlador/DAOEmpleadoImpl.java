package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;
import com.autosamistosos.basedatos.modelo.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOEmpleadoImpl extends conexionBD implements empleadoDAO{
    @Override
    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO empleados VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, empleado.getId());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setString(3, empleado.getPapellido());
            preparedStatement.setString(4, empleado.getSapellido());
            preparedStatement.setInt(5, empleado.getNumeroCasa());
            preparedStatement.setString(6, empleado.getCalle());
            preparedStatement.setString(7, empleado.getColonia());
            preparedStatement.setInt(8, empleado.getCp());
            preparedStatement.setInt(9, empleado.getTelefono());
            preparedStatement.setString(10, empleado.getTipoEmpleado());

            if( preparedStatement.executeUpdate() >= 1 )
                System.out.printf("Se ha agregado el Empleado.");
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
    }

    @Override
    public void actualizar(Empleado empleado){
        String sql = "UPDATE empleados SET Nombre = ?, Primer_apellido = ?, Segundo_apellido = ?, Numero_Casa = ?, Calle = ?, Colonia = ?, CP = ?, Telefono = ?, Tipo_empleado = ? WHERE ID_Empleado = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getPapellido());
            preparedStatement.setString(3, empleado.getSapellido());
            preparedStatement.setInt(4, empleado.getNumeroCasa());
            preparedStatement.setString(5, empleado.getCalle());
            preparedStatement.setString(6, empleado.getColonia());
            preparedStatement.setInt(7, empleado.getCp());
            preparedStatement.setInt(8, empleado.getTelefono());
            preparedStatement.setString(9, empleado.getTipoEmpleado());
            preparedStatement.setInt(10, empleado.getId());

            if( preparedStatement.executeUpdate() >= 1 )
                System.out.printf("Se ha actualizado el Empleado.");
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
    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM empleados WHERE ID_Empleado = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if( preparedStatement.executeUpdate() >= 1 )
                System.out.printf("Se ha eliminado el Empleado.");
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
    }

    public Empleado convertir(ResultSet rs, int id) throws SQLException {
        Empleado empleado = null;
        String nombre = rs.getString("Nombre");
        String apellido = rs.getString("Primer_apellido");
        String sapellido = rs.getString("Segundo_apellido");
        int numeroCasa = rs.getInt("Numero_Casa");
        String calle = rs.getString("Calle");
        String colonia = rs.getString("Colonia");
        int cp = rs.getInt("CP");
        int telefono = rs.getInt("Telefono");
        String tipoEmpleado = rs.getString("Tipo_empleado");

        empleado = new Empleado(id, nombre,apellido,sapellido,numeroCasa,calle,colonia,cp,telefono,tipoEmpleado);

        return empleado;
    }

    @Override
    public Empleado buscar(Integer id)  {
        String sql = "SELECT * FROM empleados WHERE ID_Empleado = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Empleado empleado = null;
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                empleado = convertir(resultSet, id);
            }else {
                System.out.printf("No se ha encontrado registro");
            }

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
        return empleado;
    }

    @Override
    public List<Empleado> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM empleados";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            preparedStatement = conexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                empleados.add(convertir(resultSet, id));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error en instruccion SQL");
        }finally {
            try {
                if (resultSet != null){
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("Error instruccion SQL");
            }
        }

        return empleados;
    }
}
