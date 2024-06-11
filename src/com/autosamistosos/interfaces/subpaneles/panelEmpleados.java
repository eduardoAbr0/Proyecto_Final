package com.autosamistosos.interfaces.subpaneles;

import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.modelo.Empleado;
import com.autosamistosos.interfaces.personalizacion.interfaz;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.altasClientes;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.bajasClientes;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.cambiosClientes;
import com.autosamistosos.interfaces.subpaneles.clientesABCC.consultasClientes;
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
    JButton btnAgregar, btnEliminar, btnRestablecer, btnBuscar, btnModificar;
    JPanel panelTool;
    JDesktopPane ABCC = new JDesktopPane();

    String iconAgg = "/ComponentesG/iconAgg.png";
    String iconBuscar = "/ComponentesG/iconSearch.png";
    String iconElim = "/ComponentesG/iconEliminar.png";
    String iconCambiar = "/ComponentesG/iconModify.png";
    String imgFon = "/ComponentesG/empleadosImg.png";
    public panelEmpleados() {
        setLayout(gbl);

        ABCC = new interfaz.deskImg(imgFon);
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
        panelTool.add(btnRestablecer = new JButton("Restablecer"));
        btnRestablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABCC.removeAll();
                ABCC.repaint();
            }
        });

        agregar(0,0,1,1,0,0);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(panelTool, gbc);

        agregar(0,1,GridBagConstraints.REMAINDER,GridBagConstraints.REMAINDER,1,1);
        gbc.fill = GridBagConstraints.BOTH;
        add(ABCC,gbc);

        //Personalizacion de todos los botones
        interfaz.estiloBoton(btnAgregar, new Color(0x90EE90), new Color(0x006400), interfaz.iconoC(iconAgg,25,25));
        interfaz.estiloBoton(btnEliminar, new Color(0xFF4500), new Color(0x8B0000),interfaz.iconoC(iconElim,25,25));
        interfaz.estiloBoton(btnBuscar, new Color(0xFFD700), new Color(0xFF8C00),interfaz.iconoC(iconBuscar,25,25));
        interfaz.estiloBoton(btnModificar, new Color(0x1E90FF), new Color(0x00008B),interfaz.iconoC(iconCambiar,25,25));
        interfaz.estiloBoton(btnRestablecer);

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