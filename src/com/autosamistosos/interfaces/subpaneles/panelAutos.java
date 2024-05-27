package com.autosamistosos.interfaces.subpaneles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.autosamistosos.basedatos.modelo.Empleado;
import com.autosamistosos.interfaces.subpaneles.autosABCC.altasAutos;
import com.autosamistosos.interfaces.subpaneles.autosABCC.bajasAutos;
import com.autosamistosos.interfaces.subpaneles.autosABCC.cambiosAutos;
import com.autosamistosos.interfaces.subpaneles.autosABCC.consultasAutos;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.altasClientes;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.bajasClientes;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.cambiosClientes;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.consultasClientes;

public class panelAutos extends JPanel {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JButton btnAgregar, btnEliminar, btnMostrarClientes, btnMostrarEncuestas, btnRestablecer, btnBuscar, btnEncuesta, btnModificar;
    JTable tbAutos, tbEncuestas;
    JPanel panelTool;
    JDesktopPane ABCC = new JDesktopPane();
    ArrayList<Empleado> listEmp;
    DefaultTableModel modelAutos = new DefaultTableModel();
    //DAOClienteImpl daoCliente = new DAOClienteImpl()            ;
    public panelAutos() {
        setLayout(gbl);

        //OPCIONES DE ABCC EN PARTE SUPERIOR
        panelTool = new JPanel();
        panelTool.setLayout(new FlowLayout());
        panelTool.add(btnAgregar = new JButton("Agregar"));
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new altasAutos());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnEliminar = new JButton("Eliminar"));
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new bajasAutos());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnModificar = new JButton("Modificar"));
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new cambiosAutos());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnBuscar = new JButton("Buscar"));
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.add(new consultasAutos());
                ABCC.setVisible(true);
            }
        });
        panelTool.add(btnRestablecer = new JButton("Restablecer"));

        agregar(0,0,1,1,1,1);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(panelTool, gbc);

        //CONSULTA DE TODOS LOS CLIENTES
        btnMostrarClientes = new JButton("Mostrar autos");
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
        String autos[] = {"Auto","Modelo","Precio","Fecha fab","Peso","Cilindros","Color","Capacidad","Estado","Seguro","Kilometros","Garantia"};
        for (String col: autos){
            modelAutos.addColumn(col);
        }
        tbAutos = new JTable(modelAutos);
        JScrollPane jsCl = new JScrollPane(tbAutos);
        agregar(0,3,1,1,1,1);
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnMostrarClientes, gbc);
        JLabel txtTablaAutos = new JLabel("Tabla autos");
        agregar(0,4,1,1,1,1);
        gbc.anchor = GridBagConstraints.SOUTH;
        add(txtTablaAutos, gbc);


        gbc.fill = GridBagConstraints.BOTH;
        agregar(jsCl,0,5,1,2,3,1);

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
