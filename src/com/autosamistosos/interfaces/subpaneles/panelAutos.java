package com.autosamistosos.interfaces.subpaneles;

import javax.swing.*;
import java.awt.*;

public class panelAutos extends JPanel {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JButton btnAgregar, btnEliminar, btnBorrar, btnRestablecer;
    JTable tbAutos;
    public panelAutos() {
        setLayout(gbl);

        btnAgregar = new JButton("Agregar");
        agregar(btnAgregar, 0,0,1,1,1,1);

        btnEliminar = new JButton("Eliminar");
        agregar(btnEliminar, 1,0,1,1,1,1);

        btnBorrar = new JButton("Borrar");
        agregar(btnBorrar, 2,0,1,1,1,1);

        btnRestablecer = new JButton("Restablecer");
        agregar(btnRestablecer, 3,0,1,1,1,1);

        String test [] = {"HOLA","AUTO"};
        String testt [][]= {{"HOLA", "MUNDO"},{"HOLA", "MUNDO"}};

        tbAutos = new JTable(testt,test);
        JScrollPane jsp = new JScrollPane(tbAutos);


        gbc.fill = GridBagConstraints.BOTH;
        agregar(jsp,0,1,1,4,1,1);

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
