package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;
import com.autosamistosos.basedatos.modelo.Automovil;
import com.autosamistosos.basedatos.modelo.Cliente;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOClienteImpl implements clienteDAO{
    @Override
    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes(ID_Cliente,Correo,Nombre,EMPLEADOS_ID_Empleado) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement =conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getIdCliente());
            preparedStatement.setString(2, cliente.getCorreo());
            preparedStatement.setString(3, cliente.getNombre());
            preparedStatement.setInt(4, cliente.getIdEmpleado());

            if (preparedStatement.executeUpdate() >= 1){
                JOptionPane.showMessageDialog(null,"Se ha agregado el Cliente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    @Override
    public void actualizar(Cliente cliente)  {
        String sql = "UPDATE clientes SET Nombre = ?, Correo = ?, Primer_apellido = ?, Segundo_apellido = ?, Numero_Casa = ?, Calle = ?, Colonia = ?, CP = ?, RFC = ?, Telefono = ?, EMPLEADOS_ID_Empleado WHERE ID_Cliente = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getCorreo());
            preparedStatement.setString(3, cliente.getpApellido());
            preparedStatement.setString(4, cliente.getsApellido());
            preparedStatement.setInt(5, cliente.getNumeroCasa());
            preparedStatement.setString(6, cliente.getCalle());
            preparedStatement.setString(7, cliente.getColonia());
            preparedStatement.setInt(8, cliente.getCp());
            preparedStatement.setString(9, cliente.getRFC());
            preparedStatement.setInt(10, cliente.getTelefono());
            preparedStatement.setInt(11, cliente.getIdCliente());

            if( preparedStatement.executeUpdate() >= 1 ){
                JOptionPane.showMessageDialog(null,"Se ha actualizado el Cliente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    @Override
    public void eliminar(Integer id)  {
        String sql = "DELETE FROM clientes WHERE ID_Cliente = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if( preparedStatement.executeUpdate() >= 1 )
                JOptionPane.showMessageDialog(null, "Se ha eliminado el Cliente.", "Cliente Eliminado", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public Cliente convertir(ResultSet rs, int id) throws SQLException {
        Cliente cliente = null;
        String nombre = rs.getString("Nombre");
        String correo = rs.getString("Correo");
        String apellido = rs.getString("Primer_ap");
        String sapellido = rs.getString("Segundo_ap");
        int numeroCasa = rs.getInt("Numero_casa");
        String calle = rs.getString("Calle");
        String colonia = rs.getString("Colonia");
        int cp = rs.getInt("CP");
        String rfc = rs.getString("RFC");
        int telefono = rs.getInt("Telefono");
        int idEmpleado = rs.getInt("EMPLEADOS_ID_Empleado");

        cliente = new Cliente(id, correo,nombre, idEmpleado);
        cliente.setpApellido(apellido);
        cliente.setsApellido(sapellido);
        cliente.setNumeroCasa(numeroCasa);
        cliente.setCalle(calle);
        cliente.setColonia(colonia);
        cliente.setCp(cp);
        cliente.setRFC(rfc);
        cliente.setTelefono(telefono);

        return cliente;
    }

    @Override
    public Cliente buscar(Integer id)  {
        String sql = "SELECT * FROM clientes WHERE ID_Cliente = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Cliente cliente = null;
        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cliente = convertir(resultSet, id);
            }else {
                JOptionPane.showMessageDialog(null, "No se encontro el Cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Error SQL", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> buscarTodos()  {
        String sql = "SELECT * FROM clientes";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                clientes.add(convertir(resultSet, id));
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

        return clientes;
    }
}
