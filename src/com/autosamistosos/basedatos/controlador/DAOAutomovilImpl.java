package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;
import com.autosamistosos.basedatos.modelo.Automovil;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAOAutomovilImpl implements automovilDAO{
    @Override
    public void insertar(Automovil automovil) {
        String sql = "INSERT INTO automoviles(ID_Vehiculo, Modelo, Precio, Fecha_fabricacion, Pais_fabricacion, Estado_fabricacion," +
                "Peso,Cilindros,Color,Capacidad,Estado) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, automovil.getIdAutomovil());
            preparedStatement.setString(2, automovil.getModeloA());
            preparedStatement.setDouble(3, automovil.getPrecioAutomovil());
            preparedStatement.setString(4, automovil.getFechaFab());
            preparedStatement.setString(5, automovil.getPaisFab());
            preparedStatement.setString(6, automovil.getEstadoFab());
            preparedStatement.setInt(7, automovil.getPesoAutomovil());
            preparedStatement.setInt(8, automovil.getCilindroAutomovil());
            preparedStatement.setString(9, automovil.getColor());
            preparedStatement.setInt(10, automovil.getCapacidad());
            preparedStatement.setString(11, automovil.getEstado());
            if (preparedStatement.executeUpdate() >= 1){
                JOptionPane.showMessageDialog(null, "Automovil agregado correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar automovil","Mensaje",JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null ) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL","Mensaje",JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    @Override
    public void actualizar(Automovil automovil) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM automoviles WHERE ID_Empleado = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
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

    @Override
    public Automovil buscar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Automovil> buscarTodos() throws SQLException {
        return List.of();
    }
}
