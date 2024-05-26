package com.autosamistosos.interfaces.subpaneles.clientesABCC;

import com.autosamistosos.basedatos.controlador.DAOClienteImpl;
import com.autosamistosos.basedatos.controlador.clienteDAO;
import com.autosamistosos.basedatos.modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class altasClientes extends JFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtNombre, txtPrimerA, txtSegundoA, txtNumeroCasa, txtCalle, txtColonia, txtCP, txtEmpleado;
    JButton btnAgregar, btnLimpiar;
    Cliente cliente;
    DAOClienteImpl daoCliente = new DAOClienteImpl();

    public altasClientes(){
        getContentPane().setLayout(gbl);
        setTitle("Altas empleados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel txID = new JLabel("ID Cliente: ");
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

        JLabel txEmpleado = new JLabel("Atendido por vendedor: ");
        agregarComp(txEmpleado,0,8,1,1,1,1);
        add(txEmpleado, gbc);
        txtEmpleado = new JTextField(10);
        agregarComp(txtEmpleado,1,8,1,1,1,1);
        add(txtEmpleado, gbc);


        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cliente = new Cliente(Integer.parseInt(txtID.getText()),
                        txtNombre.getText(),
                        txtPrimerA.getText(),
                        txtSegundoA.getText(),
                        Integer.parseInt(txtNumeroCasa.getText()),
                        txtCalle.getText(),
                        txtColonia.getText(),
                        Integer.parseInt(txtCP.getText()),null,null);
                        cliente.setIdEmpleado(Integer.parseInt(txtEmpleado.getText()));

                        daoCliente.insertar(cliente);

            }
        });
        agregarComp(btnAgregar,0,9,1,1,1,1);
        add(btnAgregar, gbc);

        btnLimpiar = new JButton("Limpiar");
        agregarComp(btnLimpiar,1,9,1,1,1,1);
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
        new altasClientes();
    }
}

