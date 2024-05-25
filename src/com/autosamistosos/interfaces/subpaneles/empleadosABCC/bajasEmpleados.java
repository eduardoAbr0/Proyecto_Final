package com.autosamistosos.interfaces.subpaneles.empleadosABCC;

import com.autosamistosos.basedatos.modelo.Empleado;
import com.autosamistosos.basedatos.controlador.empleadoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bajasEmpleados extends JFrame {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField txtID;
    JButton btnEliminar;

    public bajasEmpleados(){
        getContentPane().setLayout(gbl);
        setTitle("Bajas empleados");
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

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(empleadoDAO.eliminarEmpleado(Integer.parseInt(txtID.getText())))
                    JOptionPane.showMessageDialog(null,
                            "SE ELIMINO con EXITO!!!!");
                else
                    JOptionPane.showMessageDialog(null,
                            "ERROR en la insercion!!!!");
            }
        });
        agregarComp(btnEliminar,0,1,1,2,1,1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnEliminar, gbc);

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
        new bajasEmpleados();
    }
}
