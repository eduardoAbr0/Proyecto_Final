package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;
import com.autosamistosos.basedatos.modelo.Automovil;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public void actualizar(Automovil automovil) {
        String sql = "UPDATE automoviles SET Modelo = ?, Precio = ?, Fecha_fabricacion = ?, Pais_fabricacion = ?, Estado_fabricacion = ?, Peso = ?, Cilindros = ?, Color = ?, Capacidad = ?, Estado = ?, Seguro = ?, Kilometros = ?,Garantia = ? WHERE ID_Vehiculo = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, automovil.getModeloA());
            preparedStatement.setDouble(2, automovil.getPrecioAutomovil());
            preparedStatement.setString(3, automovil.getFechaFab());
            preparedStatement.setString(4, automovil.getPaisFab());
            preparedStatement.setString(5, automovil.getEstadoFab());
            preparedStatement.setInt(6, automovil.getPesoAutomovil());
            preparedStatement.setInt(7, automovil.getCilindroAutomovil());
            preparedStatement.setString(8, automovil.getColor());
            preparedStatement.setInt(9, automovil.getCapacidad());
            preparedStatement.setString(10, automovil.getEstado());
            preparedStatement.setString(11, automovil.getSeguro());
            preparedStatement.setDouble(12, automovil.getKmAutomovil());
            preparedStatement.setString(13,automovil.getGarantiaAutomovil());
            preparedStatement.setInt(14, automovil.getIdAutomovil());

            if( preparedStatement.executeUpdate() >= 1 )
                JOptionPane.showMessageDialog(null, "Se cambio con exito automovil.","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar automovil.","Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    @Override
    public void eliminar(Integer id) {
        String sql = "DELETE FROM automoviles WHERE ID_Vehiculo = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if( preparedStatement.executeUpdate() >= 1 )
                JOptionPane.showMessageDialog(null, "Automovil eliminado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL","Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public Automovil convertir(ResultSet rs, int id) throws SQLException {
        Automovil automovil = null;
        String modeloA = rs.getString("Modelo");
        Double precioAutomovil = rs.getDouble("Precio");
        String fechaFab = rs.getString("Fecha_fabricacion");
        String paisFab = rs.getString("Pais_Fabricacion");
        String estadoFab = rs.getString("Estado_fabricacion");
        int pesoAutomovil = rs.getInt("Peso");
        int cilindroAutomovil = rs.getInt("Cilindros");
        String color = rs.getString("Color");
        int capacidad = rs.getInt("Capacidad");
        String estado = rs.getString("Estado");
        double km = rs.getDouble("Kilometros");
        String seguro = rs.getString("Seguro");
        String garantia = rs.getString("Garantia");

        automovil = new Automovil(id,modeloA,precioAutomovil,fechaFab,paisFab,estadoFab,pesoAutomovil,cilindroAutomovil,color,capacidad,estado);
        automovil.setKmAutomovil(km);
        automovil.setSeguro(seguro);
        automovil.setGarantiaAutomovil(garantia);

        return automovil;
    }

    @Override
    public Automovil buscar(Integer id) {
        String sql = "SELECT * FROM automoviles WHERE ID_Vehiculo = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Automovil auto = null;
        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                auto = convertir(resultSet, id);
            }else {
                JOptionPane.showMessageDialog(null, "No se encontro registro","Error",JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL","Error",JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Error SQL","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        return auto;
    }

    @Override
    public ArrayList<Automovil> buscarTodos() {
        String sql = "SELECT * FROM automoviles";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Automovil> automoviles = new ArrayList<>();
        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                automoviles.add(convertir(resultSet, id));
            }
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error SQL","Error",JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null,"Error SQL","Error",JOptionPane.ERROR_MESSAGE);
            }
        }

        return automoviles;
    }
}
