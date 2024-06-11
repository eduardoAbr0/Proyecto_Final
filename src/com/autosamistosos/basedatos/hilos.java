package com.autosamistosos.basedatos;

import com.autosamistosos.basedatos.controlador.DAO;
import com.autosamistosos.basedatos.controlador.DAOAutomovilImpl;
import com.autosamistosos.basedatos.controlador.DAOClienteImpl;
import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.modelo.Automovil;
import com.autosamistosos.basedatos.modelo.Cliente;
import com.autosamistosos.basedatos.modelo.Empleado;

public class hilos extends Thread {

    String operacion;
    Object objeto;
    int id;
    DAOAutomovilImpl daoAutomovil = new DAOAutomovilImpl();
    DAOClienteImpl daoCliente = new DAOClienteImpl();
    DAOEmpleadoImpl daoEmpleado = new DAOEmpleadoImpl();

    public hilos(String operacion) {
        this.operacion = operacion;
        this.objeto = objeto;
    }

    @Override
    public void run() {
        switch (operacion){
            case "insertarAutomovil":
                daoAutomovil.insertar((Automovil) objeto);
                break;
            case "eliminarAutomovil":
                daoAutomovil.eliminar(id);
                break;
            case "cambiarAutomovil":
                daoAutomovil.actualizar((Automovil) objeto);
                break;
            case "consultarAutomovil":
                objeto = daoAutomovil.buscar(id);
                break;
            case "consultarTAutomovil":
                objeto = daoAutomovil.buscarTodos();
                break;
            case "insertarCliente":
                daoCliente.insertar((Cliente) objeto);
                break;
            case "eliminarCliente":
                daoCliente.eliminar(id);
                break;
            case "cambiarCliente":
                daoCliente.actualizar((Cliente) objeto);
                break;
            case "consultarCliente":
                objeto = daoCliente.buscar(id);
                break;
            case "consultarTCliente":
                objeto = daoCliente.buscarTodos();
                break;
            case "insertarEmpleado":
                daoEmpleado.insertar((Empleado) objeto);
                break;
            case "eliminarEmpleado":
                daoEmpleado.eliminar(id);
                break;
            case "cambiarEmpleado":
                daoEmpleado.actualizar((Empleado) objeto);
                break;
            case "consultarEmpleado":
                objeto = daoEmpleado.buscar(id);
                break;
            case "consultarTEmpleado":
                objeto = daoEmpleado.buscarTodos();
                break;
        }
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public void setId(int id) {
        this.id = id;
    }
}