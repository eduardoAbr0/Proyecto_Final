package com.autosamistosos.interfaces.subpaneles.empleadosABCC;

import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.modelo.Empleado;
import com.autosamistosos.basedatos.controlador.empleadoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class cambiosEmpleados extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtNombre, txtPrimerA, txtSegundoA, txtNumeroCasa, txtCalle, txtColonia, txtCP, txtTelefono;
    JButton btnCambiar, btnLimpiar;
    JComboBox cbTipoE, cmbID;
    Empleado emp;
    DAOEmpleadoImpl daoEmpleado = new DAOEmpleadoImpl();

    public cambiosEmpleados(){
        super("Cambios empleados", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        JLabel txID = new JLabel("ID Empleado: ");
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

        JLabel txNombre = new JLabel("Nombre: ");
        agregarComp(txNombre, 0, 1, 1, 1, 1, 1);
        add(txNombre, gbc);
        txtNombre = new JTextField(10);
        agregarComp(txtNombre, 1, 1, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNombre, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txPA = new JLabel("Primer apellido: ");
        agregarComp(txPA, 0, 2, 1, 1, 1, 1);
        add(txPA, gbc);
        txtPrimerA = new JTextField(10);
        agregarComp(txtPrimerA, 1, 2, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPrimerA, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txSA = new JLabel("Segundo apellido: ");
        agregarComp(txSA, 0, 3, 1, 1, 1, 1);
        add(txSA, gbc);
        txtSegundoA = new JTextField(10);
        agregarComp(txtSegundoA, 1, 3, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtSegundoA, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txNmCasa = new JLabel("Numero casa: ");
        agregarComp(txNmCasa, 0, 4, 1, 1, 1, 1);
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
        agregarComp(txtNumeroCasa, 1, 4, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNumeroCasa, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCalle = new JLabel("Calle: ");
        agregarComp(txCalle, 0, 5, 1, 1, 1, 1);
        add(txCalle, gbc);
        txtCalle = new JTextField(10);
        agregarComp(txtCalle, 1, 5, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCalle, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txColonia = new JLabel("Colonia: ");
        agregarComp(txColonia, 0, 6, 1, 1, 1, 1);
        add(txColonia, gbc);
        txtColonia = new JTextField(10);
        agregarComp(txtColonia, 1, 6, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtColonia, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCP = new JLabel("CP: ");
        agregarComp(txCP, 0, 7, 1, 1, 1, 1);
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
        agregarComp(txtCP, 1, 7, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCP, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txTelefono = new JLabel("Telefono: ");
        agregarComp(txTelefono, 0, 8, 1, 1, 1, 1);
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
        agregarComp(txtTelefono, 1, 8, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtTelefono, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txTipo = new JLabel("Tipo empleado: ");
        agregarComp(txTipo, 0, 9, 1, 1, 1, 1);
        add(txTipo, gbc);
        cbTipoE = new JComboBox();
        cbTipoE.addItem("Vendedor");
        cbTipoE.addItem("Gerente");
        cbTipoE.addItem("Administrador");
        agregarComp(cbTipoE, 1, 9, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cbTipoE, gbc);
        gbc.fill = GridBagConstraints.NONE;

        btnCambiar = new JButton("Cambiar");
        btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtNombre.getText().isEmpty() ||
                        txtPrimerA.getText().isEmpty() ||
                        txtSegundoA.getText().isEmpty() ||
                        txtNumeroCasa.getText().isEmpty() ||
                        txtCalle.getText().isEmpty() ||
                        txtColonia.getText().isEmpty() ||
                        txtCP.getText().isEmpty() ||
                        txtTelefono.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo(s) vacio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else {

                    emp = new Empleado((Integer) cmbID.getSelectedItem(),
                            txtNombre.getText(),
                            txtPrimerA.getText(),
                            txtSegundoA.getText(),
                            Integer.parseInt(txtNumeroCasa.getText()),
                            txtCalle.getText(),
                            txtColonia.getText(),
                            Integer.parseInt(txtCP.getText()),
                            Integer.parseInt(txtTelefono.getText()),
                            cbTipoE.getSelectedItem().toString());

                    daoEmpleado.actualizar(emp);
                }

            }
        });
        agregarComp(btnCambiar,0,10,1,1,1,1);
        add(btnCambiar, gbc);

        btnLimpiar = new JButton("Limpiar");
        agregarComp(btnLimpiar,1,10,1,1,1,1);
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
        ArrayList<Empleado> autos = daoEmpleado.buscarTodos();

        for(Empleado e : autos){
            cmbID.addItem(e.getId());
        }
    }

    public void rellenarTxt(){
        if (cmbID.getItemCount()>0){
            emp = daoEmpleado.buscar((Integer) cmbID.getSelectedItem());
            txtNombre.setText(emp.getNombre());
            txtPrimerA.setText(emp.getPapellido());
            txtSegundoA.setText(emp.getSapellido());
            txtNumeroCasa.setText(String.valueOf(emp.getNumeroCasa()));
            txtCalle.setText(emp.getCalle());
            txtColonia.setText(emp.getColonia());
            txtCP.setText(String.valueOf(emp.getCp()));
            txtTelefono.setText(String.valueOf(emp.getTelefono()));
            if (emp.getTipoEmpleado().equals("Vendedor")){
                cbTipoE.setSelectedIndex(0);
            } else if (emp.getTipoEmpleado().equals("Gerente")) {
                cbTipoE.setSelectedIndex(1);
            } else if (emp.getTipoEmpleado().equals("Administrador")) {
                cbTipoE.setSelectedIndex(2);
            }
        }
    }
}
