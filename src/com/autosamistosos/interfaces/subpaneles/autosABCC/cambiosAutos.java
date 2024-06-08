package com.autosamistosos.interfaces.subpaneles.autosABCC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cambiosAutos extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtModelo, txtPrecio, txtFechaf, txtPeso, txtCilindros, txtColor, txtCapL, txtEstado, txtSeguro, txtKilometros, txtGarantia;
    JButton btnCambiar, btnLimpiar;
    //Cliente cl;
    //DAOClienteImpl daoCliente = new DAOClienteImpl();

    public cambiosAutos(){
        super("Cambios autos", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
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

        JLabel txFechaf = new JLabel("Fecha fabricacion: ");
        agregarComp(txFechaf,0,3,1,1,1,1);
        add(txFechaf, gbc);
        txtFechaf = new JTextField(10);
        agregarComp(txtFechaf,1,3,1,1,1,1);
        add(txtFechaf, gbc);

        JLabel txPeso = new JLabel("Peso: ");
        agregarComp(txPeso,0,4,1,1,1,1);
        add(txPeso, gbc);
        txtPeso = new JTextField(10);
        agregarComp(txtPeso,1,4,1,1,1,1);
        add(txtPeso, gbc);

        JLabel txCilindros = new JLabel("Cilindros: ");
        agregarComp(txCilindros,0,5,1,1,1,1);
        add(txCilindros, gbc);
        txtCilindros = new JTextField(10);
        agregarComp(txtCilindros,1,5,1,1,1,1);
        add(txtCilindros, gbc);

        JLabel txColor = new JLabel("Color: ");
        agregarComp(txColor,0,6,1,1,1,1);
        add(txColor, gbc);
        txtColor = new JTextField(10);
        agregarComp(txtColor,1,6,1,1,1,1);
        add(txtColor, gbc);

        JLabel txCapL = new JLabel("Capacidad litros: ");
        agregarComp(txCapL,0,7,1,1,1,1);
        add(txCapL, gbc);
        txtCapL = new JTextField(10);
        agregarComp(txtCapL,1,7,1,1,1,1);
        add(txtCapL, gbc);

        JLabel txEstado = new JLabel("Estado: ");
        agregarComp(txEstado,0,8,1,1,1,1);
        add(txEstado, gbc);
        txtEstado = new JTextField(10);
        agregarComp(txtEstado,1,8,1,1,1,1);
        add(txtEstado, gbc);

        JLabel txSeguro = new JLabel("Seguro: ");
        agregarComp(txSeguro,0,9,1,1,1,1);
        add(txSeguro, gbc);
        txtSeguro = new JTextField(10);
        agregarComp(txtSeguro,1,9,1,1,1,1);
        add(txtSeguro, gbc);

        JLabel txKilometros = new JLabel("Kilometros: ");
        agregarComp(txKilometros,0,10,1,1,1,1);
        add(txKilometros, gbc);
        txtKilometros = new JTextField(10);
        agregarComp(txtKilometros,1,10,1,1,1,1);
        add(txtKilometros, gbc);

        JLabel txGarantia = new JLabel("Garantia: ");
        agregarComp(txGarantia,0,11,1,1,1,1);
        add(txGarantia, gbc);
        txtGarantia = new JTextField(10);
        agregarComp(txtGarantia,1,11,1,1,1,1);
        add(txtGarantia, gbc);


        btnCambiar = new JButton("Cambiar");
        btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        agregarComp(btnCambiar,0,12,1,1,1,1);
        add(btnCambiar, gbc);

        btnLimpiar = new JButton("Limpiar");
        agregarComp(btnLimpiar,1,12,1,1,1,1);
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
}
