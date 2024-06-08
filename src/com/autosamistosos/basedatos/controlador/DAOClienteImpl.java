package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;
import com.autosamistosos.basedatos.modelo.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClienteImpl implements clienteDAO{
    @Override
    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes VALUES(?,?,?,?,?,?,?,?,?,?)";
        String sqlR = "INSERT INTO relaciones_clientes VALUES(?,?)";
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementR = null;

        try {
            preparedStatement =conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getIdCliente());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getpApellido());
            preparedStatement.setString(4, cliente.getsApellido());
            preparedStatement.setInt(5, cliente.getNumeroCasa());
            preparedStatement.setString(6, cliente.getCalle());
            preparedStatement.setString(7, cliente.getColonia());
            preparedStatement.setInt(8, cliente.getCp());
            preparedStatement.setString(9, cliente.getRFC());
            preparedStatement.setInt(10, cliente.getTelefono());
            if (preparedStatement.executeUpdate() >= 1){
                System.out.printf("Se ha agregado el Cliente.");

                preparedStatementR = conexionBD.getInstancia().getConexion().prepareStatement(sqlR);
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
    public void actualizar(Cliente cliente)  {
        String sql = "UPDATE clientes SET Nombre = ?, Primer_apellido = ?, Segundo_apellido = ?, Numero_Casa = ?, Calle = ?, Colonia = ?, CP = ?, RFC_Cliente = ?, Telefono_Cliente = ? WHERE ID_Cliente = ?";
        String sqlR = "UPDATE relaciones_clientes SET Empleado_ID_FK = ? WHERE ID_Cliente_FK = ?";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getpApellido());
            preparedStatement.setString(3, cliente.getsApellido());
            preparedStatement.setInt(4, cliente.getNumeroCasa());
            preparedStatement.setString(5, cliente.getCalle());
            preparedStatement.setString(6, cliente.getColonia());
            preparedStatement.setInt(7, cliente.getCp());
            preparedStatement.setString(8, cliente.getRFC());
            preparedStatement.setInt(9, cliente.getTelefono());
            preparedStatement.setInt(10, cliente.getIdCliente());


            if( preparedStatement.executeUpdate() >= 1 )
                System.out.printf("Se ha actualizado el Cliente.");

            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sqlR);
            preparedStatement.setInt(1, cliente.getIdEmpleado());
            preparedStatement.setInt(2, cliente.getIdCliente());

            if( preparedStatement.executeUpdate() >= 1 )
                System.out.printf("Se ha actualizado relacion del Cliente.");
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
    public void eliminar(Integer id)  {
        String sql = "DELETE FROM clientes WHERE ID_Cliente = ?";
        String sqlR = "DELETE FROM relaciones_clientes WHERE ID_Cliente_FK = ?";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sqlR);
            preparedStatement.setInt(1, id);

            if( preparedStatement.executeUpdate() >= 1 )
                System.out.printf("Se ha eliminado relacion del Cliente.");

            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            if( preparedStatement.executeUpdate() >= 1 )
                System.out.printf("Se ha eliminado el Cliente.");

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

    public Cliente convertir(ResultSet rs, int id) throws SQLException {
        Cliente cliente = null;
        String nombre = rs.getString("Nombre");
        String apellido = rs.getString("Primer_apellido");
        String sapellido = rs.getString("Segundo_apellido");
        int numeroCasa = rs.getInt("Numero_Casa");
        String calle = rs.getString("Calle");
        String colonia = rs.getString("Colonia");
        int cp = rs.getInt("CP");
        String rfc = rs.getString("RFC_Cliente");
        String telefono = rs.getString("Telefono_Cliente");

        //cliente = new Cliente(id, nombre,apellido,sapellido,numeroCasa,calle,colonia,cp,telefono,rfc);

        return cliente;
    }

    @Override
    public Cliente buscar(Integer id)  {
        String sql = "SELECT * FROM clientes WHERE ID_Cliente = ?";
        String sqlR = "SELECT * FROM relaciones_clientes WHERE ID_Cliente_FK = ?";
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
        return cliente;
    }

    @Override
    public ArrayList<Cliente> buscarTodos()  {
        return new ArrayList<>();
    }
}
