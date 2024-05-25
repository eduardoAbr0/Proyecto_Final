package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;
import com.autosamistosos.basedatos.modelo.Empleado;

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
    public boolean eliminarEmpleado(int id){
        String sql = "DELETE FROM empleados WHERE ID_Empleado='"+id+"'";
        return conexion.ejecutarInstruccionDML(sql);
    }

    //Metodo de CAMBIOS ----------------
    public boolean actualizarEmpleado(Empleado emp){
        String sql = "UPDATE empleados SET Nombre='"+emp.getNombre()+"', Primer_Ap='X', " +
                "Segundo_Ap='X' ....... WHERE Num_Control='"+emp.getId()+"'";
        return conexion.ejecutarInstruccionDML(sql);
    }
    /*
    public ArrayList mostrarEmpleados(String filtro){
        ArrayList listaEmpleados = new ArrayList();

        String sql = "SELECT * FROM empleados";
        ResultSet rs = conexion.ejecutarConsultaSQL(sql);
        try{
            rs.next();
            do {
                int nc = Integer.parseInt(rs.getString(1));
                String curp = rs.getString("CURP");
                String n = rs.getString("Nombre");
                String pa = rs.getString("Primer_Ap");
                String sa = rs.getString("Segundo_Ap");
                String f = rs.getString("Fecha_Nac");
                byte e = rs.getByte("Edad");
                byte s = rs.getByte("Semestre");
                String c = rs.getString("Carrera");

                empleado a = new empleado(nc, n, pa, sa, e, s, c);
                listaEmpleados.add(a);
            }while(rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaEmpleados;
    }
    */

}//CONSTRUCTOR
