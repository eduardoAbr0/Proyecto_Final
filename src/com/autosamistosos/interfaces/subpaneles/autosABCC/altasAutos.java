package com.autosamistosos.interfaces.subpaneles.autosABCC;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class altasAutos extends JFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtModelo, txtPrecio, txtPeso, txtColor, txtCapacidadL;
    JButton btnAgregar, btnLimpiar;
    JComboBox cbCilinrdos;

    JFormattedTextField txtFechaFab;
    public altasAutos(){
        getContentPane().setLayout(gbl);
        setTitle("Altas autos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel txID = new JLabel("ID Auto: ");
        agregarComp(txID,0,0,1,1,1,1);
        add(txID, gbc);
        txtID = new JTextField(10);
        agregarComp(txtID,1,0,1,1,1,1);
        add(txtID, gbc);

        JLabel txModelo = new JLabel("Modelo: ");
        agregarComp(txModelo,0,1,1,1,1,1);
        add(txModelo, gbc);
        txtModelo = new JTextField(10);
        agregarComp(txtModelo,1,1,1,1,1,1);
        add(txtModelo, gbc);

        JLabel txPrecio = new JLabel("Precio: ");
        agregarComp(txPrecio,0,2,1,1,1,1);
        add(txPrecio, gbc);
        txtPrecio = new JTextField(10);
        agregarComp(txtPrecio,1,2,1,1,1,1);
        add(txtPrecio, gbc);


        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(editor);
        agregarComp(dateSpinner,1,3,1,1,1,1);
        add(dateSpinner, gbc);

        JLabel txFechaFab = new JLabel("Fecha Fabricación: ");
        agregarComp(txFechaFab,0,3,1,1,1,1);
        add(txFechaFab, gbc);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        txtFechaFab = new JFormattedTextField(df);

        //add(txtFechaFab, gbc);

        JLabel txPeso = new JLabel("Peso: ");
        agregarComp(txPeso,0,4,1,1,1,1);
        add(txPeso, gbc);
        txtPeso = new JTextField(10);
        agregarComp(txtPeso,1,4,1,1,1,1);
        add(txtPeso, gbc);

        JLabel txColor = new JLabel("Color: ");
        agregarComp(txColor,0,5,1,1,1,1);
        add(txColor, gbc);
        txtColor = new JTextField(10);
        agregarComp(txtColor,1,5,1,1,1,1);
        add(txtColor, gbc);

        JLabel txCapacidadL = new JLabel("Capacidad en litros: ");
        agregarComp(txCapacidadL,0,6,1,1,1,1);
        add(txCapacidadL, gbc);
        txtCapacidadL = new JTextField(10);
        agregarComp(txtCapacidadL,1,6,1,1,1,1);
        add(txtCapacidadL, gbc);

        JLabel txCilindros = new JLabel("Cilindros: ");
        agregarComp(txCilindros,0,7,1,1,1,1);
        add(txCilindros, gbc);
        cbCilinrdos = new JComboBox();
        cbCilinrdos.addItem("2");
        cbCilinrdos.addItem("4");
        cbCilinrdos.addItem("6");
        cbCilinrdos.addItem("12");
        cbCilinrdos.addItem("16");
        agregarComp(cbCilinrdos,1,7,1,1,1,1);
        add(cbCilinrdos, gbc);

        btnAgregar = new JButton("Agregar");
        agregarComp(btnAgregar,0,8,1,1,1,1);
        add(btnAgregar, gbc);

        btnLimpiar = new JButton("Limpiar");
        agregarComp(btnLimpiar,1,8,1,1,1,1);
        add(btnLimpiar, gbc);


        setVisible(true);
    }

    public void agregarComp(JComponent c, int x, int y, int alt, int anch, int pesox, int pesoy){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anch;
        gbc.gridheight = alt;
        gbc.weightx = pesox;
        gbc.weighty = pesoy;

        gbl.setConstraints(c,gbc);
    }

    public static void main(String[] args) {
        new altasAutos();
    }
}
