package com.autosamistosos.interfaces.subpaneles.clientesABCC;

import com.autosamistosos.basedatos.controlador.DAOClienteImpl;
import com.autosamistosos.basedatos.controlador.DAOEmpleadoImpl;
import com.autosamistosos.basedatos.modelo.Cliente;
import com.autosamistosos.basedatos.modelo.Empleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class altasClientes extends JInternalFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID, txtNombre, txtPrimerA, txtSegundoA, txtNumeroCasa, txtCalle, txtColonia, txtCP, txtEmpleado, txtCorreo;
    JButton btnAgregar, btnLimpiar;
    JComboBox cmbIDEmpl;
    Cliente cliente;
    DAOClienteImpl daoCliente = new DAOClienteImpl();
    DAOEmpleadoImpl daoEmpleado = new DAOEmpleadoImpl();

    public altasClientes(){
        super("Altas clientes", true, true, true, true);

        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        // Label e input de ID Auto
        JLabel txID = new JLabel("ID Cliente: ");
        agregarComp(txID, 0, 0, 1, 1, 1, 1);
        add(txID, gbc);
        SpinnerNumberModel spM = new SpinnerNumberModel(1, 1, null, 1);
        JSpinner spId = new JSpinner(spM);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spId.getEditor()).getTextField();
        tf.setEditable(false);
        agregarComp(spId, 1, 0, 1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(spId, gbc);
        gbc.fill = GridBagConstraints.NONE;

        JLabel txCorreo = new JLabel("Correo: ");
        agregarComp(txCorreo,0,1,1,1,1,1);
        add(txCorreo, gbc);
        txtCorreo = new JTextField(10);
        agregarComp(txtCorreo,1,1,1,1,1,1);
        add(txtCorreo, gbc);

        JLabel txNombre = new JLabel("Nombre: ");
        agregarComp(txNombre,0,2,1,1,1,1);
        add(txNombre, gbc);
        txtNombre = new JTextField(10);
        agregarComp(txtNombre,1,2,1,1,1,1);
        add(txtNombre, gbc);

        JLabel txIDEm = new JLabel("ID Empleado: ");
        agregarComp(txIDEm,0,3,1,1,1,1);
        add(txIDEm, gbc);
        cmbIDEmpl = new JComboBox();
        agregarComp(cmbIDEmpl,1,3,1,1,1,1);
        add(cmbIDEmpl, gbc);

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtNombre.getText().isEmpty()||txtCorreo.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Componente(s) vacio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else if (cmbIDEmpl.getItemCount()==0) {
                    JOptionPane.showMessageDialog(null, "Ingresa un empleado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else{
                    cliente = new Cliente(
                            Integer.parseInt(spId.getValue().toString()),
                            txtCorreo.getText(),
                            txtNombre.getText(),
                            (Integer) cmbIDEmpl.getSelectedItem());

                    daoCliente.insertar(cliente);
                }
            }
        });
        agregarComp(btnAgregar,0,4,1,1,1,1);
        add(btnAgregar, gbc);

        btnLimpiar = new JButton("Limpiar");
        agregarComp(btnLimpiar,1,4,1,1,1,1);
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

        rellenarCmbEmpleados();
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

    public void rellenarCmbEmpleados(){
        ArrayList<Empleado> autos = daoEmpleado.buscarTodos();

        for(Empleado e : autos){
            cmbIDEmpl.addItem(e.getId());
        }

    }
}

