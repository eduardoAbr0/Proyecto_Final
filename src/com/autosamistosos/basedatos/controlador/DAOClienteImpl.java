package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;
import com.autosamistosos.basedatos.modelo.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAOClienteImpl extends conexionBD implements clienteDAO{
    @Override
    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes VALUES(?,?,?,?,?,?,?,?,?,?)";
        String sqlR = "INSERT INTO relaciones_clientes VALUES(?,?)";
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementR = null;

        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getIdCliente());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getpApellido());
            preparedStatement.setString(4, cliente.getsApellido());
            preparedStatement.setInt(5, cliente.getNumeroCasa());
            preparedStatement.setString(6, cliente.getCalle());
            preparedStatement.setString(7, cliente.getColonia());
            preparedStatement.setInt(8, cliente.getCp());
            preparedStatement.setString(9, cliente.getRFC());
            preparedStatement.setString(10, cliente.getTelefono());
            if (preparedStatement.executeUpdate() >= 1){
                System.out.printf("Se ha agregado el Cliente.");

                preparedStatementR = conexion.prepareStatement(sqlR);
                preparedStatementR.setInt(1, cliente.getIdCliente());
                preparedStatementR.setInt(2, cliente.getIdEmpleado());
                if(preparedStatementR.executeUpdate()>=1)
                System.out.printf("Se agrego la relacion cliente-empleado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en instruccion SQL");
        } finally {
            try {
                if (preparedStatement != null || preparedStatementR != null) {
                    preparedStatement.close();
                    preparedStatementR.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en instruccion SQL");
            }

        }
    }

    @Override
    public void actualizar(Cliente cliente) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {

    }

    @Override
    public Cliente buscar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() throws SQLException {
        return List.of();
    }
}
