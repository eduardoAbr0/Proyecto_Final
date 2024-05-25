package com.autosamistosos.interfaces.subpaneles.empleadosABCC;

import javax.swing.*;
import java.awt.*;

public class altasEmpleados extends JFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtNombre, txtPrimerA, txtSegundoA, txtNumeroCasa, txtCalle, txtColonia, txtCP, txtTelefono;
    JButton btnAgregar, btnLimpiar;
    JComboBox cbTipoE;

    public altasEmpleados(){
        getContentPane().setLayout(gbl);
        setTitle("Altas empleados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel txID = new JLabel("ID Empleado: ");
        agregarComp(txID,0,0,1,1,1,1);
        add(txID, gbc);
        txtID = new JTextField(10);
        agregarComp(txtID,1,0,1,1,1,1);
        add(txtID, gbc);

        JLabel txNombre = new JLabel("Nombre: ");
        agregarComp(txNombre,0,1,1,1,1,1);
        add(txNombre, gbc);
        txtNombre = new JTextField(10);
        agregarComp(txtNombre,1,1,1,1,1,1);
        add(txtNombre, gbc);

        JLabel txPA = new JLabel("Primer apellido: ");
        agregarComp(txPA,0,2,1,1,1,1);
        add(txPA, gbc);
        txtPrimerA = new JTextField(10);
        agregarComp(txtPrimerA,1,2,1,1,1,1);
        add(txtPrimerA, gbc);

        JLabel txSA = new JLabel("Segundo apellido: ");
        agregarComp(txSA,0,3,1,1,1,1);
        add(txSA, gbc);
        txtSegundoA = new JTextField(10);
        agregarComp(txtSegundoA,1,3,1,1,1,1);
        add(txtSegundoA, gbc);

        JLabel txNmCasa = new JLabel("Numero Casa: ");
        agregarComp(txNmCasa,0,4,1,1,1,1);
        add(txNmCasa, gbc);
        txtNumeroCasa = new JTextField(10);
        agregarComp(txtNumeroCasa,1,4,1,1,1,1);
        add(txtNumeroCasa, gbc);

        JLabel txCalle = new JLabel("Calle: ");
        agregarComp(txCalle,0,5,1,1,1,1);
        add(txCalle, gbc);
        txtCalle = new JTextField(10);
        agregarComp(txtCalle,1,5,1,1,1,1);
        add(txtCalle, gbc);

        JLabel txColonia = new JLabel("Colonia: ");
        agregarComp(txColonia,0,6,1,1,1,1);
        add(txColonia, gbc);
        txtColonia = new JTextField(10);
        agregarComp(txtColonia,1,6,1,1,1,1);
        add(txtColonia, gbc);

        JLabel txCP = new JLabel("CP: ");
        agregarComp(txCP,0,7,1,1,1,1);
        add(txCP, gbc);
        txtCP = new JTextField(10);
        agregarComp(txtCP,1,7,1,1,1,1);
        add(txtCP, gbc);

        JLabel txTelefono = new JLabel("Telefono: ");
        agregarComp(txTelefono,0,8,1,1,1,1);
        add(txTelefono, gbc);
        txtTelefono = new JTextField(10);
        agregarComp(txtTelefono,1,8,1,1,1,1);
        add(txtTelefono, gbc);

        JLabel txTipo = new JLabel("Tipo empleado: ");
        agregarComp(txTipo,0,9,1,1,1,1);
        add(txTipo, gbc);
        cbTipoE  = new JComboBox();
        cbTipoE.addItem("Vendedor");
        cbTipoE.addItem("Gerente");
        cbTipoE.addItem("Administrador");
        agregarComp(cbTipoE,1,9,1,1,1,1);
        add(cbTipoE, gbc);

        btnAgregar = new JButton("Agregar");
        agregarComp(btnAgregar,0,10,1,1,1,1);
        add(btnAgregar, gbc);

        btnLimpiar = new JButton("Limpiar");
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

    public static void main(String[] args) {
        new altasEmpleados();
    }
}
