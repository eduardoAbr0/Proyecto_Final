package com.autosamistosos.interfaces.subpaneles.ventasABCC;

import com.autosamistosos.basedatos.modelo.Factura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class altasVentas extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9;
    JComboBox combo1;
    JButton btnAgregar, btnLimpiar;
    Factura factura;
    //DAOClienteImpl daoCliente = new DAOClienteImpl();

    public altasVentas(){
        super("Altas ventas", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        JLabel txID = new JLabel("ID Venta: ");
        agregarComp(txID,0,0,1,1,1,1);
        add(txID, gbc);
        txtID = new JTextField(10);
        agregarComp(txtID,1,0,1,1,1,1);
        add(txtID, gbc);

        JLabel tx1 = new JLabel("Fecha venta: ");
        agregarComp(tx1,0,1,1,1,1,1);
        add(tx1, gbc);
        txt1 = new JTextField(10);
        agregarComp(txt1,1,1,1,1,1,1);
        add(txt1, gbc);

        JLabel tx2 = new JLabel("Adiciones: ");
        agregarComp(tx2,0,2,1,1,1,1);
        add(tx2, gbc);
        combo1 = new JComboBox();
        combo1.addItem("Adornos");
        combo1.addItem("Sistema alarma");
        combo1.addItem("Sistema audio");
        agregarComp(combo1,1,2,1,1,1,1);
        add(combo1, gbc);

        JLabel tx3 = new JLabel("Tipo pago: ");
        agregarComp(tx3,0,3,1,1,1,1);
        add(tx3, gbc);
        txt3 = new JTextField(10);
        agregarComp(txt3,1,3,1,1,1,1);
        add(txt3, gbc);

        JLabel tx4 = new JLabel("RFC Cliente: ");
        agregarComp(tx4,0,4,1,1,1,1);
        add(tx4, gbc);
        txt4 = new JTextField(10);
        agregarComp(txt4,1,4,1,1,1,1);
        add(txt4, gbc);

        JLabel tx5 = new JLabel("Telefono cliente: ");
        agregarComp(tx5,0,5,1,1,1,1);
        add(tx5, gbc);
        txt5 = new JTextField(10);
        agregarComp(txt5,1,5,1,1,1,1);
        add(txt5, gbc);

        JLabel tx6 = new JLabel("Auto: ");
        agregarComp(tx6,0,6,1,1,1,1);
        add(tx6, gbc);
        txt6 = new JTextField(10);
        agregarComp(txt6,1,6,1,1,1,1);
        add(txt6, gbc);

        JLabel tx7 = new JLabel("Cliente: ");
        agregarComp(tx7,0,7,1,1,1,1);
        add(tx7, gbc);
        txt7 = new JTextField(10);
        agregarComp(txt7,1,7,1,1,1,1);
        add(txt7, gbc);

        JLabel tx8 = new JLabel("Empleado: ");
        agregarComp(tx8,0,8,1,1,1,1);
        add(tx8, gbc);
        txt8 = new JTextField(10);
        agregarComp(txt8,1,8,1,1,1,1);
        add(txt8, gbc);

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            /*
                factura = new Factura(
                        Integer.parseInt(txtID.getText()),
                        Double.parseDouble(txt1.getText()),
                        combo1.getSelectedItem(),
                        txt3.getText(),
                        txt4.getText(),
                        Integer.parseInt(txt8.getText()),
                        Integer.parseInt(txt7.getText()),
                        Integer.parseInt(txt9.getText()));
                */
            }

        });
        agregarComp(btnAgregar,0,10,1,1,1,1);
        add(btnAgregar, gbc);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        agregarComp(btnLimpiar,1,10,1,1,1,1);
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
