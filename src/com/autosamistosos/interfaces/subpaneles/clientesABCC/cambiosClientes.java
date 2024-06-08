package com.autosamistosos.interfaces.subpaneles.clientesABCC;

import com.autosamistosos.basedatos.controlador.DAOClienteImpl;
import com.autosamistosos.basedatos.modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class cambiosClientes extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtNombre, txtPrimerA, txtSegundoA, txtNumeroCasa, txtCalle, txtColonia, txtCP, txtTelefono,txtRFC, txtIDEmpleado, txtCorreo;
    JButton btnCambiar, btnLimpiar;
    Cliente cl;
    DAOClienteImpl daoCliente = new DAOClienteImpl();

    public cambiosClientes(){
        super("Cambios clientes", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        JLabel txID = new JLabel("ID Cliente: ");
        agregarComp(txID,0,0,1,1,1,1);
        add(txID, gbc);
        JComboBox cmbID = new JComboBox();
        agregarComp(cmbID,1,0,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCorreo = new JLabel("Correo: ");
        agregarComp(txCorreo,0,1,1,1,1,1);
        add(txCorreo, gbc);
        txtCorreo = new JTextField(10);
        agregarComp(txtCorreo,1,1,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCorreo, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txNombre = new JLabel("Nombre: ");
        agregarComp(txNombre,0,2,1,1,1,1);
        add(txNombre, gbc);
        txtNombre = new JTextField(10);
        agregarComp(txtNombre,1,2,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNombre, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txPA = new JLabel("Primer apellido: ");
        agregarComp(txPA,0,3,1,1,1,1);
        add(txPA, gbc);
        txtPrimerA = new JTextField(10);
        agregarComp(txtPrimerA,1,3,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPrimerA, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txSA = new JLabel("Segundo apellido: ");
        agregarComp(txSA,0,4,1,1,1,1);
        add(txSA, gbc);
        txtSegundoA = new JTextField(10);
        agregarComp(txtSegundoA,1,4,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtSegundoA, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txNmCasa = new JLabel("Numero Casa: ");
        agregarComp(txNmCasa,0,5,1,1,1,1);
        add(txNmCasa, gbc);
        txtNumeroCasa = new JTextField(10);
        txtNumeroCasa.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(Character.isDigit(e.getKeyChar()))) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        agregarComp(txtNumeroCasa,1,5,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNumeroCasa, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCalle = new JLabel("Calle: ");
        agregarComp(txCalle,0,6,1,1,1,1);
        add(txCalle, gbc);
        txtCalle = new JTextField(10);
        agregarComp(txtCalle,1,6,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCalle, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txColonia = new JLabel("Colonia: ");
        agregarComp(txColonia,0,7,1,1,1,1);
        add(txColonia, gbc);
        txtColonia = new JTextField(10);
        agregarComp(txtColonia,1,7,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtColonia, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCP = new JLabel("CP: ");
        agregarComp(txCP,0,8,1,1,1,1);
        add(txCP, gbc);
        txtCP = new JTextField(10);
        txtCP.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(Character.isDigit(e.getKeyChar()))) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        agregarComp(txtCP,1,8,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCP, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txRFC = new JLabel("RFC: ");
        agregarComp(txRFC,0,9,1,1,1,1);
        add(txRFC, gbc);
        txtRFC = new JTextField(10);
        agregarComp(txtRFC,1,9,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtRFC, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txTelefono = new JLabel("Telefono: ");
        agregarComp(txTelefono,0,10,1,1,1,1);
        add(txTelefono, gbc);
        txtTelefono = new JTextField(10);
        txtTelefono.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(Character.isDigit(e.getKeyChar()))) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        agregarComp(txtTelefono,1,10,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTelefono, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txIDEmpleado = new JLabel("ID Empleado: ");
        agregarComp(txIDEmpleado,0,11,1,1,1,1);
        add(txIDEmpleado, gbc);
        txtIDEmpleado = new JTextField(10);
        txtIDEmpleado.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(Character.isDigit(e.getKeyChar()))) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        agregarComp(txtIDEmpleado,1,11,1,1,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtIDEmpleado, gbc);
        gbc.fill = GridBagConstraints.NONE;

        btnCambiar = new JButton("Cambiar");
        btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 cl = new Cliente(Integer.parseInt(txtID.getText()),
                        txtNombre.getText(),
                        txtPrimerA.getText(),
                        txtSegundoA.getText(),
                        Integer.parseInt(txtNumeroCasa.getText()),
                        txtCalle.getText(),
                        txtColonia.getText(),
                        Integer.parseInt(txtCP.getText()),
                        Integer.parseInt(txtTelefono.getText(), );

                daoCliente.actualizar(cl);
*/
            }
        });
        agregarComp(btnCambiar,0,12,1,1,1,1);
        add(btnCambiar, gbc);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Component component: getContentPane().getComponents()){
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        textField.setText("");
                    }
                }
            }
        });
        agregarComp(btnLimpiar,1,12,1,1,1,1);
        add(btnLimpiar, gbc);

        rellenarCmb();
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

    public void rellenarCmb(){
        /*
        ArrayList<Cliente> clientes = daoCliente.buscarTodos();

        for(Cliente c : clientes){
            cmbID.addItem(c.getIdCliente());
        }

         */

    }
}
