package com.autosamistosos.interfaces.subpaneles.clientesABCC;

import com.autosamistosos.basedatos.controlador.DAOClienteImpl;
import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.hilos;
import com.autosamistosos.basedatos.modelo.Cliente;
import com.autosamistosos.basedatos.modelo.Empleado;
import com.autosamistosos.interfaces.personalizacion.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class cambiosClientes extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtNombre, txtPrimerA, txtSegundoA, txtNumeroCasa, txtCalle, txtColonia, txtCP, txtTelefono, txtRFC, txtIDEmpleado, txtCorreo;
    JButton btnCambiar, btnLimpiar;
    JComboBox cmbID, cmbIDEmp;
    Cliente cl;
    ArrayList<Cliente> clientes;
    ArrayList<Empleado> empleados;
    DAOClienteImpl daoCliente = new DAOClienteImpl();
    DAOEmpleadoImpl daoEmpleado = new DAOEmpleadoImpl();
    hilos h;

    public cambiosClientes() {
        super("Cambios clientes", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        setResizable(false);

        JLabel txID = new JLabel("ID Cliente: ");
        agregarComp(txID, 0, 0, 1, 1, 1, 1);
        add(txID, gbc);
        cmbID = new JComboBox();
        cmbID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rellenarTxt();
            }
        });
        agregarComp(cmbID, 1, 0, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbID, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCorreo = new JLabel("Correo: ");
        agregarComp(txCorreo, 0, 1, 1, 1, 1, 1);
        add(txCorreo, gbc);
        txtCorreo = new JTextField(10);
        agregarComp(txtCorreo, 1, 1, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCorreo, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txNombre = new JLabel("Nombre: ");
        agregarComp(txNombre, 0, 2, 1, 1, 1, 1);
        add(txNombre, gbc);
        txtNombre = new JTextField(10);
        agregarComp(txtNombre, 1, 2, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNombre, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txPA = new JLabel("Primer apellido: ");
        agregarComp(txPA, 0, 3, 1, 1, 1, 1);
        add(txPA, gbc);
        txtPrimerA = new JTextField(10);
        agregarComp(txtPrimerA, 1, 3, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPrimerA, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txSA = new JLabel("Segundo apellido: ");
        agregarComp(txSA, 0, 4, 1, 1, 1, 1);
        add(txSA, gbc);
        txtSegundoA = new JTextField(10);
        agregarComp(txtSegundoA, 1, 4, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtSegundoA, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txNmCasa = new JLabel("Numero Casa: ");
        agregarComp(txNmCasa, 0, 5, 1, 1, 1, 1);
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
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        agregarComp(txtNumeroCasa, 1, 5, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNumeroCasa, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCalle = new JLabel("Calle: ");
        agregarComp(txCalle, 0, 6, 1, 1, 1, 1);
        add(txCalle, gbc);
        txtCalle = new JTextField(10);
        agregarComp(txtCalle, 1, 6, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCalle, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txColonia = new JLabel("Colonia: ");
        agregarComp(txColonia, 0, 7, 1, 1, 1, 1);
        add(txColonia, gbc);
        txtColonia = new JTextField(10);
        agregarComp(txtColonia, 1, 7, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtColonia, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCP = new JLabel("CP: ");
        agregarComp(txCP, 0, 8, 1, 1, 1, 1);
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
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        agregarComp(txtCP, 1, 8, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCP, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txRFC = new JLabel("RFC: ");
        agregarComp(txRFC, 0, 9, 1, 1, 1, 1);
        add(txRFC, gbc);
        txtRFC = new JTextField(10);
        agregarComp(txtRFC, 1, 9, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtRFC, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txTelefono = new JLabel("Telefono: ");
        agregarComp(txTelefono, 0, 10, 1, 1, 1, 1);
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
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        agregarComp(txtTelefono, 1, 10, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTelefono, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txIDEmpleado = new JLabel("ID Empleado: ");
        agregarComp(txIDEmpleado, 0, 11, 1, 1, 1, 1);
        add(txIDEmpleado, gbc);
        cmbIDEmp = new JComboBox();
        agregarComp(cmbIDEmp, 1, 11, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cmbIDEmp, gbc);
        gbc.fill = GridBagConstraints.NONE;

        btnCambiar = new JButton("Cambiar");
        btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCorreo.getText().isEmpty() || txtNombre.getText().isEmpty() || txtPrimerA.getText().isEmpty() ||
                        txtSegundoA.getText().isEmpty() || txtNumeroCasa.getText().isEmpty() || txtCalle.getText().isEmpty() || txtColonia.getText().isEmpty()
                        || txtCP.getText().isEmpty() || txtRFC.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo(s) vacio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else if (cmbID.getItemCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Agrega clientes para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else if (cmbIDEmp.getItemCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Agrega empleados.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    cl = new Cliente(
                            Integer.parseInt(txtID.getText()),
                            txtCorreo.getText(),
                            txtNombre.getText(),
                            (Integer) cmbIDEmp.getSelectedItem());

                    cl.setpApellido(txtPrimerA.getText());
                    cl.setsApellido(txtSegundoA.getText());
                    cl.setNumeroCasa(Integer.parseInt(txtNumeroCasa.getText()));
                    cl.setCalle(txtCalle.getText());
                    cl.setColonia(txtColonia.getText());
                    cl.setRFC(txtRFC.getText());
                    cl.setCp(Integer.parseInt(txtCP.getText()));
                    cl.setTelefono(Integer.parseInt(txtTelefono.getText()));

                    h = new hilos("cambiarCliente");
                    h.setObjeto(cl);
                    h.start();
                }
            }
        });
        agregarComp(btnCambiar, 0, 12, 1, 1, 1, 1);
        add(btnCambiar, gbc);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component component : getContentPane().getComponents()) {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        textField.setText("");
                    }
                }
            }
        });
        agregarComp(btnLimpiar, 1, 12, 1, 1, 1, 1);
        add(btnLimpiar, gbc);


        rellenarCmb();
        rellenarCmbEmp();
        aplicarEstilos(getContentPane());
        setVisible(true);
    }

    public void agregarComp(JComponent c, int x, int y, int alt, int anch, int pesox, int pesoy) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = anch;
        gbc.gridheight = alt;
        gbc.weightx = pesox;
        gbc.weighty = pesoy;

        gbl.setConstraints(c, gbc);
    }

    public void rellenarCmb() {
        clientes = daoCliente.buscarTodos();

        for(Cliente c : clientes){
            cmbID.addItem(c.getIdCliente());
        }
    }

    public void rellenarCmbEmp(){
        empleados = daoEmpleado.buscarTodos();

        for(Empleado e : empleados){
            cmbIDEmp.addItem(e.getId());
        }
    }

    public void rellenarTxt(){
        if (cmbID.getItemCount()>0){
            cl = daoCliente.buscar((Integer) cmbID.getSelectedItem());
            txtCorreo.setText(cl.getCorreo());
            txtNombre.setText(cl.getNombre());
            txtPrimerA.setText(cl.getpApellido());
            txtSegundoA.setText(cl.getsApellido());
            txtNumeroCasa.setText(String.valueOf(cl.getNumeroCasa()));
            txtCalle.setText(cl.getCalle());
            txtColonia.setText(cl.getColonia());
            txtCP.setText(String.valueOf(cl.getCp()));
            txtRFC.setText(String.valueOf(cl.getRFC()));
            txtTelefono.setText(String.valueOf(cl.getTelefono()));
        }
    }

    public void aplicarEstilos(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JButton) {
                interfaz.estiloBoton((JButton) c,20);
            } else if (c instanceof  JTextField) {
                interfaz.personalizarTextField((JTextField) c,Color.BLACK,22,Color.BLACK);
            } else if (c instanceof  JLabel) {
                interfaz.personalizarLabelNormal((JLabel) c,Color.BLACK,22);
            } else if (c instanceof Container) {
                // Llamada recursiva para aplicar el estilo a los sub-componentes
                aplicarEstilos((Container) c);
            }
        }
    }
}
