package com.autosamistosos.interfaces;

import javax.swing.*;
import java.awt.*;

public class general extends JFrame{
    BorderLayout bl = new BorderLayout();
    JPanel barraArriba, general, opciones;
    JButton btnInicio, btnClientes, btnAutos, btnEmpleados, btnFacturas, btnVentas;

    public general(){
        getContentPane().setLayout(bl);
        setTitle("AutosAmistosos");
        setMinimumSize(new Dimension(1000, 700));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barraArriba = new JPanel();
        general = new JPanel();
        opciones = new JPanel();

        barraArriba.setBackground(Color.CYAN);
        general.setBackground(Color.BLACK);
        opciones.setBackground(Color.GREEN);

        barraArriba.setPreferredSize(new Dimension(0,200));
        //barraArriba.setMinimumSize(new Dimension(0,50));

        opciones.setPreferredSize(new Dimension(200,0));
        opciones.setLayout(new GridLayout(6,0));

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


        //opciones.setMinimumSize(new Dimension(25,0));

        add(barraArriba, BorderLayout.NORTH);
        add(general, BorderLayout.CENTER);
        add(opciones, BorderLayout.WEST);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
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
