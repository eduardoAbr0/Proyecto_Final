package com.autosamistosos.interfaces.subpaneles;

import javax.swing.*;
import java.awt.*;

public class panelVentas extends JPanel {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JButton btnAgregar, btnEliminar, btnBorrar, btnRestablecer, btnBuscar, btnReporte, btnModificar;
    JTextField txFBuscar, txFEncuesta, txFModificar;
    JTable tbVentas, tbReportes;
    public panelVentas() {
        setLayout(gbl);

        JLabel txtBuscar = new JLabel("Buscar una venta: ");
        agregar(txtBuscar, 0 ,0,1,1,1,1);
        txFBuscar = new JTextField(5);
        agregar(txFBuscar, 1 ,0,1,1,1,1);
        btnBuscar = new JButton("Buscar");
        agregar(btnBuscar, 2 ,0,1,1,1,1);

        btnAgregar = new JButton("Agregar");
        agregar(btnAgregar, 0,1,1,1,1,1);

        btnEliminar = new JButton("Eliminar");
        agregar(btnEliminar, 1,1,1,1,1,1);

        btnBorrar = new JButton("Borrar");
        agregar(btnBorrar, 2,1,1,1,1,1);

        btnRestablecer = new JButton("Restablecer");
        agregar(btnRestablecer, 3,1,1,1,1,1);

        btnReporte = new JButton("Generar reporte de venta:");
        agregar(btnReporte, 4,1,1,1,1,1);
        txFEncuesta = new JTextField(5);
        agregar(txFEncuesta, 4 ,2,1,1,1,1);

        btnModificar = new JButton("Modificar venta:");
        agregar(btnModificar, 4,3,1,1,1,1);
        txFModificar = new JTextField(5);
        agregar(txFModificar, 4 ,4,1,1,1,1);

        String test [] = {"HOLA","AUTO"};
        String testt [][]= {{"HOLA", "MUNDO"},{"HOLA", "MUNDO"}};

        tbVentas = new JTable(testt, test);
        JScrollPane jsCl = new JScrollPane(tbVentas);


        gbc.fill = GridBagConstraints.BOTH;
        agregar(jsCl,0,2,3,4,1,1);


    }
    public void agregar(JComponent c, int x, int y, int altura, int anchura, int wx, int wy) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anchura;
        gbc.gridheight = altura;
        gbc.weightx = 1;
        gbc.weighty = 1;

        add(c, gbc);
    }
}