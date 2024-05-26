package com.autosamistosos.interfaces.subpaneles;

import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.modelo.Empleado;
import com.autosamistosos.interfaces.subpaneles.empleadosABCC.altasEmpleados;
import com.autosamistosos.interfaces.subpaneles.empleadosABCC.bajasEmpleados;
import com.autosamistosos.interfaces.subpaneles.empleadosABCC.cambiosEmpleados;
import com.autosamistosos.interfaces.subpaneles.empleadosABCC.consultasEmpleados;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class panelEmpleados extends JPanel {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JButton btnAgregar, btnEliminar, btnMostrarEmpleados, btnMostrarReportes, btnRestablecer, btnBuscar, btnReporte, btnModificar;
    JTable tbEmpleados, tbReportes;
    JPanel panelTool;
    JDesktopPane ABCC = new JDesktopPane();
    ArrayList<Empleado> listEmp;
    DefaultTableModel modelEmp = new DefaultTableModel();
    DefaultTableModel modelReportes = new DefaultTableModel();
    DAOEmpleadoImpl daoEmpleado = new DAOEmpleadoImpl();
    public panelEmpleados() {
        setLayout(gbl);

        //OPCIONES DE ABCC EN PARTE SUPERIOR
        panelTool = new JPanel();
        panelTool.setLayout(new FlowLayout());
        panelTool.add(btnAgregar = new JButton("Agregar"));
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new altasEmpleados());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnEliminar = new JButton("Eliminar"));
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new bajasEmpleados());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnModificar = new JButton("Modificar"));
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new cambiosEmpleados());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnBuscar = new JButton("Buscar"));
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new consultasEmpleados());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnReporte = new JButton("Reporte"));
        panelTool.add(btnRestablecer = new JButton("Restablecer"));

        agregar(0,0,1,1,1,1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(panelTool, gbc);

        //CONSULTA DE TODOS LOS EMPLEADOS
        btnMostrarEmpleados = new JButton("Mostrar empleados");
        btnMostrarEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listEmp = daoEmpleado.buscarTodos();

                for(Empleado emp: listEmp){
                    modelEmp.addRow(new Object[]{emp.getId(),emp.getNombre(),emp.getPapellido(),emp.getSapellido(),emp.getNumeroCasa(),emp.getCalle(),emp.getColonia(),emp.getCp(),emp.getTelefono()});
                }
                tbEmpleados.setModel(modelEmp);
            }
        });
        //TABLA PARA MOSTRAR DATOS EMPLEADOS
        String empleados[] = {"Empleado","Nombre","Primer apell","Segundo apell","Num. Casa","Calle","Colonia","CP","Telefono"};
        for (String col: empleados){
            modelEmp.addColumn(col);
        }
        tbEmpleados = new JTable(modelEmp);
        JScrollPane jsCl = new JScrollPane(tbEmpleados);



        agregar(0,3,1,1,1,1);
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnMostrarEmpleados, gbc);
        JLabel txtTablaEmpleados = new JLabel("Tabla empleados");
        agregar(0,4,1,1,1,1);
        gbc.anchor = GridBagConstraints.SOUTH;
        add(txtTablaEmpleados, gbc);

        //CONSULTA DE LOS REPORTES
        btnMostrarReportes = new JButton("Mostrar reportes");
        btnMostrarReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //TABLA PARA MOSTRAR REPORTES
        String reportes[] = {"Reporte","Mes","Comision","Empleado"};
        for (String col: reportes){
            modelReportes.addColumn(col);
        }
        tbReportes = new JTable(modelReportes);
        JScrollPane jsEnc = new JScrollPane(tbReportes);

        agregar(1,3,1,1,1,1);
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnMostrarReportes, gbc);
        JLabel txtTablaReportes = new JLabel("Tabla reportes");
        agregar(1,4,1,1,1,1);
        gbc.anchor = GridBagConstraints.SOUTH;
        add(txtTablaReportes, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        agregar(jsCl,0,5,1,1,3,1);

        gbc.fill = GridBagConstraints.BOTH;
        agregar(jsEnc,1,5,1,1,1,1);

        agregar(0,1,2,2,4,4);
        gbc.fill = GridBagConstraints.BOTH;
        add(ABCC,gbc);

    }
    public void agregar(JComponent c, int x, int y, int altura, int anchura, int wx, int wy) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anchura;
        gbc.gridheight = altura;
        gbc.weightx = wx;
        gbc.weighty = wy;

        add(c, gbc);
    }

    public void agregar( int x, int y, int altura, int anchura, int wx, int wy) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anchura;
        gbc.gridheight = altura;
        gbc.weightx = wx;
        gbc.weighty = wy;

    }


}