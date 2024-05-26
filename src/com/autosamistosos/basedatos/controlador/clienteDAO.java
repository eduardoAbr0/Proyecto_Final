package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;
import com.autosamistosos.basedatos.modelo.Cliente;
import com.autosamistosos.basedatos.modelo.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class clienteDAO {
    /*
    static conexionBD conexion = new conexionBD();
    //metodos para las acciones ABCC (CRUD)

    //===================== METODOS ABCC ==============
    //Metodo de ALTAS ----------------
    public static boolean agregarCliente(Cliente cl){
        boolean res = false;

        String sql = "INSERT INTO clientes VALUES('"+cl.getIdCliente()+"','"+cl.getNombre()+"','"+cl.getpApellido()+"','"+cl.getsApellido()+"','"+cl.getNumeroCasa()+"','"+cl.getCalle()+"','"+cl.getColonia()+"','"+cl.getCp()+"')";
        res = conexion.ejecutarInstruccionDML(sql);
        return res;
        //return conexion.ejecutarInstruccionDML(sql);
    }

    //Metodo de BAJAS ----------------
    public static boolean eliminarCliente(int id){
        String sql = "DELETE FROM clientes WHERE ID_Cliente='"+id+"'";
        return conexion.ejecutarInstruccionDML(sql);
    }

    //Metodo de CAMBIOS ----------------
    public static boolean actualizarCliente(Cliente cl){
        String sql = "UPDATE clientes SET Nombre='"+cl.getNombre()+"', Primer_apellido='"+cl.getpApellido()+"', Segundo_apellido='"+cl.getsApellido()+"', Numero_casa='"+cl.getNumeroCasa()+"', Calle='"+cl.getCalle()+"', Colonia='"+cl.getColonia()+"', CP='"+cl.getCp()+"', RFC='"+cl.getRFC()+"', Telefono='"+cl.getTelefono()+"' WHERE ID_Cliente='"+cl.getIdCliente()+"'";
        return conexion.ejecutarInstruccionDML(sql);
    }

    public static ArrayList mostrarClientes(String filtro){
        ArrayList listaClientes = new ArrayList();

        String sql = "SELECT * FROM clientes";
        ResultSet rs = conexion.ejecutarConsultaSQL(sql);
        try{
            rs.next();
            do {
                int id = Integer.parseInt(rs.getString(1));
                String n = rs.getString("Nombre");
                String pa = rs.getString("Primer_apellido");
                String sa = rs.getString("Segundo_apellido");
                int ncasa = Integer.parseInt(rs.getString("Numero_casa"));
                String calle = rs.getString("Calle");
                String colonia = rs.getString("Colonia");
                int cp = Integer.parseInt(rs.getString("CP"));
                String rfc = rs.getString("RFC");
                int tel = Integer.parseInt(rs.getString("Telefono"));

                Cliente a = new Cliente(id, n, pa, sa, ncasa, calle, colonia, cp, tel,rfc);
                listaClientes.add(a);
            }while(rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaClientes;
    }
    public static Cliente consultaClienteId(int id) {
        Cliente cl = null;

        String sql = "SELECT * FROM clientes WHERE ID_Cliente = '"+id+"'";
        ResultSet rs = conexion.ejecutarConsultaSQL(sql);
        try {
            if (rs.next()) {
                int id1 = Integer.parseInt(rs.getString(1));
                String n = rs.getString("Nombre");
                String pa = rs.getString("Primer_apellido");
                String sa = rs.getString("Segundo_apellido");
                int ncasa = Integer.parseInt(rs.getString("Numero_casa"));
                String calle = rs.getString("Calle");
                String colonia = rs.getString("Colonia");
                int cp = Integer.parseInt(rs.getString("CP"));
                String rfc = rs.getString("RFC");
                int tel = Integer.parseInt(rs.getString("Telefono"));

                cl = new Cliente(id1, n, pa, sa, ncasa, calle, colonia, cp, tel,rfc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cl;
    }
*/


}//CONSTRUCTOR
