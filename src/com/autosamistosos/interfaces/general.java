package com.autosamistosos.interfaces;

import com.autosamistosos.interfaces.personalizacion.interfaz;
import com.autosamistosos.interfaces.subpaneles.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class general extends JFrame {
    BorderLayout bl = new BorderLayout();
    CardLayout cl = new CardLayout();
    JPanel barraArriba, general, opciones;
    JButton btnInicio, btnClientes, btnAutos, btnEmpleados, btnFacturas, btnVentas, btnReportes, btnEncuestas, btnLicencias;

    public general() {
        //CONFIGURACIONES INICIALES DEL JFRAME
        getContentPane().setLayout(bl);
        setTitle("AutosAmistosos");
        setMinimumSize(new Dimension(1300, 700));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CREACION PANELES GENERALES PARA LA PARTE SUPERIOR, CENTRO E IZQUIERDA
        barraArriba = new JPanel();

        //USO DE CARD LAYOUT PARA ACCEDER LOS DIFERENTES SUBPANELES EN EL MISMO AREA(CENTER)
        general = new JPanel(cl);
        opciones = new JPanel();
        //CREACION DE SUBPANELES PARA LA PARTE CENTRAL DEL PANEL GENERAL
        panelInicio pnlInicio = new panelInicio();
        panelAutos pnlAuto = new panelAutos();
        panelClientes pnlClientes = new panelClientes();
        panelEmpleados pnlEmpleados = new panelEmpleados();
        panelFacturas pnlFacturas = new panelFacturas();
        panelVentas pnlVentas = new panelVentas();
        panelReportes pnlReportes = new panelReportes();
        panelEncuestas pnlEncuestas = new panelEncuestas();
        panelLicencias pnlLicencias = new panelLicencias();

        general.add(pnlInicio, "INICIO");
        general.add(pnlAuto,"AUTOS");
        general.add(pnlClientes,"CLIENTES");
        general.add(pnlEmpleados,"EMPLEADOS");
        general.add(pnlVentas,"VENTAS");
        general.add(pnlFacturas,"FACTURAS");
        general.add(pnlReportes,"REPORTES");
        general.add(pnlEncuestas,"ENCUESTAS");
        general.add(pnlLicencias,"LICENCIAS");

        //PERSONALIZACION BASICA DE COLORES PARA IDENTIFICAR
        barraArriba.setBackground(Color.BLACK);
        general.setBackground(Color.DARK_GRAY);
        opciones.setBackground(Color.WHITE);

        //CONFIGURACION TAMANOS Y ESPECIFICACIONES PARA LAYOUT EN EL PANEL
        barraArriba.setPreferredSize(new Dimension(0, 200));
        opciones.setPreferredSize(new Dimension(200, 0));
        opciones.setLayout(new GridLayout(9, 0));

        //CREACION Y CONFIGURACION DE BOTONES DE LA PARTE IZQUIERDA, QUE SERAN
        //DE USO PARA ACCEDER A LOS DIFERENTES SUBPANELES
        btnInicio = new JButton("Inicio");
        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "INICIO");
            }
        });
        opciones.add(btnInicio);
        btnAutos = new JButton("Autos");
        btnAutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "AUTOS");
            }
        });
        opciones.add(btnAutos);
        btnClientes = new JButton("Clientes");
        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "CLIENTES");
            }
        });
        opciones.add(btnClientes);
        btnEmpleados = new JButton("Empleados");
        btnEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "EMPLEADOS");
            }
        });
        opciones.add(btnEmpleados);
        btnFacturas = new JButton("Facturas");
        btnFacturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "FACTURAS");
            }
        });
        opciones.add(btnFacturas);
        btnVentas = new JButton("Ventas");
        btnVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "VENTAS");
            }
        });
        opciones.add(btnVentas);
        btnReportes = new JButton("Reportes");
        btnReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "REPORTES");
            }
        });
        opciones.add(btnReportes);
        btnEncuestas = new JButton("Encuestas");
        btnEncuestas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "ENCUESTAS");
            }
        });
        opciones.add(btnEncuestas);
        btnLicencias = new JButton("Licencias");
        btnLicencias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(general, "LICENCIAS");
            }
        });
        opciones.add(btnLicencias);

        //SE AGREGAN LOS PANELES PARA LA PARTE SUPERIOR , CENTRAL E IZQUIERDA DEL BORDER LAYOUT
        add(barraArriba, BorderLayout.NORTH);
        add(general, BorderLayout.CENTER);
        add(opciones, BorderLayout.WEST);

        //Personalizacion de los botones
        for (Component c : opciones.getComponents()){
            if(c instanceof JButton){
                interfaz.estiloBoton((JButton) c);
            }
        }

        //DEMAS CONFIGURACIONES DEL JFRAME
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);

        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new general();
            }
        });
    }
}
