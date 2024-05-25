package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;
import com.autosamistosos.basedatos.modelo.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class empleadoDAO {
    static conexionBD conexion = new conexionBD();
    //metodos para las acciones ABCC (CRUD)

    //===================== METODOS ABCC ==============
    //Metodo de ALTAS ----------------
    public static boolean agregarEmpleado(Empleado emp){
        boolean res = false;

        String sql = "INSERT INTO empleados VALUES('"+emp.getId()+"','"+emp.getNombre()+"','"+emp.getPapellido()+"','"+emp.getSapellido()+"','"+emp.getNumeroCasa()+"','"+emp.getCalle()+"','"+emp.getColonia()+"','"+emp.getCp()+"','"+emp.getTelefono()+"','"+emp.getTipoEmpleado()+"')";
        res = conexion.ejecutarInstruccionDML(sql);
        return res;
        //return conexion.ejecutarInstruccionDML(sql);
    }

    //Metodo de BAJAS ----------------
    public static boolean eliminarEmpleado(int id){
        String sql = "DELETE FROM empleados WHERE ID_Empleado='"+id+"'";
        return conexion.ejecutarInstruccionDML(sql);
    }

    //Metodo de CAMBIOS ----------------
    public static boolean actualizarEmpleado(Empleado emp){
        String sql = "UPDATE empleados SET Nombre='"+emp.getNombre()+"', Primer_apellido='"+emp.getPapellido()+"', Segundo_apellido='"+emp.getSapellido()+"', Numero_casa='"+emp.getNumeroCasa()+"', Calle='"+emp.getCalle()+"', Colonia='"+emp.getColonia()+"', CP='"+emp.getCp()+"', Telefono='"+emp.getTelefono()+"', Tipo_empleado='"+emp.getTipoEmpleado()+"' WHERE ID_Empleado='"+emp.getId()+"'";
        return conexion.ejecutarInstruccionDML(sql);
    }

    public static ArrayList mostrarEmpleados(String filtro){
        ArrayList listaEmpleados = new ArrayList();

        String sql = "SELECT * FROM empleados";
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
                int tel = Integer.parseInt(rs.getString("Telefono"));
                String tipoe = rs.getString("Tipo_empleado");

                Empleado a = new Empleado(id, n, pa, sa, ncasa, calle, colonia, cp, tel, tipoe);
                listaEmpleados.add(a);
            }while(rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaEmpleados;
    }
    public static Empleado consultaEmpleadoId(int id) {
        Empleado emp = null;

        String sql = "SELECT * FROM empleados WHERE ID_Empleado = '"+id+"'";
        ResultSet rs = conexion.ejecutarConsultaSQL(sql);
        try {
            if (rs.next()) {
                String nombre = rs.getString("Nombre");
                String primerApellido = rs.getString("Primer_apellido");
                String segundoApellido = rs.getString("Segundo_apellido");
                int numeroCasa = rs.getInt("Numero_casa");
                String calle = rs.getString("Calle");
                String colonia = rs.getString("Colonia");
                int cp = rs.getInt("CP");
                int telefono = rs.getInt("Telefono");
                String tipoEmpleado = rs.getString("Tipo_empleado");

                emp = new Empleado(id, nombre, primerApellido, segundoApellido, numeroCasa, calle, colonia, cp, telefono, tipoEmpleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }



}//CONSTRUCTOR
