package com.autosamistosos.interfaces;
import com.autosamistosos.interfaces.subpaneles.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class general extends JFrame{
    BorderLayout bl = new BorderLayout();
    panelAutos pnlAuto = new panelAutos();
    JPanel panelAct, barraArriba, general, opciones;
    JButton btnInicio, btnClientes, btnAutos, btnEmpleados, btnFacturas, btnVentas;

    public general(){
        getContentPane().setLayout(bl);
        setTitle("AutosAmistosos");
        setMinimumSize(new Dimension(1000, 700));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //PANELES GENERALES PARA LA PARTE SUPERIOR, CENTRO E IZQUIERDA
        barraArriba = new JPanel();
        general = new JPanel();
        opciones = new JPanel();

        barraArriba.setBackground(Color.CYAN);
        general.setBackground(Color.BLACK);
        opciones.setBackground(Color.GREEN);

        //CONFIGURACION TAMANOS Y ESPECIFICACIONES PARA LAYOUT EN EL PANEL
        barraArriba.setPreferredSize(new Dimension(0,200));
        opciones.setPreferredSize(new Dimension(200,0));
        opciones.setLayout(new GridLayout(6,0));

        panelAct = general;
        btnInicio = new JButton("Inicio");
        opciones.add(btnInicio);
        btnAutos = new JButton("Autos");
        opciones.add(btnAutos);
        btnClientes = new JButton("Clientes");
        opciones.add(btnClientes);
        btnEmpleados = new JButton("Empleados");
        opciones.add(btnEmpleados);
        btnFacturas = new JButton("Facturas");
        opciones.add(btnFacturas);
        btnVentas = new JButton("Ventas");
        opciones.add(btnVentas);

        add(barraArriba, BorderLayout.NORTH);
        add(general, BorderLayout.CENTER);
        add(opciones, BorderLayout.WEST);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }


    public void desactivarActPanel(JComponent desc, JComponent act){
        desc.setVisible(false);
        add(act, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new general();
            }
        });
    }
}
