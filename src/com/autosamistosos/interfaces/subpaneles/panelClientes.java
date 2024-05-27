package com.autosamistosos.interfaces.subpaneles;

import com.autosamistosos.basedatos.controlador.DAOClienteImpl;
import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.modelo.Empleado;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.altasClientes;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.bajasClientes;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.cambiosClientes;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.consultasClientes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class panelClientes extends JPanel {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JButton btnAgregar, btnEliminar, btnMostrarClientes, btnMostrarEncuestas, btnRestablecer, btnBuscar, btnEncuesta, btnModificar;
    JTable tbClientes, tbEncuestas;
    JPanel panelTool;
    JDesktopPane ABCC = new JDesktopPane();
    ArrayList<Empleado> listEmp;
    DefaultTableModel modelClientes = new DefaultTableModel();
    DefaultTableModel modelEncuestas = new DefaultTableModel();
    DAOClienteImpl daoCliente = new DAOClienteImpl()            ;
    public panelClientes() {
        setLayout(gbl);

        //OPCIONES DE ABCC EN PARTE SUPERIOR
        panelTool = new JPanel();
        panelTool.setLayout(new FlowLayout());
        panelTool.add(btnAgregar = new JButton("Agregar"));
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new altasClientes());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnEliminar = new JButton("Eliminar"));
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new bajasClientes());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnModificar = new JButton("Modificar"));
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new cambiosClientes());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnBuscar = new JButton("Buscar"));
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new consultasClientes());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnEncuesta = new JButton("Encuesta"));
        panelTool.add(btnRestablecer = new JButton("Restablecer"));

        agregar(0,0,1,1,1,1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(panelTool, gbc);

        //CONSULTA DE TODOS LOS CLIENTES
        btnMostrarClientes = new JButton("Mostrar clientes");
        btnMostrarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                listEmp = daoEmpleado.buscarTodos();

                for(Empleado emp: listEmp){
                    modelClientes.addRow(new Object[]{emp.getId(),emp.getNombre(),emp.getPapellido(),emp.getSapellido(),emp.getNumeroCasa(),emp.getCalle(),emp.getColonia(),emp.getCp(),emp.getTelefono()});
                }
                tbClientes.setModel(modelClientes);

                 */
            }
        });
        //TABLA PARA MOSTRAR DATOS CLIENTES
        String clientes[] = {"Cliente","Nombre","Primer apell","Segundo apell","Num. Casa","Calle","Colonia","CP","RFC","Telefono","Vendedor"};
        for (String col: clientes){
            modelClientes.addColumn(col);
        }
        tbClientes = new JTable(modelClientes);
        JScrollPane jsCl = new JScrollPane(tbClientes);
        agregar(0,3,1,1,1,1);
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnMostrarClientes, gbc);
        JLabel txtTablaClientes = new JLabel("Tabla clientes");
        agregar(0,4,1,1,1,1);
        gbc.anchor = GridBagConstraints.SOUTH;
        add(txtTablaClientes, gbc);

        //CONSULTA DE LOS REPORTES
        btnMostrarEncuestas = new JButton("Mostrar encuestas");
        btnMostrarEncuestas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //TABLA PARA MOSTRAR ENCUESTAS
        String reportes[] = {"Encuesta","Opinion auto","Opinion vendedor","Opinion dist","Auto","Vendedor"};
        for (String col: reportes){
            modelEncuestas.addColumn(col);
        }
        tbEncuestas = new JTable(modelEncuestas);
        JScrollPane jsEnc = new JScrollPane(tbEncuestas);
        agregar(1,3,1,1,1,1);
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnMostrarEncuestas, gbc);
        JLabel txtTablaEncuestas = new JLabel("Tabla encuestas");
        agregar(1,4,1,1,1,1);
        gbc.anchor = GridBagConstraints.SOUTH;
        add(txtTablaEncuestas, gbc);

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
